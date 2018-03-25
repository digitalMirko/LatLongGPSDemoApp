package com.digitalmirko.latitudelongitudegpsapp;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

/**
 * Created by MirkoC on 3/24/2018.
 */

public class GPStracker implements LocationListener {

    Context context;

    public GPStracker(Context c){
        context = c;
    }

    public Location getLocation() {
        // if you are using anything above Android 4.0 you need this if statement, anything under and you don't need the if statement
        // checks if permission for ACCESS FINE LOCATION is granted
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            // if not a Toast message will appear telling the user its not granted
            Toast.makeText(context, "Permission not granted", Toast.LENGTH_SHORT).show();
        return null;
        }
        // if permission is granted it will come here, create a Location manager object which corresponds to the Location service
        LocationManager locMan = (LocationManager)context.getSystemService(Context.LOCATION_SERVICE);
        // checks to see if GPS is Enabled by using the isProviderEnabled method and the GPS provider
        boolean isGPSEnabled = locMan.isProviderEnabled(LocationManager.GPS_PROVIDER);
        // if the GPS is enabled
        if(isGPSEnabled){
            // requests location updates for this class
            locMan.requestLocationUpdates(LocationManager.GPS_PROVIDER,6000,10,this);
            // last known location from GPS provider
            Location loc = locMan.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            // returns the location
            return loc;
        } else {
            // if not enabled, Toast message to Enable GPS
            Toast.makeText(context,"Enable GPS",Toast.LENGTH_LONG).show();
        }
        // if nothing happens return null
        return null;
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
