package com.notepoint.stackoverflowmvc.screens.questionslist;
/*
     Created by Suman on 5/9/2020.
*/

import android.os.Bundle;
import android.widget.Toast;

import com.notepoint.stackoverflowmvc.R;
import com.notepoint.stackoverflowmvc.common.Constants;
import com.notepoint.stackoverflowmvc.networking.QuestionSchema;
import com.notepoint.stackoverflowmvc.networking.QuestionsListResponseSchema;
import com.notepoint.stackoverflowmvc.networking.StackoverflowApi;
import com.notepoint.stackoverflowmvc.questions.FetchQuestionListUseCase;
import com.notepoint.stackoverflowmvc.questions.Question;
import com.notepoint.stackoverflowmvc.screens.common.BaseActivity;
import com.notepoint.stackoverflowmvc.screens.questionDetails.QuestionDetailsActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
