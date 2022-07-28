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
        SharedPreferences per = getSharedPreferences("Password", MODE_PRIVATE);
        String fir = per.getString("pass", "ni");

        //   DBcom DB;
        new Handler().postDelayed(new Runnable(){
                @Override
                public void run(){

                    if(fir.length() != 4){
                        Intent intent = new Intent(getApplicationContext(), starter.class);
                        startActivity(intent);
                        finish();

                    }else {
                        Intent intent = new Intent(getApplicationContext(),enterer.class);
                        startActivity(intent);
                        finish();
                    }
        }

        },2000);

    }
}