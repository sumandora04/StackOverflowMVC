package com.notepoint.stackoverflowmvc.common.dependancyInjection;
/*
     Created by Suman on 5/11/2020.
*/

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;

import com.notepoint.stackoverflowmvc.networking.StackoverflowApi;
import com.notepoint.stackoverflowmvc.questions.FetchQuestionDetailsUseCase;
import com.notepoint.stackoverflowmvc.questions.FetchQuestionListUseCase;
import com.notepoint.stackoverflowmvc.screens.common.toastHelper.ToastHelper;
import com.notepoint.stackoverflowmvc.screens.common.screenNavigator.ScreenNavigator;
import com.notepoint.stackoverflowmvc.screens.common.ViewMvcFactory;
import com.notepoint.stackoverflowmvc.screens.questionslist.QuestionListController;

public class ControllerCompositionRoot {
    private final CompositionRoot mCompositionRoot;
    private Activity mActivity;

    public ControllerCompositionRoot(CompositionRoot mCompositionRoot, Activity activity) {
        this.mCompositionRoot = mCompositionRoot;
        this.mActivity = activity;
    }


    private StackoverflowApi getStackOverflowApi() {
        return mCompositionRoot.getStackOverflowApi();
    }

    private LayoutInflater getLayoutInflater(){
        return LayoutInflater.from(mActivity);
    }

    public ViewMvcFactory getViewMvcFactory(){
        return new ViewMvcFactory(getLayoutInflater());
    }

    public FetchQuestionDetailsUseCase getFetchQuestionDetailsUsecase() {
        return new FetchQuestionDetailsUseCase(getStackOverflowApi());
    }

    public FetchQuestionListUseCase getFetchQuestionListUseCase() {
        return new FetchQuestionListUseCase(getStackOverflowApi());
    }

    public QuestionListController getQuestionListController() {
        return new QuestionListController(getFetchQuestionListUseCase(),getScreenNavigator(),getMessageDisplayer());
    }

    public ScreenNavigator getScreenNavigator(){
        return new ScreenNavigator(getContext());
    }

    public ToastHelper getMessageDisplayer(){
        return new ToastHelper(getContext());
    }

    private Context getContext() {
        return mActivity;
    }
}
