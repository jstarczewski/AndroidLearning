package com.clakestudio.pc.recyclerviewtutorial.view;

import com.clakestudio.pc.recyclerviewtutorial.data.ListItem;

import java.util.List;

/**
 * Created by Jan on 9/3/2018.
 */

public interface ViewInterface {

    void startDetailActivity(String dateAndTime, String message, int colorResource);

    void setUpAdapterAndView(List<ListItem> listOfData);


}
