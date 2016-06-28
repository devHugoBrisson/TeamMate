package com.hugobrisson.teammate.common;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.hugobrisson.teammate.R;
import com.hugobrisson.teammate.common.listener.ActivityListener;
import com.hugobrisson.teammate.common.manager.CFDFragmentManager;
import com.hugobrisson.teammate.common.model.TMFragmentType;

public abstract class ActivityController extends AppCompatActivity {

    private final static String TAG = ActivityController.class.getSimpleName();
    private boolean isAnimationFinished = false;
    protected AppBarLayout mAppBar;
    protected Toolbar mToolbar;

    protected abstract void onAnimationStarted();

    /**
     * @param sTitle
     * @param isHomeEnabled
     */
    public void showToolbarActivity(String sTitle, boolean isHomeEnabled) {
        mAppBar.setVisibility(View.VISIBLE);
        mToolbar.setVisibility(View.VISIBLE);
        setSupportActionBar(mToolbar);
        ActionBar tActionBar = getSupportActionBar();
        if (tActionBar != null) {
            tActionBar.setDisplayHomeAsUpEnabled(isHomeEnabled);
            if (sTitle != null) {
                tActionBar.setDisplayShowTitleEnabled(true);
                tActionBar.setTitle(sTitle);
            }
        }
    }

    public void hideToolbarActivity() {
        mAppBar.setVisibility(View.GONE);
        mToolbar.setVisibility(View.GONE);
    }

}
