package com.samoylov.mylaba32;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    SQLiteDatabase db;
    Cursor c;
    long lol;
    SimpleCursorAdapter userAdapter;
    ListView countriesList;
    String[] name={"Ралина ","Мартина ","Анастасия ","Виоланта ","Ольга ","Александра ","Селена "};
    String[] lastName={"Фадеева ","Лаврентьева ","Михеева ","Евдокимова ","Карпова ","Васильева ","Миронова "};
    String[] nextName={"Пантелеймоновна","Кирилловна","Степановна","Владиславовна","Филипповна","Степановна","Мэлсовна"};
    SimpleDateFormat dateFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseHelper = new DatabaseHelper(getApplicationContext());
        db=databaseHelper.getWritableDatabase();
        databaseHelper.onUpgrade(db,1,2);
        db.delete(DatabaseHelper.TABLE,null,null);
        ContentValues cv = new ContentValues();
        dateFormat=new SimpleDateFormat("E yyyy.MM.dd HH:mm:ss:SS");
        for(int b=0;b<5;b++){
            cv.put(DatabaseHelper.COLUMN_NAME1, name[(int)(Math.random()*6)]);
            cv.put(DatabaseHelper.COLUMN_NAME2, lastName[(int)(Math.random()*6)]);
            cv.put(DatabaseHelper.COLUMN_NAME3, nextName[(int)(Math.random()*6)]);
            cv.put(DatabaseHelper.COLUMN_DATA, dateFormat.format(new Date()));
            db.insert(DatabaseHelper.TABLE,null,cv);
        }
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        c = db.rawQuery("select * from " + DatabaseHelper.TABLE, null);
//        String[] h=new String[]{DatabaseHelper.COLUMN_NAME};
//        userAdapter = new SimpleCursorAdapter(this, android.R.layout.two_line_list_item,
//                c, h, new int[]{android.R.id.text1, android.R.id.text2}, 0);
//        countriesList.setAdapter(userAdapter);
//    }
public void add(View view) {
    ContentValues cv = new ContentValues();
    dateFormat=new SimpleDateFormat("E yyyy.MM.dd HH:mm:ss:SS");

        cv.put(DatabaseHelper.COLUMN_NAME1, name[(int)(Math.random()*6)]);
        cv.put(DatabaseHelper.COLUMN_NAME2, lastName[(int)(Math.random()*6)]);
        cv.put(DatabaseHelper.COLUMN_NAME3, nextName[(int)(Math.random()*6)]);
        cv.put(DatabaseHelper.COLUMN_DATA, dateFormat.format(new Date()));
        db.insert(DatabaseHelper.TABLE,null,cv);

}
public void run(View v) {
    Intent intent = new Intent(this, SecondActivity.class);
    startActivity(intent);
}
    public void goIvan(View view) {
        db=databaseHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.COLUMN_NAME1,"Иванов ");
        cv.put(DatabaseHelper.COLUMN_NAME2,"Иван");
        cv.put(DatabaseHelper.COLUMN_NAME3,"Иванович");
        String q="SELECT ROWID from users order by ROWID DESC limit 1";
        Cursor c=db.rawQuery(q,null);
        if (c != null && c.moveToFirst()) {
            lol =  c.getLong(0); //The 0 is the column index, we only have 1 column, so the index is 0
        }
        db.update(DatabaseHelper.TABLE,cv,DatabaseHelper.COLUMN_ID +"=" + String.valueOf(lol),null);
    }
}
