package com.notepoint.stackoverflowmvc.screens.questionslist;
/*
     Created by Suman on 5/14/2020.
 --> Create ControllerClass only if you are doing unit test.
     Otherwise its better to keep the controller(activity) in one piece. (example: QuestionDetailsActivity)
*/

import android.widget.Toast;

import com.notepoint.stackoverflowmvc.R;
import com.notepoint.stackoverflowmvc.questions.FetchQuestionListUseCase;
import com.notepoint.stackoverflowmvc.questions.Question;
import com.notepoint.stackoverflowmvc.screens.common.MessagesDisplayer;
import com.notepoint.stackoverflowmvc.screens.common.ScreenNavigator;

import java.util.List;

public class QuestionListController implements QuestionListViewMvcImpl.Listener, FetchQuestionListUseCase.Listener  {


    private final FetchQuestionListUseCase mFetchQuestionListUseCase;
    private final ScreenNavigator mScreenNavigator;
    private final MessagesDisplayer mMessagesDisplayer;
    private QuestionListViewMvc mViewMvc;

    public QuestionListController(FetchQuestionListUseCase mFetchQuestionListUseCase, ScreenNavigator mScreenNavigator, MessagesDisplayer mMessagesDisplayer) {
        this.mFetchQuestionListUseCase = mFetchQuestionListUseCase;
        this.mScreenNavigator = mScreenNavigator;
        this.mMessagesDisplayer = mMessagesDisplayer;
    }

    protected void bindView(QuestionListViewMvc viewMvc){
        mViewMvc = viewMvc;
    }

    protected void onStart(){
        mViewMvc.registerListener(this);
        mFetchQuestionListUseCase.registerListener(this);
        mViewMvc.showProgressBar();
        mFetchQuestionListUseCase.fetchLastActiveQuestionsListAndNotify();
    }

    protected void onStop(){
        mViewMvc.unRegisterListener(this);
        mFetchQuestionListUseCase.unregisterListener(this);
    }


    @Override
    public void onQuestionClicked(Question question) {
        mScreenNavigator.toDialogDetails(question.getId());
    }


    @Override
    public void onLastActiveQuestionFetched(List<Question> questions) {
        mViewMvc.hideProgressBar();
        mViewMvc.bindQuestions(questions);
    }

    @Override
    public void onQuestionDetailFetchFailed() {
        mViewMvc.hideProgressBar();
        mMessagesDisplayer.displayNetworkErrorMessage();
    }
}
