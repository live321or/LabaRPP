package com.samoylov.mylaba32;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class SecondActivity extends AppCompatActivity {
    ListView listView;
    DatabaseHelper databaseHelper;
    SQLiteDatabase db;
    Cursor cursor;
    SimpleCursorAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        listView = findViewById(R.id.list1);
        databaseHelper = new DatabaseHelper(getApplicationContext());
    }
    @Override
    protected void onResume() {
        super.onResume();
        db=databaseHelper.getReadableDatabase();
        cursor=db.rawQuery("select * from "+DatabaseHelper.TABLE,null);
        String[] h=new String[]{DatabaseHelper.COLUMN_NAME1,DatabaseHelper.COLUMN_NAME2,DatabaseHelper.COLUMN_NAME3 ,DatabaseHelper.COLUMN_DATA};
        adapter=new SimpleCursorAdapter(this,R.layout.item,
                cursor,h,new int[]{R.id.text1,R.id.text2,R.id.text3,R.id.text4},0);
        listView.setAdapter(adapter);
    }
    public void onDestroy(){
        super.onDestroy();
        // Закрываем подключение и курсор
        db.close();
        cursor.close();
    }
}
