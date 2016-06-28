package com.hugobrisson.teammate.module.account.viewController;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.LinearLayout;

import com.hugobrisson.teammate.R;
import com.hugobrisson.teammate.common.FragmentController;
import com.hugobrisson.teammate.common.custom.TMDialog;
import com.hugobrisson.teammate.common.custom.TMImageView;
import com.hugobrisson.teammate.common.listener.ItemListener;
import com.hugobrisson.teammate.common.model.TMActionType;
import com.hugobrisson.teammate.common.utils.TMConstantKey;
import com.hugobrisson.teammate.common.utils.TMDateConverterUtils;
import com.hugobrisson.teammate.dao.UserDao;
import com.hugobrisson.teammate.model.Gender;
import com.hugobrisson.teammate.model.User;
import com.hugobrisson.teammate.module.account.adapter.ProfilePrivateInfoAdapter;
import com.hugobrisson.teammate.module.account.model.ProfileTypeInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class ProfilePrivateInfoFragment extends FragmentController implements View.OnClickListener, ItemListener {

    private AppCompatTextView mTvAge, mTvGender;
    private TMImageView mIvGender;
    private LinearLayout mLLAddInfo;


    private boolean isMyProfile = true;
    private boolean isUpdatedProfile = false;
    private User mUser;
    private List<ProfileTypeInfo> mNoTypeInfoList = new ArrayList<>();
    private List<ProfileTypeInfo> mTypeInfoList = new ArrayList<>(Arrays.asList(ProfileTypeInfo.values()));
    private List<String> mInfoLIst = new ArrayList<>();

    private RecyclerView mRv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View tLayout = inflater.inflate(R.layout.fragment_profile_private_information, container, false);
        mTvAge = (AppCompatTextView) tLayout.findViewById(R.id.tv_age);
        mTvGender = (AppCompatTextView) tLayout.findViewById(R.id.tv_gender);
        mIvGender = (TMImageView) tLayout.findViewById(R.id.iv_gender);
        mRv = (RecyclerView) tLayout.findViewById(R.id.rv_global);
        mLLAddInfo = (LinearLayout) tLayout.findViewById(R.id.ll_add_info);
        return tLayout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        manageUserProfile();
        manageUserInfo();

        mTvAge.setText(String.valueOf(TMDateConverterUtils.getAge(mUser.getBirthDate())));
        mTvGender.setText(mUser.getGender().getTitle());
        if (mUser.getGender() == Gender.WOMAN) {
            mIvGender.setBackgroundColor(ContextCompat.getColor(mContext, R.color.colorWoman));
            mIvGender.setImageResource(R.mipmap.ic_sign_woman_48dp);
            mIvGender.setIconColor(Color.WHITE);
        }
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        if (isUpdatedProfile) {
            inflater.inflate(R.menu.valid_info_menu, menu);
        }
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_save:
                //TODO call webservice to save user and response toast
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Compare user with my profile.
     */
    private void manageUserProfile() {
        if (getArguments() == null) {
            mUser = UserDao.getCurrentUser(mContext);
        } else {
            mUser = getArguments().getParcelable(TMConstantKey.EXTRA_USER);
            if (mUser == null) {
                mUser = UserDao.getCurrentUser(mContext);
            } else {
                if (mUser.getId().equals(UserDao.getCurrentUser(mContext).getId())) {
                    // TODO MY PROFILE
                } else {
                    // TODO Other PROFILE
                    isMyProfile = false;
                }
            }
        }
    }

    /**
     * allows to get Information already filled.
     */
    private void manageUserInfo() {
        mNoTypeInfoList = new ArrayList<>();
        mTypeInfoList = new ArrayList<>();
        mInfoLIst = new ArrayList<>();
        int position = 0;
        for (String tInfo : mUser.getInfo()) {
            if (tInfo == null || "".equals(tInfo)) {
                mNoTypeInfoList.add(ProfileTypeInfo.values()[position]);
            } else {
                mTypeInfoList.add(ProfileTypeInfo.values()[position]);
                mInfoLIst.add(tInfo);
            }
            position++;
        }
        mRv.setLayoutManager(new LinearLayoutManager(mContext));
        mRv.setAdapter(new ProfilePrivateInfoAdapter(mTypeInfoList, mInfoLIst, this, isMyProfile));

        if (!isMyProfile || mNoTypeInfoList.size() == 0) {
            mLLAddInfo.setVisibility(View.GONE);
        }

        mLLAddInfo.setOnClickListener(this);
    }

    /**
     * manage type info for specific handling
     *
     * @param sTypeInfoList profile type info list
     * @param sPosition     current position
     */
    private void mangeItemInfo(List<ProfileTypeInfo> sTypeInfoList, final int sPosition, final boolean hasAlreadyInfo, final boolean isRemoved) {
        final ProfileTypeInfo tProfileTypeInfo = sTypeInfoList.get(sPosition);
        switch (tProfileTypeInfo) {
            case DESCRIPTION:
                if (isRemoved) {
                    mUser.setDescription(null);
                    mInfoLIst.remove(sPosition);
                    mNoTypeInfoList.add(mTypeInfoList.get(sPosition));
                    mTypeInfoList.remove(sPosition);
                    manageUserInfo();
                } else {
                    new TMDialog(mContext, getString(tProfileTypeInfo.getTitle()), new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            isUpdatedProfile = true;
                            getActivity().invalidateOptionsMenu();
                            String desc = ((AppCompatEditText) v).getText().toString();
                            mUser.setDescription(desc);
                            if (!hasAlreadyInfo) {
                                manageUserInfo();
                            } else {
                                mInfoLIst.set(sPosition, desc);
                                mRv.getAdapter().notifyItemChanged(sPosition);
                            }
                        }
                    });
                }
                break;
            case BIRTHDATE:
                Calendar tCalendar = Calendar.getInstance();
                tCalendar.setTime(mUser.getBirthDate());
                DatePickerDialog tDatePickerDialog =
                        new DatePickerDialog(mContext, new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                Calendar tCalendar = Calendar.getInstance();
                                tCalendar.set(year, monthOfYear, dayOfMonth);
                                mUser.setBirthDate(TMDateConverterUtils.getDateAndTime(tCalendar.getTimeInMillis()));
                                mTvAge.setText(String.valueOf(TMDateConverterUtils.getAge(mUser.getBirthDate())));
                                if (!hasAlreadyInfo) {
                                    manageUserInfo();
                                } else {
                                    mInfoLIst.set(sPosition, TMDateConverterUtils.getDate(mUser.getBirthDate().getTime()));
                                    mRv.getAdapter().notifyItemChanged(sPosition);
                                }
                            }
                        }, tCalendar.get(Calendar.YEAR), tCalendar.get(Calendar.MONTH), tCalendar.get(Calendar.DAY_OF_MONTH));
                tDatePickerDialog.show();
                break;
            case ADDRESS:
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_add_info:
                List<String> tInfoList = new ArrayList<>();
                for (ProfileTypeInfo tProfileTypeInfo : mNoTypeInfoList) {
                    tInfoList.add(getString(tProfileTypeInfo.getTitle()));
                }
                new TMDialog(mContext, tInfoList, new ItemListener() {
                    @Override
                    public void OnItemClick(View v, int position, TMActionType actionType) {
                        mangeItemInfo(mNoTypeInfoList, position, false, false);
                    }
                });
                break;
        }
    }

    @Override
    public void OnItemClick(View v, final int position, TMActionType actionType) {
        switch (actionType) {
            case EDIT:
                mangeItemInfo(mTypeInfoList, position, true, false);
                break;
            case DELETE:
                new TMDialog(mContext, getString(R.string.dialog_title_delete_info), getString(R.string.dialog_desc_delete_info, getString(mTypeInfoList.get(position).getTitle()).toUpperCase()), new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mangeItemInfo(mTypeInfoList, position, true, true);
                    }
                });
                break;
        }

    }
}
