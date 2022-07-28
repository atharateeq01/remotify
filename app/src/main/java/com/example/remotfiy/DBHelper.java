package com.example.remotfiy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.concurrent.ConcurrentHashMap;

public class DBHelper extends SQLiteOpenHelper{
    private starter context;

    public DBHelper(starter context) {
        super(context, "Remoti", null, 1);
    }

    public DBHelper(chnage_password context) {
        super(context, "Remoti", null, 1);
    }
    public DBHelper(enterer context) {
        super(context, "Remoti", null, 1);
    }




    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create table user (Id number primary key , password text, re_password text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop table if exists user");

    }


    public Boolean insert (String user_phone, String password){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("re_password" , user_phone);
        contentValues.put("password" , password);
        contentValues.put("Id" , 44);
        long result = DB.insert("user", null, contentValues);
        if(result == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public Boolean update (String newpassword, String oldpassword) {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("update user set password = ?  , re_password = ? where password = ?", new String[]{newpassword, newpassword, oldpassword});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean checkpass( String message) {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("select * from user where password = ?", new String[]{message});
        if(cursor.getCount() > 0){
            return true;
        }
        else{
            return false;
        }
    }



    public Boolean insert_pas ( String password){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("password" , password);
        long result = DB.insert("user", null, contentValues);
        if(result == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public Boolean check (String password){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("select * from user where password = ?", new String[]{password});
        if(cursor.getCount() > 0){
            return true;
        }
        else{
            return false;
        }
    }

    public void onCreate2(SQLiteDatabase DB) {
        DB.execSQL("create table sms_text (text_id number primary key AUTOINCREMENT, sms text, sms_form text)");

    }


    public void onUpgrade2(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop table if exists sms_text");

    }
    public Boolean inserttext (String sms, String sms_from){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("sms" , sms);
        contentValues.put("sms_from" , sms_from);
        long result = DB.insert("sms_text", null, contentValues);
        if(result == -1){
            return false;
        }
        else{
            return true;
        }
    }


}
