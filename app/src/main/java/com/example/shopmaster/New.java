package com.example.shopmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class New extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        Button bt_create = (Button) findViewById(R.id.bt_create);
        Button bt_add = (Button) findViewById(R.id.bt_add);
        Button bt_update = (Button) findViewById(R.id.bt_update);
        Button bt_query = (Button) findViewById(R.id.bt_query);
        Button bt_delete = (Button) findViewById(R.id.bt_delete);
        EditText et_name = (EditText) findViewById(R.id.et_name);
        EditText et_age = (EditText) findViewById(R.id.et_age);
        NewSQL databaseHelper = new NewSQL(New.this, "Goods.db", null, 3);
        //创建数据库
        bt_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.getWritableDatabase();
            }
        });
        //向表中插入数据
        bt_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = et_name.getText().toString();
                int age = Integer.parseInt(et_age.getText().toString());
                SQLiteDatabase database = databaseHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("name",name);
                values.put("price",age);
                database.insert("Goods",null,values);
                Toast.makeText(New.this,"数据插入成功",Toast.LENGTH_LONG).show();
            }
        });
        //修改表中的数据
        bt_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase database = databaseHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                String name = et_name.getText().toString();
                values.put("price",name);
                database.update("Goods",values,"name=?",new String[]{"张三"});
                Toast.makeText(New.this,"更新数据成功",Toast.LENGTH_LONG).show();
            }
        });
        //查找数据库里的内容
        SQLiteDatabase database = databaseHelper.getWritableDatabase();
        Cursor cursor = database.query("Goods", null, null, null, null, null, null, null);
        if (cursor.moveToFirst()){
            do{
                String name = cursor.getString(cursor.getColumnIndex("name"));
                double age = cursor.getDouble(cursor.getColumnIndex("price"));
                int image = cursor.getInt(cursor.getColumnIndex("image"));
                Log.i("查询结果",name+"---"+age+"---"+image);
            }while (cursor.moveToNext());
        }

        cursor.close();
        //删除数据
        bt_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase database1 = databaseHelper.getWritableDatabase();
                database.delete("Goods","name=?",new String[]{"李四"});
                Toast.makeText(New.this,"数据删除成功",Toast.LENGTH_LONG).show();
            }
        });
    }
}