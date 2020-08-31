package com.ali.anoweb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class shopdetails extends AppCompatActivity{

    holderclassproducts adapterproduct;
    List<modelproducts> modelpro;

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopdetails);

        recyclerView=findViewById(R.id.recshop);

        modelpro = new ArrayList<>();
        modelpro.add(new modelproducts("Brochurenickienickienickie","Rs 1999",R.drawable.shirt));
        modelpro.add(new modelproducts("loren ipsum","Rs 2000",R.drawable.jacket));
        modelpro.add(new modelproducts("loren ipsum","Rs 500",R.drawable.shirt));
        modelpro.add(new modelproducts("loren ipsum","Rs 700",R.drawable.jacket));
        modelpro.add(new modelproducts("loren ipsum","Rs 1000",R.drawable.shirt));
        modelpro.add(new modelproducts("loren ipsum","Rs 3000",R.drawable.jacket));
        modelpro.add(new modelproducts("loren ipsum","Rs 200",R.drawable.shirt));
        modelpro.add(new modelproducts("loren ipsum","Rs 200",R.drawable.jacket));

        adapterproduct = new holderclassproducts(modelpro, this);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(adapterproduct);
        adapterproduct.notifyDataSetChanged();
    }

}