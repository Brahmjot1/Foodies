package com.brahm.retrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface
{
    @GET("api/json/v1/1/list.php?i=list")
    Call<ResponseBody>getDishes();
}
