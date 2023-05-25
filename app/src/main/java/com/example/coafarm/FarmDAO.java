package com.example.coafarm;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class FarmDAO {
    public static final String TABLE_NAME="farm";
    //編號表格欄位的名稱 固定不變
    public static final String KEY_ID="_id";
    public static final String  NAME_COLUMN="Name";
    public static final String  TEL_COLUMN="Tel";
    public static final String  INTRODUCTION_COLUMN="Introduction";
    public static final String  TRAFFIC_COLUMN= "TrafficGuidelines";
    public static final String  ADDRESS_COLUMN ="Address";
    public static final String  CITY_COLUMN = "City";
    public static final String  TOWN_COLUMN = "Town";
    public static final String  PHOTO_COLUMN = "Photo";
    public static final String  LATITUDE_COLUMN = "Latitude";
    public static final String  LONGITUDE_COLUMN = "Longitude";

//    public static final String CREATE_TABLE="CREATE TABLE farm (_id  INTEGER PRIMARY KEY   AUTOINCREMENT,Name TEXT " +
//            ",Tel TEXT ,Introduction TEXT ,TrafficGuidelines TEXT ,Address TEXT ,City TEXT ,Town TEXT ,Photo TEXT ) ";

    public static final String CREATE_TABLE="CREATE TABLE "+TABLE_NAME+" ("+
            KEY_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, "+
            NAME_COLUMN+" TEXT,"+
            TEL_COLUMN+" TEXT,"+
            INTRODUCTION_COLUMN+" TEXT,"+
            TRAFFIC_COLUMN+" TEXT,"+
            ADDRESS_COLUMN+" TEXT,"+
            CITY_COLUMN+" TEXT,"+
            TOWN_COLUMN+" TEXT,"+
            PHOTO_COLUMN+" TEXT,"+
            LATITUDE_COLUMN+" TEXT,"+
            LONGITUDE_COLUMN+" TEXT)"
           ;
    private     SQLiteDatabase db;
    public FarmDAO(Context context){
        db=MyDBHelper.getDatabase(context);
    }

    public void close(){
        db.close();
    }

    public List<Farm> getAll(){
        List<Farm> result = new ArrayList<Farm>();
        Cursor c = db.query(TABLE_NAME,null,null,null,null,null,null);
        while (c.moveToNext()){
            result.add(getRecord(c));
        }
        return result;
    }


    public Farm insert (Farm farm){
        //建立準備新增資料的ContentValues物件
        ContentValues cv =new ContentValues();

        //加入ContentValues物件包裝的新增資料
        //第一個參數是欄位名稱 第二個參數是欄位的資料
//        cv.put(KEY_ID,farm.getID());
        cv.put(NAME_COLUMN,farm.getName());
        cv.put(TEL_COLUMN,farm.getTel());
        cv.put(INTRODUCTION_COLUMN,farm.getIntroduction());
        cv.put(TRAFFIC_COLUMN,farm.getTrafficGuidelines());
        cv.put(ADDRESS_COLUMN,farm.getAddress());
        cv.put(CITY_COLUMN,farm.getCity());
        cv.put(TOWN_COLUMN,farm.getTown());
        cv.put(PHOTO_COLUMN,farm.getPhoto());
        cv.put(LATITUDE_COLUMN,farm.getLatitude());
        cv.put(LONGITUDE_COLUMN,farm.getLongitude());
        Log.v("FarmDAO",""+cv);
        //新增一筆資料並取得編號
        //第一個參數是表格名稱
        //第二個參數是沒有指定欄位直的預設值
        //第三個參數是包裝新增資料的ContentValues物件
        long id=db.insert(TABLE_NAME,null,cv);

        //設定編號
//        farm.setID(id);
        //回傳結果
        return farm;
    }


    @SuppressLint("Range")
    public Farm getRecord(Cursor cursor){
        //準備回傳結果用的物件
        Farm result=new Farm();
        result.setID(cursor.getLong(0));
        result.setName(cursor.getString(cursor.getColumnIndex(NAME_COLUMN)));
        result.setTel(cursor.getString(cursor.getColumnIndex(TEL_COLUMN)));
        result.setIntroduction(cursor.getString(cursor.getColumnIndex(INTRODUCTION_COLUMN)));
        result.setTrafficGuidelines(cursor.getString(cursor.getColumnIndex(TRAFFIC_COLUMN)));
        result.setAddress(cursor.getString(cursor.getColumnIndex(ADDRESS_COLUMN)));
        result.setCity(cursor.getString(cursor.getColumnIndex(CITY_COLUMN)));
        result.setTown(cursor.getString(cursor.getColumnIndex(TOWN_COLUMN)));
        result.setPhoto(cursor.getString(cursor.getColumnIndex(PHOTO_COLUMN)));
        result.setLatitude(cursor.getString(cursor.getColumnIndex(LATITUDE_COLUMN)));
        result.setLongitude(cursor.getString(cursor.getColumnIndex(LONGITUDE_COLUMN)));
         //回傳結果
        return result;
    }

}
