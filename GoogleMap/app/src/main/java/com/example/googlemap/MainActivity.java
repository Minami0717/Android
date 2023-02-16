package com.example.googlemap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    GoogleMap map;
    MapFragment fragment;
    GroundOverlayOptions videoMark;
    ArrayList<GroundOverlayOptions> marks = new ArrayList<GroundOverlayOptions>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("구글 지도 활용");
        fragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        fragment.getMapAsync(this);

    }
    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        map = googleMap;
        map.getUiSettings().setZoomControlsEnabled(true);
        map.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(@NonNull LatLng latLng) {
                videoMark = new GroundOverlayOptions().image(BitmapDescriptorFactory.
                        fromResource(R.drawable.star)).position(latLng,100f,100f);
                marks.add(videoMark);
                map.clear();
                for (GroundOverlayOptions mark : marks)
                    map.addGroundOverlay(mark);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0,1,0,"위성 지도");
        menu.add(0,2,0,"일반 지도");
        menu.add(0,3,0,"바로전 CCTV 지우기");
        menu.add(0,4,0,"모든 CCTV 지우기");

        SubMenu subMenu = menu.addSubMenu("유명 장소 바로가기 >>");
        subMenu.add(0,5,0,"기요미즈데라");
        subMenu.add(0,6,0,"아키하바라");
        subMenu.add(0,7,0,"칸다 묘진");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                return true;
            case 2:
                map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                return true;
            case 3:
                marks.remove(marks.size()-1);
                map.clear();
                for (GroundOverlayOptions mark : marks)
                    map.addGroundOverlay(mark);
                return true;
            case 4:
                marks.clear();
                map.clear();
                return true;
            case 5:
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(
                        34.99504065125749, 135.78503556930602),15));
                return true;
            case 6:
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(
                        35.70229440472475, 139.77446616746835),15));
                return true;
            case 7:
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(
                        35.70216669238664, 139.76784065397743),15));
                return true;
        }
        return false;
    }
}