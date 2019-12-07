package com.example.nydemo.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.nydemo.R;
import com.example.nydemo.model.Media;
import com.example.nydemo.model.MediaMetaData;
import com.example.nydemo.model.Result;

public class ArticleDetailActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView ivBack, ivArticle;
    private TextView toolbarTitle, tvTitle, tvSubTitle, tvDescription;
    private Result result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_detail);
        Intent intent = getIntent();
        if(intent != null)
            result = intent.getParcelableExtra("result");
        ivBack = findViewById(R.id.toolbar_back);
        tvTitle = findViewById(R.id.tv_title);
        tvSubTitle = findViewById(R.id.tv_sub_title);
        toolbarTitle = findViewById(R.id.toolbar_title);
        ivArticle = findViewById(R.id.iv_article);
        tvDescription = findViewById(R.id.tv_description);
        ivBack.setBackgroundResource(0);
        ivBack.setBackgroundResource(R.drawable.ic_navigate_before_black_24dp);
        ivBack.setOnClickListener(this);
        toolbarTitle.setText(getString(R.string.article_detail));
        setDetail();
    }

    private void setDetail() {
        if(result != null) {
            tvTitle.setText(result.getTitle());
            tvSubTitle.setText(result.getAbstracts());
            tvDescription.setText(result.getAdxKeywords());
            if(result.getMedia() != null && result.getMedia().size() > 0
                    && result.getMedia().get(0).getMediaMetadata() != null && result.getMedia().get(0).getMediaMetadata().size() > 0) {
                MediaMetaData mediaMetaData = null;
                if(result.getMedia().get(0).getMediaMetadata().size() > 2)
                    mediaMetaData = result.getMedia().get(0).getMediaMetadata().get(2);
                else if(result.getMedia().get(0).getMediaMetadata().size() > 1)
                    mediaMetaData = result.getMedia().get(0).getMediaMetadata().get(1);
                else
                    mediaMetaData = result.getMedia().get(0).getMediaMetadata().get(0);
                if (mediaMetaData != null) {
                    Glide.with(this)
                            .load(mediaMetaData.getUrl())
                            .apply(new RequestOptions().override(mediaMetaData.getWidth(), mediaMetaData.getHeight()))
                            .into(ivArticle);
                }
            }

        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.toolbar_back:
                finish();
                break;
        }
    }
}
