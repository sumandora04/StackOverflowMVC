package com.notepoint.stackoverflowmvc.screens.questionslist;
/*
     Created by Suman on 5/11/2020.
*/

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.notepoint.stackoverflowmvc.R;
import com.notepoint.stackoverflowmvc.questions.Question;
import com.notepoint.stackoverflowmvc.screens.common.toolbar.ToolbarViewMvc;
import com.notepoint.stackoverflowmvc.screens.common.views.BaseObservableViewMvc;
import com.notepoint.stackoverflowmvc.screens.common.ViewMvcFactory;

import java.util.List;

public class QuestionListViewMvcImpl extends BaseObservableViewMvc<QuestionListViewMvc.Listener>
        implements QuestionListViewMvc, QuestionListRecyclerAdapter.Listener{

    private final ToolbarViewMvc mToolbarViewMvc;
    private final Toolbar mToolbar;

    private final ProgressBar mProgressBar;
    private final RecyclerView mQuestionRecycler;
    private QuestionListRecyclerAdapter mQuestionListRecyclerAdapter;

    public QuestionListViewMvcImpl(LayoutInflater inflater, ViewGroup parent, ViewMvcFactory viewMvcFactory) {
        setRootView(inflater.inflate(R.layout.layout_questions_list, parent, false));

        mProgressBar = findViewById(R.id.progress_bar);

        mQuestionRecycler = findViewById(R.id.recycler_questions);
        mQuestionRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        mQuestionListRecyclerAdapter = new QuestionListRecyclerAdapter(this, viewMvcFactory);
        mQuestionRecycler.setAdapter(mQuestionListRecyclerAdapter);

        /* For adding toolbar */
        mToolbar = findViewById(R.id.toolbar);
        mToolbarViewMvc = viewMvcFactory.getToolBarViewMvc(mToolbar);
        mToolbarViewMvc.setToolbarTitle(getString(R.string.questions_list_screen_title));
        mToolbar.addView(mToolbarViewMvc.getRootView());
    }

    @Override
    public void bindQuestions(List<Question> questions) {
        mQuestionListRecyclerAdapter.bindQuestion(questions);
    }

    @Override
    public void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showProgressBar() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onQuestionClicked(Question question) {
        for (Listener listener : getmListener()) {
            listener.onQuestionClicked(question);
        }
    }


}
