package com.example.remotfiy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button change, function, logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.RECEIVE_SMS) != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.RECEIVE_SMS}, 1000);
        }

        logout = findViewById(R.id.logout);
        change = findViewById(R.id.change);
        function = findViewById(R.id.function);


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), enterer.class);
                startActivity(intent);
                finish();
            }
        });

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), chnage_password.class);
                startActivity(intent);
                finish();
            }
        });

        function.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), funcations.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void onReqeustPermissionResult(int reqestCode, @NonNull String[] persmission, @NonNull int[] grantResult){
        if(reqestCode == 100){
            if(grantResult[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "we can go for SMS", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "We can't get SMS", Toast.LENGTH_SHORT).show();
            }
        }
    }
}