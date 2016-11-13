package com.parkproject.parkit;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Marker ElectroMarkers;
    Marker DisabledMarkers;
    Marker WomanMarkers;

    //private BottomBar bottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
/*
        // Notice how you don't use the setContentView method here! Just
        // pass your layout to bottom bar, it will be taken care of.
        // Everything will be just like you're used to.
        bottomBar = BottomBar.bind(this, R.layout.activity_maps,
                savedInstanceState);

        mbottomBar.setItems(
                new BottomBarTab(R.drawable.ic_recents, "Price"),
                new BottomBarTab(R.drawable.ic_favorites, "Park Duration"),
                new BottomBarTab(R.drawable.ic_nearby, "Electro"),
                new BottomBarTab(R.drawable.ic_friends, "Disabled"),
                new BottomBarTab(R.drawable.ic_friends, "Woman")
        );

        bottomBar.setOnItemSelectedListener(new OnTabSelectedListener() {
            @Override
            public void onItemSelected(final int position) {
                // the user selected a new tab
                switch (position) {
                    case 2:
                        ElectroMarkers.setVisible(false);
                    case 3:
                        DisabledMarkers.setVisible(false);
                    case 4:
                        WomanMarkers.setVisible(false);
                }
            }
        });
    }*/
        setContentView(R.layout.activity_maps);
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



        // Add a marker in London and move the camera
        LatLng muc = new LatLng(51.483429920883154, -0.10336160659790039);
        mMap.addMarker(new MarkerOptions().position(muc).title("Me").icon(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(muc , 12.0f) );

        //Big Ben
        LatLng lo = new LatLng(51.5007, -0.1246261);
        ElectroMarkers = mMap.addMarker(new MarkerOptions().position(lo).title("Destination").icon(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));

        // Add several markers Sealife
        LatLng lon1 = new LatLng(51.50212846556025, -0.11890232563018799);
        ElectroMarkers = mMap.addMarker(new MarkerOptions().position(lon1).title("Sealife").icon(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        LatLng lon2 = new LatLng(51.50205500149991, -0.11836588382720947);
        ElectroMarkers = mMap.addMarker(new MarkerOptions().position(lon2).title("Sealife").icon(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        LatLng lon3 = new LatLng(51.50210211660335, -0.11845573782920837);
        ElectroMarkers = mMap.addMarker(new MarkerOptions().position(lon3).title("Sealife").icon(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        LatLng lon4 = new LatLng(51.50210712551514, -0.1185522973537445);
        ElectroMarkers = mMap.addMarker(new MarkerOptions().position(lon4).title("Sealife").icon(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        LatLng lon5 = new LatLng(51.50208542022674, -0.11864081025123596);
        DisabledMarkers = mMap.addMarker(new MarkerOptions().position(lon5).title("Sealife").icon(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        LatLng lon6 = new LatLng(51.50206705420541, -0.11860057711601257);
        DisabledMarkers = mMap.addMarker(new MarkerOptions().position(lon6).title("Sealife").icon(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        LatLng lon7 = new LatLng(51.50199692932859, -0.11850133538246155);
        DisabledMarkers = mMap.addMarker(new MarkerOptions().position(lon7).title("Sealife").icon(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        LatLng lon8 = new LatLng(51.50187170606591, -0.11893317103385925);
        mMap.addMarker(new MarkerOptions().position(lon8).title("Sealife").icon(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        LatLng lon9 = new LatLng(51.5018783846486, -0.11885270476341248);
        mMap.addMarker(new MarkerOptions().position(lon9).title("Sealife").icon(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        LatLng lon10 = new LatLng(51.5019234650562, -0.11876419186592102);
        mMap.addMarker(new MarkerOptions().position(lon10).title("Sealife").icon(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        //Station
        LatLng lon12 = new LatLng(51.498636809058155, -0.11154502630233765);
        DisabledMarkers = mMap.addMarker(new MarkerOptions().position(lon2).title("Lambert").icon(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        LatLng lon13 = new LatLng(51.49869926863669, -0.11170461773872375);
        WomanMarkers = mMap.addMarker(new MarkerOptions().position(lon2).title("Lambert").icon(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        LatLng lon14 = new LatLng(51.49871930577657, -0.11175557971000671);
        WomanMarkers = mMap.addMarker(new MarkerOptions().position(lon2).title("Lambert").icon(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        LatLng lon15 = new LatLng(51.498762719549426, -0.11189237236976624);
        mMap.addMarker(new MarkerOptions().position(lon15).title("Lambert").icon(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
    }
}
