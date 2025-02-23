package com.ali.anoweb.holderclasses;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ali.anoweb.R;
import com.ali.anoweb.Models.modelproductbyshop;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;
import static com.ali.anoweb.loginpagecustomer.MY_PREFS_NAME;

public class holderproductbyshop extends RecyclerView.Adapter<holderproductbyshop.holder> {
    List<modelproductbyshop> list;
    Context context;
    String disrate;
    onproinshopclicklistener monproclicklistener;

    String finalDiscount;
    String title, desc, price, discounted, image, color, size, days, qtyleft;

    public holderproductbyshop(List<modelproductbyshop> list, Context context,String disrate) {
        this.list = list;
        this.disrate=disrate;
        this.context = context;
    }

    public void setonproinshopclicklistener(onproinshopclicklistener listener)
    {
        monproclicklistener=  listener;
    }

    public interface onproinshopclicklistener{
       public void onproclick(String proid,String title,String desc,String price,String discounted,String image,String color,String size,String days,String qtyleft);
    }

    @NonNull
    @Override
    public holderproductbyshop.holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layoutproinshop,parent,false);
        return new holderproductbyshop.holder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, final int position) {

        holder.price.setText("Rs "+list.get(position).getPrice());
        holder.title.setText(list.get(position).getName());
        try{
        SharedPreferences prefs = context.getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        String path=list.get(position).getImage().replaceFirst("localhost",prefs.getString("ipv4","10.0.2.2"));
        Picasso.get().load(path).networkPolicy(NetworkPolicy.NO_STORE).into(holder.imageView);
        }
        catch (Exception e){
        }

        final String price=list.get(position).getPrice();
        final String title=list.get(position).getName();
        String discount=list.get(position).getPromotionRate();
        final String desc=list.get(position).getDetail();
        final String image=list.get(position).getImage();
        final String color=list.get(position).getColor();
        final String size=list.get(position).getSize();
        final String qtyleft=list.get(position).getQuantity();
        final String days=list.get(position).getPromotionTill();
        final String proid=list.get(position).get_id();
        finalDiscount= discount;

//        if (disrate.equals("none")){
//        }
//        else {
//            int dis=Integer.valueOf(disrate)/Integer.valueOf(list.get(position).getPrice())*100;
//            discount=String.valueOf(dis);
//        }

        if (disrate.equals("none")){

            if (discount.equals("none")){
                holder.discount.setText("0");
                holder.discount.setVisibility(View.INVISIBLE);
                finalDiscount ="0";
            }

            else {
                finalDiscount=discount;
                holder.price.setText("Rs "+list.get(position).getPromotionRate());
                holder.discount.setText("Rs "+list.get(position).getPrice());

                holder.discount.setPaintFlags(holder.discount.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            }
        }
        else {
            Float d=(Float.parseFloat(price)-(Float.valueOf(price)/100)*Float.parseFloat(disrate));
            holder.price.setText("Rs "+String.valueOf(d.intValue()));
            holder.discount.setText("Rs "+list.get(position).getPrice());
            holder.discount.setPaintFlags(holder.discount.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }

        //        }
//        else {
//            finalDiscount=String.valueOf(Integer.valueOf(disrate)/Integer.valueOf(list.get(position).getPrice())*100);
//            holder.discount.setText("Rs "+list.get(position).getPromotionRate());
//            holder.discount.setPaintFlags(holder.discount.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
//        }


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        monproclicklistener.onproclick(proid,title,desc,price,finalDiscount,image,color,size,days,qtyleft);
            }
        });
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    public class holder extends RecyclerView.ViewHolder{
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
