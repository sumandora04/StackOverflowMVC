package com.notepoint.stackoverflowmvc.networking;
/*
     Created by Suman on 5/9/2020.
*/

import com.notepoint.stackoverflowmvc.networking.questions.QuestionDetailsResponseSchema;
import com.notepoint.stackoverflowmvc.networking.questions.QuestionsListResponseSchema;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface StackoverflowApi {

    @GET("/questions?sort=activity&order=desc&site=stackoverflow&filter=withbody")
    Call<QuestionsListResponseSchema> fetchLastActiveQuestions(@Query("pagesize") Integer pageSize);

    @GET("/questions/{questionId}?site=stackoverflow&filter=withbody")
    Call<QuestionDetailsResponseSchema> fetchQuestionDetails(@Path("questionId") String questionId);

}
