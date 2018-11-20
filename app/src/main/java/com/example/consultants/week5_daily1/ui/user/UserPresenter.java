package com.example.consultants.week5_daily1.ui.user;

import android.content.ContentProvider;
import android.content.ContentValues;

import android.content.Context;
import android.net.Uri;
import android.widget.Toast;

import com.example.consultants.week5_daily1.model.EmployeeProvider;

public class UserPresenter implements UserContract.Presenter {

    UserContract.View view;
    EmployeeProvider employeeProvider;

    @Override
    public void onAttach(UserContract.View view) {
        this.view = view;
    }

    @Override
    public void onDetach() {
        this.view = null;
    }

    public void AddEmployee(String FirstName, String LastName, String Salary, String WorkDays, Context context) {
        // Add a new student record
        ContentValues values = new ContentValues();

        //TODO just access the
        values.put(employeeProvider.FIRST_NAME, FirstName);
        values.put(employeeProvider.LAST_NAME, LastName);
        values.put(employeeProvider.SALARY, Salary);
        values.put(employeeProvider.DAYS_WORKED, WorkDays);

        Uri uri = context.getContentResolver().insert(
                EmployeeProvider.CONTENT_URI, values);

        Toast.makeText(context.getApplicationContext(), uri.toString(), Toast.LENGTH_LONG).show();
//        Toast.makeText(getBaseContext(),
//                uri.toString(), Toast.LENGTH_LONG).show();
    }


//    public void onRetrieveEmployee(String FirstName, String LastName) {
//        // Retrieve student records
//        String URL = "content://com.example.consultants.contentproviders.StudentsProvider";
//
//        Uri students = Uri.parse(URL);
//        Cursor c = managedQuery(students, null, null, null, "name");
//
//        if (c.moveToFirst()) {
//            do{
//                Toast toast = Toast.makeText(this,
//                        c.getString(c.getColumnIndex(EmployeeProvider._ID)) +
//                                ", " + c.getString(c.getColumnIndex(EmployeeProvider.FIRST_NAME)) +
//                                ", " + c.getString(c.getColumnIndex(EmployeeProvider.LAST_NAME)) +
//                                ", " +
//                                Toast.LENGTH_SHORT).show();
//            } while (c.moveToNext());
//        }
//    }

}
