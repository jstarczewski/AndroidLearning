package com.wiseassblog.startingpoint.repolist;

import android.arch.lifecycle.ViewModel;
import android.view.ViewManager;

import com.wiseassblog.startingpoint.data.RepositoryDataSourceInterface;
import com.wiseassblog.startingpoint.util.BaseSchedulerProvider;
import com.wiseassblog.startingpoint.viewmodel.ListViewModel;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Function;
import io.reactivex.subscribers.DisposableSubscriber;

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

    public void start(String user) {
        getListFromDataSource(user);
    }

    public void stop() {
        // helps us stop our background operations when they should be stopped
        disposable.clear();
    }

    private void getListFromDataSource(String user) {
        // list of so called flawable - > check rx docs
        disposable.add(
                //1 Return data from the data source
                dataSource.getUserRepositories(user)
                        //2 return this data on the UI thread
                .observeOn(schedulerProvider.getUiScheduler())
                //3 Start our stream with loading screen
                .startWith(ListViewModel.loading())
                // 4
                .onErrorReturn(
                        new Function<Throwable, ListViewModel>() {
                            @Override
                            public ListViewModel apply(Throwable throwable) throws Exception {
                                return ListViewModel.error(throwable.getMessage());
                            }
                        }
                )
                // 5 the resulting flowable should be subscribed to with new Subscriber
                .subscribeWith(
                        new DisposableSubscriber<ListViewModel>() {


                            @Override
                            public void onNext(ListViewModel listViewModel) {

                            }

                            @Override
                            public void onError(Throwable t) {

                            }

                            @Override
                            public void onComplete() {

                            }
                        }

                )
        );
    }

}
