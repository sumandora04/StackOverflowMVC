package com.notepoint.stackoverflowmvc.screens.questionslist;
/*
     Created by Suman on 5/9/2020.
*/

import android.view.View;

import com.notepoint.stackoverflowmvc.questions.Question;

import java.util.List;

interface QuestionListViewMvc {
    //Interface for notifying question clicked to the activity:
    public interface Listener{
        void onQuestionClicked(Question question);
    }

    void registerListener(Listener listener);

    void unRegisterListener(Listener listener);

    View getRootView();

    void bindQuestions(List<Question> questions);


}
