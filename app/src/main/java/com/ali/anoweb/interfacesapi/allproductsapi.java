package com.ali.anoweb.interfacesapi;

import com.ali.anoweb.Models.modelproducts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface allproductsapi {
    @GET("products/allproducts")
    Call<List<modelproducts>> listCall();

}
