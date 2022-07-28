package com.example.remotfiy;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.telephony.SmsManager;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class Location {
    Context context;
    String loc;
    private FusedLocationProviderClient fusedLocationClient;
    LocationManager locationManager;

    public Location(Context context) {
        this.context = context;
        loc = "assa";
    }

    public void get(final String number) {

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(context);
        locationManager = (LocationManager) this.context.getSystemService(Context.LOCATION_SERVICE);

        if (ContextCompat.checkSelfPermission(context,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        } else {

            fusedLocationClient.getLastLocation()
                    .addOnSuccessListener(new OnSuccessListener<android.location.Location>() {
                        @Override
                        public void onSuccess(android.location.Location location) {
                            Double latitude =31.37794880665359;
                            Double longitude =74.23058293863417;
//                            latitude = location.getLatitude();
//                            longitude = location.getLongitude();
                            // Got last known location. In some rare situations this can be null.
                            if (location != null) {
                                // Logic to handle location object

                                latitude = location.getLatitude();
                                longitude = location.getLongitude();

                                //Toast.makeText(context, latitude+"", Toast.LENGTH_SHORT).show();
                                //loc="Latitude: "+location.getLatitude()+"\nLongitude: "+location.getLongitude();
                                loc = "Tap on link for phone's current location\n" +
                                        "https://maps.google.com/?q="
                                        + location.getLatitude() + "," + location.getLongitude();
                                sms_send(number, loc);
//                                Toast.makeText(context,loc,Toast.LENGTH_LONG).show();
                                location.reset();
                            } else {


                                loc = "Tap on link for phone's current location\n" +
                                        "https://maps.google.com/?q="
                                        + latitude + "," + longitude;
                                sms_send(number, loc);

                            }

                        }

                    });

        }
    }

    public void sms_send(String sender_contact, String message) {
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(sender_contact.substring(1), null, message, null, null); }
}
