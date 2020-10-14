package com.ali.anoweb.interfacesapi;

import com.ali.anoweb.Models.modelcategoryinshop;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface categoryinshopapi {

    @GET(".")
    Call<List<modelcategoryinshop>> list();
}
