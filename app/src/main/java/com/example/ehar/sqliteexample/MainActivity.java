package com.example.ehar.sqliteexample;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends Activity {

    UniveristyDbHelper dbHelper = null;
    SQLiteDatabase db = null;

    Handler h = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        h = new Handler();
        dbHelper = new UniveristyDbHelper(this);
        new CreateDB().execute();
    }

    void listStudents() {
        UniversityDBQueries.listStudents(db);
    }


    private class CreateDB extends AsyncTask<Void, Void, SQLiteDatabase> {

        @Override
        protected SQLiteDatabase doInBackground(Void... voids) {
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            String [] names = {"Harry", "Hermione", "Ron"};
            int [] ids = {1,2,3};

            for (int i = 0; i < names.length; i++) {
                values.put(StudentsContract.StudentEntry.COLUMN_NAME_ID, ids[i]);
                values.put(StudentsContract.StudentEntry.COLUMN_NAME_NAME, names[i]);

                // the second arg means don't insert a row when there
                // are no values
                long rowId = db.insert(StudentsContract.StudentEntry.TABLE_NAME,
                        null, values);
            }

            return db;
        }

        @Override
        protected void onPostExecute(SQLiteDatabase db) {
            super.onPostExecute(db);
            MainActivity.this.db = db;
            h.post(new Runnable() {
                @Override
                public void run() {
                    listStudents();
                }
            });
        }
    }
}
