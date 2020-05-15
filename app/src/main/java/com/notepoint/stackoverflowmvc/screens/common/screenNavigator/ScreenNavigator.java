package com.notepoint.stackoverflowmvc.screens.common.screenNavigator;
/*
     Created by Suman on 5/14/2020.
*/

import android.content.Context;

import com.notepoint.stackoverflowmvc.screens.questionDetails.QuestionDetailsActivity;

public class ScreenNavigator {

    private final Context mContext;

    public ScreenNavigator(Context mContext) {
        this.mContext = mContext;
    }

    public void toDialogDetails(String questionId) {
        QuestionDetailsActivity.start(mContext, questionId);
    }
}
