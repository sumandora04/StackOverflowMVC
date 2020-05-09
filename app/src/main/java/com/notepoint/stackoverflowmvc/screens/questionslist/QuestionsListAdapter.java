package com.notepoint.stackoverflowmvc.screens.questionslist;
/*
     Created by Suman on 5/9/2020.
*/

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.notepoint.stackoverflowmvc.questions.Question;

public class QuestionsListAdapter extends ArrayAdapter<Question> implements QuestionsListItemViewMvc.Listener {

    private final OnQuestionClickListener mOnQuestionClickListener;

    public interface OnQuestionClickListener {
        void onQuestionClicked(Question question);
    }

    public QuestionsListAdapter(Context context,
                                OnQuestionClickListener onQuestionClickListener) {
        super(context, 0);
        mOnQuestionClickListener = onQuestionClickListener;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            QuestionsListItemViewMvc viewMvc =new QuestionsListItemViewMvcImpl(
                    LayoutInflater.from(getContext()),
                    parent
            );
            // set listener
            viewMvc.registerListener(this);
            convertView = viewMvc.getRootView();
            convertView.setTag(viewMvc);
        }

        final Question question = getItem(position);
        // bind the data to views
        QuestionsListItemViewMvc viewMvc = (QuestionsListItemViewMvc) convertView.getTag(); // Get the view by tag
        viewMvc.bindQuestion(question); //Set the value.
        return convertView;
    }

    @Override
    public void onQuestionClicked(Question question) {
        mOnQuestionClickListener.onQuestionClicked(question);
    }
}

