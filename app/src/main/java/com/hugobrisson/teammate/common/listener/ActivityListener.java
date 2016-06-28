package com.hugobrisson.teammate.common.listener;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.hugobrisson.teammate.common.model.TMFragmentType;

public interface ActivityListener {

    void onChangeActivity(Intent intent);

    void onChangeFragment(FragmentManager fragmentManager, Fragment fragment, TMFragmentType fragmentType);
}
