package com.sust.onlineorder.utils;

/**
 * 2018/4/25
 */
public class IdUtils {
    private static IdWorker  idWorker= new IdWorker();

    public static String getNextId(){
        return String.valueOf(idWorker.nextId());
    }
}
