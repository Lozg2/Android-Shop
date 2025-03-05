package com.example.shopmaster;

import android.app.Application;

public class Data extends Application {
    private double globalVariable;
    private String globalVariable2;

    public double getGlobalVariable() {

        return globalVariable;
    }

    public String getGlobalVariable2() {

        return globalVariable2;
    }

    public void setGlobalVariable(double value) {

        this.globalVariable = value;
    }

    public void setGlobalVariable2(String value) {

        this.globalVariable2 = value;
    }
}
