package com.app.pojo;


public class Example{
    private Integer id;
    private String ruby;
    private String mean;
    private String text;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRuby() {
        return this.ruby;
    }

    public void setRuby(String ruby) {
        this.ruby = ruby;
    }

    public String getMean() {
        return this.mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", ruby='" + getRuby() + "'" +
            ", mean='" + getMean() + "'" +
            ", text='" + getText() + "'" +
            "}";
    }
}