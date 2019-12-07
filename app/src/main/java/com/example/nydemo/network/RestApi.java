package com.example.nydemo.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class RestApi {

    public static final String API_BASE_URL = "https://api.nytimes.com/svc/mostpopular/v2/";
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder().readTimeout(10000, TimeUnit.MILLISECONDS).connectTimeout(10000,TimeUnit.MILLISECONDS);

    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder().baseUrl(API_BASE_URL).addConverterFactory(GsonConverterFactory.create());

    public static <S> S createService(Class<S> aClass){
        Retrofit retrofit = retrofitBuilder.client(httpClient.build()).build();
        return retrofit.create(aClass);
    }
}
