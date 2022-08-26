package com.api.distributed.system.apisystem.utilities;


import java.util.concurrent.TimeUnit;

public class Utils {

    public static String replaceSecondsToMinutes(String time){
        String[] divideTime = time.split("\\.");
        int minutes = Integer.parseInt(divideTime[0]) / 60;
        int seconds = Integer.parseInt(divideTime[0]) % 60;
        int miliseconds = 0;
        if(divideTime[1].length()<=2){
            miliseconds = Integer.parseInt(divideTime[1].substring(0,2));
        } else {
            miliseconds = Integer.parseInt(divideTime[1].substring(0,3));
        }


        if(seconds < 10){
            return minutes + ":0" +seconds + ":" + miliseconds;
        } else{
            return minutes + ":" +seconds + ":" + miliseconds;
        }

    }

    public static String changeMilisecondsToMinutes(float milliseconds){
        long minutes = TimeUnit.MILLISECONDS.toMinutes((long) milliseconds);
        long seconds = (TimeUnit.MILLISECONDS.toSeconds((long) milliseconds) % 60);
        long miliseconds = (TimeUnit.MILLISECONDS.toMillis((long) milliseconds) % 1000);
        if(seconds < 10){
            return minutes + ":0" +seconds + ":" + miliseconds;
        } else {
            return minutes + ":" + seconds + ":" + miliseconds;
        }
    }

    public static String changeMilisecondsToSeconds(int milliseconds){
        long seconds = (TimeUnit.MILLISECONDS.toSeconds(milliseconds) % 60);
        long miliseconds = (TimeUnit.MILLISECONDS.toMillis(milliseconds) % 1000);
        if(seconds < 10){
            return "0" +seconds + ":" + miliseconds;
        } else {
            return seconds + ":" + miliseconds;
        }
    }
}
