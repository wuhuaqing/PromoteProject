package com.example.promoteproject.net;

import com.example.promoteproject.bean.Contributor;
import com.example.promoteproject.bean.Follower;
import com.example.promoteproject.bean.Repository;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubService {


      @GET("/repos/{owner}/{repo}/contributors")
      Observable<List<Contributor>> contributors(
              @Path("owner") String owner,
              @Path("repo") String repo

      );

      @GET("users/{username}/followers")//https://api.github.com/users/JakeWharton/followers
      Call<List<Follower>> getFollowers(
              @Path("username") String username
      );


      @GET("/repos/{owner}/{repo}")
      Observable<Repository> repo(
              @Path("owner") String owner,
              @Path("repo") String repo);


}
