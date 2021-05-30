package com.crinsoft.sanalturrehberi;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class GoogleMapActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    String Lat;
    String Lng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        float zoomLevel = (float) 10.0;
       Intent intent = getIntent();
        String a =intent.getStringExtra("deneme");
        String b = intent.getStringExtra("MekanIsmi");
        System.out.println(a);

        String[] parts = a.split(",");
         Lat =parts[0];
         Lng = parts[1];

         Float Flat = Float.parseFloat(Lat);
         Float FLng = Float.parseFloat(Lng);




        Toast toast = Toast.makeText(this,Lat,Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();



        mMap = googleMap;

        LatLng currentLocation = new LatLng((float) 41.04123635556372, (float)29.007275911267257);
        mMap.addMarker(new MarkerOptions().
                position(currentLocation).
                title("Bulunduğunuz Lokasyon"));



        LatLng newLocaiton = new LatLng(Flat,FLng );
        mMap.addMarker(new MarkerOptions().
                position(newLocaiton).
                title(b));



        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLocation,zoomLevel));

    }
}