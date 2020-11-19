package com.example.promoteproject.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 登录信息
 */
public class LoginResp implements Serializable {

    private static final long serialVersionUID = -5818119265594002640L;
    public String sid;//sid
    public String name;//收费员名称
    public String workNum;//工号
    public String collectorId;//收费员id
    public List<Park> parks;
    public int  hasUpdate	;//	int	是否有更新 1(有更新)0(没有更新)
    public String lang;//		不可空	语言
    public String tenantId	 ;//	不可空	租户ID

    public static  final  int updata_no = 0;
    public static  final  int updata_yes = 1;
}
