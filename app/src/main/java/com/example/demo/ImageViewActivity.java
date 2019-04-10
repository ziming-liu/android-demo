package com.example.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageViewActivity extends AppCompatActivity {
    private ImageView mIv4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        mIv4 = findViewById(R.id.iv_2);
        Glide.with(this).load("https://www.baidu.com/img/bd_logo1.png?where=super").into(mIv4);
    }
}
