package com.example.aptapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.StreetViewPanoramaOptions;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PointOfInterest;

public class Map_apartment extends AppCompatActivity implements OnMapReadyCallback {

    private static final int REQUEST_LOCATION_PERMISSION = 0;
    private GoogleMap mMap;

    private void setInfoWindowClicktoPanaroma(GoogleMap map)
    {
        map.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                if(marker.getTag() == "poi")
                {
                    StreetViewPanoramaOptions options = new StreetViewPanoramaOptions().position(marker.getPosition());
                }
            }
        });
    }

    private void setPoiClick(final GoogleMap map)
    {
        map.setOnPoiClickListener(new GoogleMap.OnPoiClickListener() {
            @Override
            public void onPoiClick(PointOfInterest poi)
            {
                Marker poiMarker = mMap.addMarker(new MarkerOptions()
                        .position(poi.latLng).title(poi.name));
                poiMarker.showInfoWindow();
                poiMarker.setTag("poi");
            }
        });
    }

    private void enableMyLocation() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);
        } else {
            ActivityCompat.requestPermissions(this, new String[]
                            {Manifest.permission.ACCESS_FINE_LOCATION},
                    REQUEST_LOCATION_PERMISSION);
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_apartment);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = SupportMapFragment.newInstance();// getSupportFragmentManager()
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,mapFragment).commit();
        //  .findFragmentById(R.id.map);
        mapFragment.getMapAsync( this);
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
    //32.731945, -97.121558   === meadow run

    //When any line shows error for missing package, click on the keyword underlined red, press Alt+Enter, it imports correct library or package in Android studio

    //function created with dummy coordinates entered for the Meadow Run Apartments

    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng meadow_run = new LatLng(32.731945, -97.121558);
        mMap.addMarker(new MarkerOptions().position(meadow_run).title("Meadow Run Apartments"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(meadow_run, 10F));
        setPoiClick(mMap);
        enableMyLocation();
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        // Check if location permissions are granted and if so enable the
        // location data layer.
        switch (requestCode) {
            case REQUEST_LOCATION_PERMISSION:
                if (grantResults.length > 0
                        && grantResults[0]
                        == PackageManager.PERMISSION_GRANTED) {
                    enableMyLocation();
                    break;
                }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.map_options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Change the map type based on the user's selection.
        switch (item.getItemId()) {
            case R.id.normal_map:
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                return true;
            case R.id.hybrid_map:
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                return true;
            case R.id.satellite_map:
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                return true;
            case R.id.terrain_map:
                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



//sample function for the University Village's apartments
/*
    public void onMapReady2(GoogleMap googleMap2) {
        mMap = googleMap2;

        // Add a marker in Sydney and move the camera
        LatLng university_village = new LatLng(32.730593, -97.119917);
        mMap.addMarker(new MarkerOptions().position(university_village).title("University Village Apartments"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(university_village,10F));
    }
*/
}
