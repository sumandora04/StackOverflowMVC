package com.notepoint.stackoverflowmvc.common.dependancyInjection;
/*
     Created by Suman on 5/11/2020.
*/

import com.notepoint.stackoverflowmvc.common.Constants;
import com.notepoint.stackoverflowmvc.networking.StackoverflowApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CompositionRoot {
    private Retrofit mRetrofit;

    public StackoverflowApi getStackOverflowApi() {
        return getRetrofit().create(StackoverflowApi.class);
    }

    private Retrofit getRetrofit(){
        if (mRetrofit == null){
            mRetrofit =  new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return mRetrofit;
    }
}
