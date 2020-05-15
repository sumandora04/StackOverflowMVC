package com.notepoint.stackoverflowmvc.screens.common.views;
/*
     Created by Suman on 5/11/2020.
*/

import android.content.Context;
import android.view.View;

import androidx.annotation.StringRes;

public abstract class BaseViewMvc implements ViewMvc {
    private View mRootView;

    @Override
    public View getRootView() {
        return mRootView;
    }

    protected void setRootView(View rootView) {
        mRootView = rootView;
    }

    //A generic method to get the views by id:
    protected  <T extends View> T findViewById(int id) {
        return getRootView().findViewById(id);
    }

    protected Context getContext() {
        return getRootView().getContext();
    }

    protected String getString(@StringRes int id) {
        return getContext().getString(id);
    }
}
