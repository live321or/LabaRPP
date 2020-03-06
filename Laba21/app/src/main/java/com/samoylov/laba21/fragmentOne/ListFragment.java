package com.samoylov.laba21.fragmentOne;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.samoylov.laba21.HomeActivity;
import com.samoylov.laba21.R;
import com.samoylov.laba21.RequestInterface;
import com.samoylov.laba21.Technologies;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ListFragment extends Fragment {
    private ArrayList<Technologies> technologies=new ArrayList<>();

    private RecyclerView rV;
    private RvAdapter rvAdapter;
    private FragmentManager manager;
    public ListFragment(FragmentManager manager){
        this.manager=manager;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_list, container, false);
        getTechnologiesResponse();
        rV=v.findViewById(R.id.rv);
        LinearLayoutManager lm=new LinearLayoutManager(getActivity());
        rV.setLayoutManager(lm);

        return v;
    }

    private void getTechnologiesResponse() {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/wesleywerner/ancient-tech/02decf875616dd9692b31658d92e64a20d99f816/src/data/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestInterface requestInterface=retrofit.create(RequestInterface.class);
        Call<List<Technologies>> call=requestInterface.getTechnologiesJson();

        call.enqueue(new Callback<List<Technologies>>() {
            @Override
            public void onResponse(Call<List<Technologies>> call, Response<List<Technologies>> response) {
                technologies=new ArrayList<>(response.body());
                rvAdapter=new RvAdapter(technologies,manager,20);
                rV.setAdapter(rvAdapter);
                Toast.makeText(getView().getContext(),"Success",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<Technologies>> call, Throwable t) {
                Toast.makeText(getView().getContext(),"Failed",Toast.LENGTH_SHORT).show();

            }
        });
    }
}
