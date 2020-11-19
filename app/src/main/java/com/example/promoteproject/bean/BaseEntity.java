package com.example.promoteproject.bean;

public class BaseEntity<T> {

    T data;

    String errorCode;

    String errorMsg;

    @Override
    public String toString() {
        return "BaseEntity{" +
                "data=" + data +
                ", errorCode='" + errorCode + '\'' +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }
}
