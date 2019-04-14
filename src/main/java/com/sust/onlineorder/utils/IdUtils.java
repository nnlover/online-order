package com.sust.onlineorder.utils;


public class IdUtils {
    private static IdWorker  idWorker= new IdWorker();

    public static String getNextId(){
        return String.valueOf(idWorker.nextId());
    }

    public static String buildAOrderNo(){ return  String.valueOf(idWorker.nextId());}
}
