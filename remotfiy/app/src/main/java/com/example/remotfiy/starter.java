package com.example.remotfiy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class starter extends AppCompatActivity {

    EditText phone , password;
    Button login;
    DBHelper DB;
    DBcom dbc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starter);
        getSupportActionBar().hide();
        phone = findViewById(R.id.Phone_start);
        password = findViewById(R.id.pass_start);
        login = findViewById(R.id.login_start);
        DB = new DBHelper(this );
        dbc = new DBcom(this );
        dbc.insert("s_sound", "false");
        dbc.insert("s_bln", "false");
        dbc.insert("s_blo", "false");
        dbc.insert("s_fn", "false");
        dbc.insert("s_fo", "false");
        login.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                String pho = phone.getText().toString();
                String pas = password.getText().toString();
                if(TextUtils.isEmpty(pho) || TextUtils.isEmpty(pas)){
                    Toast.makeText(starter.this, "Enter phone# and password", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean che = DB.check(pas);
                    if(che == false){
                        Boolean in = DB.insert(pho, pas);
                        if (in == true ){
                            Toast.makeText(starter.this, "You may go ahead", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), enterer.class);
                            startActivity(intent);
                            finish();
                        }
                        else{
                            Toast.makeText(starter.this, "Something went wrong", Toast.LENGTH_SHORT).show();

                        }
                    }
                    else{
                        Toast.makeText(starter.this, "Password exist", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });


    }
}