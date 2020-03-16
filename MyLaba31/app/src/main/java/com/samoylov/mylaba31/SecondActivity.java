package com.samoylov.mylaba31;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import androidx.appcompat.app.AppCompatActivity;

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
        String[] h=new String[]{DatabaseHelper.COLUMN_NAME,DatabaseHelper.COLUMN_DATA};
        adapter=new SimpleCursorAdapter(this,android.R.layout.two_line_list_item,
                cursor,h,new int[]{android.R.id.text1,android.R.id.text2},0);
        listView.setAdapter(adapter);
    }
    public void onDestroy(){
        super.onDestroy();
        // Закрываем подключение и курсор
        db.close();
        cursor.close();
    }
}
