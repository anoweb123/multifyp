package com.ali.anoweb.interfacesapi;

import com.ali.anoweb.Models.modelproductbyshop;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface productsbyshop {
    @GET(".")
    Call<List<modelproductbyshop>> list();

}