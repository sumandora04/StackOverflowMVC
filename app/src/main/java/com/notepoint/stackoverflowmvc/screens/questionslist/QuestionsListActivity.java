package com.notepoint.stackoverflowmvc.screens.questionslist;
/*
     Created by Suman on 5/9/2020.
*/

import android.os.Bundle;

import com.notepoint.stackoverflowmvc.screens.common.controller.BaseActivity;

public class QuestionsListActivity extends BaseActivity {

    private QuestionListController mQuestionListController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mQuestionListController = getControllerComposition().getQuestionListController();
        QuestionListViewMvc viewMvc = getControllerComposition().getViewMvcFactory().getQuestionListViewMvc(null);
        mQuestionListController.bindView(viewMvc);
        setContentView(viewMvc.getRootView());
    }

    @Override
    protected void onStart() {
        super.onStart();
        mQuestionListController.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mQuestionListController.onStop();
    }
}
