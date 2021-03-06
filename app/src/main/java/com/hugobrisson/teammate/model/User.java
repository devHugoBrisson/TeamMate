package com.hugobrisson.teammate.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.hugobrisson.teammate.BuildConfig;
import com.hugobrisson.teammate.common.utils.TMConstantKey;
import com.hugobrisson.teammate.common.utils.TMDateConverterUtils;
/*
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class User implements Parcelable {

    public static final String COLUMN_ID="id";
    public static final String COLUMN_MAIL="mail";
    public static final String COLUMN_PASSWORD="password";
    public static final String COLUMN_NAME="name";
    public static final String COLUMN_GENDER="gender";
    public static final String COLUMN_BIRTHDATE="birthDate";
    public static final String COLUMN_PROFILE_PHOTO="profilePhoto";
    public static final String COLUMN_DESCRIPTION="description";


    public String id;


    private String mail;


    private String password;


    private String name;


    private Gender gender;


    private Date birthDate;


    private String profilePhoto;


    private String description;


    protected User(Parcel in) {
        id = in.readString();
        mail = in.readString();
        password = in.readString();
        name = in.readString();
        gender = (Gender) in.readSerializable();
        birthDate = (Date) in.readSerializable();
        profilePhoto = in.readString();
        description = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public User() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(mail);
        dest.writeString(password);
        dest.writeString(name);
        dest.writeSerializable(gender);
        dest.writeSerializable(birthDate);
        dest.writeString(profilePhoto);
        dest.writeString(description);
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getInfo() {
        return new ArrayList<>(Arrays.asList(getDescription(), TMDateConverterUtils.getDate(getBirthDate().getTime()), ""));
    }
}
