package com.ali.anoweb;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.zip.Inflater;

public class holderclassproducts extends RecyclerView.Adapter<holderclassproducts.holder> {
    List<modelproducts> modelproducts;
    onproclicklistener monproclicklistener;
    Context context;
    public holderclassproducts(List<modelproducts> modelproducts, Context context) {
        this.context=context;
        this.modelproducts=modelproducts;
    }


    public void setoncartclicklistener(onproclicklistener listener){
        monproclicklistener=  listener;
    }

    public interface onproclicklistener{
        void onproclick();
    }


    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.productondashboardlayout,parent,false);
        return new holderclassproducts.holder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {

        holder.price.setText(modelproducts.get(position).getPrice());
        holder.title.setText(modelproducts.get(position).getTitle());
        holder.imageView.setImageResource(modelproducts.get(position).getImage());

        if (modelproducts.get(position).getTitle().length()>14){
            holder.title.setText(modelproducts.get(position).getTitle().substring(0,18).concat("..."));
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                monproclicklistener.onproclick();
            }
        });



    }

    @Override
    public int getItemCount() {
        return modelproducts.size();
    }

    public class holder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView price,title;
        public holder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.img);
            price=itemView.findViewById(R.id.price);
            title=itemView.findViewById(R.id.title);
        }
    }
}
