package com.hugobrisson.teammate.dao;

import com.hugobrisson.teammate.model.Sport;

import java.util.ArrayList;
import java.util.List;

public class SportDao {

    public static List<Sport> getSports(long millisecond){

        List<Sport> sports = new ArrayList<>();
        if(millisecond == 0){
            Sport sport = new Sport();
            sport.setId("1");
            sport.setName("Football");
            sports.add(sport);

            sport = new Sport();
            sport.setId("2");
            sport.setName("Course");
            sports.add(sport);

            sport = new Sport();
            sport.setId("3");
            sport.setName("Tennis");
            sports.add(sport);
        }
        return  sports;
    }
}
