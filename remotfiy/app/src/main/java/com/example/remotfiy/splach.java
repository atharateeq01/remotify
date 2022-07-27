package com.example.remotfiy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class splach extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splach);
        getSupportActionBar().hide();
     //   DBcom DB;
        new Handler().postDelayed(new Runnable(){
                @Override
                public void run(){
                    SharedPreferences per = getSharedPreferences("REFERENCES", MODE_PRIVATE);
                    String fir = per.getString("first_time", "yes");

                    if(fir.equals("yes")){
                        SharedPreferences.Editor edit = per.edit();
                        edit.putString("first_time", "no");
                        edit.apply();
                        Intent intent = new Intent(getApplicationContext(), starter.class);
                        startActivity(intent);
                        finish();

                    }else {
                        SharedPreferences.Editor edit = per.edit();
                        edit.putString("first_time", "no");
                        edit.apply();
                        Intent intent = new Intent(getApplicationContext(),enterer.class);
                        startActivity(intent);
                        finish();
                    }
        }

        },2000);

    }
}