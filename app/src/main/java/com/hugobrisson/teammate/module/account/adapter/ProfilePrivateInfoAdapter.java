package com.hugobrisson.teammate.module.account.adapter;


import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hugobrisson.teammate.R;
import com.hugobrisson.teammate.common.custom.TMImageView;
import com.hugobrisson.teammate.common.listener.ItemListener;
import com.hugobrisson.teammate.common.model.TMActionType;
import com.hugobrisson.teammate.module.account.model.ProfileTypeInfo;

import java.util.List;

public class ProfilePrivateInfoAdapter extends RecyclerView.Adapter<ProfilePrivateInfoAdapter.PrivateInfoViewHolder> {

    private List<ProfileTypeInfo> mTypeInfoList;
    private List<String> mInfoLIst;
    private ItemListener mItemListener;
    private boolean mIsMyProfile;

    public ProfilePrivateInfoAdapter(List<ProfileTypeInfo> sTypeInfoList, List<String> sInfoList, ItemListener sItemListener, boolean sIsMyProfile) {
        mTypeInfoList = sTypeInfoList;
        mInfoLIst = sInfoList;
        mItemListener = sItemListener;
        mIsMyProfile = sIsMyProfile;
    }


    @Override
    public PrivateInfoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View tInflatedView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_profile_info, parent, false);
        return new PrivateInfoViewHolder(tInflatedView);
    }

    @Override
    public void onBindViewHolder(PrivateInfoViewHolder holder, final int position) {
        ProfileTypeInfo profileTypeInfo = mTypeInfoList.get(position);
        String info = mInfoLIst.get(position);

        holder.tvTitle.setText(profileTypeInfo.getTitle());
        holder.tvDesc.setText(info);

        if (!mIsMyProfile) {
            holder.ivEdit.setVisibility(View.INVISIBLE);
        } else {
            if (!profileTypeInfo.getFieldObligatory()) {
                holder.ivDelete.setVisibility(View.VISIBLE);
            }
        }

        holder.ivEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mItemListener.OnItemClick(v, position, TMActionType.EDIT);
            }
        });

        holder.ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mItemListener.OnItemClick(v, position, TMActionType.DELETE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mTypeInfoList.size();
    }

    public static class PrivateInfoViewHolder extends RecyclerView.ViewHolder {

        public AppCompatTextView tvTitle, tvDesc;
        public TMImageView ivEdit, ivDelete;

        public PrivateInfoViewHolder(View itemView) {
            super(itemView);
            tvTitle = (AppCompatTextView) itemView.findViewById(R.id.tv_title);
            tvDesc = (AppCompatTextView) itemView.findViewById(R.id.tv_desc);
            ivDelete = (TMImageView) itemView.findViewById(R.id.iv_delete);
            ivEdit = (TMImageView) itemView.findViewById(R.id.iv_edit);
        }
    }
}
