package com.example.coafarm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="mydata.db";
    public static final int VERSION=1;
    //資料庫物件 固定的欄位變數
    private static SQLiteDatabase database;


    public MyDBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //需要使用資料庫的元件呼叫這個方法取得資料庫物件，一般的應用都不需要修改
    public static SQLiteDatabase getDatabase(Context context){
        if(database==null||!database.isOpen()){
            database=new MyDBHelper(context,DATABASE_NAME,null,VERSION).getWritableDatabase();
        }
        return database;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
         db.execSQL(FarmDAO.CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //刪除原有的表格
        db.execSQL("DROP TABLE IF EXISTS "+FarmDAO.TABLE_NAME);
        //會再回來完成這裡需要執行的工作
        //呼叫onCreate建立新版的表格
        onCreate(db);
    }
}
