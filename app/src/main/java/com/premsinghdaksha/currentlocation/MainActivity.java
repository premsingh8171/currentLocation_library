package com.premsinghdaksha.currentlocation;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.premsinghdaksha.currentlocation_library.GetAddFromLatLong;
import com.premsinghdaksha.currentlocation_library.TrackGPSLocation;

public class MainActivity extends AppCompatActivity {
    private TextView select_tv;
    private GetAddFromLatLong getAddFromLatLong;
    private TrackGPSLocation trackGPSLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        select_tv = findViewById(R.id.select_tv);
        trackGPSLocation = new TrackGPSLocation(MainActivity.this);
        getAddFromLatLong = new GetAddFromLatLong(MainActivity.this);

        findViewById(R.id.selectadd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //here we passes the lat long by sing trackGPSAddress
                getAddFromLatLong.SaveLocationData(trackGPSLocation.getLatitude(), trackGPSLocation.getLongitude());
                String value = getAddFromLatLong.getCity();

                //set current address
                select_tv.setText(value);
            }
        });

    }


}