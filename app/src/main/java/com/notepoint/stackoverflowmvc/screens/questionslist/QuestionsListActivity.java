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

public class QuestionsListActivity extends BaseActivity implements QuestionListViewMvcImpl.Listener, FetchQuestionListUseCase.Listener {


    private FetchQuestionListUseCase mFetchQuestionListUseCase;
    //ViewMvc:
    private QuestionListViewMvc mViewMvc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Initialise ViewMvc:
//        mViewMvc = new QuestionListViewMvcImpl(LayoutInflater.from(this),null); // Activity does not have a parent view
        mViewMvc = getControllerComposition().getViewMvcFactory().getQuestionListViewMvc(null);
        //Register the listener:
        mViewMvc.registerListener(this);

        mFetchQuestionListUseCase = getControllerComposition().getFetchQuestionListUseCase();
        //Set the view:
        setContentView(mViewMvc.getRootView());

    }

    @Override
    protected void onStart() {
        super.onStart();
        mFetchQuestionListUseCase.registerListener(this);
        mViewMvc.showProgressBar();
        mFetchQuestionListUseCase.fetchLastActiveQuestionsListAndNotify();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mFetchQuestionListUseCase.unregisterListener(this);
    }

    private void bindQuestions(List<Question> questions) {
        mViewMvc.hideProgressBar();
        mViewMvc.bindQuestions(questions);
    }


    @Override
    public void onQuestionClicked(Question question) {
        QuestionDetailsActivity.start(this, question.getId());
    }

    @Override
    public void onLastActiveQuestionFetched(List<Question> questions) {
        bindQuestions(questions);
    }

    @Override
    public void onQuestionDetailFetchFailed() {
        mViewMvc.hideProgressBar();
        Toast.makeText(this, R.string.error_network_call_failed, Toast.LENGTH_SHORT).show();
    }
}
