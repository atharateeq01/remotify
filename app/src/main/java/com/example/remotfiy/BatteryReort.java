package com.example.remotfiy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build;

import static android.content.Context.BATTERY_SERVICE;

public class BatteryReort {
    int battery;
    Context context;

    public BatteryReort(Context context) {
        this.context = context;
    }

    public String getbattery() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            BatteryManager bm = (BatteryManager) this.context.getSystemService(BATTERY_SERVICE);
            battery = bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY);
        }
        return "Your phone is " + battery + "% charged.";
    }
}
