package com.notepoint.stackoverflowmvc.questions;
/*
     Created by Suman on 5/14/2020.
*/

import com.notepoint.stackoverflowmvc.common.BaseObservable;
import com.notepoint.stackoverflowmvc.common.Constants;
import com.notepoint.stackoverflowmvc.networking.QuestionDetailsResponseSchema;
import com.notepoint.stackoverflowmvc.networking.QuestionSchema;
import com.notepoint.stackoverflowmvc.networking.QuestionsListResponseSchema;
import com.notepoint.stackoverflowmvc.networking.StackoverflowApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FetchQuestionListUseCase extends BaseObservable<FetchQuestionListUseCase.Listener> {

    private final StackoverflowApi mStackoverflowApi;

    public FetchQuestionListUseCase(StackoverflowApi mStackoverflowApi) {
        this.mStackoverflowApi = mStackoverflowApi;
    }

    public interface Listener{
        void onLastActiveQuestionFetched(List<Question> questions);
        void onQuestionDetailFetchFailed();
    }


    public void fetchLastActiveQuestionsListAndNotify(){
        mStackoverflowApi.fetchLastActiveQuestions(Constants.QUESTIONS_LIST_PAGE_SIZE)
               .enqueue(new Callback<QuestionsListResponseSchema>() {
                   @Override
                   public void onResponse(Call<QuestionsListResponseSchema> call, Response<QuestionsListResponseSchema> response) {
                       if (response.isSuccessful()) {
                           notifySuccess(response.body().getQuestions());
                       } else {
                           notifyFailure();
                       }
                   }

                   @Override
                   public void onFailure(Call<QuestionsListResponseSchema> call, Throwable t) {
                       notifyFailure();
                   }
               });
    }


    private void notifySuccess(List<QuestionSchema> questionSchemas) {

        List<Question> questions = new ArrayList<>(questionSchemas.size());
        for (QuestionSchema questionSchema : questionSchemas) {
            questions.add(new Question(questionSchema.getId(), questionSchema.getTitle()));
        }

        for (Listener listener: getListeners()){
            listener.onLastActiveQuestionFetched(questions);
        }
    }

    private void notifyFailure() {
        for (Listener listener: getListeners()){
            listener.onQuestionDetailFetchFailed();
        }
    }
}
