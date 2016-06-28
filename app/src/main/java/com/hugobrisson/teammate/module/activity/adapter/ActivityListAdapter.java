package com.hugobrisson.teammate.module.activity.adapter;


import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hugobrisson.teammate.R;
import com.hugobrisson.teammate.common.custom.TMImageView;
import com.hugobrisson.teammate.common.listener.ItemListener;
import com.hugobrisson.teammate.common.model.TMActionType;
import com.hugobrisson.teammate.model.Activity;
import com.hugobrisson.teammate.module.account.model.ProfileTypeInfo;

import java.util.List;

public class ActivityListAdapter extends RecyclerView.Adapter<ActivityListAdapter.ActivityInfoViewHolder> {

    private List<Activity> mActivities;
    private ItemListener mItemListener;

    public ActivityListAdapter(List<Activity> sActivities, ItemListener sItemListener) {
        mActivities = sActivities;
        mItemListener = sItemListener;
    }


    @Override
    public ActivityInfoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View tInflatedView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_activity, parent, false);
        return new ActivityInfoViewHolder(tInflatedView);
    }

    @Override
    public void onBindViewHolder(ActivityInfoViewHolder holder, final int position) {
        Activity tActivity = mActivities.get(position);

        holder.tvName.setText(tActivity.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mItemListener.OnItemClick(v, position, TMActionType.CLICK);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mActivities.size();
    }

    public static class ActivityInfoViewHolder extends RecyclerView.ViewHolder {

        public AppCompatTextView tvStartDate, tvEndDate, tvName, tvOwner, tvMaters, tvDistance;

        public ActivityInfoViewHolder(View itemView) {
            super(itemView);
            tvStartDate = (AppCompatTextView) itemView.findViewById(R.id.tv_start_time);
            tvEndDate = (AppCompatTextView) itemView.findViewById(R.id.tv_end_time);
            tvName = (AppCompatTextView) itemView.findViewById(R.id.tv_name);
            tvOwner = (AppCompatTextView) itemView.findViewById(R.id.tv_owner);
            tvMaters = (AppCompatTextView) itemView.findViewById(R.id.tv_number_players);
            tvDistance = (AppCompatTextView) itemView.findViewById(R.id.tv_distance);
        }
    }
}
