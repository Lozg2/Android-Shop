package com.example.shopmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] Price = {"Saber", "Kami","Berserker","Archer","Rider"};
    String[] Hot = {"Saber", "Berserker","Rider","Archer","Kami"};
    String[] Evaluate = {"Berserker", "Archer","Rider","Saber","Kami"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this,"启动成功",Toast.LENGTH_LONG).show();

        Data myApp = (Data) getApplication();
        myApp.setGlobalVariable(0);
        myApp.setGlobalVariable2("\n");  // 给全局变量赋值

        ListView lv_start = (ListView) findViewById(R.id.lv_start);
        Button bt_new = findViewById(R.id.bt_new);
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        bt_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, New.class);
                startActivity(intent);
            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                //创数据库
                NewSQL dataHelper = new NewSQL(MainActivity.this, "NewSQL.db", null, 3);
                dataHelper.getWritableDatabase();

                //重置
                SQLiteDatabase database = dataHelper.getWritableDatabase();
                database.execSQL("DELETE FROM Goods;");
                database.execSQL("UPDATE sqlite_sequence SET seq = 0 WHERE name ='Goods'");

                //存入初始数据
                ContentValues values = new ContentValues();
                values.put("name","Saber");
                values.put("price",99.0);
                values.put("image",R.drawable.saber);
                database.insert("Goods",null,values);
                values.put("name","Kami");
                values.put("price",88.0);
                values.put("image",R.drawable.kami);
                database.insert("Goods",null,values);
                values.put("name","Berserker");
                values.put("price",77.2);
                values.put("image",R.drawable.berserker);
                database.insert("Goods",null,values);
                values.put("name","Archer");
                values.put("price",66.6);
                values.put("image",R.drawable.archer);
                database.insert("Goods",null,values);
                values.put("name","Rider");
                values.put("price",55.7);
                values.put("image",R.drawable.rider);
                database.insert("Goods",null,values);

                switch (checkedId) {
                    case R.id.rb_price:
                        //ListView
                        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, Price);
                        lv_start.setAdapter(adapter1);
                        lv_start.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // 获取点击的商品信息
                                String selectedProduct = (String) parent.getItemAtPosition(position);

                                // 将商品名字传递到另一个活动中
                                Intent intent = new Intent(MainActivity.this, ProductDetailActivity.class);
                                intent.putExtra("productName", selectedProduct);
                                startActivity(intent);
                            }

                        });
                        break;
                    case R.id.rb_hot:
                        //ListView
                        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, Hot);
                        lv_start.setAdapter(adapter2);
                        lv_start.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // 获取点击的商品信息
                                String selectedProduct = (String) parent.getItemAtPosition(position);

                                // 将商品名字传递到另一个活动中
                                Intent intent = new Intent(MainActivity.this, ProductDetailActivity.class);
                                intent.putExtra("productName", selectedProduct);
                                startActivity(intent);
                            }
                        });
                        break;

                    case R.id.rb_evaluate:
                        //ListView
                        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, Evaluate);
                        lv_start.setAdapter(adapter3);
                        lv_start.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                // 获取点击的商品信息
                                String selectedProduct = (String) parent.getItemAtPosition(position);

                                // 将商品名字传递到另一个活动中
                                Intent intent = new Intent(MainActivity.this, ProductDetailActivity.class);
                                intent.putExtra("productName", selectedProduct);
                                startActivity(intent);
                            }
                        });
                        break;
                }
            }
        });


    }
}

