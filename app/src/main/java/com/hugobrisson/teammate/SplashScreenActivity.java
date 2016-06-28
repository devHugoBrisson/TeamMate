package com.hugobrisson.teammate;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.view.animation.AnimationUtils;

import com.hugobrisson.teammate.module.enrollment.SignInActivity;
import com.hugobrisson.teammate.module.maters.MatersActivity;

public class SplashScreenActivity extends AppCompatActivity {

    AppCompatTextView mTvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        mTvTitle = (AppCompatTextView) findViewById(R.id.tv_title);
        mTvTitle.startAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
        mTvTitle.setVisibility(View.VISIBLE);
        assert mTvTitle != null;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreenActivity.this, MatersActivity.class));
                finish();
            }
        }, 3000);
    }
}
