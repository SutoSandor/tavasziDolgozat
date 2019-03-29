package com.example.tavaszidolgozat;

import android.content.Intent;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Formatter;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class WifiInfo extends AppCompatActivity {
    private Button wifiaddress, vissza;
    private TextView ipcim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi_info);
        init();
        wifiaddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WifiManager wm = (WifiManager) getSystemService(WIFI_SERVICE);
                String ip = Formatter.formatIpAddress(wm.getConnectionInfo().getIpAddress());
                ipcim.setText("IP ADDRESS: "+ip);
                Toast.makeText(WifiInfo.this, "IP elmentve!", Toast.LENGTH_SHORT).show();
            }
        });
        vissza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WifiInfo.this,MainActivity.class));
            }
        });
    }
    public void init(){
        wifiaddress = findViewById(R.id.ipaddress);
        ipcim = findViewById(R.id.ip_cim);
        vissza = findViewById(R.id.vissza);
    }
}
