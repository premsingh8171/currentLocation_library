package com.premsinghdaksha.currentlocation;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.premsinghdaksha.currentlocation_library.GetAddFromLatLong;
import com.premsinghdaksha.currentlocation_library.TrackGPSLocation;

public class MainActivity extends AppCompatActivity {
    private TextView select_tv;
    private GetAddFromLatLong getAddFromLatLong;
    private TrackGPSLocation trackGPSLocation;
    private int checkPermition = 0;
    private static final int MY_PERMISSIONS_REQUEST_CODE = 101;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        select_tv = findViewById(R.id.select_tv);
        checkPermission();
        getAddFromLatLong = new GetAddFromLatLong(MainActivity.this);

        findViewById(R.id.selectadd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //here we passes the lat long by sing trackGPSAddress
                getAddFromLatLong.SaveLocationData(trackGPSLocation.getLatitude(), trackGPSLocation.getLongitude());
                String value = getAddFromLatLong.getCity();
                String value2 = getAddFromLatLong.getAddress();
                String value3 = getAddFromLatLong.getCountry();
                String value4 = getAddFromLatLong.getLocality();
                String value5 = getAddFromLatLong.getPincode();
                String value6 = getAddFromLatLong.getState();

                //set current address
                select_tv.setText(value);
            }
        });

    }

    protected void checkPermission() {
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
        ) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)
            ) {
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_REQUEST_CODE);

            } else {

                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,}, MY_PERMISSIONS_REQUEST_CODE
                );
            }
        } else {
            checkPermition = 1;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_CODE: {
                if ((grantResults[0] == 0)) {
                    checkPermition = 1;
                    try {
//                        locationManager = (LocationManager) MainActivity.this.getSystemService(Context.LOCATION_SERVICE);
//                        double Latitude = getLastBestLocation().getLatitude();
//                        double Longitude = getLastBestLocation().getLongitude();
                        trackGPSLocation = new TrackGPSLocation(MainActivity.this);


                    } catch (Exception e) {
                        e.fillInStackTrace();
                    }
                } else {
                    checkPermition = 0;
                }
                return;
            }
        }
    }

}