package com.abhibarkade.try1_bth;

import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Intent;

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

    public Intent turnOn() {
        BluetoothManager bluetoothManager = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            bluetoothManager = application.getSystemService(BluetoothManager.class);
        }
        BluetoothAdapter bluetoothAdapter = bluetoothManager.getAdapter();
        Intent intent = null;
        if (!bluetoothAdapter.isEnabled())
            intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);

        return intent;
    }
}