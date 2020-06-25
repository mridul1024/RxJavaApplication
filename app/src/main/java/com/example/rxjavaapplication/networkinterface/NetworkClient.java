package com.example.rxjavaapplication.networkinterface;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkClient {

    private static final String BASE_URL = "https://www.reddit.com/";
    private Retrofit networkClient;

    public Retrofit getRetrofitReference(){
        if(networkClient == null){
            networkClient = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return networkClient;
    }
}
