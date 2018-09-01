package com.clakestudio.pc.interfaces;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivityOne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButtonOne buttonOne = new ButtonOne();

        // current instance to MainActivityOne class
        buttonOne.setMainActivityOne(this);



    }

    public void onClick(int viewId) {

    }

}
