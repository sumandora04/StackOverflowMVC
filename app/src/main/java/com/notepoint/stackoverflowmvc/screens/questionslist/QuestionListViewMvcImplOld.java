package com.notepoint.stackoverflowmvc.screens.questionslist;
/*
     Created by Suman on 5/9/2020.
*/

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.notepoint.stackoverflowmvc.R;
import com.notepoint.stackoverflowmvc.questions.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestionListViewMvcImplOld implements QuestionsListAdapter.OnQuestionClickListener, QuestionListViewMvc {

    private View mRootView;
    private ListView mLstQuestions;
    private QuestionsListAdapter mQuestionsListAdapter;

    //Listener lists:
    private final List<Listener> mListeners = new ArrayList<>(1);

    public QuestionListViewMvcImplOld(LayoutInflater inflater, ViewGroup parent) {
        mRootView = inflater.inflate(R.layout.layout_questions_list, parent, false);

//        mLstQuestions = findViewById(R.id.lst_questions);
        mQuestionsListAdapter = new QuestionsListAdapter(getContext(), this);
        mLstQuestions.setAdapter(mQuestionsListAdapter);
    }


    @Override
    public View getRootView() {
        return mRootView;
    }

    //A generic method to get the views by id:
    private <T extends View> T findViewById(int id) {
        return getRootView().findViewById(id);
    }

    private Context getContext() {
        return getRootView().getContext();
    }

    @Override
    public void bindQuestions(List<Question> questions) {
        mQuestionsListAdapter.clear();
        mQuestionsListAdapter.addAll(questions);
        mQuestionsListAdapter.notifyDataSetChanged();
    }

    @Override
    public void registerListener(Listener listener){
        mListeners.add(listener);
    }

    @Override
    public void unRegisterListener(Listener listener){
        mListeners.remove(listener);
    }


    @Override
    public void onQuestionClicked(Question question) {
        for (Listener listener : mListeners) {
            listener.onQuestionClicked(question);
        }
    }


}
