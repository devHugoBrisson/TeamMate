package com.hugobrisson.teammate.common.custom;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.hugobrisson.teammate.R;


public class TMRecyclerView extends RelativeLayout {

    private RecyclerView mRecyclerView;
    private LinearLayout mLlError;
    private AppCompatTextView mTvError;
    private TMImageView mIvError;
    private ProgressBar mPbLoader;
    private Context mContext;

    public TMRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    private void init() {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.custom_recyclerview, this, true);
        mLlError = (LinearLayout) getRootView().findViewById(R.id.ll_error);
        mTvError = (AppCompatTextView) getRootView().findViewById(R.id.tv_error);
        mIvError = (TMImageView) getRootView().findViewById(R.id.iv_error);
        mPbLoader = (ProgressBar) getRootView().findViewById(R.id.pb_loader);
        mRecyclerView = (RecyclerView) getRootView().findViewById(R.id.rv_custom);
    }

    public void setAdapter(RecyclerView.Adapter adapter){
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setAdapter(adapter);
    }

    public void setCustomError(int icon,int message) {
        mIvError.setImageDrawable(ContextCompat.getDrawable(mContext,icon));
        mTvError.setText(message);
    }

    public void onLoaded() {
        mLlError.setVisibility(GONE);
        mRecyclerView.setVisibility(GONE);
        mPbLoader.setVisibility(VISIBLE);
    }

    public void onShowed(boolean hasError) {
        mPbLoader.setVisibility(GONE);
        if (hasError) {
            mLlError.setVisibility(VISIBLE);
        } else {
            mRecyclerView.setVisibility(VISIBLE);
        }
    }

}
