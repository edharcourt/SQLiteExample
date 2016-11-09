package com.example.ehar.sqliteexample;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ehar on 11/9/16.
 */

public class UniveristyDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Univeristy.db";
    public static final int DATABASE_VERSION = 2;

    private static final String SQL_CREATE_STUDENTS_TABLE =
            "CREATE TABLE " +
                    StudentsContract.StudentEntry.TABLE_NAME + " (" +
                    StudentsContract.StudentEntry.COLUMN_NAME_ID + " int not null, " +
                    StudentsContract.StudentEntry.COLUMN_NAME_NAME + " varchar not null, " +
                    "PRIMARY KEY (" + StudentsContract.StudentEntry.COLUMN_NAME_ID + "))";

    private static final String SQL_DROP_STUDENTS_TABLE =
            "DROP TABLE IF EXISTS " + StudentsContract.StudentEntry.TABLE_NAME;



    public UniveristyDbHelper(Context ctx) {
        // no CursorFactory
        super(ctx,DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_STUDENTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(SQL_DROP_STUDENTS_TABLE);
        onCreate(db);
    }
}
