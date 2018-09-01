package com.clakestudio.pc.interfaces;


/**
 * Created by Jan on 9/1/2018.
 */

public class ButtonTwo {


    private OnWidgetClickListener onWidgetClickListener;

    //private MainActivityOne mainActivityOne;

    public ButtonTwo() {
    }

    private void OnClick() {
        onWidgetClickListener.onClick(getViewId());
    }

    public void setOnWidgetClickListener(OnWidgetClickListener onWidgetClickListener) {
        this.onWidgetClickListener = onWidgetClickListener;
    }

    /// id generated at runtime
    public int getViewId() {
        return 123456;
    }
}
