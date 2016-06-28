package com.hugobrisson.teammate.module.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.hugobrisson.teammate.R;
import com.hugobrisson.teammate.common.ActivityController;
import com.hugobrisson.teammate.common.manager.CFDFragmentManager;
import com.hugobrisson.teammate.common.model.TMFragmentType;
import com.hugobrisson.teammate.module.account.viewController.ProfileFragment;
import com.hugobrisson.teammate.module.activity.ActivityTabFragment;
import com.hugobrisson.teammate.module.home.model.MenuType;

import java.util.ArrayList;


public class HomeActivity extends ActivityController {

    private ArrayList<AHBottomNavigationItem> mNavigationItems = new ArrayList<>();
    private AHBottomNavigation mNavigation;
    private MenuType mMenuType;
    private MenuType mCurrentMenuType = MenuType.PROFILE;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mAppBar = (AppBarLayout) findViewById(R.id.app_bar);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        CFDFragmentManager.initFragment(getSupportFragmentManager(), new ProfileFragment());
        initUI();
    }

    /**
     * Init UI
     */
    private void initUI() {

        mNavigation = (AHBottomNavigation) findViewById(R.id.nav_menu);

        AHBottomNavigationItem item1 = new AHBottomNavigationItem(getString(R.string.menu_around_me), R.mipmap.ic_room_black_24dp);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem(getString(R.string.menu_activity), R.mipmap.ic_local_activity_black_24dp);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem(getString(R.string.profile), R.mipmap.ic_account_circle_white_24dp);
        AHBottomNavigationItem item4 = new AHBottomNavigationItem(getString(R.string.menu_messages), R.mipmap.ic_chat_black_24dp);
        AHBottomNavigationItem item5 = new AHBottomNavigationItem(getString(R.string.menu_settings), R.mipmap.ic_settings_black_24dp);

        mNavigationItems.add(item1);
        mNavigationItems.add(item2);
        mNavigationItems.add(item3);
        mNavigationItems.add(item4);
        mNavigationItems.add(item5);

        mNavigation.addItems(mNavigationItems);
        mNavigation.setAccentColor(ContextCompat.getColor(this, R.color.colorAccent));
        mNavigation.setInactiveColor(ContextCompat.getColor(this, R.color.colorInactive));
        mNavigation.setNotificationBackgroundColor(ContextCompat.getColor(this, R.color.colorNotificationMenu));
        mNavigation.setCurrentItem(2);

        mNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position, boolean wasSelected) {
                Fragment tFragment = null;
                switch (position) {
                    case 0:
                        mMenuType = MenuType.LOCATION;
                        break;
                    case 1:
                        mMenuType = MenuType.ACTIVITIES;
                        tFragment = new ActivityTabFragment();
                        break;
                    case 2:
                        mMenuType = MenuType.PROFILE;
                        tFragment = new ProfileFragment();
                        break;
                    case 3:
                        mMenuType = MenuType.NOTIFICATION;
                        break;
                    case 4:
                        mMenuType = MenuType.SETTINGS;
                        break;
                }

                if (tFragment != null && mCurrentMenuType != mMenuType) {
                    mCurrentMenuType = mMenuType;
                    CFDFragmentManager.initFragment(getSupportFragmentManager(), tFragment);
                }
            }
        });
    }

    @Override
    protected void onAnimationStarted() {

    }
}
