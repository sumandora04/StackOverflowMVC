package com.notepoint.stackoverflowmvc.screens.questionslist;
/*
     Created by Suman on 5/11/2020.
*/

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.notepoint.stackoverflowmvc.questions.Question;
import com.notepoint.stackoverflowmvc.screens.common.ViewMvcFactory;

import java.util.ArrayList;
import java.util.List;

public class QuestionListRecyclerAdapter extends RecyclerView.Adapter<QuestionListRecyclerAdapter.QuestionHolder>
        implements QuestionsListItemViewMvc.Listener {


    public interface Listener {
        void onQuestionClicked(Question question);
    }

    public class QuestionHolder extends RecyclerView.ViewHolder {
        final QuestionsListItemViewMvc mViewMvc;

        public QuestionHolder(QuestionsListItemViewMvc viewMvc) {
            super(viewMvc.getRootView());
            mViewMvc = viewMvc;
        }
    }


    private final Listener mListener;
    private final ViewMvcFactory mViewMvcFactory;
    private List<Question> mQuestions = new ArrayList<>();

    public QuestionListRecyclerAdapter(Listener mListener, ViewMvcFactory viewMvcFactory) {
        this.mListener = mListener;
        mViewMvcFactory = viewMvcFactory;
    }

    public void bindQuestion(List<Question> questions) {
        mQuestions = new ArrayList<>(questions);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public QuestionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        QuestionsListItemViewMvc viewMvc = mViewMvcFactory.getQuestionListItemViewMvc(parent);
        viewMvc.registerListener(this);
        return new QuestionHolder(viewMvc);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionHolder holder, int position) {
        holder.mViewMvc.bindQuestion(mQuestions.get(position));
    }

    @Override
    public int getItemCount() {
        return mQuestions.size();
    }

    @Override
    public void onQuestionClicked(Question question) {
        mListener.onQuestionClicked(question);
    }
}
