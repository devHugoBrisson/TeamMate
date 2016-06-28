package com.hugobrisson.teammate.module.account.viewController;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.hugobrisson.teammate.R;
import com.hugobrisson.teammate.common.FragmentController;
import com.hugobrisson.teammate.common.utils.TMBase64Utils;
import com.hugobrisson.teammate.common.utils.TMConstantKey;
import com.hugobrisson.teammate.dao.UserDao;
import com.hugobrisson.teammate.model.User;
import com.hugobrisson.teammate.common.custom.TMPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ProfileFragment extends FragmentController {

    CollapsingToolbarLayout mToolbarLayout;
    Toolbar mToolbar;
    TabLayout mTabLayout;
    ViewPager mViewPager;
    User mUser;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View tLayout = inflater.inflate(R.layout.fragment_profile, container, false);
        mToolbarLayout = (CollapsingToolbarLayout) tLayout.findViewById(R.id.toolbar_layout);
        mToolbar = (Toolbar) tLayout.findViewById(R.id.toolbar);
        mTabLayout = (TabLayout) tLayout.findViewById(R.id.tablayout);
        mViewPager = (ViewPager) tLayout.findViewById(R.id.viewpager);
        return tLayout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (getArguments() == null) {
            mUser = UserDao.getCurrentUser(getContext());
           setToolbar(mToolbar, false, null);
        } else {
            mUser = getArguments().getParcelable(TMConstantKey.EXTRA_USER);
            if (mUser == null) {
                mUser = UserDao.getCurrentUser(mContext);
                setToolbar(mToolbar, true, null);
            } else {
                if (mUser.getId().equals(UserDao.getCurrentUser(mContext).getId())) {
                    setToolbar(mToolbar, true, null);
                    // TODO MY profile
                } else {
                    setToolbar(mToolbar, true, null);
                    // TODO Other PROFILE
                }
            }
        }

        mToolbarLayout.setTitle(mUser.getName());
        mToolbarLayout.setBackground(TMBase64Utils.decode(getResources(), mUser.getProfilePhoto()));
        mViewPager.setAdapter(new TMPagerAdapter(getChildFragmentManager(), getResources().getStringArray(R.array.accountTabTitles), getFragmentList()));
        mTabLayout.setupWithViewPager(mViewPager);

    }

    private List<Fragment> getFragmentList() {
        List<Fragment> tFragmentList = new ArrayList<>();
        tFragmentList.add(new ProfileGlobalFragment());
        tFragmentList.add(new ProfilePrivateInfoFragment());

        for (Fragment fragment : tFragmentList) {
            if (getArguments() == null || getArguments().getParcelable(TMConstantKey.EXTRA_USER) == null) {
                Bundle tBundle = new Bundle();
                tBundle.putParcelable(TMConstantKey.EXTRA_USER, mUser);
                fragment.setArguments(tBundle);
            } else {
                fragment.setArguments(getArguments());
            }
        }
        return tFragmentList;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
