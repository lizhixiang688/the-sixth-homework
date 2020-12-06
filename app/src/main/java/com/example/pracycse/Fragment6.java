package com.example.pracycse;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Fragment6  extends Fragment {
    private List<Thing> thingList=new ArrayList<>();
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.fragment_6,container,false);
        RecyclerView recyclerView=(RecyclerView)view.findViewById(R.id.recycle_view);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        RecycleviewAdapater adapater=new RecycleviewAdapater(thingList);
        recyclerView.setAdapter(adapater);
        adapater.notifyDataSetChanged();
        init();
        return view;
    }
    public void init(){
        for(int i=1;i<=10;i++){
            Thing thing1=new Thing("重邮万岁",R.drawable.img_6);
            thingList.add(thing1);

        }

    }
}
