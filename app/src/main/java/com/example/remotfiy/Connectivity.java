package com.example.remotfiy;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;

public class Connectivity {
    Context context;

    public Connectivity(Context context) {
        this.context = context;
    }

    public Boolean checkconnection() {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activenetwork = connectivityManager.getActiveNetworkInfo();

        if (null != activenetwork) {
            if (activenetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                return true;
            } else if (activenetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

}
