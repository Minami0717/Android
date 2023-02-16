package com.example.fragment;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

// ActionBar : 여러가지 화면을 사용
// Fragment : 액티비티 화면을 분할 또는 실행 중에 화면을 동적으로 추가하거나 제거
public class MainActivity extends AppCompatActivity implements ActionBar.TabListener {
    ActionBar.Tab tabRed, tabGreen, tabBlue;
    MyTabFragment myTabFragments[] = new MyTabFragment[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 액션바를 탭으로 설정
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        tabRed = actionBar.newTab();
        tabRed.setText("빨간색");
        tabRed.setTabListener(this);
        actionBar.addTab(tabRed);

        tabGreen = actionBar.newTab();
        tabGreen.setText("초록색");
        tabGreen.setTabListener(this);
        actionBar.addTab(tabGreen);

        tabBlue = actionBar.newTab();
        tabBlue.setText("파란색");
        tabBlue.setTabListener(this);
        actionBar.addTab(tabBlue);
    }

    // 탭을 선택하면 동작
    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        // 현재 선택한 프래그먼트로 사용할 변수
        MyTabFragment myTabFragment = null;

        // 선택한 탭이 기존에 한 번도 선택된 적이 없는 경우
        if (myTabFragments[tab.getPosition()] == null) {
            myTabFragment = new MyTabFragment(); // 새로운 프래그먼트 생성

            // 현재 프래그먼트 값을 지정
            Bundle data = new Bundle();
            data.putString("tabName", tab.getText().toString());
            myTabFragment.setArguments(data);

            // 프ㅐ그먼트 배열에 저장
            myTabFragments[tab.getPosition()] = myTabFragment;
        }
        else { // 기존에 해당 탭을 선택한 적이 있는 경우
            myTabFragment = myTabFragments[tab.getPosition()];
        }

        ft.replace(android.R.id.content, myTabFragment);
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    // Fragment를 상속받는 MyTabFragment 클래스
    public static class MyTabFragment extends Fragment {
        String tabName;

        // 탭을 클릭했을 때 지정한 데이터로 각 프래그먼트를 지정
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Bundle data = getArguments();
            tabName = data.getString("tabName");
        }

        // 프래그먼트에 나타날 화면을 구성
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            // 리니어 레이아웃 생성
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            LinearLayout baseLayout = new LinearLayout(super.getActivity());
            baseLayout.setOrientation(LinearLayout.VERTICAL);
            baseLayout.setLayoutParams(layoutParams);

            // 클릭한 탭마다 배경색을 다르게 설정
            if (tabName == "빨간색") {
                baseLayout.setBackgroundColor(Color.RED);
            }
            else if (tabName == "초록색") {
                baseLayout.setBackgroundColor(Color.GREEN);
            }
            else if (tabName == "파란색") {
                baseLayout.setBackgroundColor(Color.BLUE);
            }

            // 구성한 레이아웃 반환
            return baseLayout;
        }
    }
}