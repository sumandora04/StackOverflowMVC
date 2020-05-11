package com.notepoint.stackoverflowmvc;

import android.app.Application;

import com.notepoint.stackoverflowmvc.common.dependancyInjection.CompositionRoot;

/*
     Created by Suman on 5/11/2020.
*/

public class CustomApplication extends Application {

    private CompositionRoot mCompositionRoot;

    @Override
    public void onCreate() {
        super.onCreate();
        mCompositionRoot = new CompositionRoot();
    }

    public CompositionRoot getCompositionRoot() {
        return mCompositionRoot;
    }

}
