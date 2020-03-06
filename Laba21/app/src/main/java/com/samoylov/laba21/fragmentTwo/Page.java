package com.samoylov.laba21.fragmentTwo;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.samoylov.laba21.R;
import com.samoylov.laba21.Technologies;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class Page extends Fragment {
    static final String ARGUMENT_PAGE_NUMBER = "arg_page_nuber";

    int pageNuber;
    int backColor;
    String picUri="https://raw.githubusercontent.com/wesleywerner/ancient-tech/02decf875616dd9692b31658d92e64a20d99f816/src/images/tech/";
    private ArrayList<Technologies> t;

    public static Page newInstance(ArrayList<Technologies> technologies,int pageNuber){
        Page pageFragment = new Page();
        //Bundle arguments = new Bundle();
        //arguments.putInt("num", page);
        //pageFragment.setArguments(arguments);
        pageFragment.pageNuber=pageNuber;
        pageFragment.t=technologies;
        return pageFragment;
    }

    public Page() {
        // Required empty public constructor
    }

//    public static Page newInstance(String name) {
//    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //pageNuber = getArguments() != null ? getArguments().getInt("num") : 1;

        Random rnd=new Random();
        backColor= Color.argb(40, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pager,container,false);

        TextView tvPage=(TextView) view.findViewById(R.id.tvPager);
        ImageView imageView=(ImageView) view.findViewById(R.id.KArtina);
        Picasso.get().load(picUri+t.get(pageNuber).getGraphic()).error(R.drawable.ic_launcher_background).into(imageView);
        tvPage.setText(t.get(pageNuber).getHelptext());
        tvPage.setBackgroundColor(backColor);

        return view;
    }
}
