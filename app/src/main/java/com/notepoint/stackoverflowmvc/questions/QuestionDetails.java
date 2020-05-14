package com.notepoint.stackoverflowmvc.questions;
/*
     Created by Suman on 5/13/2020.
*/

public class QuestionDetails {
    private final String mId;

    private final String mTitle;

    private final String mBody;

    public QuestionDetails(String id, String title, String body) {
        mId = id;
        mTitle = title;
        mBody = body;
    }

    public String getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getBody() {
        return mBody;
    }
}
