package com.notepoint.stackoverflowmvc.screens.questionslist;
/*
     Created by Suman on 5/9/2020.
*/

import android.view.View;

import com.notepoint.stackoverflowmvc.questions.Question;
import com.notepoint.stackoverflowmvc.screens.common.ObservableViewMvc;
import com.notepoint.stackoverflowmvc.screens.common.ViewMvc;

import java.util.List;

interface QuestionListViewMvc extends ObservableViewMvc<QuestionListViewMvc.Listener> {
    //Interface for notifying question clicked to the activity:
    public interface Listener{
        void onQuestionClicked(Question question);
    }

    void bindQuestions(List<Question> questions);


}
