package com.notepoint.stackoverflowmvc.screens.common;
/*
     Created by Suman on 5/11/2020.
*/

import android.content.Context;
import android.view.View;

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
}
