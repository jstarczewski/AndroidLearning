package com.clakestudio.pc.recyclerviewtutorial.logic;

import com.clakestudio.pc.recyclerviewtutorial.data.DataSourceInterface;
import com.clakestudio.pc.recyclerviewtutorial.data.ListItem;
import com.clakestudio.pc.recyclerviewtutorial.view.ViewInterface;

/**
 * Created by Jan on 9/3/2018.
 */

public class Controller {

    private ViewInterface view;
    private DataSourceInterface dataSource;

    public Controller(ViewInterface view, DataSourceInterface dataSource) {
        this.view = view;
        this.dataSource = dataSource;
    }

    public void getListFromDataSource() {
        view.setUpAdapterAndView(dataSource.getListOfData());
    }

    public void onListItemClick(ListItem testItem) {
        view.startDetailActivity(testItem.getDateAndTime(), testItem.getMessage(), testItem.getColorResource());
    }
}
