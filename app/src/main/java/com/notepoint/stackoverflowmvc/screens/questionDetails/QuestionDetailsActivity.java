package com.notepoint.stackoverflowmvc.screens.questionDetails;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.notepoint.stackoverflowmvc.questions.FetchQuestionDetailsUseCase;
import com.notepoint.stackoverflowmvc.questions.QuestionDetails;
import com.notepoint.stackoverflowmvc.screens.common.controller.BaseActivity;
import com.notepoint.stackoverflowmvc.screens.common.toastHelper.ToastHelper;

public class QuestionDetailsActivity extends BaseActivity
        implements FetchQuestionDetailsUseCase.Listener, QuestionDetailViewMvc.Listener {

    private FetchQuestionDetailsUseCase mFetchQuestionDetailsUseCase;
    private ToastHelper mToastHelper;
    private QuestionDetailViewMvc mViewMvc;
    public static final String EXTRA_QUESTION_ID = "EXTRA_QUESTION_ID";

    public static void start(Context context, String questionId) {
        Intent intent = new Intent(context, QuestionDetailsActivity.class);
        intent.putExtra(EXTRA_QUESTION_ID, questionId);
        context.startActivity(intent);
    }

    public String getQuestionId() {
        return getIntent().getStringExtra(EXTRA_QUESTION_ID);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mFetchQuestionDetailsUseCase = getControllerComposition().getFetchQuestionDetailsUsecase();
        mToastHelper = getControllerComposition().getMessageDisplayer();
        mViewMvc = getControllerComposition().getViewMvcFactory().getQuestionDetailViewMvc(null);
        setContentView(mViewMvc.getRootView());
    }


    @Override
    protected void onStart() {
        super.onStart();
        mViewMvc.registerListener(this);
        mFetchQuestionDetailsUseCase.registerListener(this);
        mViewMvc.showProgressBar();
        mFetchQuestionDetailsUseCase.fetchQuestionDetailsAndNotify(getQuestionId());
    }

    @Override
    protected void onStop() {
        super.onStop();
        mViewMvc.unRegisterListener(this);
        mFetchQuestionDetailsUseCase.unregisterListener(this);
    }

    private void bindQuestionDetail(QuestionDetails questionDetails) {
        mViewMvc.hideProgressBar();
        mViewMvc.bindQuestionDetail(questionDetails);
    }

    @Override
    public void onQuestionDetailFetched(QuestionDetails questionDetails) {
        bindQuestionDetail(questionDetails);
    }

    @Override
    public void onQuestionDetailFetchFailed() {
        mViewMvc.hideProgressBar();
        mToastHelper.displayNetworkErrorMessage();
    }

    @Override
    public void onNavigationUpClicked() {
        onBackPressed();
    }
}
