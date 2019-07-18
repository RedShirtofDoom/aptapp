package com.example.aptapp;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Map_apartment extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_apartment);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }




    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override


    //coordinates for common apartments near UTA campus
//32°44'02.5"N 97°07'09.6"W   == timberbrook apartment
//32.730593, -97.119917 === university village
//32.731901, -97.121427   ==== meadow run

    //function created with dummy coordinates entered for the Meadow Run Apartments

    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng meadow_run = new LatLng(32.731901, -97.121427);
        mMap.addMarker(new MarkerOptions().position(meadow_run).title("Meadow Run Apartments"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(meadow_run, 10F));
    }



//sample function for the University Village's apartments

    public void onMapReady2(GoogleMap googleMap2) {
        mMap = googleMap2;

        // Add a marker in Sydney and move the camera
        LatLng university_village = new LatLng(32.730593, -97.119917);
        mMap.addMarker(new MarkerOptions().position(university_village).title("University Village Apartments"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(university_village,10F));
    }

}
