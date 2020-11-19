package com.example.promoteproject.bean;

import retrofit2.http.Field;

public class LoginReq {

     String identifier ;
     String workNum;
     String password;
     int softWareType;
     int version;

    public LoginReq(String identifier, String workNum, String password, int softWareType, int version) {
        this.identifier = identifier;
        this.workNum = workNum;
        this.password = password;
        this.softWareType = softWareType;
        this.version = version;
    }
}
