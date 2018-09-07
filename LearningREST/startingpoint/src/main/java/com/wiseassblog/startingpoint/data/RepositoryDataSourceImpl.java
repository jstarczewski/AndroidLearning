package com.wiseassblog.startingpoint.data;

import com.wiseassblog.startingpoint.datamodel.RepositoryDataModel;
import com.wiseassblog.startingpoint.viewmodel.ListViewModel;
import com.wiseassblog.startingpoint.viewmodel.RepositoryListItem;

import org.reactivestreams.Publisher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

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

        return
                // 1 Return a Flowable of type List<RepositoryDataMode>
                restAdapter.getUserRepositories(user)
                        // 2 Transform the data from RepositoryDataModels to ListViewModels
                        .flatMap( // input
                                // Function is -> restAdapter.getUserRepository(user) -> in Publisher<?> change ? to ListViewModel
                                new Function<List<RepositoryDataModel>,
                                        // output
                                        Publisher<ListViewModel>>() {
                                    @Override
                                    public Publisher<ListViewModel> apply(List<RepositoryDataModel> repositoryDataModels) throws Exception {
                                        List<RepositoryListItem> listItems = new ArrayList<>();
                                        if (repositoryDataModels.size() == 0)
                                            throw new IOException("empty data set");
                                        for (RepositoryDataModel repo : repositoryDataModels) {
                                            listItems.add(
                                                    new RepositoryListItem(
                                                            repo.getDecription(),
                                                            repo.getCreated_at(),
                                                            repo.getAvatar_url()
                                                    )
                                            );
                                        }
                                        return Flowable.just(ListViewModel.success(listItems));
                                    }
                                }
                        )
                        // bad shit -> make testing impossible aka hard
                        // do this work (fetching data and transformatin it on background thread
                .subscribeOn(Schedulers.io())
                ;

    }
}
