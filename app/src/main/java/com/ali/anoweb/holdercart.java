package com.ali.anoweb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class holdercart extends RecyclerView.Adapter<holdercart.holder>
{
    List<modelcart> modelcarts;
    Context context;

    public holdercart(List<modelcart> modelcarts, Context context) {
        this.modelcarts = modelcarts;
        this.context = context;
    }

    @NonNull
    @Override
    public holdercart.holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cartlayout,parent,false);
        return new holdercart.holder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull holdercart.holder holder, int position) {

        holder.imageView.setImageResource(modelcarts.get(position).getImage());
        holder.title.setText(modelcarts.get(position).getTitle());
        holder.price.setText(modelcarts.get(position).getPrice());

    }

    @Override
    public int getItemCount() {
        return modelcarts.size();
    }

    public class holder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView title,price;

        public holder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.img);
            title=itemView.findViewById(R.id.title);
            price=itemView.findViewById(R.id.price);

        }
    }
}
