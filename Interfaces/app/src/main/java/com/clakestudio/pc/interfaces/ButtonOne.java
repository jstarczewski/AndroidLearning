package com.clakestudio.pc.interfaces;


/**
 * Created by Jan on 9/1/2018.
 */

public class ButtonOne {

    private MainActivityOne mainActivityOne;

    public ButtonOne() {}

    public void setMainActivityOne(MainActivityOne mainActivityOne) {
        this.mainActivityOne = mainActivityOne;
    }

    private void OnClick() {
        mainActivityOne.onClick(getViewId());
    }


    /// id generated at runtime
    public int getViewId() {
        return 123456;
    }
}
