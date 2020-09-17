package com.ali.anoweb.Fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.Spinner;

import com.ali.anoweb.R;
import com.ali.anoweb.adaperslider;
import com.ali.anoweb.holdercategory;
import com.ali.anoweb.holderclassproducts;
import com.ali.anoweb.holderproslider;
import com.ali.anoweb.modelbanner;
import com.ali.anoweb.modelcateg;
import com.ali.anoweb.modelproducts;
import com.ali.anoweb.modelproductslider;
import com.ali.anoweb.modelslider;
import com.ali.anoweb.sliderbanneradapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class mainDashboardFragment extends Fragment implements holderclassproducts.onproclicklistener,adaperslider.onshopclicklistener,holderproslider.onproclicklistener {
    ImageView cart;
    ImageView menu;

    String category="";
    BottomNavigationView bottomNavigationView;
    RecyclerView recyclerView;
    adaperslider adapter;
    List<modelslider> models;

    RecyclerView recyclerViewcat;
    holdercategory holdercategory;
    List<modelcateg> modelcat;

    Spinner categories;
//    EditText searchView;
    RecyclerView recpoduct;

    RecyclerView recsliderpro;
    holderproslider holderproslider;
    List<modelproductslider> list;

    holderclassproducts adapterproduct;
    List<modelproducts> modelpro;
    SliderView sliderView;


    Boolean isscrolling=false;
    com.ali.anoweb.sliderbanneradapter sliderbanneradapter;
    List<modelbanner> modelsliders;
    int current_items,scrolled_items,total_items;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_main_dashboard, container, false);



//        String head="Explore by categorieslayout";
//        SpannableString spannableString=new SpannableString(head);
//        ForegroundColorSpan foregroundColorSpan=new ForegroundColorSpan(Color.BLUE);
//        spannableString.setSpan(foregroundColorSpan,2,10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

//        final String[] spin1 = {String.valueOf(spannableString),"pents", "shirts"};

//        categories = (Spinner)view.findViewById(R.id.categor);
//        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, spin1){
//            @Override
//            public View getDropDownView(int position, View convertView, ViewGroup parent)
//            {
//                View v = null;
//                v = super.getDropDownView(position, null, parent);
//                // If this is the selected item position
//                if (position == 0) {
//                    v.setBackgroundColor(Color.parseColor("#D3D3D3"));
//                }
//                else {
//                    // for other views
//                    v.setBackgroundColor(Color.WHITE);
//                }
//                return v;
//            }
//        };
//        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        categories.setAdapter(adapter1);

        recsliderpro=view.findViewById(R.id.recpro);
        list=new ArrayList<>();

        recyclerViewcat=view.findViewById(R.id.reccat);
        modelcat=new ArrayList<>();


        SliderView sliderView =view.findViewById(R.id.imageSlider);
        recpoduct=view.findViewById(R.id.productrec);

        cart=view.findViewById(R.id.cart);
        menu=view.findViewById(R.id.menu);

//        searchView=view.findViewById(R.id.search);
//        searchView.requestFocus();
            cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cart cart = new cart();
                FragmentManager fragmentManagerpro = getParentFragmentManager();
                FragmentTransaction fragmentTransactionpro = fragmentManagerpro.beginTransaction();
                fragmentTransactionpro.replace(R.id.fragment, cart);
                fragmentTransactionpro.commit();
            }
        });
        recyclerView=view.findViewById(R.id.rec);
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
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }
        });
        adapter.notifyDataSetChanged();
        adapter.setonshopclicklistener(mainDashboardFragment.this);

//categriesondashboard
        modelcat = new ArrayList<>();
        modelcat.add(new modelcateg("Food",R.drawable.food));
        modelcat.add(new modelcateg("Clothes",R.drawable.clothes));
        modelcat.add(new modelcateg("Electronics",R.drawable.electro));
        modelcat.add(new modelcateg("Fitness",R.drawable.sports));
        modelcat.add(new modelcateg("Health and safety",R.drawable.health));
        modelcat.add(new modelcateg("Groceries and households",R.drawable.groceries));

        recyclerViewcat.setHasFixedSize(true);
        recyclerViewcat.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        holdercategory = new holdercategory(modelcat, getContext());
        recyclerViewcat.setAdapter(holdercategory);
        holdercategory.notifyDataSetChanged();

//productsondashboard
        modelpro = new ArrayList<>();
        modelpro.add(new modelproducts("Brochurenickienickienickie","1999",R.drawable.shirt,"200"));
        modelpro.add(new modelproducts("loren ipsum","2000",R.drawable.jacket,"2200"));
        modelpro.add(new modelproducts("loren ipsum","500",R.drawable.shirt,"2200"));
        modelpro.add(new modelproducts("loren ipsum","700",R.drawable.jacket,"2200"));
