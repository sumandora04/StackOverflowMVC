package com.notepoint.stackoverflowmvc.screens.common;
/*
     Created by Suman on 5/11/2020.
*/

import com.notepoint.stackoverflowmvc.screens.questionslist.QuestionsListItemViewMvc;

public interface ObservableViewMvc<ListenerType> extends ViewMvc {

    void registerListener(ListenerType listener);
    void unRegisterListener(ListenerType listener);
}
