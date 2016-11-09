package com.example.ehar.sqliteexample;

import android.provider.BaseColumns;

/**
 * Created by ehar on 11/9/16.
 */

public class StudentsContract {

    private StudentsContract() {}

    public static class StudentEntry implements BaseColumns {
        public static final String TABLE_NAME       = "students";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_ID   = "_id";
    }
}
