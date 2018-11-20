package com.example.consultants.week5_daily1.ui.user.DisplayActivity;

import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.consultants.week5_daily1.Constants;
import com.example.consultants.week5_daily1.R;

public class DisplayActivity extends AppCompatActivity {

    private String url;
    private Uri employee;
    private CursorAdapter cursorAdapter;
    private ListView lvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        url = Constants.CONTENT_PROVIDER;
        employee = Uri.parse(url);
        Cursor c = managedQuery(employee, null, null, null, "LastName");
        cursorAdapter = new CursorAdapter(this,c);

        lvDisplay = findViewById(R.id.lvEmployeeInfo);
        lvDisplay.setAdapter(cursorAdapter);

    }
}
