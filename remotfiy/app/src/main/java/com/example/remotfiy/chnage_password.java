package com.example.remotfiy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class chnage_password extends AppCompatActivity {
    EditText newpass , oldpass;
    Button change1, back;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chnage_password);
        getSupportActionBar().hide();
        oldpass = findViewById(R.id.oldpass);
        newpass = findViewById(R.id.newpass);
        change1= findViewById(R.id.chnage1);
        back = findViewById(R.id.back);
        DB = new DBHelper(this );
        change1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String old = oldpass.getText().toString();
                String newp = newpass.getText().toString();
                if(TextUtils.isEmpty(old) || TextUtils.isEmpty(newp)){
                    Toast.makeText(chnage_password.this, "Enter old and new password", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean che = DB.check(old);
                    if(che == true){
                        Boolean in = DB.update(newp, old);
                        if (in == true ){
                            Toast.makeText(chnage_password.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), chnage_password.class);
                            startActivity(intent);
                            finish();
                        }
                        else{
                            Toast.makeText(chnage_password.this, "Your password is updated", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), enterer.class);
                            startActivity(intent);
                            finish();

                        }
                    }
                    else{
                        Toast.makeText(chnage_password.this, "Enter correct old password", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), chnage_password.class);
                        startActivity(intent);
                        finish();

                    }
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


    }
}