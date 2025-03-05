package com.example.shopmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductDetailActivity extends AppCompatActivity {

    private int check_saber = 0;
    private int check_berserker = 0;
    private int check_kami = 0;
    private int check_rider = 0;
    private int check_archer = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);


        // 在这里初始化视图和添加逻辑
        ImageView imageViewProduct = findViewById(R.id.imageViewProduct);
        TextView textViewName = findViewById(R.id.textViewName);
        TextView textViewPrice = findViewById(R.id.textViewPrice);
        CheckBox checkBoxAddToCart = findViewById(R.id.checkBoxAddToCart);
        Button buttonAddToCart = findViewById(R.id.buttonAddToCart);
        Button buttonSure = findViewById(R.id.buttonSure);

        buttonSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProductDetailActivity.this,CartActivity.class);
                startActivity(intent);
            }
        });

        //获取数据库
        NewSQL dataHelper = new NewSQL(ProductDetailActivity.this, "NewSQL.db", null, 3);
        dataHelper.getWritableDatabase();
        SQLiteDatabase database = dataHelper.getWritableDatabase();

        Intent intent = getIntent();
        String name = intent.getStringExtra("productName");
        switch (name){
            case "Saber":
                // 查询具有特定 ID 值的数据
                Cursor cursor1 = database.rawQuery("SELECT * FROM Goods WHERE id = ?", new String[]{String.valueOf(1)});
                cursor1.moveToFirst(); // 将 Cursor 移动到结果集的第一行
                double price1 = cursor1.getDouble(cursor1.getColumnIndex("price"));
                int image1 = cursor1.getInt(cursor1.getColumnIndex("image"));

                do {
                    // 处理数据
                    textViewPrice.setText("商品价格："+price1);
                    imageViewProduct.setImageResource(image1);
                } while (cursor1.moveToNext());

                //double price = 99.0;
                //int image = R.drawable.saber;
                textViewName.setText("商品名称："+name);
                if(check_saber == 1){
                    checkBoxAddToCart.setChecked(true);
                }
                // 添加点击事件监听器
                buttonAddToCart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        check_saber=1;
                        checkBoxAddToCart.setChecked(true);
                        Data myApp = (Data) getApplication();
                        String nameValue = myApp.getGlobalVariable2();
                        myApp.setGlobalVariable2(nameValue + name + "\n");
                        double currentValue = myApp.getGlobalVariable();
                        myApp.setGlobalVariable(currentValue + price1); // 给全局变量加钱
                    }
                });
                break;
            case "Kami":
                // 查询具有特定 ID 值的数据
                Cursor cursor2 = database.rawQuery("SELECT * FROM Goods WHERE id = ?", new String[]{String.valueOf(2)});
                cursor2.moveToFirst(); // 将 Cursor 移动到结果集的第一行
                double price2 = cursor2.getDouble(cursor2.getColumnIndex("price"));
                int image2 = cursor2.getInt(cursor2.getColumnIndex("image"));
                do {
                    // 处理数据
                    textViewPrice.setText("商品价格："+price2);
                    imageViewProduct.setImageResource(image2);
                } while (cursor2.moveToNext());

                textViewName.setText("商品名称："+name);
                if(check_kami == 1){
                    checkBoxAddToCart.setChecked(true);
                }
                // 添加点击事件监听器
                buttonAddToCart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        check_kami=1;
                        checkBoxAddToCart.setChecked(true);
                        Data myApp = (Data) getApplication();
                        String nameValue = myApp.getGlobalVariable2();
                        myApp.setGlobalVariable2(nameValue + name + "\n");
                        double currentValue = myApp.getGlobalVariable();
                        myApp.setGlobalVariable(currentValue + price2); // 给全局变量加钱
                    }
                });
                break;
            case "Berserker":
                // 查询具有特定 ID 值的数据
                Cursor cursor3 = database.rawQuery("SELECT * FROM Goods WHERE id = ?", new String[]{String.valueOf(3)});
                cursor3.moveToFirst(); // 将 Cursor 移动到结果集的第一行
                // 处理查询结果
                double price3 = cursor3.getDouble(cursor3.getColumnIndex("price"));
                int image3 = cursor3.getInt(cursor3.getColumnIndex("image"));

                do {
                    // 处理数据
                    textViewPrice.setText("商品价格："+price3);
                    imageViewProduct.setImageResource(image3);

                } while (cursor3.moveToNext());

                textViewName.setText("商品名称："+name);
                if(check_berserker == 1){
                    checkBoxAddToCart.setChecked(true);
                }
                // 添加点击事件监听器
                buttonAddToCart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        check_berserker=1;
                        checkBoxAddToCart.setChecked(true);
                        Data myApp = (Data) getApplication();
                        String nameValue = myApp.getGlobalVariable2();
                        myApp.setGlobalVariable2(nameValue + name + "\n");
                        double currentValue = myApp.getGlobalVariable();
                        myApp.setGlobalVariable(currentValue + price3); // 给全局变量加钱
                    }
                });
                break;
            case "Archer":
                // 查询具有特定 ID 值的数据
                Cursor cursor4 = database.rawQuery("SELECT * FROM Goods WHERE id = ?", new String[]{String.valueOf(4)});
                cursor4.moveToFirst(); // 将 Cursor 移动到结果集的第一行
                // 处理查询结果
                double price4 = cursor4.getDouble(cursor4.getColumnIndex("price"));
                int image4 = cursor4.getInt(cursor4.getColumnIndex("image"));

                do {
                    // 处理数据
                    textViewPrice.setText("商品价格："+price4);
                    imageViewProduct.setImageResource(image4);

                } while (cursor4.moveToNext());

                textViewName.setText("商品名称："+name);
                if(check_archer == 1){
                    checkBoxAddToCart.setChecked(true);
                }
                // 添加点击事件监听器
                buttonAddToCart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        check_archer=1;
                        checkBoxAddToCart.setChecked(true);
                        Data myApp = (Data) getApplication();
                        String nameValue = myApp.getGlobalVariable2();
                        myApp.setGlobalVariable2(nameValue + name + "\n");
                        double currentValue = myApp.getGlobalVariable();
                        myApp.setGlobalVariable(currentValue + price4); // 给全局变量加钱
                    }
                });
                break;
            case "Rider":
                // 查询具有特定 ID 值的数据
                Cursor cursor5 = database.rawQuery("SELECT * FROM Goods WHERE id = ?", new String[]{String.valueOf(5)});
                cursor5.moveToFirst(); // 将 Cursor 移动到结果集的第一行
                // 处理查询结果
                double price5 = cursor5.getDouble(cursor5.getColumnIndex("price"));
                int image5 = cursor5.getInt(cursor5.getColumnIndex("image"));

                do {
                    // 处理数据
                    textViewPrice.setText("商品价格："+price5);
                    imageViewProduct.setImageResource(image5);

                } while (cursor5.moveToNext());

                textViewName.setText("商品名称："+name);
                if(check_rider == 1){
                    checkBoxAddToCart.setChecked(true);
                }
                // 添加点击事件监听器
                buttonAddToCart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        check_rider=1;
                        checkBoxAddToCart.setChecked(true);
                        Data myApp = (Data) getApplication();
                        String nameValue = myApp.getGlobalVariable2();
                        myApp.setGlobalVariable2(nameValue + name + "\n");
                        double currentValue = myApp.getGlobalVariable();
                        myApp.setGlobalVariable(currentValue + price5); // 给全局变量加钱
                    }
                });
                break;
        }

    }

}