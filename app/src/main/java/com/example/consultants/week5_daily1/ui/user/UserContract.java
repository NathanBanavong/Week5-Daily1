package com.example.consultants.week5_daily1.ui.user;

import android.content.Context;

import com.example.consultants.week5_daily1.ui.base.BasePresenter;
import com.example.consultants.week5_daily1.ui.base.BaseView;

public interface UserContract {
    interface View extends BaseView {

    }

    interface Presenter extends BasePresenter<View> {
        void AddEmployee(String FirstName, String LastName, String Salary, String WorkDays, Context context);
    }
}
