package com.example.doctors;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

public class databasehandler extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "ian.db";
    private static final int VERSION = 1;
    private static final String TABLE = "Info";

    public databasehandler(View.OnClickListener context) {
        super((Context) context,DATABASE_NAME,null,VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL ( "Create table info(location varchar(100), fname varchar(100), lname varchar(100),gender varchar(20),email varchar(50),department varchar(20))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL ( "DROP table if exists info" );
        onCreate ( db );
    }
    public boolean saveInfor(String location, String fname,String lname ,String gender,String email,String department){
        SQLiteDatabase db=this.getWritableDatabase ();
        ContentValues values=new ContentValues(  );
        values.put ( "location",location );
        values.put ( "fname",fname );
        values.put ( "lname",lname );
        values.put ( "gender",gender );
        values.put ( "email",email );
        values.put ( "department",department );



        long sendData=db.insert ( TABLE,null,values );
        if (sendData==-1)
            return false;
        else
            return true;
    }
}

