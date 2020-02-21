package com.samoylov.mylaba1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView rV;
    private RvAdapter rvAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        rV = findViewById(R.id.rv_numbers);

        LinearLayoutManager lM= new LinearLayoutManager(this);
        rV.setLayoutManager(lM);

        rV.setHasFixedSize(true);
        rvAdapter=new RvAdapter(1000000);
        rV.setAdapter(rvAdapter);
    }
}
