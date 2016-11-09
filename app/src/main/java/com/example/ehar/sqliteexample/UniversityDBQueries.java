package com.example.ehar.sqliteexample;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by ehar on 11/9/16.
 */

public class UniversityDBQueries {

    private static String LOG_TAG = UniversityDBQueries.class.getName();

    public static void listStudents(SQLiteDatabase db) {
        String [] projection = {
                StudentsContract.StudentEntry._ID,
                StudentsContract.StudentEntry.COLUMN_NAME_NAME};

        Cursor c = db.query(

                StudentsContract.StudentEntry.TABLE_NAME,
                projection,
                null,  // no WHERE clause columns
                null,  // no WHERE clause arguments
                null,  // no groupBy
                null,  // no filter
                null
        );


        int nameIdx = c.getColumnIndex(StudentsContract.StudentEntry.COLUMN_NAME_NAME);

        while (c.moveToNext()) {
            String name = c.getString(nameIdx);
            Log.i(LOG_TAG, name);
        }

    }

}
