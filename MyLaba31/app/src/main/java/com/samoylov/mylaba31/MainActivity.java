package com.samoylov.mylaba31;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    SimpleDateFormat dateFormat;

    DatabaseHelper databaseHelper;
    SQLiteDatabase db;
    Cursor userCursor;
    SimpleCursorAdapter userAdapter;
    long lol;
    String[] name = {"Ралина ", "Мартина ", "Анастасия ", "Виоланта ", "Ольга ", "Александра ", "Селена "};
    String[] lastName = {"Фадеева ", "Лаврентьева ", "Михеева ", "Евдокимова ", "Карпова ", "Васильева ", "Миронова "};
    String[] nextName = {"Пантелеймоновна", "Кирилловна", "Степановна", "Владиславовна", "Филипповна", "Степановна", "Мэлсовна"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dateFormat = new SimpleDateFormat("E yyyy.MM.dd HH:mm:ss:SS");

        databaseHelper = new DatabaseHelper(getApplicationContext());
        db = databaseHelper.getWritableDatabase();
        db.delete(DatabaseHelper.TABLE, null, null);
        ContentValues cv = new ContentValues();
        for (int b = 0; b < 5; b++) {
            cv.put(DatabaseHelper.COLUMN_NAME, name[(int) (Math.random() * 6)] + lastName[(int) (Math.random() * 6)] + nextName[(int) (Math.random() * 6)]);
            cv.put(DatabaseHelper.COLUMN_DATA,  dateFormat.format(new Date()));
            db.insert(DatabaseHelper.TABLE, null, cv);
        }
    }



    // по нажатию на кнопку запускаем UserActivity для добавления данных
    public void add(View view) {
        ContentValues cv = new ContentValues();

        cv.put(DatabaseHelper.COLUMN_NAME, name[(int) (Math.random() * 6)] + lastName[(int) (Math.random() * 6)] + nextName[(int) (Math.random() * 6)]);
        cv.put(DatabaseHelper.COLUMN_DATA, dateFormat.format(new Date()));
        db.insert(DatabaseHelper.TABLE, null, cv);

    }

    public void run(View v) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    public void goIvan(View view) {
        db = databaseHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.COLUMN_NAME, "Иванов Иван Иванович");
        String q = "SELECT ROWID from users order by ROWID DESC limit 1";
        Cursor c = db.rawQuery(q, null);
        if (c != null && c.moveToFirst()) {
            lol = c.getLong(0); //The 0 is the column index, we only have 1 column, so the index is 0
        }
        db.update(DatabaseHelper.TABLE, cv, DatabaseHelper.COLUMN_ID + "=" + String.valueOf(lol), null);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // Закрываем подключение и курсор
        db.close();
        userCursor.close();
    }
}