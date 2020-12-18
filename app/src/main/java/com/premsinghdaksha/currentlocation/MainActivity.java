/**
 * Created by Er.prem singh on 16/12/2020.
 * https://www.linkedin.com/in/prem-singh-daksha-82az/
 */
package com.premsinghdaksha.currentlocation;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.premsinghdaksha.currentlocation_library.GetLocFromLatLong;
import com.premsinghdaksha.currentlocation_library.TrackGPSLocation;

public class MainActivity extends AppCompatActivity {
    private TextView select_tv, address;
    private GetLocFromLatLong getLocFromLatLong;
    private TrackGPSLocation trackGPSLocation;
    private int checkPermition = 0;
    private static final int MY_PERMISSIONS_REQUEST_CODE = 101;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        select_tv = findViewById(R.id.select_tv);
        address = findViewById(R.id.address);
        checkPermission();
        trackGPSLocation = new TrackGPSLocation(MainActivity.this);
        getLocFromLatLong = new GetLocFromLatLong(MainActivity.this);
        getLocFromLatLong.getLocation_(trackGPSLocation.getLatitude(), trackGPSLocation.getLongitude());

        findViewById(R.id.selectadd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkPermition == 1) {
                    //here we passes the lat long by sing trackGPSAddress
                    String value = getLocFromLatLong.getLocality();

//                    String value2 = getLocFromLatLong.getAddress();
//                    String value3 = getLocFromLatLong.getCountry();
//                    String value4 = getLocFromLatLong.getLocality();
//                    String value5 = getLocFromLatLong.getPincode();
//                    String value6 = getLocFromLatLong.getAdminArea();
//                    String value7 = getLocFromLatLong.getCountryCode();
//                    String value8 = getLocFromLatLong.getFeatureName();
//                    String value9 = getLocFromLatLong.getState();
//                    String value10 = getLocFromLatLong.getPhone();
//                    String value11 = getLocFromLatLong.getSubLocality();
//                    String value12 = getLocFromLatLong.getUrl();

                    //set current address
                    select_tv.setText(value);

                } else {
                    checkPermission();
                }
            }
        });

        address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkPermition == 1) {
                    address.setText(getLocFromLatLong.getAddress());
                } else {
                    checkPermission();
                }
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
        Log.d("trackGPSLoca", String.valueOf(checkPermition));

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_CODE: {
                if ((grantResults[0] == 0)) {
                    checkPermition = 1;
                } else {
                    checkPermition = 0;
                }
                return;
            }
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        trackGPSLocation = new TrackGPSLocation(MainActivity.this);
        getLocFromLatLong = new GetLocFromLatLong(MainActivity.this);
        getLocFromLatLong.getLocation_(trackGPSLocation.getLatitude(), trackGPSLocation.getLongitude());

    }
}