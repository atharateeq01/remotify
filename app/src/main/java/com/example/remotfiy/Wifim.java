package com.example.remotfiy;

import android.content.Context;
import android.net.wifi.WifiManager;

public class Wifim {
    Context context;
    WifiManager wifiManager;

    public Wifim(Context context) {
        this.context = context;
        wifiManager = (android.net.wifi.WifiManager) this.context.getSystemService(Context.WIFI_SERVICE);
    }

    public void wifion() {

        wifiManager.setWifiEnabled(true);
    }

    public void wifioff() {

        wifiManager.setWifiEnabled(false);
    }


}
