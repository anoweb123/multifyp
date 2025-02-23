package com.ali.anoweb.interfacesapi;

import com.ali.anoweb.Models.modelproductbyshop;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface productsbycatinshopapi {
    @FormUrlEncoded
    @POST(".")
    Call<List<modelproductbyshop>> response(
            @Field("id") String id,
            @Field("category") String category
    );
}
