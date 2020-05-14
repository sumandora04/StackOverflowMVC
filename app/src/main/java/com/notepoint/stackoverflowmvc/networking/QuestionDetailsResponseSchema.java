package com.notepoint.stackoverflowmvc.networking;
/*
     Created by Suman on 5/13/2020.
*/

import com.google.gson.annotations.SerializedName;

import java.util.Collections;
import java.util.List;

public class QuestionDetailsResponseSchema {

    @SerializedName("items")
    private final List<QuestionSchema> mQuestions;

    public QuestionDetailsResponseSchema(QuestionSchema question) {
        mQuestions = Collections.singletonList(question);
    }

    public QuestionSchema getQuestion() {
        return mQuestions.get(0);
    }
}
