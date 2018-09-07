package com.wiseassblog.startingpoint.datamodel;

import com.squareup.moshi.Json;

/**
 * Created by Jan on 9/7/2018.
 */

public class RepositoryDataModel  {


    // all is static final cuz we do not expect this data to change while application overflow

    final String decription;

    @Json(name = "created_at")
    final String created_at;
    final Owner Owner;

    public RepositoryDataModel(String decription, String created_at, RepositoryDataModel.Owner owner) {
        this.decription = decription;
        this.created_at = created_at;
        Owner = owner;
    }

    public String getDecription() {
        return decription;
    }

    public String getCreated_at() {
        return created_at;
    }

    public RepositoryDataModel.Owner getOwner() {
        return Owner;
    }

    static class Owner {

        final String avatar_url;

        public Owner(String avatar_url) {
            this.avatar_url = avatar_url;
        }

        public String getAvatar_url() {
            return avatar_url;
        }
    }

}
