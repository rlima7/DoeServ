package com.example.doacao_.projeto_integrador.activity;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.example.doacao_.projeto_integrador.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ActMapa extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_mapa);
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
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setZoomControlsEnabled(true);

        LatLng abracc = new LatLng(-12.9744837,-38.5113402);
        mMap.addMarker(new MarkerOptions().position(abracc).title("ABRACC"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(abracc));

        LatLng dulce = new LatLng(-12.9350217,-38.506722);
        mMap.addMarker(new MarkerOptions().position(dulce).title("Irmã Dulce"));


        LatLng francisco = new LatLng(-12.9224689,-38.5086552);
        mMap.addMarker(new MarkerOptions().position(francisco).title("Abrigo São Francisco"));


        LatLng abrigo = new LatLng(-12.9309546,-38.5151909);
        mMap.addMarker(new MarkerOptions().position(abrigo).title("Abrigo São Gabriel"));


        LatLng lar = new LatLng(-12.9695425,-38.4888968);
        mMap.addMarker(new MarkerOptions().position(lar).title("Lar da Criança"));


        LatLng jose = new LatLng(-12.9722519,-38.4974906);
        mMap.addMarker(new MarkerOptions().position(jose).title("Lar Irmão São José"));

    }
}
