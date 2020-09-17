package com.ali.anoweb.Fragments;

import android.graphics.Paint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ali.anoweb.R;
import com.ali.anoweb.dbhandler;
import com.ali.anoweb.holderclassproducts;
import com.google.android.material.snackbar.Snackbar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link productfragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class productfragment extends Fragment {

    TextView discountedview,priceview,descview,daysleftview,leftinstockview,colorview,sizeview,titleview;
    ImageView imageView;
    Button addtocart,buynow,addtowish;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public productfragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment productfragment.
     */
    // TODO: Rename and change types and number of parameters
    public static productfragment newInstance(String param1, String param2) {
        productfragment fragment = new productfragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
                final View view= inflater.inflate(R.layout.fragment_productfragment, container, false);

                addtocart=view.findViewById(R.id.addtocart);
                addtowish=view.findViewById(R.id.addtowish);

                discountedview=view.findViewById(R.id.discount);
                priceview=view.findViewById(R.id.price);
                daysleftview=view.findViewById(R.id.daysleft);
                titleview=view.findViewById(R.id.title);
                descview=view.findViewById(R.id.desc);
                colorview=view.findViewById(R.id.color);
                sizeview=view.findViewById(R.id.size);
                leftinstockview=view.findViewById(R.id.leftinstock);
                imageView=view.findViewById(R.id.img);


                final String title=getArguments().getString("titlekey");
                final String price=getArguments().getString("pricekey");
                final String discount=getArguments().getString("discountedkey");
                final String desc=getArguments().getString("desckey");
                final int image=getArguments().getInt("imagekey");
                final String leftinstock=getArguments().getString("qtyleftkey");
                String daysleft=getArguments().getString("dayskey");
                final String color=getArguments().getString("colorkey");
                final String size=getArguments().getString("sizekey");


                discountedview.setText("Rs "+discount);
                discountedview.setPaintFlags(discountedview.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                titleview.setText(title);
                priceview.setText("Rs "+price);
                descview.setText(desc);
                leftinstockview.setText(leftinstock);
                daysleftview.setText(daysleft+" days left at this price");
                colorview.setText(color);
                sizeview.setText(size);
                imageView.setImageResource(image);

                addtocart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dbhandler dbhandler=new dbhandler(getContext());
                        long a=dbhandler.addtocart(title,image,desc,price,discount,color,size,"1",Integer.valueOf(leftinstock));
                        dbhandler.close();
                        Toast.makeText(getContext(), "Added to cart", Toast.LENGTH_SHORT).show();
                    }
                });
                addtowish.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dbhandler dbhandler=new dbhandler(getContext());
                        long a=dbhandler.addtowishlist(title,image,desc,price,discount,color,size);
                        dbhandler.close();
                        Toast.makeText(getContext(), "Added to Wishlist", Toast.LENGTH_SHORT).show();
                    }
                });

        return view;
    }
}