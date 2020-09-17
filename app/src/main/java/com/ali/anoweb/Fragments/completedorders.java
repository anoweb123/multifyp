package com.ali.anoweb.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ali.anoweb.R;
import com.ali.anoweb.holdercompleted;
import com.ali.anoweb.holderwishlist;
import com.ali.anoweb.modelcompleted;
import com.ali.anoweb.modelwishlist;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link completedorders#newInstance} factory method to
 * create an instance of this fragment.
 */
public class completedorders extends Fragment {

    RecyclerView recyclerView;
    List<modelcompleted> list;
    holdercompleted adapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public completedorders() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment completedorders.
     */
    // TODO: Rename and change types and number of parameters
    public static completedorders newInstance(String param1, String param2) {
        completedorders fragment = new completedorders();
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
        View view= inflater.inflate(R.layout.fragment_completedorders, container, false);

        recyclerView=view.findViewById(R.id.rec);

        list = new ArrayList<>();
        list.add(new modelcompleted("Order completed","2 sep,2020","Rs 1999"));
        list.add(new modelcompleted("Order completed","2 sep,2020","Rs 1999"));
        list.add(new modelcompleted("Order completed","2 sep,2020","Rs 1999"));
        list.add(new modelcompleted("Order completed","2 sep,2020","Rs 1999"));
        list.add(new modelcompleted("Order completed","2 sep,2020","Rs 1999"));
        list.add(new modelcompleted("Order completed","2 sep,2020","Rs 1999"));
        adapter = new holdercompleted(list, getContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        return view;
    }
}