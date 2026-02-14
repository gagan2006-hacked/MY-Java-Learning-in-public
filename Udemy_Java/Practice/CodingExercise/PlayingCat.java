package com.Udemy_Java.Practice.CodingExercise;

public class PlayingCat {
    // write code here
    public static boolean isCatPlaying(boolean summer ,int temperature ){
        if (summer){
            return (temperature>=25&&temperature<=45);
        }
        return temperature>=25&&temperature<=35;
    }
}