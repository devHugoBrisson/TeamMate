package com.hugobrisson.teammate.module.maters.adapter;


import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hugobrisson.teammate.R;
import com.hugobrisson.teammate.common.listener.ItemListener;
import com.hugobrisson.teammate.common.model.TMActionType;
import com.hugobrisson.teammate.model.User;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.List;

public class MatersAdapter extends RecyclerView.Adapter<MatersAdapter.PrivateInfoViewHolder> {

    private List<User> mUserList;
    private ItemListener mItemListener;

    public MatersAdapter(List<User> sTypeInfoList, ItemListener sItemListener) {
        mUserList = sTypeInfoList;
        mItemListener = sItemListener;
    }


    @Override
    public PrivateInfoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View tInflatedView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_maters, parent, false);
        return new PrivateInfoViewHolder(tInflatedView);
    }

    @Override
    public void onBindViewHolder(PrivateInfoViewHolder holder, final int position) {
        User tUser = mUserList.get(position);

        holder.tvName.setText(tUser.getName());
        holder.civPhoto.setImageResource(R.mipmap.test_img);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mItemListener.OnItemClick(v, position, TMActionType.CLICK);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }

    public static class PrivateInfoViewHolder extends RecyclerView.ViewHolder {

        public AppCompatTextView tvName;
        public CircularImageView civPhoto;

        public PrivateInfoViewHolder(View itemView) {
            super(itemView);
            tvName = (AppCompatTextView) itemView.findViewById(R.id.tv_name);
            civPhoto = (CircularImageView) itemView.findViewById(R.id.civ_photo);
        }
    }
}
