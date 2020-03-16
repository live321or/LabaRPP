package com.samoylov.mylaba32;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "userstore.db"; // название бд
    private static final int SCHEMA = 2; // версия базы данных
    static final String TABLE = "users"; // название таблицы в бд
    public String[] fio;
    // названия столбцов
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME1 = "name1";
    public static final String COLUMN_NAME2 = "name2";
    public static final String COLUMN_NAME3 = "name3";
    public static final String COLUMN_DATA = "data";
    public static final String COLUMN_YEAR = "year";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, SCHEMA);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE);
        db.execSQL("CREATE TABLE users(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_NAME1 + " TEXT,"
                + COLUMN_NAME2 + " TEXT,"
                + COLUMN_NAME3 + " TEXT,"
                + COLUMN_DATA + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE);
        onCreate(db);
    }
}
