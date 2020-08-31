package com.ali.anoweb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class cart extends AppCompatActivity {

RecyclerView recyclerView;
List<modelcart> models;
holdercart adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        recyclerView=findViewById(R.id.rec);

        models = new ArrayList<>();
        models.add(new modelcart("jacket in blue colorrrr", "Rs 1999",R.drawable.shopp));
        models.add(new modelcart("jacket", "Rs 1999",R.drawable.shopp));
        models.add(new modelcart("jacket", "Rs 1999",R.drawable.shopp));
        models.add(new modelcart("jacket", "Rs 1999",R.drawable.shopp));
        models.add(new modelcart("jacket", "Rs 1999",R.drawable.shopp));

        adapter = new holdercart(models, this);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        //adapter.setonshopclicklistener(this);


    }
}