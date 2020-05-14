package com.notepoint.stackoverflowmvc.screens.questionDetails;
/*
     Created by Suman on 5/13/2020.
*/

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.notepoint.stackoverflowmvc.R;
import com.notepoint.stackoverflowmvc.questions.QuestionDetails;
import com.notepoint.stackoverflowmvc.screens.common.BaseViewMvc;

public class QuestionDetailViewMvcImpl extends BaseViewMvc implements QuestionDetailViewMvc {

    private TextView mTxtQuestionTitle;
    private TextView mTxtQuestionBody;
    private ProgressBar mProgress;

    public QuestionDetailViewMvcImpl(LayoutInflater layoutInflater, ViewGroup parent) {
        setRootView(layoutInflater.inflate(R.layout.activity_question_details, parent, false));

        mTxtQuestionTitle = findViewById(R.id.question_header_text);
        mTxtQuestionBody = findViewById(R.id.question_body_text);
        mProgress = findViewById(R.id.progress_bar);
    }

    @Override
    public void bindQuestionDetail(QuestionDetails questionDetails) {
        String questionTitle = questionDetails.getTitle();
        String questionBody = questionDetails.getBody();

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            mTxtQuestionTitle.setText(Html.fromHtml(questionTitle, Html.FROM_HTML_MODE_LEGACY));
            mTxtQuestionBody.setText(Html.fromHtml(questionBody, Html.FROM_HTML_MODE_LEGACY));
        } else {
            mTxtQuestionTitle.setText(Html.fromHtml(questionTitle));
            mTxtQuestionBody.setText(Html.fromHtml(questionBody));
        }
    }

    @Override
    public void hideProgressBar() {
        mProgress.setVisibility(View.GONE);
    }

    @Override
    public void showProgressBar() {
        mProgress.setVisibility(View.VISIBLE);
    }
}
