package com.example.promoteproject.bean;

import java.io.Serializable;

/**
 * 路段点
 */
public class Park implements Serializable {

    private static final long serialVersionUID = -6757828071505692948L;


    public String roadSectionId;//停车段ID
    public String name;//停车点名称
    public String tollCollectorName;//	已签到的收费员名字
    public int dutyStatus;//值班状态（1值班中、4空闲）
    public String collectorId;//已签到的收费员ID


    /**
     * 值班状态（1值班中、4空闲）
     */
    public static final  int duty_work = 1;
    public static final  int duty_idle = 4;

    /**
     * 是否本人 (0 不是, 1是)
     */
    public static final  int isSelf_yes = 1;
    public static final  int isSelf_no = 0;



}
