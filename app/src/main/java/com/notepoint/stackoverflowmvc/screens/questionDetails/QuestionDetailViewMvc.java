package com.notepoint.stackoverflowmvc.screens.questionDetails;
/*
     Created by Suman on 5/13/2020.
*/

import com.notepoint.stackoverflowmvc.questions.QuestionDetails;
import com.notepoint.stackoverflowmvc.screens.common.views.ObservableViewMvc;
import com.notepoint.stackoverflowmvc.screens.common.views.ViewMvc;

public interface QuestionDetailViewMvc extends ObservableViewMvc<QuestionDetailViewMvc.Listener> {

    public interface Listener {
        void onNavigationUpClicked();
    }

    void bindQuestionDetail(QuestionDetails questionDetails);

    void hideProgressBar();

    void showProgressBar();
}
