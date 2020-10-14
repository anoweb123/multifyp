package com.ali.anoweb.interfacesapi;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface forgetpassapi {
    @FormUrlEncoded
    @PUT("customer/forgetPassword")
    Call<ResponseBody> forgetpassword(@Field("email") String email);

}
