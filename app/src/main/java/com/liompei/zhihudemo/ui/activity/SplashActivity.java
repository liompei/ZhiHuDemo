package com.liompei.zhihudemo.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.liompei.zhihudemo.MainActivity;

/**
 * Created by Liompei
 * on 2016/10/9.
 */

public class SplashActivity extends AppCompatActivity{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}