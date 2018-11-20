package com.example.consultants.week5_daily1.ui.user;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.consultants.week5_daily1.Constants;
import com.example.consultants.week5_daily1.R;
import com.example.consultants.week5_daily1.ui.user.DisplayActivity.DisplayActivity;

public class MainActivity extends AppCompatActivity implements UserContract.View{

    Constants constants;
    UserPresenter userPresenter;
    private NotificationManager notificationManager;
    private EditText etFirstName;
    private EditText etLastName;
    private EditText etSalary;
    private EditText etDaysWorked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onBindViews();

        //cast the notification manager
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationChannel(notificationManager);
        userPresenter = new UserPresenter();

    }

    public void onBindViews() {

        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etSalary = findViewById(R.id.etSalary);
        etDaysWorked = findViewById(R.id.etDaysOnJob);
    }

    @Override
    protected void onStart() {
        super.onStart();
        userPresenter.onAttach(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        userPresenter.onDetach();
    }

    public void notificationChannel(NotificationManager notificationManager) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(constants.channelID,
                    constants.channelTitle,
                    NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription(constants.channelDesc);
            notificationManager.createNotificationChannel(channel);
        }
    }


    public void onAddEmployee(View view) {
        userPresenter.AddEmployee(etFirstName.getText().toString(),
                etLastName.getText().toString(),
                etSalary.getText().toString(),
                etDaysWorked.getText().toString(),
                getApplicationContext());
    }

    public void onClickRetrieveEmployee(View view) {
        //TODO create second activity that will send the information to view -> list, adapter, recycler
        //intent needs to
        Intent intent = new Intent(this, DisplayActivity.class);
        startActivity(intent);
//        userPresenter.onRetrieveEmployee(etFirstName.getText().toString(),
//                etLastName.getText().toString());
    }

    @Override
    public void showError(String errow) {

    }
}
