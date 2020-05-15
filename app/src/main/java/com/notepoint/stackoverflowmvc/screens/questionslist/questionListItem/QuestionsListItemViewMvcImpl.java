package com.notepoint.stackoverflowmvc.screens.questionslist.questionListItem;
/*
     Created by Suman on 5/9/2020.
*/

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.notepoint.stackoverflowmvc.R;
import com.notepoint.stackoverflowmvc.questions.Question;
import com.notepoint.stackoverflowmvc.screens.common.views.BaseObservableViewMvc;

public class QuestionsListItemViewMvcImpl extends BaseObservableViewMvc<QuestionsListItemViewMvc.Listener>
        implements QuestionsListItemViewMvc {
    private Question mQuestion;
    private TextView mTextTitle;

    public QuestionsListItemViewMvcImpl(LayoutInflater inflater, ViewGroup parent) {
        setRootView(inflater.inflate(R.layout.layout_question_list_item, parent, false));
        mTextTitle = findViewById(R.id.txt_title);

        getRootView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (Listener listener : getmListener()) {
                    listener.onQuestionClicked(mQuestion);
                }
            }
        });
    }

    @Override
    public void bindQuestion(Question question) {
        //Assign the mQuestion to get value in the onClick():
        mQuestion = question;

        mTextTitle.setText(question.getTitle());
    }
}
