package com.example.pracycse;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class RecycleviewAdapater extends RecyclerView.Adapter<RecycleviewAdapater.ViewHolder> {
    private List<Thing> mthing;

    @Override
    public int getItemCount() {
        return mthing.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView thingImg;
        TextView thingName;
        public ViewHolder(View view){
            super(view);

            thingImg=(ImageView)view.findViewById(R.id.thing_img);
            thingName=(TextView)view.findViewById(R.id.thing_name);
        }
    }
    public RecycleviewAdapater(List<Thing>thingList){
        mthing=thingList;
    }
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_1,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }
    public void onBindViewHolder(ViewHolder holder,int position){

        Thing thing=mthing.get(position);
        holder.thingImg.setImageResource(thing.getImgid());
        holder.thingName.setText(thing.getName());
    }


}