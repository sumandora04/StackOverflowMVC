package com.notepoint.stackoverflowmvc.common.dependancyInjection;
/*
     Created by Suman on 5/11/2020.
*/

import android.app.Activity;
import android.view.LayoutInflater;

import com.notepoint.stackoverflowmvc.networking.StackoverflowApi;
import com.notepoint.stackoverflowmvc.questions.FetchQuestionDetailsUseCase;
import com.notepoint.stackoverflowmvc.screens.common.ViewMvcFactory;

public class ControllerCompositionRoot {
    private final CompositionRoot mCompositionRoot;
    private Activity mActivity;

    public ControllerCompositionRoot(CompositionRoot mCompositionRoot, Activity activity) {
        this.mCompositionRoot = mCompositionRoot;
        this.mActivity = activity;
    }


    public StackoverflowApi getStackOverflowApi() {
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
}
