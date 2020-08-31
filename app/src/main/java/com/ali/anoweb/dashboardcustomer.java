package com.ali.anoweb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.ali.anoweb.Fragments.mainDashboardFragment;
import com.ali.anoweb.Fragments.profilecustomer;
import com.ali.anoweb.Fragments.searchfragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

import io.realm.mongodb.App;

public class dashboardcustomer extends AppCompatActivity {

    ImageView cart;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Button button;
    ImageView menu;
    BottomNavigationView bottomNavigationView;
    RecyclerView recyclerView;
    adaperslider adapter;
    List<modelslider> models;
    App app;
    androidx.appcompat.widget.SearchView searchView;
    RecyclerView recpoduct;
    holderclassproducts adapterproduct;
    List<modelproducts> modelpro;

    SliderView sliderView;
    sliderbanneradapter sliderbanneradapter;
    List<modelbanner> modelsliders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboardcustomer);



        bottomNavigationView=findViewById(R.id.botnav);
//        SliderView sliderView = findViewById(R.id.imageSlider);
//        recpoduct=findViewById(R.id.productrec);
//
//        cart=findViewById(R.id.cart);
//        menu=findViewById(R.id.menu);
//
//        searchView=findViewById(R.id.search);


        mainDashboardFragment mainDashboardFragment = new mainDashboardFragment();

        FragmentManager fragmentManagers = getSupportFragmentManager();
        FragmentTransaction fragmentTransactions = fragmentManagers.beginTransaction();
        fragmentTransactions.add(R.id.fragment, mainDashboardFragment);
        fragmentTransactions.commit();
        bottomNavigationView.setSelectedItemId(R.id.navigation_home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.navigation_pro:
                        profilecustomer details = new profilecustomer();
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.fragment, details);
                        fragmentTransaction.commit();
                        break;
                    case R.id.navigation_home:
                        mainDashboardFragment mainDashboardFragment = new mainDashboardFragment();
                        FragmentManager fragmentManagers = getSupportFragmentManager();
                        FragmentTransaction fragmentTransactions = fragmentManagers.beginTransaction();
                        fragmentTransactions.replace(R.id.fragment, mainDashboardFragment);
                        fragmentTransactions.commit();
                        break;
                    case R.id.navigation_search:
                        searchfragment searchfragment = new searchfragment();
                        FragmentManager fragmentManagersea = getSupportFragmentManager();
                        FragmentTransaction fragmentTransactionssea = fragmentManagersea.beginTransaction();
                        fragmentTransactionssea.replace(R.id.fragment, searchfragment);
                        fragmentTransactionssea.commit();
                        break;
                }

                return true;
            }
        });
//        cart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(dashboardcustomer.this, com.ali.anoweb.cart.class);
//                startActivity(intent);
//            }
//        });
////        Realm.init(dashboardcustomer.this);
////        String appID ="application-0-crqjz";
////        app = new App(new AppConfiguration.Builder(appID)
////                .build());
//
//        recyclerView=findViewById(R.id.rec);
//        navigationView=findViewById(R.id.nav);
//
//
//
//
////slider
//        models = new ArrayList<>();
//        models.add(new modelslider(R.drawable.shopp, "stylonickienickienickie"));
//        models.add(new modelslider(R.drawable.shopp, "nickie"));
//        models.add(new modelslider(R.drawable.shopp, "khadii"));
//        models.add(new modelslider(R.drawable.shopp, "shop"));
//
//        adapter = new adaperslider(models, this);
//
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
//        recyclerView.setAdapter(adapter);
//        adapter.notifyDataSetChanged();
//        adapter.setonshopclicklistener(this);
//
////productsondashboard
//        modelpro = new ArrayList<>();
//        modelpro.add(new modelproducts("Brochurenickienickienickie","Rs 1999",R.drawable.shirt));
//        modelpro.add(new modelproducts("loren ipsum","Rs 2000",R.drawable.jacket));
//        modelpro.add(new modelproducts("loren ipsum","Rs 500",R.drawable.shirt));
//        modelpro.add(new modelproducts("loren ipsum","Rs 700",R.drawable.jacket));
//        modelpro.add(new modelproducts("loren ipsum","Rs 1000",R.drawable.shirt));
//        modelpro.add(new modelproducts("loren ipsum","Rs 3000",R.drawable.jacket));
//        modelpro.add(new modelproducts("loren ipsum","Rs 200",R.drawable.shirt));
//        modelpro.add(new modelproducts("loren ipsum","Rs 200",R.drawable.jacket));
//
//        adapterproduct = new holderclassproducts(modelpro, this);
//
//        recpoduct.setHasFixedSize(true);
//        recpoduct.setLayoutManager(new GridLayoutManager(this,2));
//        recpoduct.setAdapter(adapterproduct);
//        adapterproduct.notifyDataSetChanged();
//        adapterproduct.setoncartclicklistener(dashboardcustomer.this);
//
////discount_banner
//        modelsliders = new ArrayList<>();
//        modelsliders.add(new modelbanner(R.drawable.banner));
//        modelsliders.add(new modelbanner(R.drawable.banner2));
//        modelsliders.add(new modelbanner(R.drawable.banner2));
//        modelsliders.add(new modelbanner(R.drawable.banner));
//        modelsliders.add(new modelbanner(R.drawable.banner));
//        modelsliders.add(new modelbanner(R.drawable.banner2));
//        modelsliders.add(new modelbanner(R.drawable.banner));
//        modelsliders.add(new modelbanner(R.drawable.banner2));
//        modelsliders.add(new modelbanner(R.drawable.banner2));
//
//        sliderbanneradapter= new sliderbanneradapter(modelsliders,this);
//
//        sliderView.setSliderAdapter(sliderbanneradapter);
//
//        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);//set indicator animation by using IndicatorAnimationType. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
//        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
//        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
//        sliderView.setIndicatorSelectedColor(Color.WHITE);
//        sliderView.setIndicatorUnselectedColor(Color.GRAY);
//        sliderView.setScrollTimeInSec(4); //set scroll delay in seconds :
//        sliderView.startAutoCycle();
   }
}