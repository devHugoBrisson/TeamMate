package com.hugobrisson.teammate.module.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hugobrisson.teammate.R;
import com.hugobrisson.teammate.common.FragmentController;
import com.hugobrisson.teammate.common.custom.TMPagerAdapter;
import com.hugobrisson.teammate.common.utils.TMConstantKey;

import com.hugobrisson.teammate.module.activity.model.ActivityStateType;

import java.util.ArrayList;
import java.util.List;

public class ActivityTabFragment extends FragmentController {

    Toolbar mToolbar;
    TabLayout mTabLayout;
    ViewPager mViewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View tLayout = inflater.inflate(R.layout.fragment_profile, container, false);
        mToolbar = (Toolbar) tLayout.findViewById(R.id.toolbar);
        mTabLayout = (TabLayout) tLayout.findViewById(R.id.tablayout);
        mViewPager = (ViewPager) tLayout.findViewById(R.id.viewpager);
        return tLayout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setToolbar(mToolbar, false, null);
        mViewPager.setAdapter(new TMPagerAdapter(getChildFragmentManager(), getResources().getStringArray(R.array.activityTabTitles), getFragmentList()));
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private List<Fragment> getFragmentList() {
        List<Fragment> tFragmentList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Fragment tFragment = new ActivityListFragment();
            Bundle tBundle = new Bundle();
            tBundle.putSerializable(TMConstantKey.EXTRA_ACTIVITY_TYPE, ActivityStateType.values()[i]);
            tFragment.setArguments(tBundle);
            tFragmentList.add(tFragment);
        }
        return tFragmentList;
    }
}
