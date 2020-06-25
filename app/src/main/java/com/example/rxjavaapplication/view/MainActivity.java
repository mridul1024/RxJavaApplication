package com.example.rxjavaapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.rxjavaapplication.R;
import com.example.rxjavaapplication.contract.ModuleOneContract;
import com.example.rxjavaapplication.presenter.ModuleOnePresenter;

public class MainActivity extends AppCompatActivity implements ModuleOneContract.View {

    private static final String TAG = "View class -";
    private ModuleOnePresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter = new ModuleOnePresenter(this);
    }

    @Override
    public void initView() {
        Log.d(TAG, "initView: "+ "called");
    }
}