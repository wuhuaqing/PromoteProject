package com.example.promoteproject.bean;

public class Follower {


    /**
     * login : hakimrie
     * id : 182110
     * node_id : MDQ6VXNlcjE4MjExMA==
     * avatar_url : https://avatars1.githubusercontent.com/u/182110?v=4
     * gravatar_id : 
     * url : https://api.github.com/users/hakimrie
     * html_url : https://github.com/hakimrie
     * followers_url : https://api.github.com/users/hakimrie/followers
     * following_url : https://api.github.com/users/hakimrie/following{/other_user}
     * gists_url : https://api.github.com/users/hakimrie/gists{/gist_id}
     * starred_url : https://api.github.com/users/hakimrie/starred{/owner}{/repo}
     * subscriptions_url : https://api.github.com/users/hakimrie/subscriptions
     * organizations_url : https://api.github.com/users/hakimrie/orgs
     * repos_url : https://api.github.com/users/hakimrie/repos
     * events_url : https://api.github.com/users/hakimrie/events{/privacy}
     * received_events_url : https://api.github.com/users/hakimrie/received_events
     * type : User
     * site_admin : false
     */

    public String login;
    public int id;
    public String node_id;
    public String avatar_url;
    public String gravatar_id;
    public String url;
    public String html_url;
    public String followers_url;
    public String following_url;
    public String gists_url;
    public String starred_url;
    public String subscriptions_url;
    public String organizations_url;
    public String repos_url;
    public String events_url;
    public String received_events_url;
    public String type;
    public boolean site_admin;

    @Override
    public String toString() {
        return "Follower{" +
                "login='" + login + '\'' +
                ", id=" + id +
                ", avatar_url='" + avatar_url + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
