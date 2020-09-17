package com.ali.anoweb;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
public class holderwishlist extends RecyclerView.Adapter<holderwishlist.holder> {
        List<modelwishlist> list;
        Context context;

    public holderwishlist(List<modelwishlist> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layoutwishlist,parent,false);
        return new holderwishlist.holder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
        holder.title.setText(list.get(position).getTitle());
        holder.price.setText("Rs "+list.get(position).getPrice());
        holder.discounted.setText("Rs "+list.get(position).getDiscounted());
        holder.color.setText("Color: "+list.get(position).getColor());
        holder.size.setText("Size: "+list.get(position).getSize());
        holder.discounted.setPaintFlags(holder.discounted.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        holder.img.setImageResource(list.get(position).getImage());
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    public class holder extends RecyclerView.ViewHolder {
        TextView title,price,discounted,size,color;
        ImageView img;

        public holder(@NonNull View itemView) {
            super(itemView);

            img=itemView.findViewById(R.id.img);
            title=itemView.findViewById(R.id.title);
            price=itemView.findViewById(R.id.price);
            color=itemView.findViewById(R.id.color);
            size=itemView.findViewById(R.id.size);
            discounted=itemView.findViewById(R.id.discount);

        }
    }
}
