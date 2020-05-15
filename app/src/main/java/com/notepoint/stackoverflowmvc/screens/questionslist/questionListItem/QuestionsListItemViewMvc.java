package com.notepoint.stackoverflowmvc.screens.questionslist.questionListItem;
/*
     Created by Suman on 5/9/2020.
*/

import com.notepoint.stackoverflowmvc.questions.Question;
import com.notepoint.stackoverflowmvc.screens.common.views.ObservableViewMvc;

public interface QuestionsListItemViewMvc extends ObservableViewMvc<QuestionsListItemViewMvc.Listener> {

    public interface Listener{
        void onQuestionClicked(Question question);
    }

    void bindQuestion(Question question);
}
