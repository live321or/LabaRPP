package com.samoylov.laba21.fragmentTwo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.samoylov.laba21.HomeActivity;
import com.samoylov.laba21.R;
import com.samoylov.laba21.Technologies;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewPagerFragment extends Fragment {
    //    static final String TAG = "myLogs";
//    static final int PAGE_COUNT = 20;
    public ViewPager viewPager;
    //    PagerAdapter pagerAdapter;
    int posItem;
    private ArrayList<Technologies> t;
    public ViewPagerFragment() {
        // Required empty public constructor

    }
    public static ViewPagerFragment newI(int pos,ArrayList<Technologies> t){
        ViewPagerFragment vPF=new ViewPagerFragment();
        vPF.posItem=pos;
        vPF.t=t;
        return vPF;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //View v=inflater.inflate(R.layout.fragment_view_pager, container, false);
//        pager=(ViewPager) v.findViewById(R.id.pager);
//        pagerAdapter=new MyFragmentPagerAdapter(getChildFragmentManager());
//        pager.setAdapter(pagerAdapter);
//        pager.getCurrentItem();
        //return v;
        viewPager = (ViewPager) inflater.inflate(R.layout.fragment_view_pager
                , container, false);
        viewPager.setAdapter(new PageAdapter(this,t));
        viewPager.setCurrentItem(posItem);
//        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
//            @Override
//            public void onPageSelected(int position) {
//                HomeActivity.currentPosition = position;
//            }
//        });
        return viewPager;
    }

//    private class MyFragmentPagerAdapter extends FragmentPagerAdapter {
//        public MyFragmentPagerAdapter(FragmentManager Fragment) {
//            super(getChildFragmentManager());
//        }
//
//        @NonNull
//        @Override
//        public Page getItem(int position) {
//            t.get(posItem).getName();
//            return Page.newInstance(position,new ArrayList<Technologies>(t));
//        }
//
//        @Override
//        public int getCount() {
//            return PAGE_COUNT;
//        }
//
//
//    }
}
