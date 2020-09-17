package com.ali.anoweb.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ali.anoweb.R;
import com.ali.anoweb.holderclassproducts;
import com.ali.anoweb.modelproducts;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link shop#newInstance} factory method to
 * create an instance of this fragment.
 */
public class shop extends Fragment implements holderclassproducts.onproclicklistener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    holderclassproducts adapterproduct;
    List<modelproducts> modelpro;

    RecyclerView recyclerView;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public shop() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment shop.
     */
    // TODO: Rename and change types and number of parameters
    public static shop newInstance(String param1, String param2) {
        shop fragment = new shop();
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
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_shop, container, false);
        recyclerView=view.findViewById(R.id.recshop);

        modelpro = new ArrayList<>();
        modelpro.add(new modelproducts("Brochur","1999",R.drawable.shirt,"2200"));
        modelpro.add(new modelproducts("loren ipsum","2000",R.drawable.jacket,"2200"));
        modelpro.add(new modelproducts("Brochur","1999",R.drawable.shirt,"2200"));
        modelpro.add(new modelproducts("loren ipsum","2000",R.drawable.jacket,"2200"));
        modelpro.add(new modelproducts("Brochur","1999",R.drawable.shirt,"2200"));
        modelpro.add(new modelproducts("loren ipsum","2000",R.drawable.jacket,"2200"));
        modelpro.add(new modelproducts("Brochur","1999",R.drawable.shirt,"2200"));
        modelpro.add(new modelproducts("loren ipsum","2000",R.drawable.jacket,"2200"));
        modelpro.add(new modelproducts("Brochur","1999",R.drawable.shirt,"2200"));
        modelpro.add(new modelproducts("loren ipsum","2000",R.drawable.jacket,"2200"));

        adapterproduct = new holderclassproducts(modelpro, getContext());

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        recyclerView.setAdapter(adapterproduct);
        adapterproduct.notifyDataSetChanged();
        adapterproduct.setoncartclicklistener(this);
        return view;
    }

    @Override
    public void onproclick(String title, String desc, String price, String discounted, int image, String color, String size, String days, String qtyleft) {
        productfragment productfragment = new productfragment();
        FragmentManager fragmentManagerpro = getParentFragmentManager();
        FragmentTransaction fragmentTransactionpro = fragmentManagerpro.beginTransaction();
        Bundle bundle=new Bundle();
        bundle.putString("titlekey",title);
        bundle.putString("desckey",desc);
        bundle.putString("pricekey",price);
        bundle.putString("discountedkey",discounted);
        bundle.putString("colorkey",color);
        bundle.putString("sizekey",size);
        bundle.putString("dayskey",days);
        bundle.putString("qtyleftkey",qtyleft);
        bundle.putInt("imagekey",image);
        productfragment.setArguments(bundle);
        fragmentTransactionpro.replace(R.id.fragment, productfragment);
        fragmentTransactionpro.commit();

    }
}