package com.notepoint.stackoverflowmvc.screens.common;
/*
     Created by Suman on 5/11/2020.
*/

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.notepoint.stackoverflowmvc.screens.questionDetails.QuestionDetailViewMvc;
import com.notepoint.stackoverflowmvc.screens.questionDetails.QuestionDetailViewMvcImpl;
import com.notepoint.stackoverflowmvc.screens.questionslist.QuestionListViewMvc;
import com.notepoint.stackoverflowmvc.screens.questionslist.QuestionListViewMvcImpl;
import com.notepoint.stackoverflowmvc.screens.questionslist.QuestionsListItemViewMvc;
import com.notepoint.stackoverflowmvc.screens.questionslist.QuestionsListItemViewMvcImpl;

public class ViewMvcFactory {
    private LayoutInflater mLayoutInflater;

    public ViewMvcFactory(LayoutInflater mLayoutInflater) {
        this.mLayoutInflater = mLayoutInflater;
    }

    public QuestionListViewMvc getQuestionListViewMvc(@Nullable ViewGroup parent){
        return new QuestionListViewMvcImpl(mLayoutInflater,parent, this);
    }

    public QuestionsListItemViewMvc getQuestionListItemViewMvc(@Nullable ViewGroup parent){
        return new QuestionsListItemViewMvcImpl(mLayoutInflater,parent);
    }

    public QuestionDetailViewMvc getQuestionDetailViewMvc(@Nullable ViewGroup parent){
        return new QuestionDetailViewMvcImpl(mLayoutInflater,parent);
    }
}
