package com.example.consultants.week5_daily1.ui.base;

public interface BasePresenter <V extends BaseView>{

    void onAttach(V view);
    void onDetach();
}
