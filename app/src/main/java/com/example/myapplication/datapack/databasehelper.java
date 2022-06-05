package com.example.myapplication.datapack;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.myapplication.model.item;
import com.example.myapplication.util.util;

import java.util.ArrayList;
import java.util.List;

public class databasehelper extends SQLiteOpenHelper {

    String name, phn, description, date, location, postType;


    public databasehelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, util.DATABASE_NAME, factory, util.DATABASE_VERSION);
    }
    public databasehelper(@Nullable Context context)
    {
        super(context, util.DATABASE_NAME, null, util.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
         String CREATE_ITEM_TABLE = "CREATE TABLE " + util.TABLE_NAME + "(" + util.ITEM_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + util.NAME + " TEXT , " + util.PHONE + " TEXT , " + util.DATE + " TEXT , " + util.LOCATION
+ " TEXT , " + util.DESCRIPTION + " TEXT , " + util.POST_TYPE + " TEXT)";
         db.execSQL(CREATE_ITEM_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String DROP_ITEM_TABLE = "DROP TABLE IF EXISTS '" + util.TABLE_NAME+ "'";
        db.execSQL(DROP_ITEM_TABLE, new String [] {util.TABLE_NAME});
        onCreate(db);

    }

    public long insertItem(item item)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(util.NAME, item.getName());
        contentValues.put(util.PHONE, item.getPhn());
        contentValues.put(util.DESCRIPTION, item.getDescrp());
        contentValues.put(util.LOCATION, item.getLocation());
        contentValues.put(util.DATE, item.getDate());
        contentValues.put(util.POST_TYPE, item.getPost_type());

        long newRowID = db.insert(util.TABLE_NAME, null, contentValues);
        db.close();
        return newRowID;

    }
    public String fetchItem(int item_id)
    {
        String r="0";

        String q= "SELECT * FROM " + util.TABLE_NAME + " where " + util.ITEM_ID + "= '" + Integer.toString(item_id) + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(q, null);
        if(cursor.moveToFirst())
        {
            do{
                postType = cursor.getString(0);
                name = cursor.getString(1);
                phn = Integer.toString(cursor.getInt(2));
                description = cursor.getString(3);
                date = cursor.getString(4);
                location  = cursor.getString(5);

                r = postType + "\n Name " + name + "\n Phone No." + phn + "\n Description: " + description + "\n Date: "  + date + "\n Location: " + location;



            }while (cursor.moveToNext());
        }
        db.close();
        return  r;
    }

    public Cursor fetchAllItem()
    {
        List<item> itemList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String listAll = "select * from " + util.TABLE_NAME;
        Cursor cursor0 = db.rawQuery(listAll, null);


        return cursor0;

    }

    public void deleteItem(String names, String descriptions)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String q = " DELETE FROM "+util.TABLE_NAME+" WHERE "+names+" = '"+name+"'"+" AND "+descriptions+" = '"+description+"'";
        Cursor cursor = db.rawQuery(q, null);
        db.close();

    }
}
