package com.ensim.projetsnowtam;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.ensim.projetsnowtam.service.AirportResult;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener {
    private static final String TAG = "MapsActivity";
    private GoogleMap mMap;
    private ArrayList<AirportResult> listAirportResult = new ArrayList<AirportResult>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        Intent intent = getIntent();
        if (intent != null){
            listAirportResult = intent.getParcelableArrayListExtra("listAirPort");
        }
        Log.d(TAG,listAirportResult.size()+"");
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setOnInfoWindowClickListener(this);
        PolylineOptions polylineOptions = new PolylineOptions();
        // Add a marker in Sydney and move the camera
        for (AirportResult apr: listAirportResult) {
            LatLng currentAirport = new LatLng(apr.getLatitude(), apr.getLongitude());


            if(apr.isOnTarget()){
                polylineOptions.add(currentAirport);
            }



            mMap.addMarker(new MarkerOptions().position(currentAirport).title(apr.getICAO_Code()));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(currentAirport));
            mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        }
        mMap.addPolyline(polylineOptions.width(5).color(Color.RED).geodesic(true));
    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        Integer index=0;
        Log.d(TAG,"ON CLICK WINDOW "+marker.getTitle());
        for (AirportResult apr:listAirportResult) {
            if(apr.getICAO_Code().equals(marker.getTitle())){
                index = listAirportResult.indexOf(apr);
            }
        }
        Log.d(TAG,"size : "+listAirportResult.size()+" index : ");
        Intent intent = new Intent(MapsActivity.this,SnowtamActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("listAirPort",listAirportResult);
        bundle.putInt("index",index);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