//        modelpro.add(new modelproducts("loren ipsum","Rs 1000",R.drawable.shirt,"Rs 2200"));
//        modelpro.add(new modelproducts("loren ipsum","Rs 3000",R.drawable.jacket,"Rs 2200"));
//        modelpro.add(new modelproducts("loren ipsum","Rs 200",R.drawable.shirt,"Rs 2200"));
//        modelpro.add(new modelproducts("loren ipsum","Rs 200",R.drawable.jacket,"Rs 2200"));
//        modelpro.add(new modelproducts("loren ipsum","Rs 3000",R.drawable.jacket,"Rs 2200"));
//        modelpro.add(new modelproducts("loren ipsum","Rs 200",R.drawable.shirt,"Rs 2200"));
//        modelpro.add(new modelproducts("loren ipsum","Rs 200",R.drawable.jacket,"Rs 2200"));

        recpoduct.setHasFixedSize(true);
        final LinearLayoutManager manager=new GridLayoutManager(getContext(),2);
        recpoduct.setLayoutManager(manager);
        adapterproduct = new holderclassproducts(modelpro, getContext());
        recpoduct.setAdapter(adapterproduct);

        adapterproduct.notifyDataSetChanged();
        adapterproduct.setoncartclicklistener(mainDashboardFragment.this);

        recpoduct.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState== AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL){
                    isscrolling=true;
                }
            }
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                current_items=manager.getChildCount();
                scrolled_items=manager.findFirstVisibleItemPosition();
                total_items=manager.getItemCount();
                if ((current_items+scrolled_items==total_items)){
                    modelpro.add(new modelproducts("loren ipsum","1000",R.drawable.about,"2200"));
                    modelpro.add(new modelproducts("loren ipsum","3000",R.drawable.banner,"2200"));
                    modelpro.add(new modelproducts("loren ipsum","200",R.drawable.color,"2200"));
                    modelpro.add(new modelproducts("loren ipsum","200",R.drawable.shop,"2200"));
                    modelpro.add(new modelproducts("loren ipsum","200",R.drawable.color,"2200"));
                    modelpro.add(new modelproducts("loren ipsum","200",R.drawable.color,"2200"));
//                    adapterproduct.notifyDataSetChanged();
                }
            }
        });
//productsondashboardslider
        list.add(new modelproductslider(R.drawable.shirt,"Brochur","1999","2000"));
        list.add(new modelproductslider(R.drawable.shirt,"Brochur","1999","2000"));
        list.add(new modelproductslider(R.drawable.shirt,"nickie","1999","2000"));
        list.add(new modelproductslider(R.drawable.shirt,"nickie","1999","2000"));
        list.add(new modelproductslider(R.drawable.shirt,"Brochurenickienickienickie","1999","2000"));
        list.add(new modelproductslider(R.drawable.shirt,"Brochur","1999","2000"));

        recsliderpro.setHasFixedSize(true);
        recsliderpro.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        holderproslider = new holderproslider(list, getContext());
        recsliderpro.setAdapter(holderproslider);
        holderproslider.notifyDataSetChanged();
        holderproslider.setoncartclicklistener(this);
//discount_banner
        modelsliders = new ArrayList<>();
        modelsliders.add(new modelbanner(R.drawable.shop));
        modelsliders.add(new modelbanner(R.drawable.shop));
        modelsliders.add(new modelbanner(R.drawable.shop));
        modelsliders.add(new modelbanner(R.drawable.shop));
        modelsliders.add(new modelbanner(R.drawable.shop));
        modelsliders.add(new modelbanner(R.drawable.shop));
        modelsliders.add(new modelbanner(R.drawable.shop));
        modelsliders.add(new modelbanner(R.drawable.shop));
        modelsliders.add(new modelbanner(R.drawable.shop));
        modelsliders.add(new modelbanner(R.drawable.shop));

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
    public void onshopqclick() {
        shop shop = new shop();
        FragmentManager fragmentManagerpro = getParentFragmentManager();
        FragmentTransaction fragmentTransactionpro = fragmentManagerpro.beginTransaction();
        fragmentTransactionpro.replace(R.id.fragment, shop);
        fragmentTransactionpro.commit();
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

    @Override
    public void onproclickinslide(String title, String desc, String price, String discounted, int image, String color, String size, String days, String qtyleft) {
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