package com.notepoint.stackoverflowmvc.screens.questionslist;
/*
     Created by Suman on 5/9/2020.
*/

import android.view.View;

import com.notepoint.stackoverflowmvc.questions.Question;

import java.util.List;

public interface QuestionsListItemViewMvc {
    public interface Listener{
        void onQuestionClicked(Question question);
    }

    View getRootView();
    void registerListener(Listener listener);
    void unRegisterListener(Listener listener);
    void bindQuestion(Question question);
}
