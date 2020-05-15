package com.notepoint.stackoverflowmvc.screens.common.views;
/*
     Created by Suman on 5/11/2020.
*/

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class BaseObservableViewMvc<ListenerType> extends BaseViewMvc
        implements ObservableViewMvc<ListenerType> {

    private Set<ListenerType> mListener = new HashSet<>();

    @Override
    public void registerListener(ListenerType listener) {
        mListener.add(listener);
    }

    @Override
    public void unRegisterListener(ListenerType listener) {
        mListener.remove(listener);
    }

    protected Set<ListenerType> getmListener(){
        return Collections.unmodifiableSet(mListener);
    }
}
