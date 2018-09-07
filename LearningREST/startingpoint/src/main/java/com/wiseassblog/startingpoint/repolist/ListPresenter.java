package com.wiseassblog.startingpoint.repolist;

import com.wiseassblog.startingpoint.data.RepositoryDataSourceInterface;
import com.wiseassblog.startingpoint.util.BaseSchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Jan on 9/7/2018.
 */

public class ListPresenter {


    private ViewInterface view;


    // abstraction of our dataSource
    private RepositoryDataSourceInterface dataSource;


    // This helps us manage our Reactive streams
    private CompositeDisposable disposable;

    // it helps us provide our RX implementation with Schedulers
    private BaseSchedulerProvider schedulerProvider;

    @Inject
    public ListPresenter(ViewInterface view,
                         RepositoryDataSourceInterface dataSource,
                         CompositeDisposable compositeDisposable,
                         BaseSchedulerProvider schedulerProvider) {
        this.view = view;
        this.dataSource = dataSource;
        this.disposable = compositeDisposable;
        this.schedulerProvider = schedulerProvider;
    }

    

}
