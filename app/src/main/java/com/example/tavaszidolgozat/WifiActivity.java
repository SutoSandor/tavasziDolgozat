package com.example.tavaszidolgozat;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class WifiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi);
        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.navigation);
        final WifiManager wifi = (WifiManager)WifiActivity.this.getSystemService(Context.WIFI_SERVICE);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.back:
                        startActivity(new Intent(WifiActivity.this, MainActivity.class));
                        break;
                    case R.id.wifioff:
                        Toast.makeText(WifiActivity.this, "WifiKi", Toast.LENGTH_SHORT).show();
                        wifi.setWifiEnabled(false);
                        break;
                    case R.id.wifion:
                        Toast.makeText(WifiActivity.this, "WifiOn", Toast.LENGTH_SHORT).show();
                        wifi.setWifiEnabled(true);
                        break;
                }
                return true;
            }
        });
    }
}
