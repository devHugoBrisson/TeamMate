package com.hugobrisson.teammate.dao;

import com.hugobrisson.teammate.model.Activity;
import com.hugobrisson.teammate.module.activity.model.ActivityStateType;

import java.util.ArrayList;
import java.util.List;

public class ActivityDao {

    /**
     * @param sActivityState
     * @return
     */
    public static List<Activity> getActivitiesWithState(ActivityStateType sActivityState) {
        List<Activity> tActivities = new ArrayList<>();
        // TODO CALL BD WITH request
        switch (sActivityState) {
            case MINE:
                //tActivities.add(new Activity("Mine"));
                break;
            case PARTICIPATE:
               // tActivities.add(new Activity("Participate"));
                break;
            case WAITING:
               // tActivities.add(new Activity("Waiting"));
                break;
        }
        return tActivities;
    }
}
