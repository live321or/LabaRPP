package com.samoylov.laba21;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.samoylov.laba21.fragmentOne.ListFragment;

public class HomeActivity extends AppCompatActivity {
private ListFragment listFragment;
private FragmentManager manager;
    public static int currentPosition;
    private static final String KEY_CURRENT_POSITION = "com.delaroystudios.viewpagertogrid.key.currentPosition";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        manager = getSupportFragmentManager();
        listFragment = new ListFragment();
        listFragment=ListFragment.newInstance(manager);


        getSupportFragmentManager().beginTransaction().replace(R.id.homeA ,listFragment).commit();
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_CURRENT_POSITION, currentPosition);
    }
}
