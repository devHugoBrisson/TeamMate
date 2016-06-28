package com.hugobrisson.teammate.model;

import com.hugobrisson.teammate.R;

public enum Gender {
    MAN(R.string.man),WOMAN(R.string.woman);

    private Integer title;

    Gender(Integer sTitle) {
        title = sTitle;
    }

    public Integer getTitle() {
        return title;
    }

    public void setTitle(Integer sTitle) {
        this.title = sTitle;
    }
}
