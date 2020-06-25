package com.example.rxjavaapplication.contract;

public interface ModuleOneContract {
    interface Model{

    }
    interface Presenter{
        void initPresenter();
        void fetchData();
    }
    interface View{
        void initView();
    }
}
