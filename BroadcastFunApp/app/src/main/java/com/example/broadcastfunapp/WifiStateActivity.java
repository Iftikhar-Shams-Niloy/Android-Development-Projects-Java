package com.example.broadcastfunapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class WifiStateActivity extends AppCompatActivity {
    Button buttonGetStatus;
    TextView connectionType;
    TextView connectionStatus;
    NetworkRequest networkRequest;
    ImageView imageNetworkState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi_state);
        buttonGetStatus = findViewById(R.id.button_get_status);
        connectionType = findViewById(R.id.text_view_connection_type);
        connectionStatus = findViewById(R.id.text_view_connection_status);
        imageNetworkState = findViewById(R.id.image_view_state);
        setOnClickListeners();
    }

    private void setOnClickListeners() {
        buttonGetStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkConnection()) {
                    Toast.makeText(getApplicationContext(), "Connected", Toast.LENGTH_SHORT).show();
                } else {
                    connectionStatus.setText("Status : Offline" );
                    connectionType.setText("Type : N/A");
                    Toast.makeText(getApplicationContext(), "Disconnected", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public boolean checkConnection() {
        ConnectivityManager myConnectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo myNetworkInfo = myConnectivityManager.getActiveNetworkInfo();
        if (myNetworkInfo == null){
            return false;
        }
        if (myNetworkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
            setWifiSignal();
        }
        if (myNetworkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
            setMobileSignal();
        }
        return true;
    }

    private void setMobileSignal() {
        TelephonyManager myTelephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            SignalStrength mySignalStrength = myTelephonyManager.getSignalStrength();
            int signalLevel = mySignalStrength.getLevel();
            connectionType.setText("Type : Mobile Data");
            connectionStatus.setText("Status : " + signalLevel);
            if (signalLevel == 4){
                imageNetworkState.setImageResource(R.drawable.cellularhigh);
            } else if (signalLevel == 3) {
                imageNetworkState.setImageResource(R.drawable.cellularmedium);
            } else if (signalLevel == 2) {
                imageNetworkState.setImageResource(R.drawable.cellularlow);
            } else {
                imageNetworkState.setImageResource(R.drawable.cellulargone);
            }
        }
    }

    private void setWifiSignal(){
        WifiManager myWifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInfo = myWifiManager.getConnectionInfo();
        int signalStrength = WifiManager.calculateSignalLevel(wifiInfo.getRssi(), 3) + 1;
        connectionType.setText("Type : Wifi");
        connectionStatus.setText("Status : "+ signalStrength);
        if (signalStrength == 1){
            imageNetworkState.setImageResource(R.drawable.wifilow);
        } else if (signalStrength == 2) {
            imageNetworkState.setImageResource(R.drawable.wifimedium);
        } else if (signalStrength == 3) {
            imageNetworkState.setImageResource(R.drawable.wifihigh);
        }
    }
}