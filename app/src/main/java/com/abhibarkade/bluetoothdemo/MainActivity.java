package com.abhibarkade.bluetoothdemo;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.abhibarkade.try1_bth.TurnBluetoothOn;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TurnBluetoothOn bluetooth=new TurnBluetoothOn(getApplication());
        if(!bluetooth.checkDeviceSupport())
            Toast.makeText(this, "No Bluetooth", Toast.LENGTH_SHORT).show();
        else{
            startActivityForResult(bluetooth.turnOn(),101);
        }
    }
}