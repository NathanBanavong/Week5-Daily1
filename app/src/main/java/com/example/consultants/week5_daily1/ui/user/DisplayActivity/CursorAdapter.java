package com.example.consultants.week5_daily1.ui.user.DisplayActivity;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.consultants.week5_daily1.R;

public class CursorAdapter extends android.widget.CursorAdapter {

    private TextView tvFirstName;
    private TextView tvLastName;
    private TextView tvSalary;
    private TextView tvDaysWorked;
    private String firstName;
    private String lastName;
    private String salary;
    private String daysWorked;

    public CursorAdapter(Context context, Cursor c) {
        super(context, c, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.displayitem, viewGroup, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        tvFirstName = view.findViewById(R.id.tvFirstName);
        tvLastName = view.findViewById(R.id.tvLastName);
        tvSalary = view.findViewById(R.id.tvSalary);
        tvDaysWorked = view.findViewById(R.id.tvDaysWorked);

        firstName = cursor.getString(cursor.getColumnIndexOrThrow("FirstName"));
        lastName = cursor.getString(cursor.getColumnIndexOrThrow("FirstName"));
        salary = cursor.getString(cursor.getColumnIndexOrThrow("Salary"));
        daysWorked = cursor.getString(cursor.getColumnIndexOrThrow("DaysWorked"));

        tvFirstName.setText(firstName);
        tvLastName.setText(lastName);
        tvDaysWorked.setText(daysWorked);
        tvSalary.setText(salary);

    }


}
