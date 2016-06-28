package com.hugobrisson.teammate.module.enrollment.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hugobrisson.teammate.R;
import com.hugobrisson.teammate.common.FragmentController;
import com.hugobrisson.teammate.common.manager.CFDFragmentManager;
import com.hugobrisson.teammate.common.manager.SnackbarManager;
import com.hugobrisson.teammate.common.model.TMFragmentType;
import com.hugobrisson.teammate.model.User;
import com.hugobrisson.teammate.module.home.HomeActivity;

public class LogInFragment extends Fragment implements View.OnClickListener {

    AppCompatEditText mEtMail, mEtPassword;
    AppCompatButton mBtLogIn;
    AppCompatTextView mTvForgotPassword, mTvSignIn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View tLayout = inflater.inflate(R.layout.fragment_log_in, container, false);
        mEtMail = (AppCompatEditText) tLayout.findViewById(R.id.et_mail);
        mEtPassword = (AppCompatEditText) tLayout.findViewById(R.id.et_password);
        mBtLogIn = (AppCompatButton) tLayout.findViewById(R.id.bt_log_in);
        mTvForgotPassword = (AppCompatTextView) tLayout.findViewById(R.id.tv_forgot_password);
        mTvSignIn = (AppCompatTextView) tLayout.findViewById(R.id.tv_sign_in);
        return tLayout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mBtLogIn.setOnClickListener(this);
        mTvSignIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_log_in:
                // TODO call check user
                startActivity(new Intent(getActivity(), HomeActivity.class));
                getActivity().finish();
                break;
            case R.id.tv_sign_in:
                CFDFragmentManager.changeFragment(getActivity().getSupportFragmentManager(), new SignInFragment());
                break;
        }
    }

    private void checkUser() {
        String tMail = mEtMail.getText().toString();
        String tPassword = mEtPassword.getText().toString();
        if ("".equals(tMail) || "".equals(tPassword)) {
            SnackbarManager.show(getView(),getString(R.string.error_all_fields));
        }
        // TODO if check mail
        // TODO else call webservice and manage result with retrofit
    }
}
