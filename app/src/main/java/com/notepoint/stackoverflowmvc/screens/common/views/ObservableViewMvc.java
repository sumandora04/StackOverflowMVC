package com.notepoint.stackoverflowmvc.screens.common.views;
/*
     Created by Suman on 5/11/2020.
*/

public interface ObservableViewMvc<ListenerType> extends ViewMvc {

    void registerListener(ListenerType listener);
    void unRegisterListener(ListenerType listener);
}
