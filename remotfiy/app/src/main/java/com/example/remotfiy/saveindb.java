package com.example.remotfiy;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class saveindb extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    public static class saveind{
        private static saveind instance;

        public saveind(){

        }

        public static saveind getInstance(){
            if (instance == null){
                instance = new saveind();
            }
            return instance;
        }

        public void getFoo(String aa) {
            String a = aa;
        }
        // your fields, getter and setter here

    }
}
