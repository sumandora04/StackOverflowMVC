package com.notepoint.stackoverflowmvc.screens.questionslist;
/*
     Created by Suman on 5/9/2020.
*/

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.notepoint.stackoverflowmvc.R;
import com.notepoint.stackoverflowmvc.questions.Question;

public class QuestionsListAdapter extends ArrayAdapter<Question> {

    private final OnQuestionClickListener mOnQuestionClickListener;

    public interface OnQuestionClickListener {
        void onQuestionClicked(Question question);
    }

    public QuestionsListAdapter(Context context,
                                OnQuestionClickListener onQuestionClickListener) {
        super(context, 0);
        mOnQuestionClickListener = onQuestionClickListener;
    }

    //Create a static class-> Viewholder:
    private static class ViewHolder{
        private TextView mTextTitle; // Because we have only one textView in our adapter.
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
//            convertView = LayoutInflater.from(parent.getContext())
//                    .inflate(R.layout.layout_question_list_item, parent, false);

            //Now create an object of ViewHolder and hold the id of the textView once and use it every time:
//            ViewHolder viewHolder = new ViewHolder();
//            viewHolder.mTextTitle = convertView.findViewById(R.id.txt_title);
//            convertView.setTag(viewHolder); // Set the viewHolder as a tag for the convertView (itemView).

            QuestionsListItemViewMvc viewMvc =new QuestionsListItemViewMvcImpl(
                    LayoutInflater.from(getContext()),
                    parent
            );
            convertView = viewMvc.getRootView();
            convertView.setTag(viewMvc);
        }

        final Question question = getItem(position);

        // bind the data to views
//        ViewHolder viewHolder = (ViewHolder) convertView.getTag(); // Get the viewHolder by tag
//        viewHolder.mTextTitle.setText(question.getTitle()); // Set the value.

        QuestionsListItemViewMvc viewMvc = (QuestionsListItemViewMvc) convertView.getTag();
        viewMvc.bindQuestion(question);

        // set listener
        convertView.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                onQuestionClicked(question);
            }
        });

        return convertView;
    }

    private void onQuestionClicked(Question question) {
        mOnQuestionClickListener.onQuestionClicked(question);
    }
}

