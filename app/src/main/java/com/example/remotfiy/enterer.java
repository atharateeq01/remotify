package com.example.remotfiy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class enterer extends AppCompatActivity {
    EditText password;
    Button login;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enterer);
        getSupportActionBar().hide();



        password = findViewById(R.id.pass_enter);
        login = findViewById(R.id.login_enter);
        DB = new DBHelper(this );
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pas = password.getText().toString();
                if( TextUtils.isEmpty(pas)){
                    Toast.makeText(enterer.this, "Enter password", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean che = DB.check(pas);
                    if(che == true){
                        Toast.makeText(enterer.this, "You may go ahead", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    else{
                        Toast.makeText(enterer.this, "Incorrect password", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });
    }
}