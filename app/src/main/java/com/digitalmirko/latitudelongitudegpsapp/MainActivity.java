package com.digitalmirko.latitudelongitudegpsapp;

import android.Manifest;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnGetGPS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGetGPS = findViewById(R.id.btnGetGPS);
        ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},123);
        btnGetGPS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GPStracker g = new GPStracker(getApplicationContext());
                Location l = g.getLocation();
                if(l != null){
                    double lat = l.getLatitude();
                    double lon = l.getLongitude();
                    String latString = String.format("%.4f",lat);
                    String lonString = String.format("%.4f",lon);
                    Toast.makeText(getApplicationContext(),"Lat: "+ latString + "\n Lon: " + lonString,Toast.LENGTH_LONG ).show();
                }
            }
        });
    }
}
