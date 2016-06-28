package com.hugobrisson.teammate.module.account.model;

import com.hugobrisson.teammate.R;

public enum ProfileTypeInfo {

    DESCRIPTION(R.string.desc,false), BIRTHDATE(R.string.birth_date,true), ADDRESS(R.string.address,false);

    private Integer title;
    private boolean isFieldObligatory;

    ProfileTypeInfo(Integer sTitle,boolean sIsFieldObligatory) {
        title = sTitle;
        isFieldObligatory = sIsFieldObligatory;
    }

    public Integer getTitle() {
        return title;
    }

    public void setTitle(Integer sTitle) {
        this.title = sTitle;
    }

    public boolean getFieldObligatory(){
        return isFieldObligatory;
    }

    public void setFieldObligatory(boolean sFieldObligatory){
        isFieldObligatory = sFieldObligatory;
    }

}
