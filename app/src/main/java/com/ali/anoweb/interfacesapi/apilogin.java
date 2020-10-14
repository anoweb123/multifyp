package com.ali.anoweb.interfacesapi;

import com.ali.anoweb.Models.getdatabyloginmodel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface apilogin {
    @FormUrlEncoded
    @POST("customer/login")
    Call<getdatabyloginmodel> response(
        @Field("email") String email,
        @Field("password") String password
        );
}
