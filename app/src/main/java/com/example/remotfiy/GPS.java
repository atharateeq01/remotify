package com.example.remotfiy;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;

public class GPS {
    Location gps = null, network = null, final_loc = null;
    LocationManager locationManager;
    Context context;

    public GPS(Context context) {
        this.context = context;
        locationManager = (LocationManager) this.context.getSystemService(Context.LOCATION_SERVICE);

    }

    public String getLocation() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (this.context.checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && this.context.checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    Activity#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for Activity#requestPermissions for more details.
                return "Permission not granted";
            }
        }
        gps = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        network = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        if (gps != null) {
            String loc = "Latitude:  " + gps.getLatitude() + "\nLongitude:  " + gps.getLongitude();
            gps.reset();
            return loc;
        } else if (network != null) {
            String loc = "Latitude" + network.getLatitude() + "\nLongitude:  " + network.getLongitude();
            gps.reset();
            return loc;
        } else {
            return "Can't get Location";
        }
    }
}

