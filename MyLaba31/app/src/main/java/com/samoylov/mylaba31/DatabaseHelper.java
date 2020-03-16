package com.samoylov.mylaba31;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "userstore.db"; // название бд
    private static final int SCHEMA = 1; // версия базы данных
    static final String TABLE = "users"; // название таблицы в бд
    // названия столбцов
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_DATA = "year";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, SCHEMA);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE users (" + COLUMN_ID + " INTEGER PRIMARY KeY AUTOINCREMENT,"
                + COLUMN_NAME + " TEXT,"
                + COLUMN_DATA + "TEXT)");
//        db.execSQL("INSERT INTO " + TABLE
//                + " (" + COLUMN_NAME + ", "
//                + COLUMN_YEAR + ") VALUES ('Том Смит', 1981);");
//        db.execSQL("INSERT INTO " + TABLE
//                + " (" + COLUMN_NAME + ", "
//                + COLUMN_YEAR + ") VALUES ('Tom Smet', 1981);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE);
        onCreate(db);
    }
}
