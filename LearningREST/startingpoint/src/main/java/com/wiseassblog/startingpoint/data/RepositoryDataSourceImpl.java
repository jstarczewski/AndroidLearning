package com.wiseassblog.startingpoint.data;

import com.wiseassblog.startingpoint.viewmodel.ListViewModel;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by Jan on 9/7/2018.
 */

public class RepositoryDataSourceImpl implements RepositoryDataSourceInterface {

    private GitHubRestAdapter restAdapter;

    @Inject
    public RepositoryDataSourceImpl(GitHubRestAdapter restAdapter) {
        this.restAdapter = restAdapter;
    }

    @Override
    public Flowable<ListViewModel> getUserRepositories(String user) {
        return null;
    }
}
