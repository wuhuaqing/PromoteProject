package com.example.promoteproject.net;

import com.example.promoteproject.bean.Contributor;
import com.example.promoteproject.bean.Follower;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AndroidService {
      String artticle = "wxarticle/list/405/1/json";


      @GET("users/list?sort=desc")
      Call<ResponseBody>  getArticle();

      @GET("/repos/{owner}/{repo}/contributors")
      Call<List<Contributor>> contributors(
              @Path("owner") String owner,
              @Path("repo") String repo);

      @GET("users/{username}/followers")//https://api.github.com/users/JakeWharton/followers
      Call<List<Follower>> getFollowers(
              @Path("username")String username
      );
}
