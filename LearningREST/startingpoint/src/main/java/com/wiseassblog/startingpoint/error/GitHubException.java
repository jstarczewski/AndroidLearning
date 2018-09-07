package com.wiseassblog.startingpoint.error;

import java.io.IOError;
import java.io.IOException;

/**
 * Created by Jan on 9/7/2018.
 */

public class GitHubException extends IOException {

    private int responseCode;
    private String message;


    public GitHubException(int code, String message) {
        this.responseCode = code;
        this.message = message;
    }

    public int getResponsCode() {
        return responseCode;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
