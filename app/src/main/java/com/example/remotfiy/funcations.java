package com.example.remotfiy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class funcations extends AppCompatActivity {

    Switch s_sound, s_bln, s_blo, s_fo, s_fn, s_no_sound, moden, modev, modes, help, loc, wifion, wifioff;
    Button back;
    DBcom DB;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funcations);
        getSupportActionBar().hide();

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1000);
        }
        back =findViewById(R.id.Back_all);
        //save =findViewById(R.id.save_all);
   //     s_sound =findViewById(R.id.s_sound);
        s_sound = findViewById(R.id.s_sound);
        s_bln = findViewById(R.id.s_bluthon);
        s_blo = findViewById(R.id.s_bluthoff);
        s_fn = findViewById(R.id.s_flashon);
        s_fo = findViewById(R.id.s_flashoff);
        s_no_sound = findViewById(R.id.s_no_sound);
        moden = findViewById(R.id.mode_n);
        modev = findViewById(R.id.mode_v);
        modes = findViewById(R.id.moded_s);
        loc  = findViewById(R.id.s_loc);
        help  = findViewById(R.id.help);

        SharedPreferences sharedPreferences = getSharedPreferences("save", MODE_PRIVATE);
        s_sound.setChecked(sharedPreferences.getBoolean("value",false));
        s_no_sound.setChecked(sharedPreferences.getBoolean("value1",false));
        s_bln.setChecked(sharedPreferences.getBoolean("value2",false));
        s_blo.setChecked(sharedPreferences.getBoolean("value3",false));
        s_fn.setChecked(sharedPreferences.getBoolean("value4",false));
        s_fo.setChecked(sharedPreferences.getBoolean("value5",false));
        modev.setChecked(sharedPreferences.getBoolean("value6",false));
        modes.setChecked(sharedPreferences.getBoolean("value7",false));
        moden.setChecked(sharedPreferences.getBoolean("value8",false));
        help.setChecked(sharedPreferences.getBoolean("value9",false));
        loc.setChecked(sharedPreferences.getBoolean("value12",false));

       // DB = new DBcom(this );
        s_sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (s_sound.isChecked()) {
                    // DB.update("s_sound", "true");
                    SharedPreferences.Editor editor = getSharedPreferences("save", MODE_PRIVATE
                    ).edit();
                    editor.putBoolean("value", true);
                    editor.apply();

                    s_sound.setChecked(true);
                } else {
                    //    DB.update("s_sound", "false");
                    SharedPreferences.Editor editor = getSharedPreferences("save", MODE_PRIVATE
                    ).edit();
                    editor.putBoolean("value", false);
                    editor.apply();
                    s_sound.setChecked(false);
                }
            }
        });

        s_no_sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (s_no_sound.isChecked()) {
                    // DB.update("s_sound", "true");
                    SharedPreferences.Editor editor = getSharedPreferences("save", MODE_PRIVATE
                    ).edit();
                    editor.putBoolean("value1", true);
                    editor.apply();

                    s_no_sound.setChecked(true);
                } else {
                    //    DB.update("s_sound", "false");
                    SharedPreferences.Editor editor = getSharedPreferences("save", MODE_PRIVATE
                    ).edit();
                    editor.putBoolean("value1", false);
                    editor.apply();
                    s_no_sound.setChecked(false);
                }
            }
        });

        s_fn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (s_fn.isChecked()) {
                    // boolean a = DB.update("s_fn", "true");
                    SharedPreferences.Editor editor = getSharedPreferences("save", MODE_PRIVATE
                    ).edit();
                    editor.putBoolean("value4", true);
                    editor.apply();

                    s_fn.setChecked(true);
                } else {
                    // boolean a = DB.update("s_fn", "false");
                    SharedPreferences.Editor editor = getSharedPreferences("save", MODE_PRIVATE
                    ).edit();
                    editor.putBoolean("value4", false);
                    editor.apply();
                    s_fn.setChecked(false);
                }
            }
        });

        s_fo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (s_fo.isChecked()) {
                    // DB.update("s_sound", "true");
                    SharedPreferences.Editor editor = getSharedPreferences("save", MODE_PRIVATE
                    ).edit();
                    editor.putBoolean("value5", true);
                    editor.apply();

                    s_fo.setChecked(true);
                } else {
                    //    DB.update("s_sound", "false");
                    SharedPreferences.Editor editor = getSharedPreferences("save", MODE_PRIVATE
                    ).edit();
                    editor.putBoolean("value5", false);
                    editor.apply();
                    s_fo.setChecked(false);
                }
            }
        });

        s_bln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (s_bln.isChecked()) {
                    // boolean a = DB.update("s_fn", "true");
                    SharedPreferences.Editor editor = getSharedPreferences("save", MODE_PRIVATE
                    ).edit();
                    editor.putBoolean("value2", true);
                    editor.apply();

                    s_bln.setChecked(true);
                } else {
                    // boolean a = DB.update("s_fn", "false");
                    SharedPreferences.Editor editor = getSharedPreferences("save", MODE_PRIVATE
                    ).edit();
                    editor.putBoolean("value2", false);
                    editor.apply();
                    s_bln.setChecked(false);
                }
            }
        });

        s_blo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (s_blo.isChecked()) {
                    // boolean a = DB.update("s_fn", "true");
                    SharedPreferences.Editor editor = getSharedPreferences("save", MODE_PRIVATE
                    ).edit();
                    editor.putBoolean("value3", true);
                    editor.apply();

                    s_blo.setChecked(true);
                } else {
                    // boolean a = DB.update("s_fn", "false");
                    SharedPreferences.Editor editor = getSharedPreferences("save", MODE_PRIVATE
                    ).edit();
                    editor.putBoolean("value3", false);
                    editor.apply();
                    s_blo.setChecked(false);
                }
            }
        });

        modes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (modes.isChecked()) {
                    // boolean a = DB.update("s_fn", "true");
                    SharedPreferences.Editor editor = getSharedPreferences("save", MODE_PRIVATE
                    ).edit();
                    editor.putBoolean("value7", true);
                    editor.apply();

                    modes.setChecked(true);
                } else {
                    // boolean a = DB.update("s_fn", "false");
                    SharedPreferences.Editor editor = getSharedPreferences("save", MODE_PRIVATE
                    ).edit();
                    editor.putBoolean("value7", false);
                    editor.apply();
                    modes.setChecked(false);
                }
            }
        });

        moden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (moden.isChecked()) {
                    // boolean a = DB.update("s_fn", "true");
                    SharedPreferences.Editor editor = getSharedPreferences("save", MODE_PRIVATE
                    ).edit();
                    editor.putBoolean("value8", true);
                    editor.apply();

                    moden.setChecked(true);
                } else {
                    // boolean a = DB.update("s_fn", "false");
                    SharedPreferences.Editor editor = getSharedPreferences("save", MODE_PRIVATE
                    ).edit();
                    editor.putBoolean("value8", false);
                    editor.apply();
                    moden.setChecked(false);
                }
            }
        });

        modev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (modev.isChecked()) {
                    // boolean a = DB.update("s_fn", "true");
                    SharedPreferences.Editor editor = getSharedPreferences("save", MODE_PRIVATE
                    ).edit();
                    editor.putBoolean("value6", true);
                    editor.apply();

                    modev.setChecked(true);
                } else {
                    // boolean a = DB.update("s_fn", "false");
                    SharedPreferences.Editor editor = getSharedPreferences("save", MODE_PRIVATE
                    ).edit();
                    editor.putBoolean("value6", false);
                    editor.apply();
                    modev.setChecked(false);
                }
            }
        });

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (help.isChecked()) {
                    // boolean a = DB.update("s_fn", "true");
                    SharedPreferences.Editor editor = getSharedPreferences("save", MODE_PRIVATE
                    ).edit();
                    editor.putBoolean("value9", true);
                    editor.apply();

                    help.setChecked(true);
                } else {
                    // boolean a = DB.update("s_fn", "false");
                    SharedPreferences.Editor editor = getSharedPreferences("save", MODE_PRIVATE
                    ).edit();
                    editor.putBoolean("value9", false);
                    editor.apply();
                    help.setChecked(false);
                }
            }
        });



        loc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (loc.isChecked()) {
                    // boolean a = DB.update("s_fn", "true");
                    SharedPreferences.Editor editor = getSharedPreferences("save", MODE_PRIVATE
                    ).edit();
                    editor.putBoolean("value12", true);
                    editor.apply();
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
                        requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 1000);
                    }
                    loc.setChecked(true);
                } else {
                    // boolean a = DB.update("s_fn", "false");
                    SharedPreferences.Editor editor = getSharedPreferences("save", MODE_PRIVATE
                    ).edit();
                    editor.putBoolean("value12", false);
                    editor.apply();
                    loc.setChecked(false);
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        DB = new DBcom(this );

//        save.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(s_sound.isChecked()) {
//                   // DB.update("s_sound", "true");
//
//                    s_sound.setChecked(false);
//                }else {
//                //    DB.update("s_sound", "false");
//                    s_sound.setChecked(true);
//                }
//                if(s_sound.isChecked()) {
//                    DB.update("s_sound", "true");
//
//                    s_sound.setChecked(true);
//                }else {
//                    DB.update("s_sound", "false");
//                    s_sound.setChecked(false);
//                }
//                if(s_bln.isChecked()) {
//                    DB.update("s_btn", "true");
//                    s_bln.setChecked(true);
//                }else {
//                    DB.update("s_bln", "false");
//                    s_bln.setChecked(false);
//                }
//                if(s_blo.isChecked()) {
//                    DB.update("s_bln", "true");
//                    s_blo.setChecked(true);
//                }else {
//                    DB.update("s_blo", "false");
//                    s_blo.setChecked(false);
//                }
//                if(s_fn.isChecked()) {
//                    DB.update("s_fn", "true");
//                    s_fn.setChecked(true);
//                }else {
//                    DB.update("s_fn", "false");
//                    s_fn.setChecked(false);
//                }
//                if(s_fo.isChecked()) {
//                    DB.update("s_fo", "true");
//                    s_fo.setChecked(true);
//                }else {
//                    DB.update("s_fo", "false");
//                    s_fo.setChecked(false);
//                }
//                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        });
    }

}