package com.broada.cm.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class DecodeTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = URLDecoder.decode("中文", "utf-8");
        System.out.println(str);
    }
}
