package com.hugobrisson.teammate.module.enrollment.controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatRadioButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hugobrisson.teammate.R;
import com.hugobrisson.teammate.common.FragmentController;
import com.hugobrisson.teammate.common.manager.SnackbarManager;

import java.util.Date;

public class SignInFragment extends Fragment implements View.OnClickListener {

    AppCompatButton mBtFacebook, mBtGoogle, mBtSignIn;
    AppCompatEditText mEtName, mEtBirthDate, mEtMail, mEtPassword, mEtConfirmPassword;
    AppCompatRadioButton mRbWoman;

    Date mDate;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View tLayout = inflater.inflate(R.layout.fragment_sign_in, container, false);
        mBtFacebook = (AppCompatButton) tLayout.findViewById(R.id.bt_facebook);
        mBtGoogle = (AppCompatButton) tLayout.findViewById(R.id.bt_google_more);
        mBtSignIn = (AppCompatButton) tLayout.findViewById(R.id.bt_sign_in);
        mEtName = (AppCompatEditText) tLayout.findViewById(R.id.et_name);
        mEtBirthDate = (AppCompatEditText) tLayout.findViewById(R.id.et_birth_date);
        mEtMail = (AppCompatEditText) tLayout.findViewById(R.id.et_mail);
        mEtPassword = (AppCompatEditText) tLayout.findViewById(R.id.et_password);
        mEtConfirmPassword = (AppCompatEditText) tLayout.findViewById(R.id.et_confirm_password);
        mRbWoman = (AppCompatRadioButton) tLayout.findViewById(R.id.rb_woman);
        return tLayout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_facebook:
                facebookSignIn();
                break;
            case R.id.bt_google_more:
                googleSignIn();
                break;
            case R.id.et_birth_date:
                // TODO date picker manager
                break;
            case R.id.bt_sign_in:
                signIn();
                break;
        }
    }

    private void facebookSignIn() {
    }

    private void googleSignIn() {
    }

    private void signIn() {
        String tName = mEtName.getText().toString();
        String tMail = mEtPassword.getText().toString();
        String tPassword = mEtPassword.getText().toString();
        boolean tGender = mRbWoman.isChecked();

        if (tName.equals("") || mDate == null || tMail.equals("") || tPassword.equals("")) {
            SnackbarManager.show(getView(), getString(R.string.error_all_fields));
        }else if(!tPassword.equals(mEtConfirmPassword.getText().toString())){
            SnackbarManager.show(getView(),getString(R.string.error_different_password));
        }
        // TODO else if mail
        // TODO call ws with User and goto next activity
    }
}


