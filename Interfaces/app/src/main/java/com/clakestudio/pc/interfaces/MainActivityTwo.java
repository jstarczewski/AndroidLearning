package com.clakestudio.pc.interfaces;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivityTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButtonTwo buttonTwo = new ButtonTwo();

        // current instance to MainActivityOne class
        //buttonOne.setMainActivityOne(this);


        // button does not care whether it is activity or the interface, this is proper
      /*  buttonTwo.setOnWidgetClickListener(new OnWidgetClickListener() {
            @Override
            public void onClick(int viewId) {

            }

        });*/

      buttonTwo.setOnWidgetClickListener(new OnWidgetClickListener() {
          @Override
          public void onClick(Thread r) {



          }
      });


        /**
         *
         *
         * ImageButton imageButton = new ImageButton();
         *
         * imageButton.setOnWidgetClickListener(this); ----> works still
         * because imagebutton is same as ButtonTwo and does note care whether it is class of framgent where method onClick is implemented
         *
         *
         * */
    }


}
