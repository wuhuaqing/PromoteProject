package com.example.promoteproject.net;

import com.example.promoteproject.bean.Contributor;
import com.example.promoteproject.bean.Follower;
import com.example.promoteproject.bean.LoginReq;
import com.example.promoteproject.bean.LoginResp;
import com.example.promoteproject.bean.Repository;
import com.example.promoteproject.config.RequestBase;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface LoginService {

      @FormUrlEncoded
      @POST("tet.pos.login")
      Observable<LoginResp> login(@Field("identifier") String identifier, @Field("workNum")  String workNum, @Field("password") String password, @Field("softWareType")  int softWareType, @Field("version") int version);

      @POST("gateway")
      Observable<LoginResp> login ( @Body RequestBase loginReq);

}
