package com.samoylov.laba21.fragmentTwo;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.samoylov.laba21.Technologies;

import java.util.ArrayList;

public class PageAdapter extends FragmentStatePagerAdapter {
    private ArrayList<Technologies> technologies;
    public PageAdapter(@NonNull Fragment fr,ArrayList<Technologies> technologies) {
        super(fr.getChildFragmentManager());
        this.technologies=technologies;
    }

    @NonNull
    @Override
    public Page getItem(int position) {

        return Page.newInstance(technologies,position);
    }

    @Override
    public int getCount() {
        return technologies.size();
    }
}
