package com.ali.anoweb.interfacesapi;

import com.ali.anoweb.Models.modelslider;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface categoryapi {
    @GET("categories/")
    Call<List<modelslider>> list();


}
