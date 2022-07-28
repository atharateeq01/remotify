package com.example.remotfiy;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;

public class bluetooth {
    BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    Context context;

    public bluetooth(Context context) {
        this.context = context;
    }

    public void turn_on_bluetooth() {
        this.bluetoothAdapter.enable();
    }

    public void turn_off_bluetooth() {
        this.bluetoothAdapter.disable();
    }
}
