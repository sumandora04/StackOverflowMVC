package com.notepoint.stackoverflowmvc.screens.questionDetails;
/*
     Created by Suman on 5/13/2020.
*/

import com.notepoint.stackoverflowmvc.questions.QuestionDetails;
import com.notepoint.stackoverflowmvc.screens.common.ViewMvc;

public interface QuestionDetailViewMvc extends ViewMvc {
    void bindQuestionDetail(QuestionDetails questionDetails);
    void hideProgressBar();
    void showProgressBar();
}
