package com.example.promoteproject.net;

import android.util.Log;

import com.example.promoteproject.bean.Contributor;
import com.example.promoteproject.bean.Follower;
import com.example.promoteproject.bean.LoginReq;
import com.example.promoteproject.bean.LoginResp;
import com.example.promoteproject.bean.Repository;
import com.example.promoteproject.config.ClientConfig;
import com.example.promoteproject.config.NetConfig;
import com.example.promoteproject.config.RequestBase;
import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RxNetLoginMoudle {

    private LoginService loginService;


    public void buildRetrofit() {
        //添加网络请求拦截器
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(NetConfig.Base_Url)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())//返回解析的转换器
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())//请求的适配  createAsync
                .build();
        loginService = retrofit.create(LoginService.class);
    }


    public Observable<LoginResp>  userLogin(){

        LoginReq loginReq = new LoginReq(ClientConfig.appId, "T10001", "T123456", 21, 4);
        Gson gson = new Gson();
        String loginstr = gson.toJson(loginReq);
        String time = formatDate(new Date(System.currentTimeMillis()), DEF_DATE_FORMATE);
        RequestBase requestBase = new RequestBase(ClientConfig.appId,"4c6073bc7508fa7fef07e1ebee964f27","tet.pos.login",time,"ZjJlNDQ2MmQzMzYxNzljZGY0ZDYxNzg3ZjU1YzcwM2Q=",loginstr);


        //  Observable<LoginResp> loginReposity = loginService.login(ClientConfig.appId, "T10001", "T123456", 21, 4);
        Observable<LoginResp> loginReposity = loginService.login(requestBase);
                return  loginReposity.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }

    public static final String DEF_DATE_FORMATE="yyyy-MM-dd HH:mm:ss";
    public static String formatDate(Date d, String format) {
        if (format == null || format.equals("")) {
            format = DEF_DATE_FORMATE;
        }
        if (d == null) {
            return "";
        } else {
            SimpleDateFormat df = new SimpleDateFormat(format);
            return df.format(d);
        }
    }
}
