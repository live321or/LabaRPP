package com.samoylov.mylaba1;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ibm.icu.text.RuleBasedNumberFormat;

import java.util.Locale;

import static android.graphics.Color.green;
import static android.graphics.Color.parseColor;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.RvViewHolder>{
    private int cunt;
//    Translate t;
    public RvAdapter(int Count){
        this.cunt=Count;
    }

    private static final RuleBasedNumberFormat nf= new RuleBasedNumberFormat(
            new Locale("ru", "Ru"), RuleBasedNumberFormat.SPELLOUT
    );

    @Override
    public RvViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int lId=R.layout.number_list_item;

        LayoutInflater inflater = LayoutInflater.from(context);

        View view=inflater.inflate(lId,parent,false);
        RvViewHolder rvViewHolder = new RvViewHolder(view);
        return rvViewHolder;
        //return new RvViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RvViewHolder holder, int position) {
//        holder.frameLayout.setBackgroundColor(parseColor("#567845"));
        holder.bind(position);

    }

    @Override
    public int getItemCount() {
        return cunt;
    }

    public class RvViewHolder extends RecyclerView.ViewHolder {


        TextView pos;
        private LinearLayout frameLayout;
        public RvViewHolder(final View itemView) {
            super(itemView);
            frameLayout =(LinearLayout) itemView.findViewById(R.id.syka);
            pos = itemView.findViewById(R.id.rv_Item);
        }

        void bind(int listIndex){
            pos.setText(nf.format(listIndex+1));

            if(listIndex%2==0){
                frameLayout.setBackgroundColor(Color.parseColor("#cccccc"));
            }else{
                frameLayout.setBackgroundColor(Color.parseColor("#ffffff"));
            }
        }
    }
}
