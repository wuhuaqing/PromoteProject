package com.example.promoteproject.net;

import android.util.Log;

import com.example.promoteproject.bean.Contributor;
import com.example.promoteproject.bean.Follower;
import com.example.promoteproject.bean.Repository;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RxNetMoudle {

    private GithubService githubService;


    public void buildRetrofit() {
        //添加网络请求拦截器
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS)).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())//返回解析的转换器
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())//请求的适配  createAsync
                .build();
        githubService = retrofit.create(GithubService.class);
    }

    /**
     * 贡献人
     * @return
     */
    public Observable<List<Contributor>> getContributors() {
        Observable<List<Contributor>> contributorsObserval = githubService.contributors("square", "retrofit");
        return contributorsObserval.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

      //  return contributorsObserval;


    }

    /**
     * 仓库信息
     * @return
     */
    public Observable getRespository() {
        Observable<Repository> repoObservable = githubService.repo("square", "retrofit");
        return repoObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }

    /**
     * 订阅人
     */
    public void getFollowers() {
        // Create a call instance for looking up Retrofit contributors.
        Call<List<Follower>> followerCall = githubService.getFollowers("JakeWharton");

        followerCall.enqueue(new Callback<List<Follower>>() {
            @Override
            public void onResponse(Call<List<Follower>> call, Response<List<Follower>> response) {
                Log.e("retrofit", response.toString());
                List<Follower> followers = response.body();
                if (followers != null) {
                    for (Follower follower : followers) {
                        Log.e("retrofit", follower.toString());
                    }
                }

            }

            @Override
            public void onFailure(Call<List<Follower>> call, Throwable t) {
                Log.e("retrofit", t.getMessage().toString());
            }
        });

    }


}
