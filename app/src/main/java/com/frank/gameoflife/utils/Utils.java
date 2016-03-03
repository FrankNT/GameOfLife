package com.frank.gameoflife.utils;

/**
 * Created by TrongPhuc on 2/27/16.
 */
public class Utils {
    public static void sleep() {
        try {
            Thread.sleep(GameConfig.SLEEP_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
