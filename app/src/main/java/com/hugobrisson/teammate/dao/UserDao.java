package com.hugobrisson.teammate.dao;

import android.content.Context;
import android.support.v4.content.ContextCompat;

import com.hugobrisson.teammate.R;
import com.hugobrisson.teammate.common.utils.TMBase64Utils;
import com.hugobrisson.teammate.model.Gender;
import com.hugobrisson.teammate.model.User;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class UserDao {

    /**
     * get current user.
     *
     * @param sContext current context
     * @return user
     */
    public static User getCurrentUser(Context sContext) {
        // TODO share Prefs gson
        User tUser = new User();
        tUser.setId("1");
        tUser.setName("Hugo Brisson");
        tUser.setMail("hugo.brisson@viacesi.fr");
        tUser.setGender(Gender.MAN);
        Calendar tCalendar = Calendar.getInstance();
        tCalendar.set(1990, 6, 20);
        tUser.setBirthDate(tCalendar.getTime());
        tUser.setDescription("");
        tUser.setProfilePhoto(TMBase64Utils.encode(sContext.getResources(), R.mipmap.test_img));
        return tUser;
    }

    /**
     * get all maters from user
     *
     * @param sContext current context
     * @param sUser    user
     * @return maters list
     */
    public static List<User> getUserMaters(Context sContext, User sUser) {

        List<User> matersList = new ArrayList<>();
        User tUser = new User();
        tUser.setId("2");
        tUser.setName("Emmanuel Evereaer");
        tUser.setMail("e.everaere@viacesi.fr");
        tUser.setGender(Gender.MAN);
        Calendar tCalendar = Calendar.getInstance();
        tCalendar.set(1990, 10, 15);
        tUser.setBirthDate(tCalendar.getTime());
        tUser.setDescription("Je suis un geek et je le resterais rien de ne m'empecheras de up");
        tUser.setProfilePhoto(TMBase64Utils.encode(sContext.getResources(), R.mipmap.bg_sign_in_9));

        matersList.add(tUser);

        tUser = new User();
        tUser.setId("3");
        tUser.setName("Laureen Kziezniak");
        tUser.setMail("e.everaere@viacesi.fr");
        tUser.setGender(Gender.WOMAN);
        tCalendar = Calendar.getInstance();
        tCalendar.set(1994, 11, 1);
        tUser.setBirthDate(tCalendar.getTime());
        tUser.setDescription("Je suis sexy lady et j'aimerais faire un peu du sport");
        tUser.setProfilePhoto(TMBase64Utils.encode(sContext.getResources(), R.mipmap.bg_sign_in_9));

        matersList.add(tUser);

        return matersList;
    }
}
