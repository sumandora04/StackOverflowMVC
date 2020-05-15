package com.notepoint.stackoverflowmvc.networking.questions;
/*
     Created by Suman on 5/9/2020.
*/

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class QuestionsListResponseSchema {

    @SerializedName("items")
    private final List<QuestionSchema> mQuestions;

    public QuestionsListResponseSchema(List<QuestionSchema> questions) {
        mQuestions = questions;
    }

    public List<QuestionSchema> getQuestions() {
        return mQuestions;
    }
}
