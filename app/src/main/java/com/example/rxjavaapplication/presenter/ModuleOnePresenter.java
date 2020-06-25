package com.example.rxjavaapplication.presenter;

import android.util.Log;

import com.example.rxjavaapplication.contract.ModuleOneContract;
import com.example.rxjavaapplication.model.ModuleOneModel;
import com.example.rxjavaapplication.networkinterface.NetworkAPI;
import com.example.rxjavaapplication.networkinterface.NetworkClient;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class ModuleOnePresenter implements ModuleOneContract.Presenter{

    private static final String TAG = "Presenter class -";

    private ModuleOneContract.View mView;
    private Retrofit client;

    public ModuleOnePresenter(ModuleOneContract.View mView){
        this.mView = mView;
        initPresenter();
    }

    @Override
    public void initPresenter() {
        client = new NetworkClient().getRetrofitReference();
        mView.initView();
        fetchData();
    }

    @Override
    public void fetchData() {
        NetworkAPI service = client.create(NetworkAPI.class);
        service.getDetails()
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ModuleOneModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ModuleOneModel value) {
                        Log.d(TAG, "onNext: "+ "data ="+ value.getKind());
                    }

                    @Override
                    public void onError(Throwable e) {
                        String message = e.getMessage();
                        Log.d(TAG, "onError: "+ message);
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete: "+ "called");
                    }
                });
    }
}
