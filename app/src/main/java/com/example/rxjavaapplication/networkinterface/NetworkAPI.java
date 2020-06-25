package com.example.rxjavaapplication.networkinterface;

import com.example.rxjavaapplication.model.ModuleOneModel;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface NetworkAPI {

    @GET("user/mridul1024.json")
    Observable<ModuleOneModel> getDetails();
}
