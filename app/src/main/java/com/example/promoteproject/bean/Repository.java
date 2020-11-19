package com.example.promoteproject.bean;

public class Repository {
    public final int id;
    public final String name;
    public final String html_url;

    public Repository(int id, String name, String html_url) {
        this.id = id;
        this.name = name;
        this.html_url = html_url;
    }

    @Override
    public String toString() {
        return "Repository{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", html_url='" + html_url + '\'' +
                '}';
    }
}
