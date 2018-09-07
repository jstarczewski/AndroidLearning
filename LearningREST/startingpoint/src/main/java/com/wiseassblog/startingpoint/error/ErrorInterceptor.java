package com.wiseassblog.startingpoint.error;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Created by Jan on 9/7/2018.
 */

public class ErrorInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {

        Response response = chain.proceed(chain.request());

        if (!response.isSuccessful()) {
            throw new GitHubException(
                    response.code(),
                    response.message()
            );
        }
        return response;
    }
}
