package com.hugobrisson.teammate.module.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.hugobrisson.teammate.R;
import com.hugobrisson.teammate.common.FragmentController;
import com.hugobrisson.teammate.common.listener.ItemListener;
import com.hugobrisson.teammate.common.model.TMActionType;
import com.hugobrisson.teammate.common.utils.TMConstantKey;
import com.hugobrisson.teammate.dao.ActivityDao;
import com.hugobrisson.teammate.model.Activity;
import com.hugobrisson.teammate.model.User;
import com.hugobrisson.teammate.module.activity.adapter.ActivityListAdapter;
import com.hugobrisson.teammate.module.activity.model.ActivityStateType;

import java.util.List;

public class ActivityListFragment extends FragmentController implements ItemListener {

    ProgressBar mLoader;
    RecyclerView mRv;
    List<Activity> mActivities;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View tLayout = inflater.inflate(R.layout.fragment_profile, container, false);
        mLoader = (ProgressBar) tLayout.findViewById(R.id.pb_loader);
        mRv = (RecyclerView) tLayout.findViewById(R.id.rv_global);
        return tLayout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getArguments() != null) {
            mLoader.setVisibility(View.VISIBLE);
            ActivityStateType tActivityState = (ActivityStateType) getArguments().getSerializable(TMConstantKey.EXTRA_ACTIVITY_TYPE);
            mActivities = ActivityDao.getActivitiesWithState(tActivityState);
            mRv.setLayoutManager(new LinearLayoutManager(mContext));
            mRv.setAdapter(new ActivityListAdapter(mActivities, this));
            mLoader.setVisibility(View.GONE);
        }
    }

    @Override
    public void OnItemClick(View v, int position, TMActionType actionType) {

    }
}
