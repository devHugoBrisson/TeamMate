package com.hugobrisson.teammate.module.account;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.hugobrisson.teammate.R;
import com.hugobrisson.teammate.common.ActivityController;
import com.hugobrisson.teammate.common.manager.CFDFragmentManager;
import com.hugobrisson.teammate.common.model.TMFragmentType;
import com.hugobrisson.teammate.module.account.viewController.ProfileFragment;

public class ProfileActivity extends ActivityController {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);
        mAppBar = (AppBarLayout) findViewById(R.id.app_bar);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);
        CFDFragmentManager.initFragment(getSupportFragmentManager(), new ProfileFragment());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onAnimationStarted() {

    }
}
