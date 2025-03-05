package com.example.shopmaster;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class Product {
    private int id;
    private String name;
    private double price;
    private int imageUrl;

    public Product(int id, String name, double price, int imageUrl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    // Getters and setters for the properties
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public static void insertProduct(Context context, String name, double price, int imageResId) {
        NewSQL NewSQL = new NewSQL(context, "NewSQL.db", null, 3);
        SQLiteDatabase db = NewSQL.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("price", price);
        values.put("image", imageResId);

        db.insert("products", null, values);
        db.close();


    }

    public static Product getProductByName(Context context, String productName) {
        NewSQL NewSQL = new NewSQL(context, "NewSQL.db", null, 3);
        SQLiteDatabase db = NewSQL.getReadableDatabase();

        Product product = null;

        Cursor cursor = db.query("products", null, "name = ?", new String[]{productName}, null, null, null);

        Log.d("CursorCount", "Count: " + cursor.getCount());
        if (cursor.moveToFirst()) {
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            double price = cursor.getDouble(cursor.getColumnIndex("price"));
            int image = cursor.getInt(cursor.getColumnIndex("image"));

            product = new Product(id, name, price, image);
        }

        cursor.close();
        db.close();

        return product;
    }

}
