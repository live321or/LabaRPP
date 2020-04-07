package com.samoylov.laba21.fragmentOne;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.samoylov.laba21.HomeActivity;
import com.samoylov.laba21.R;
import com.samoylov.laba21.Technologies;
import com.samoylov.laba21.fragmentTwo.ViewPagerFragment;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class RvAdapter extends RecyclerView.Adapter<RvAdapter.RvViewHolder> {

    private int count;

    private FragmentManager manager;
    private Fragment fragment;
    private ArrayList<Technologies> technologies;
    private String picUri = "https://raw.githubusercontent.com/wesleywerner/ancient-tech/02decf875616dd9692b31658d92e64a20d99f816/src/images/tech/";

    public RvAdapter( ArrayList<Technologies> technologies,FragmentManager manager , int Count) {
        //this.context =context;
        this.technologies=technologies;
        this.manager = manager;
        this.fragment=fragment;
        this.count = Count;
    }

    @NonNull
    @Override
    public RvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int listId = R.layout.list_item;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(listId, parent, false);
        RvViewHolder rvViewHolder = new RvViewHolder(v);
        return rvViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final RvViewHolder holder, final int position) {
        final TextView transitioningView=holder.pos;
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                fragment.getFragmentManager()
//                        .beginTransaction()
//                        .addSharedElement(transitioningView,transitioningView.getTransitionName())
//                        .replace(R.id.homeA,new ViewPagerFragment(),ViewPagerFragment.class
//                                .getSimpleName())
//                        .addToBackStack(null)
//                        .commit();
                ViewPagerFragment viewPagerFragment = new ViewPagerFragment();
                viewPagerFragment=ViewPagerFragment.newI(position,technologies);

                manager.beginTransaction()
                        .replace(R.id.homeA, viewPagerFragment)
                        .addToBackStack(null)
                        .commit();

                Toast.makeText(view.getContext(), "This position = "
                                + holder.pos.getText(),
                        Toast.LENGTH_SHORT)
                        .show();

            }
        });

        holder.pos.setText(technologies.get(position+1).getName());

        Picasso.get().load(picUri+technologies.get(position+1).getGraphic()).error(R.drawable.ic_launcher_background).into(holder.tehno);

        if (position % 2 == 0) {
            holder.linearLayout.setBackgroundColor(Color.parseColor("#cccccc"));
        } else {
            holder.linearLayout.setBackgroundColor(Color.parseColor("#ffffff"));
        }

    }

    @Override
    public int getItemCount() {
        return technologies.size()-1;
    }

    public class RvViewHolder extends RecyclerView.ViewHolder {
        TextView pos;
        public LinearLayout linearLayout;
        public ImageView tehno;

        public RvViewHolder(@NonNull View itemView) {
            super(itemView);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.item);
            tehno = (ImageView) itemView.findViewById(R.id.image_tehno);
            pos = itemView.findViewById(R.id.rv_item);
        }
    }
}

