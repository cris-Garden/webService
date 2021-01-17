package com.app.pojo;

import com.app.pojo.Mean;
import java.util.*;

public class Grammar{
    private Integer id;
    private String title;
    private String level;
    // private String about;
    // private String likes;
    private List<Mean> means;

    public List<Mean> getMeans() {
        return this.means;
    }

    public void setMeans(List<Mean> means) {
        this.means = means;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel (String level) {
        this.level = level == null ? null : level.trim();
    }


    // public String getAbout() {
    //     return about;
    // }

    // public void setAbout(String about) {
    //     this.about = about == null ? null : about.trim();
    // }


    // public String getLikes() {
    //     return likes;
    // }

    // public void setLikes(String likes) {
    //     this.likes = likes == null ? null : likes.trim();
    // }
}