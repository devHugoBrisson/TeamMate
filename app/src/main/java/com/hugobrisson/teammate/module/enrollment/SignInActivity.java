package com.hugobrisson.teammate.module.enrollment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.hugobrisson.teammate.R;
import com.hugobrisson.teammate.common.ActivityController;
import com.hugobrisson.teammate.common.manager.CFDFragmentManager;
import com.hugobrisson.teammate.common.model.TMFragmentType;
import com.hugobrisson.teammate.module.enrollment.controller.LogInFragment;


public class SignInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enrollment);
        CFDFragmentManager.initFragment(getSupportFragmentManager(), new LogInFragment());
    }
}
