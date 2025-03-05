package com.example.shopmaster;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CartActivity extends AppCompatActivity {

    private RecyclerView recyclerViewCart;
    private TextView textViewTotalPrice;
    private Button buttonCheckout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        Button buttonAddToCart = findViewById(R.id.buttonAddToCart);
        textViewTotalPrice = findViewById(R.id.textViewTotalPrice);
        TextView tv_list = findViewById(R.id.tv_list);

        TextView tv_show = (TextView) findViewById(R.id.tv_total);
        Data myApp = (Data) getApplication();
        String name = myApp.getGlobalVariable2();
        double data = myApp.getGlobalVariable(); // 提取全局变量的值
        tv_show.setText(""+data);
        tv_list.setText(name);


    }

}

