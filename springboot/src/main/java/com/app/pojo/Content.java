package com.app.pojo;

public class Content {
    private int id;
    private String ruby;
    private String origin;
    private String type;
    private String newid;
    private int index;

    public String getRuby() {
        return this.ruby;
    }

    public void setRuby(String ruby) {
        this.ruby = ruby;
    }

    public int getIndex() {
        return this.index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrigin() {
        return this.origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNewid() {
        return this.newid;
    }

    public void setNewid(String newid) {
        this.newid = newid;
    }
}