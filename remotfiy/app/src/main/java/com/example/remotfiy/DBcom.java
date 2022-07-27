package com.example.remotfiy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBcom extends SQLiteOpenHelper {
    private starter context;
    private ReceiveSms contexta;

    public DBcom(funcations context) {
        super(context, "Remoti", null, 1);
    }

    public DBcom(starter context) {
        super(context, "Remoti", null, 1);
    }
    public DBcom(Context context) {
        super(context, "Remoti", null, 1);
    }




    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create table command (com_id number primary key AUTOINCREMENT, com_name text, com_status text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop table if exists command");

    }


    public Boolean insert (String com_name, String com_status){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("com_name" , com_name);
        contentValues.put("com_status" , com_status);
        long result = DB.insert("command", null, contentValues);
        if(result == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public Boolean update (String com_name, String com_status) {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("update command set com_status = ?  where com_name = ?", new String[]{com_status, com_name});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean check (String com_name, String com_status){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("select * from user where com_name =? & com_status = ?", new String[]{ com_name, com_status});
        if(cursor.getCount() > 0){
            return true;
        }
        else{
            return false;
        }
    }



}

