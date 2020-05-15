package com.notepoint.stackoverflowmvc.screens.questionslist;
/*
     Created by Suman on 5/9/2020.
*/

import com.notepoint.stackoverflowmvc.questions.Question;
import com.notepoint.stackoverflowmvc.screens.common.views.ObservableViewMvc;

import java.util.List;

public interface QuestionListViewMvc extends ObservableViewMvc<QuestionListViewMvc.Listener> {
    //Interface for notifying question clicked to the activity:
    public interface Listener{
        void onQuestionClicked(Question question);
    }

    void bindQuestions(List<Question> questions);
    void hideProgressBar();
    void showProgressBar();


}
