package com.wiseassblog.startingpoint.data;

import com.wiseassblog.startingpoint.datamodel.RepositoryDataModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Jan on 9/7/2018.
 */

public class GitHubRestAdapter {

    private final GitHubService gitHubService;


    /**
     * The points of using Dagger2 are :
     *
     *  - testing easy cuz all dependency injections are out of the current class
     *  - we can keep track of instances we created easier (dagger does it)
     *
     *
     *
     * */


    @Inject
    public GitHubRestAdapter(Retrofit retrofit) {
        this.gitHubService = retrofit.create(GitHubService.class);
    }

    public interface GitHubService {

        /*
        @GET(UrlManager.REPOS)
        Call<List<RepositoryDataModel>> getUserPublicRepositories(
                // te "user" is gonna be replaced by user string in UrlManager
                @Path("user") String user
        );*/

        // RxJava way

        @GET(UrlManager.REPOS)
        Flowable<List<RepositoryDataModel>> getUserPublicRepositories(
                @Path("user") String user
        );


    }
    // rxjava
    public Flowable<List<RepositoryDataModel>> getUserRepositories(final String user) {
        return gitHubService.getUserPublicRepositories(user);
    }

}
