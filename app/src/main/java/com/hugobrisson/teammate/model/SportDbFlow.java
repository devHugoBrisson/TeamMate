package com.hugobrisson.teammate.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.hugobrisson.teammate.BuildConfig;
import com.hugobrisson.teammate.common.utils.TMConstantKey;
/*
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;


/*
@Table(databaseName = BuildConfig.database_name,
        tableName = TMConstantKey.DB_SPORT)*/
public class SportDbFlow {
/*
    public static final String COLUMN_ID="id";
    public static final String COLUMN_NAME="name";
    public static final String COLUMN_ICON="icon";

    @PrimaryKey
    @Column(name = COLUMN_ID)
    public String id;

    @Column(name = COLUMN_NAME)
    private String name;

    @Column(name = COLUMN_ICON)
    private String icon;

    public SportDbFlow(){}

    protected SportDbFlow(Parcel in) {
        id = in.readString();
        name = in.readString();
    }

    public static final Creator<SportDbFlow> CREATOR = new Creator<SportDbFlow>() {
        @Override
        public SportDbFlow createFromParcel(Parcel in) {
            return new SportDbFlow(in);
        }

        @Override
        public SportDbFlow[] newArray(int size) {
            return new SportDbFlow[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }*/
}
