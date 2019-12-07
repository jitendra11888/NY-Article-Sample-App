package com.example.nydemo.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nydemo.R;
import com.example.nydemo.adapter.ArticleAdapter;
import com.example.nydemo.model.NyBaseResponseModel;
import com.example.nydemo.model.Result;
import com.example.nydemo.viewmodel.NyArticleViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ArticleAdapter.OnItemClickListener {
    private NyArticleViewModel articleViewModel;
    private RecyclerView recyclerView;
    private TextView toolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbarTitle = findViewById(R.id.toolbar_title);
        findViewById(R.id.toolbar_back).setBackgroundResource(R.drawable.ic_dehaze_black_24dp);
        toolbarTitle.setText(getString(R.string.most_popular));
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        articleViewModel = ViewModelProviders.of(this).get(NyArticleViewModel.class);
        articleViewModel.getArticleLiveData().observe(this, new Observer<NyBaseResponseModel>() {
            @Override
            public void onChanged(NyBaseResponseModel nyBaseResponseModel) {
                if(nyBaseResponseModel != null) {
                    ArrayList<Result> results = nyBaseResponseModel.getResults();
                    recyclerView.setAdapter(new ArticleAdapter(results, R.layout.article_item, MainActivity.this));
                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                }
            }
        });

        articleViewModel.getMostPopularArticles();
    }

    @Override
    public void onItemClick(Result result) {
        Intent intent = new Intent(MainActivity.this, ArticleDetailActivity.class);
        intent.putExtra("result", result);
        startActivity(intent);
    }
}
