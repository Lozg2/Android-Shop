package com.example.shopmaster;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class NewSQL extends SQLiteOpenHelper {
    public static final String CREATE_GOODS = "create table Goods(" + "id integer primary key autoincrement," +
            "name text," + "price double," + "image integer)";
    private final Context mcontext;

    public NewSQL(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mcontext = context;
    }

    //创建数据库
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_GOODS);
        Toast.makeText(mcontext, "数据库创建成功", Toast.LENGTH_LONG).show();
    }

    //更新数据库
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Goods");
        onCreate(db);
    }

}