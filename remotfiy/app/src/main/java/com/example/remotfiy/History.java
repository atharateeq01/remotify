package com.example.remotfiy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class History extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Logs";
    public static final String TABLE_NAME = "Record";

    public History(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table " + TABLE_NAME + " (phone text ,functionality text,date text,time text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String phone, String functionality, String Date, String time) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("phone", phone);
        contentValues.put("functionality", functionality);
        contentValues.put("date", Date);
        contentValues.put("time", time);

        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public Cursor viewAll() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }

    public void deleteall() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("Delete from " + TABLE_NAME);
    }
}