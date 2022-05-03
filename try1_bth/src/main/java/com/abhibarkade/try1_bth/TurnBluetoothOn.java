package com.abhibarkade.try1_bth;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Intent;

import java.nio.channels.AcceptPendingException;

public class TurnBluetoothOn {

    Application application;

    public TurnBluetoothOn(Application application) {
        this.application = application;
    }

    public boolean checkDeviceSupport() {
        BluetoothManager bluetoothManager = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            bluetoothManager = application.getSystemService(BluetoothManager.class);
        }
        BluetoothAdapter bluetoothAdapter = bluetoothManager.getAdapter();
        return bluetoothAdapter == null;
    }

    @SuppressLint("MissingPermission")
    public void turnOn() {
        BluetoothManager bluetoothManager = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            bluetoothManager = application.getSystemService(BluetoothManager.class);
        }
        BluetoothAdapter bluetoothAdapter = bluetoothManager.getAdapter();

        Activity activity= (Activity) application.getApplicationContext();
        activity.startActivityForResult(new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE),101);
    }
}