package com.broada.cm.exception.entity;

public class ErrorInfo<T> {

    public static  final Integer OK =0;
    public static  final Integer ERROR =100;

    private String code;
    private String message;
    private String url;
}
