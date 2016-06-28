package com.hugobrisson.teammate.module.maters.viewController;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.hugobrisson.teammate.R;
import com.hugobrisson.teammate.common.FragmentController;
import com.hugobrisson.teammate.common.custom.TMRecyclerView;
import com.hugobrisson.teammate.common.listener.ItemListener;
import com.hugobrisson.teammate.common.model.TMActionType;

import com.hugobrisson.teammate.common.utils.TMConstantKey;
import com.hugobrisson.teammate.model.User;
import com.hugobrisson.teammate.module.account.ProfileActivity;
import com.hugobrisson.teammate.module.account.viewController.ProfileFragment;
import com.hugobrisson.teammate.module.maters.adapter.MatersAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListMatersFragment extends FragmentController implements ItemListener, SearchView.OnQueryTextListener {

    private SearchView mSearchView;
    private TMRecyclerView mRvGlobal;
    private List<User> mUserList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View tLayout = inflater.inflate(R.layout.fragment_list, container, false);
        mRvGlobal = (TMRecyclerView) tLayout.findViewById(R.id.rv_global);
        return tLayout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        reloadToolbarActivity(getString(R.string.teammaters), true);
        mRvGlobal.setCustomError(R.mipmap.ic_people_24dp,R.string.error_different_password);
        if (getArguments() != null) {
            mUserList = getArguments().getParcelableArrayList(TMConstantKey.EXTRA_MATERS_LIST);
            if (mUserList != null) {
                mRvGlobal.setAdapter(new MatersAdapter(mUserList, this));
                if(mUserList.size()>0){
                    mRvGlobal.onShowed(false);
                }else{
                    mRvGlobal.onShowed(true);
                }
            }else{
                mRvGlobal.onShowed(true);
            }
        }else{
            mRvGlobal.onShowed(true);
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.search_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
        mSearchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        mSearchView.setQueryHint(mContext.getString(R.string.research));
        mSearchView.setOnQueryTextListener(this);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void OnItemClick(View v, int position, TMActionType actionType) {
        User tUser = mUserList.get(position);
        Intent tIntent = new Intent(mContext, ProfileActivity.class).putExtra(TMConstantKey.EXTRA_USER, tUser);
        mActivityListener.onChangeActivity(tIntent);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        List<User> tUserList = new ArrayList<>();
        for (User tUser : mUserList) {
            if (tUser.getName().toLowerCase().contains(newText.toLowerCase())) {
                tUserList.add(tUser);
            }
        }
        mRvGlobal.setAdapter(new MatersAdapter(tUserList, this));
        if(mUserList.size()>0){
            mRvGlobal.onShowed(false);
        }else{
            mRvGlobal.onShowed(true);
        }
        return false;
    }
}
