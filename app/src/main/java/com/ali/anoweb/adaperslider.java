package com.ali.anoweb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class adaperslider extends RecyclerView.Adapter<adaperslider.holder> {
    private LayoutInflater layoutInflater;
    private Context context;
    private List<modelslider> models;
    onshopclicklistener monshopclicklistener;


    public adaperslider(List<modelslider> models, Context context) {
        this.models =models;
        this.context = context;
    }

    public void setonshopclicklistener(onshopclicklistener listener){
        monshopclicklistener=  listener;
    }

    public interface onshopclicklistener{
        void onshopqclick();
    }


    @NonNull
    @Override
    public adaperslider.holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sliderlayout,parent,false);
        return new holder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull adaperslider.holder holder, int position) {
        holder.imageView.setImageResource(models.get(position).getImg());
        holder.title.setText(models.get(position).getName());

        if (models.get(position).getName().length()>15){
            holder.title.setText(models.get(position).getName().substring(0,15).concat("..."));
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                monshopclicklistener.onshopqclick();
            }
        });

    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class holder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title;
        public holder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.img);
            title=itemView.findViewById(R.id.name);
        }
    }
}
