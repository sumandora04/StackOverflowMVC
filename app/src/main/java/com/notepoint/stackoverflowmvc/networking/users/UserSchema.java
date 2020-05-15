package com.notepoint.stackoverflowmvc.networking.users;
/*
     Created by Suman on 5/9/2020.
*/

import com.google.gson.annotations.SerializedName;

public class UserSchema {

    @SerializedName("display_name")
    private final String mUserDisplayName;

    @SerializedName("profile_image")
    private final String mUserAvatarUrl;

    public UserSchema(String userDisplayName, String userAvatarUrl) {
        mUserDisplayName = userDisplayName;
        mUserAvatarUrl = userAvatarUrl;
    }

    public String getUserAvatarUrl() {
        return mUserAvatarUrl;
    }

    public String getUserDisplayName() {
        return mUserDisplayName;
    }

}

