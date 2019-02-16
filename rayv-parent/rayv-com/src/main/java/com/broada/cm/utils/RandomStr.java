package com.broada.cm.utils;

import java.util.Comparator;
import java.util.Random;

public class RandomStr {
    //@SuppressWarnings("unused")
    public static String generateUpperString(int length){
        String numberChar = "0123456789";
        String str = "abc";
        String allChar = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i =0; i <length;i++){
            sb.append(allChar.charAt(random.nextInt(allChar.length())));
        }
        return sb.toString().toUpperCase();
    }

    public static void main(String[] args) {
        String str = generateUpperString(5);
        System.out.println(str);
    }
}
