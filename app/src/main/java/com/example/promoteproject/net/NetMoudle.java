package com.example.promoteproject.net;

import android.util.Log;
import android.widget.Toast;

import com.example.promoteproject.PromoteApplication;
import com.example.promoteproject.bean.Contributor;
import com.example.promoteproject.bean.Follower;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetMoudle {

    private AndroidService androidService;


    public void buildRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        androidService = retrofit.create(AndroidService.class);
    }

    public void getArticle() {
        Call<ResponseBody> article = androidService.getArticle();
        article.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.e("retrofit", response.toString());
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("retrofit", t.getMessage().toString());
            }
        });
    }

    public void getContributors() {
        // Create a call instance for looking up Retrofit contributors.
        Call<List<Contributor>> call = androidService.contributors("square", "retrofit");

        // Fetch and print a list of the contributors to the library.
      /*  new Thread(new Runnable() {
            @Override
            public void run() {
                List<Contributor> contributors = null;
                try {
                    contributors = call.execute().body();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                for (Contributor contributor : contributors) {
                   Log.e("retrofit",contributor.login + " (" + contributor.contributions + ")");
                }
            }
        }).start();*/


        call.enqueue(new Callback<List<Contributor>>() {
            @Override
            public void onResponse(Call<List<Contributor>> call, Response<List<Contributor>> response) {
                Log.e("retrofit", response.toString());
                Toast.makeText(PromoteApplication.mContext,response.toString(),Toast.LENGTH_LONG).show();
                List<Contributor> contributors = response.body();
                for (Contributor contributor : contributors) {
                    Log.e("retrofit", contributor.toString());
                }

            }

            @Override
            public void onFailure(Call<List<Contributor>> call, Throwable t) {
                Log.e("retrofit", t.getMessage().toString());
            }
        });

    }

    public void getFollowers() {
        // Create a call instance for looking up Retrofit contributors.
        Call<List<Follower>> followerCall = androidService.getFollowers("JakeWharton");

        followerCall.enqueue(new Callback<List<Follower>>() {
            @Override
            public void onResponse(Call<List<Follower>> call, Response<List<Follower>> response) {
                Log.e("retrofit", response.toString());
                List<Follower> followers = response.body();
                if(followers!=null){
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
