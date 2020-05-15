package com.notepoint.stackoverflowmvc.questions;
/*
     Created by Suman on 5/14/2020.
*/

import com.notepoint.stackoverflowmvc.common.BaseObservable;
import com.notepoint.stackoverflowmvc.networking.questions.QuestionDetailsResponseSchema;
import com.notepoint.stackoverflowmvc.networking.questions.QuestionSchema;
import com.notepoint.stackoverflowmvc.networking.StackoverflowApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FetchQuestionDetailsUseCase extends BaseObservable<FetchQuestionDetailsUseCase.Listener> {

    private final StackoverflowApi mStackoverflowApi;

    public FetchQuestionDetailsUseCase(StackoverflowApi mStackoverflowApi) {
        this.mStackoverflowApi = mStackoverflowApi;
    }

    public interface Listener{
        void onQuestionDetailFetched(QuestionDetails questionDetails);

        void onQuestionDetailFetchFailed();
    }


    public void fetchQuestionDetailsAndNotify(String questionId){
        mStackoverflowApi.fetchQuestionDetails(questionId)
                .enqueue(new Callback<QuestionDetailsResponseSchema>() {
                    @Override
                    public void onResponse(Call<QuestionDetailsResponseSchema> call, Response<QuestionDetailsResponseSchema> response) {
                        if (response.isSuccessful()){
                            notifySuccess(response.body().getQuestion());
                        }else {
                            notifyFailure();
                        }
                    }

                    @Override
                    public void onFailure(Call<QuestionDetailsResponseSchema> call, Throwable t) {
                        notifyFailure();
                    }
                });
    }


    private void notifySuccess(QuestionSchema questionSchema) {

        for (Listener listener: getListeners()){
            listener.onQuestionDetailFetched(new QuestionDetails(
                    questionSchema.getId(),
                    questionSchema.getTitle(),
                    questionSchema.getBody()));
        }
    }

    private void notifyFailure() {
        for (Listener listener: getListeners()){
            listener.onQuestionDetailFetchFailed();
        }
    }
}
