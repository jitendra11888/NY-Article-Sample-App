package com.example.nydemo.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.nydemo.model.NyBaseResponseModel;
import com.example.nydemo.network.ApiInterface;
import com.example.nydemo.network.RestApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NyArticleViewModel extends ViewModel {
    private MutableLiveData<NyBaseResponseModel> articleLiveData=new MutableLiveData<>();

    /* get articles*/
    public void getMostPopularArticles() {
        ApiInterface service = RestApi.createService(ApiInterface.class);
        Call<NyBaseResponseModel> call = service.getMostPopularArticles(7,"TEAN738LDFi2brkPdSf6CQWFKweNzokb");
        call.enqueue(new Callback<NyBaseResponseModel>() {
            @Override
            public void onResponse(Call<NyBaseResponseModel> call, Response<NyBaseResponseModel> response) {
                NyBaseResponseModel articleData = response.body();
                articleLiveData.setValue(articleData);
            }

            @Override
            public void onFailure(Call<NyBaseResponseModel> call, Throwable t) {
                Log.e("error", "error");

            }
        });
    }

    public MutableLiveData<NyBaseResponseModel> getArticleLiveData() {
        return articleLiveData;
    }

    public void setArticleLiveData(MutableLiveData<NyBaseResponseModel> articleLiveData) {
        this.articleLiveData = articleLiveData;
    }
}
