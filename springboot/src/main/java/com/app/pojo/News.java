package com.app.pojo;

import com.app.pojo.*;
import java.math.BigDecimal;
import java.util.*;

public class News {
    private int id;
    private String title;
    private String ruby;
    private BigDecimal time;
    private String imageurl;
    private String fromurl;
    private String newimage;
    private List<Content> contents;

    public List<Content> getContents() {
        return this.contents;
    }

    public void setContents(List<Content> contents) {
        this.contents = contents;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRuby() {
        return this.ruby;
    }

    public void setRuby(String ruby) {
        this.ruby = ruby;
    }

    public BigDecimal getTime() {
        return this.time;
    }

    public void setTime(BigDecimal time) {
        this.time = time;
    }

    public String getImageurl() {
        return this.imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getFromurl() {
        return this.fromurl;
    }

    public void setFromurl(String fromurl) {
        this.fromurl = fromurl;
    }

    public String getNewimage() {
        return this.newimage;
    }

    public void setNewimage(String newimage) {
        this.newimage = newimage;
    }
}