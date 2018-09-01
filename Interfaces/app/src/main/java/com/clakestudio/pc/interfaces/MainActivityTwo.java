package com.clakestudio.pc.interfaces;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivityTwo extends AppCompatActivity implements OnWidgetClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButtonTwo buttonTwo = new ButtonTwo();

        // current instance to MainActivityOne class
        //buttonOne.setMainActivityOne(this);


        // button does not care whether it is activity or the interface, this is proper
        buttonTwo.setOnWidgetClickListener(this);

    }

    @Override
    public void onClick(int viewId) {
       // Handle event somehow
    }
}
