package com.yingu.project.big.data.util;

import java.util.UUID;

/**
*@Author 曾亿
*@Date 2018/1/30 9:47
*@dec
*/
public class SubStringUUID {
    public static String subUUID(){
        UUID uuid = UUID.randomUUID();
        String strID = uuid.toString().replaceAll("-", "");
        return strID;
    }
}
