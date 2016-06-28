package com.hugobrisson.teammate.module.account.viewController;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;

import com.hugobrisson.teammate.R;
import com.hugobrisson.teammate.common.FragmentController;
import com.hugobrisson.teammate.common.model.TMFragmentType;
import com.hugobrisson.teammate.common.utils.TMConstantKey;
import com.hugobrisson.teammate.dao.UserDao;
import com.hugobrisson.teammate.model.User;
import com.hugobrisson.teammate.module.maters.MatersActivity;
import com.hugobrisson.teammate.module.maters.viewController.ListMatersFragment;

import java.util.ArrayList;
import java.util.List;

public class ProfileGlobalFragment extends FragmentController implements View.OnClickListener {

    CardView mCvRating, mCvMaters, mCvActivities, mCvNextActivity;
    AppCompatTextView mTvRating, mTvMaters, mTvActivities, mTvNextActivity;
    RatingBar mRatingBar;

    User mUser;
    List<User> mMatersList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View tLayout = inflater.inflate(R.layout.fragment_profile_global, container, false);
        mRatingBar = (AppCompatRatingBar) tLayout.findViewById(R.id.rating_bar);
        mCvRating = (CardView) tLayout.findViewById(R.id.cv_avis);
        mCvMaters = (CardView) tLayout.findViewById(R.id.cv_maters);
        mCvActivities = (CardView) tLayout.findViewById(R.id.cv_activities);
        mCvNextActivity = (CardView) tLayout.findViewById(R.id.cv_next_activity);
        mTvRating = (AppCompatTextView) tLayout.findViewById(R.id.tv_rating);
        mTvMaters = (AppCompatTextView) tLayout.findViewById(R.id.tv_maters);
        mTvActivities = (AppCompatTextView) tLayout.findViewById(R.id.tv_activities);
        mTvNextActivity = (AppCompatTextView) tLayout.findViewById(R.id.tv_next_activity);
        return tLayout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mUser = getArguments().getParcelable(TMConstantKey.EXTRA_USER);
        mMatersList = UserDao.getUserMaters(mContext, mUser);

        LayerDrawable layerDrawable = (LayerDrawable) mRatingBar.getProgressDrawable();
        layerDrawable.getDrawable(1).setColorFilter(ContextCompat.getColor(mContext, R.color.colorRating), PorterDuff.Mode.SRC_ATOP);
        layerDrawable.getDrawable(2).setColorFilter(ContextCompat.getColor(mContext, R.color.colorRating), PorterDuff.Mode.SRC_ATOP);
        mRatingBar.setRating(3.5f);

        mTvMaters.setText(String.valueOf(mMatersList.size()));

        mCvRating.setOnClickListener(this);
        mCvMaters.setOnClickListener(this);
        mCvActivities.setOnClickListener(this);
        mCvNextActivity.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent tIntent = null;
        switch (v.getId()) {
            case R.id.cv_avis:
                break;
            case R.id.cv_maters:
                tIntent = new Intent(mContext, MatersActivity.class)
                        .putParcelableArrayListExtra(TMConstantKey.EXTRA_MATERS_LIST,
                                (ArrayList<? extends Parcelable>) mMatersList);
                break;
            case R.id.cv_activities:
                break;
            case R.id.cv_next_activity:
                break;
        }
        startActivity(tIntent);
    }
}
