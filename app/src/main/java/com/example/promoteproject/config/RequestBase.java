package com.example.promoteproject.config;

public class RequestBase {

    /**
     * app_id : 93f83219ff
     * sid : 4c6073bc7508fa7fef07e1ebee964f27
     * method : tet.pos.login
     * timestamp : 2020-07-22 17:51:48
     * sign : ZjJlNDQ2MmQzMzYxNzljZGY0ZDYxNzg3ZjU1YzcwM2Q=
     * data : dTw4TucpEv9P8KBGw2y3bvbVho3/DPvsdBX4QFUZolqu0AihJVrkfI5K/n7QpLZBfHSTn6VophhiW9J50nQsL1FcWJCw9suO2up1EhMGv63MSCbyLb2z0ogQm6NBGJcVPYhzSUpF3uU=
     */

    public String app_id;
    public String sid;
    public String method;
    public String timestamp;
    public String sign;
    public String data;


    public RequestBase(String app_id, String sid, String method, String timestamp, String sign, String data) {
        this.app_id = app_id;
        this.sid = sid;
        this.method = method;
        this.timestamp = timestamp;
        this.sign = sign;
        this.data = data;
    }
}
