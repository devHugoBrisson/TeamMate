package com.hugobrisson.teammate.common.listener;

import android.view.View;

import com.hugobrisson.teammate.common.model.TMActionType;

public interface ItemListener {
    void OnItemClick(View v, int position, TMActionType actionType);
}
