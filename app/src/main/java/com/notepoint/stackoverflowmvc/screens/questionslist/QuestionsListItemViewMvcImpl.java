package com.notepoint.stackoverflowmvc.screens.questionslist;
/*
     Created by Suman on 5/9/2020.
*/

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.notepoint.stackoverflowmvc.R;
import com.notepoint.stackoverflowmvc.questions.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestionsListItemViewMvcImpl implements QuestionsListItemViewMvc {
    private View mRootView;
    private List<Listener> mListeners = new ArrayList<>(1);
    private Question mQuestion;
    private TextView mTextTitle;

    public QuestionsListItemViewMvcImpl(LayoutInflater inflater, ViewGroup parent) {
        mRootView = inflater.inflate(R.layout.layout_question_list_item, parent, false);
        mTextTitle = findViewById(R.id.txt_title);

        getRootView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (Listener listener : mListeners) {
                    listener.onQuestionClicked(mQuestion);
                }
            }
        });
    }

    private <T extends View> T findViewById(int id) {
        return getRootView().findViewById(id);
    }

    @Override
    public View getRootView() {
        return mRootView;
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
    public void bindQuestion(Question question) {
        //Assign the mQuestion to get value in the onClick():
        mQuestion = question;

        mTextTitle.setText(question.getTitle());
    }
}
