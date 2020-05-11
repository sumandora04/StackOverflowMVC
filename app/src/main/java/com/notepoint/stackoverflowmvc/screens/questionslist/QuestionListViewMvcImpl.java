package com.notepoint.stackoverflowmvc.screens.questionslist;
/*
     Created by Suman on 5/11/2020.
*/

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.notepoint.stackoverflowmvc.R;
import com.notepoint.stackoverflowmvc.questions.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestionListViewMvcImpl implements QuestionListRecyclerAdapter.Listener, QuestionListViewMvc {

    private View mRootView;
    private RecyclerView mQuestionRecycler;
    private List<Listener> mListeners = new ArrayList<>(1);
    private QuestionListRecyclerAdapter mQuestionListRecyclerAdapter;

    public QuestionListViewMvcImpl(LayoutInflater inflater, ViewGroup parent) {
        mRootView = inflater.inflate(R.layout.layout_questions_list, parent, false);

        mQuestionRecycler = findViewById(R.id.recycler_questions);
        mQuestionRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        mQuestionListRecyclerAdapter = new QuestionListRecyclerAdapter(inflater, this);
        mQuestionRecycler.setAdapter(mQuestionListRecyclerAdapter);
    }

    private Context getContext() {
        return getRootView().getContext();
    }

    @Override
    public View getRootView() {
        return mRootView;
    }


    //A generic method to get the views by id:
    private <T extends View> T findViewById(int id) {
        return getRootView().findViewById(id);
    }

    @Override
    public void registerListener(Listener listener) {
        mListeners.add(listener);
    }

    @Override
    public void unRegisterListener(Listener listener) {
        mListeners.remove(listener);
    }

    @Override
    public void bindQuestions(List<Question> questions) {
        mQuestionListRecyclerAdapter.bindQuestion(questions);
    }

    @Override
    public void onQuestionClicked(Question question) {
        for (Listener listener : mListeners) {
            listener.onQuestionClicked(question);
        }
    }


}
