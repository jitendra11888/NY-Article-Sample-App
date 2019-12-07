package com.example.nydemo.network;

import com.example.nydemo.model.NyBaseResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("viewed/{period}.json")
    Call<NyBaseResponseModel> getMostPopularArticles(@Path("period") int period, @Query("api-key") String apiKey);

}
