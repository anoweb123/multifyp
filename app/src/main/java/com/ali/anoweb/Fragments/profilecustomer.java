package com.ali.anoweb.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ali.anoweb.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link profilecustomer#newInstance} factory method to
 * create an instance of this fragment.
 */
public class profilecustomer extends Fragment {

    ImageView name,address,phone,password,email;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public profilecustomer() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment profilecustomer.
     */
    // TODO: Rename and change types and number of parameters
    public static profilecustomer newInstance(String param1, String param2) {
        profilecustomer fragment = new profilecustomer();
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
        View view= inflater.inflate(R.layout.fragment_profilecustomer, container, false);

        address=view.findViewById(R.id.addressupdate);
        name=view.findViewById(R.id.nameupdate);
        phone=view.findViewById(R.id.phoneupdate);
        password=view.findViewById(R.id.updatepassword);
        email=view.findViewById(R.id.emailupdate);

        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updatename updatename = new updatename();
                FragmentManager fragmentManagerpro = getParentFragmentManager();
                FragmentTransaction fragmentTransactionpro = fragmentManagerpro.beginTransaction();
                fragmentTransactionpro.replace(R.id.fragment, updatename);
                fragmentTransactionpro.commit();
            }
        });
        address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addressupdate updateaddress = new addressupdate();
                FragmentManager fragmentManagerpro = getParentFragmentManager();
                FragmentTransaction fragmentTransactionpro = fragmentManagerpro.beginTransaction();
                fragmentTransactionpro.replace(R.id.fragment, updateaddress);
                fragmentTransactionpro.commit();
            }
        });
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updatephone enterpassword = new updatephone();
                FragmentManager fragmentManagerpro = getParentFragmentManager();
                FragmentTransaction fragmentTransactionpro = fragmentManagerpro.beginTransaction();
                fragmentTransactionpro.replace(R.id.fragment, enterpassword);
                fragmentTransactionpro.commit();
            }
        });
        password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updatepassword enterpassword = new updatepassword();
                FragmentManager fragmentManagerpro = getParentFragmentManager();
                FragmentTransaction fragmentTransactionpro = fragmentManagerpro.beginTransaction();
                fragmentTransactionpro.replace(R.id.fragment, enterpassword);
                fragmentTransactionpro.commit();
            }
        });
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateemail enter = new updateemail();
                FragmentManager fragmentManagerpro = getParentFragmentManager();
                FragmentTransaction fragmentTransactionpro = fragmentManagerpro.beginTransaction();
                fragmentTransactionpro.replace(R.id.fragment, enter);
                fragmentTransactionpro.commit();
            }
        });
        return  view;
    }
}