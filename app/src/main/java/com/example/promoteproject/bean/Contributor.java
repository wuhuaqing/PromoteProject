package com.example.promoteproject.bean;

public class Contributor {

    /**
     * login : JakeWharton
     * id : 66577
     * node_id : MDQ6VXNlcjY2NTc3
     * avatar_url : https://avatars0.githubusercontent.com/u/66577?v=4
     * gravatar_id : 
     * url : https://api.github.com/users/JakeWharton
     * html_url : https://github.com/JakeWharton
     * followers_url : https://api.github.com/users/JakeWharton/followers
     * following_url : https://api.github.com/users/JakeWharton/following{/other_user}
     * gists_url : https://api.github.com/users/JakeWharton/gists{/gist_id}
     * starred_url : https://api.github.com/users/JakeWharton/starred{/owner}{/repo}
     * subscriptions_url : https://api.github.com/users/JakeWharton/subscriptions
     * organizations_url : https://api.github.com/users/JakeWharton/orgs
     * repos_url : https://api.github.com/users/JakeWharton/repos
     * events_url : https://api.github.com/users/JakeWharton/events{/privacy}
     * received_events_url : https://api.github.com/users/JakeWharton/received_events
     * type : User
     * site_admin : false
     * contributions : 1057
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
    public int contributions;

    @Override
    public String toString() {
        return "Contributor{" +
                "login='" + login + '\'' +
                ", id=" + id +
                ", avatar_url='" + avatar_url + '\'' +
                ", url='" + url + '\'' +
                ", contributions=" + contributions +
                '}';
    }
}
