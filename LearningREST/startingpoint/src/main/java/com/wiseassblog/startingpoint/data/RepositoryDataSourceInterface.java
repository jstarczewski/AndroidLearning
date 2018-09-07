package com.wiseassblog.startingpoint.data;

import com.wiseassblog.startingpoint.viewmodel.ListViewModel;

import io.reactivex.Flowable;

/**
 * Created by Jan on 9/7/2018.
 */

public interface RepositoryDataSourceInterface {

    // Return a resource which is capable of emitting a ListViewModel
    Flowable<ListViewModel> getUserRepositories(String user);

}
