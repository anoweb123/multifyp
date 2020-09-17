package com.ali.anoweb.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ali.anoweb.R;
import com.ali.anoweb.dbhandler;
import com.ali.anoweb.holderwishlist;
import com.ali.anoweb.modelwishlist;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link wishlist#newInstance} factory method to
 * create an instance of this fragment.
 */
public class wishlist extends Fragment {

    RecyclerView recyclerView;
    List<modelwishlist> list;
    holderwishlist adapter;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    public wishlist() {
    }
    public static wishlist newInstance(String param1, String param2) {
        wishlist fragment = new wishlist();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null){
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wishlist, container, false);
        recyclerView=view.findViewById(R.id.rec);

        list = new ArrayList<>();
        dbhandler dbhandler=new dbhandler(getContext());
        list=dbhandler.retrievewishlist();
        dbhandler.close();
        adapter = new holderwishlist(list, getContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        return view;
    }
}