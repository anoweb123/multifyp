package com.ali.anoweb;

import android.content.Context;
import android.graphics.Paint;
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
        void onproclick(String title,String desc,String price,String discounted,int image,String color,String size,String days,String qtyleft);
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

        holder.price.setText("Rs "+modelproducts.get(position).getPrice());
        holder.title.setText(modelproducts.get(position).getTitle());
        holder.imageView.setImageResource(modelproducts.get(position).getImage());
        holder.discount.setText("Rs "+modelproducts.get(position).getDiscount());
        holder.discount.setPaintFlags(holder.discount.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        final String price=modelproducts.get(position).getPrice();
        final String title=modelproducts.get(position).getTitle();
        final String discount=modelproducts.get(position).getDiscount();
        modelproducts.get(position).getDescription();
        final String desc="This is very nice cloth you will be glade to buy this its stuff is good";
        final int image=modelproducts.get(position).getImage();
        final String color="blue";
        final String size="large";
        final String qtyleft="3";
        final String days="3";

        if (modelproducts.get(position).getTitle().length()>14){
            holder.title.setText(modelproducts.get(position).getTitle().substring(0,18).concat("..."));
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                monproclicklistener.onproclick(title,desc,price,discount,image,color,size,days,qtyleft);
            }
        });
    }
    @Override
    public int getItemCount() {
        return modelproducts.size();
    }

    public class holder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView price,title,discount;
        public holder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.img);
            price=itemView.findViewById(R.id.price);
            title=itemView.findViewById(R.id.title);
            discount=itemView.findViewById(R.id.discountprice);
        }
    }
}
