package com.ali.anoweb.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ali.anoweb.R;
import com.ali.anoweb.adaperslider;
import com.ali.anoweb.dbhandler;
import com.ali.anoweb.holdercart;
import com.ali.anoweb.modelcart;
import com.ali.anoweb.modelslider;

import java.util.ArrayList;
import java.util.List;
/**
 * A simple {@link Fragment} subclass.
 * Use the {@link cart#newInstance} factory method to
 * create an instance of this fragment.
 */
public class cart extends Fragment implements holdercart.ondel{

    RecyclerView recyclerView;
    List<modelcart> modelcarts;
    holdercart adapter;
    TextView totalprice,totalpayable,payable;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public cart() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment cart.
     */
    // TODO: Rename and change types and number of parameters
    public static cart newInstance(String param1, String param2) {
        cart fragment = new cart();
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
        View view= inflater.inflate(R.layout.fragment_cart, container, false);

        recyclerView=view.findViewById(R.id.rec);
        totalprice=view.findViewById(R.id.totalprice);
        totalpayable=view.findViewById(R.id.totalpayable);
        payable=view.findViewById(R.id.payable);


        modelcarts = new ArrayList<>();
        dbhandler dbhandler=new dbhandler(getContext());
        modelcarts=dbhandler.retrievecart();
        dbhandler.close();

        dbhandler dbhandler1=new dbhandler(getContext());
        int tprice=dbhandler1.totalprice();
        totalprice.setText("Rs "+String.valueOf(tprice));
        dbhandler1.close();

        totalpayable.setText("Rs "+String.valueOf(tprice+200));
        payable.setText(String.valueOf(tprice+200));

        adapter = new holdercart(modelcarts, getContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        adapter.onclick(this);
        
        if (modelcarts.isEmpty()){
            nullcart productfragment = new nullcart();
            FragmentManager fragmentManagerpro = getParentFragmentManager();
            FragmentTransaction fragmentTransactionpro = fragmentManagerpro.beginTransaction();
            fragmentTransactionpro.replace(R.id.fragment, productfragment);
            fragmentTransactionpro.commit();
        }

//        ItemTouchHelper itemTouchHelper = new
//                ItemTouchHelper(new Swipetodeletecallback(adapter,getContext()));
//        itemTouchHelper.attachToRecyclerView(recyclerView);
        return view;
    }
    @Override
    public void onclicker(int position){
        if (position==-2){
            modelcarts = new ArrayList<>();
            dbhandler dbhandler=new dbhandler(getContext());
            modelcarts=dbhandler.retrievecart();

            adapter = new holdercart(modelcarts, getContext());
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
            adapter.onclick(this);
            int tprice=dbhandler.totalprice();
            totalprice.setText("Rs "+String.valueOf(tprice));
            dbhandler.close();

            totalpayable.setText("Rs "+String.valueOf(tprice+200));
            payable.setText(String.valueOf(tprice+200));
            if (modelcarts.isEmpty() && recyclerView.getChildCount()==0){
                nullcart productfragment = new nullcart();
                FragmentManager fragmentManagerpro = getParentFragmentManager();
                FragmentTransaction fragmentTransactionpro = fragmentManagerpro.beginTransaction();
                fragmentTransactionpro.replace(R.id.fragment, productfragment);
                fragmentTransactionpro.commit();
            }


        }
        else {
            modelcarts.remove(position);
            adapter.notifyDataSetChanged();

            modelcarts = new ArrayList<>();
            dbhandler dbhandler=new dbhandler(getContext());
            modelcarts=dbhandler.retrievecart();

            adapter = new holdercart(modelcarts, getContext());
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
            adapter.onclick(this);
            int tprice=dbhandler.totalprice();
            totalprice.setText("Rs "+String.valueOf(tprice));
            dbhandler.close();

            totalpayable.setText("Rs "+String.valueOf(tprice+200));
            payable.setText(String.valueOf(tprice+200));
            if (modelcarts.isEmpty() && recyclerView.getChildCount()==0){
                nullcart productfragment = new nullcart();
                FragmentManager fragmentManagerpro = getParentFragmentManager();
                FragmentTransaction fragmentTransactionpro = fragmentManagerpro.beginTransaction();
                fragmentTransactionpro.replace(R.id.fragment, productfragment);
                fragmentTransactionpro.commit();
            }
        }
    }
}