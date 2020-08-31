package com.ali.anoweb.Fragments;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.ali.anoweb.R;
import com.ali.anoweb.adaperslider;
import com.ali.anoweb.clickonproduct;
import com.ali.anoweb.dashboardcustomer;
import com.ali.anoweb.holderclassproducts;
import com.ali.anoweb.modelbanner;
import com.ali.anoweb.modelproducts;
import com.ali.anoweb.modelslider;
import com.ali.anoweb.shopdetails;
import com.ali.anoweb.sliderbanneradapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

import io.realm.mongodb.App;

public class mainDashboardFragment extends Fragment implements holderclassproducts.onproclicklistener,adaperslider.onshopclicklistener {
    ImageView cart;
    ImageView menu;

    String[] spin1 = { "Categories","pents", "shirts"};
    String category="";
    BottomNavigationView bottomNavigationView;
    RecyclerView recyclerView;
    adaperslider adapter;
    List<modelslider> models;
    App app;
    Spinner categories;
    EditText searchView;
    RecyclerView recpoduct;
    holderclassproducts adapterproduct;
    List<modelproducts> modelpro;

    SliderView sliderView;
    com.ali.anoweb.sliderbanneradapter sliderbanneradapter;
    List<modelbanner> modelsliders;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_main_dashboard, container, false);


                SliderView sliderView =view.findViewById(R.id.imageSlider);
        recpoduct=view.findViewById(R.id.productrec);

        categories = (Spinner)view.findViewById(R.id.categor);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, spin1);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categories.setAdapter(adapter1);
        categories.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                category=spin1[position];
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        cart=view.findViewById(R.id.cart);
        menu=view.findViewById(R.id.menu);

        searchView=view.findViewById(R.id.search);

        searchView.requestFocus();


                cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), com.ali.anoweb.cart.class);
                startActivity(intent);
            }
        });
//        Realm.init(dashboardcustomer.this);
//        String appID ="application-0-crqjz";
//        app = new App(new AppConfiguration.Builder(appID)
//                .build());

        recyclerView=view.findViewById(R.id.rec);

//        mdrawer=view.findViewById(R.id.drawer);
//        actionBarDrawerToggle=new ActionBarDrawerToggle(this,mdrawer,R.string.app_name,R.string.app_name);
//        mdrawer.addDrawerListener(actionBarDrawerToggle);
//        actionBarDrawerToggle.syncState();

//slider
        models = new ArrayList<>();
        models.add(new modelslider(R.drawable.shopp, "stylonickienickienickie"));
        models.add(new modelslider(R.drawable.shopp, "nickie"));
        models.add(new modelslider(R.drawable.shopp, "khadii"));
        models.add(new modelslider(R.drawable.shopp, "shop"));

        adapter = new adaperslider(models, getContext());

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        adapter.setonshopclicklistener(mainDashboardFragment.this);

//productsondashboard
        modelpro = new ArrayList<>();
        modelpro.add(new modelproducts("Brochurenickienickienickie","Rs 1999",R.drawable.shirt));
        modelpro.add(new modelproducts("loren ipsum","Rs 2000",R.drawable.jacket));
        modelpro.add(new modelproducts("loren ipsum","Rs 500",R.drawable.shirt));
        modelpro.add(new modelproducts("loren ipsum","Rs 700",R.drawable.jacket));
        modelpro.add(new modelproducts("loren ipsum","Rs 1000",R.drawable.shirt));
        modelpro.add(new modelproducts("loren ipsum","Rs 3000",R.drawable.jacket));
        modelpro.add(new modelproducts("loren ipsum","Rs 200",R.drawable.shirt));
        modelpro.add(new modelproducts("loren ipsum","Rs 200",R.drawable.jacket));

        adapterproduct = new holderclassproducts(modelpro, getContext());

        recpoduct.setHasFixedSize(true);
        recpoduct.setLayoutManager(new GridLayoutManager(getContext(),2));
        recpoduct.setAdapter(adapterproduct);
        adapterproduct.notifyDataSetChanged();
        adapterproduct.setoncartclicklistener(mainDashboardFragment.this);

//discount_banner
        modelsliders = new ArrayList<>();
        modelsliders.add(new modelbanner(R.drawable.banner));
        modelsliders.add(new modelbanner(R.drawable.banner2));
        modelsliders.add(new modelbanner(R.drawable.banner2));
        modelsliders.add(new modelbanner(R.drawable.banner));
        modelsliders.add(new modelbanner(R.drawable.banner));
        modelsliders.add(new modelbanner(R.drawable.banner2));
        modelsliders.add(new modelbanner(R.drawable.banner));
        modelsliders.add(new modelbanner(R.drawable.banner2));
        modelsliders.add(new modelbanner(R.drawable.banner2));

        sliderbanneradapter= new sliderbanneradapter(modelsliders,getContext());

        sliderView.setSliderAdapter(sliderbanneradapter);

        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);//set indicator animation by using IndicatorAnimationType. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(4); //set scroll delay in seconds :
        sliderView.startAutoCycle();

        return view;
    }

    @Override
    public void onproclick() {
        startActivity(new Intent(getContext(), clickonproduct.class));
    }
    @Override
    public void onshopqclick() {
        startActivity(new Intent(getContext(), shopdetails.class));
    }
    }