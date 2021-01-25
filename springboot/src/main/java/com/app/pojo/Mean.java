package com.app.pojo;

import com.app.pojo.Example;
import java.util.*;

public class Mean{
    private Integer id;
    private String title;
    private String level;
    private String mean;
    private String grammar_id;
    private String format;
    private List<Example> examples;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLevel() {
        return this.level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getMean() {
        return this.mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }

    public String getGrammar_id() {
        return this.grammar_id;
    }

    public void setGrammar_id(String grammar_id) {
        this.grammar_id = grammar_id;
    }

    public String getFormat() {
        return this.format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public List<Example> getExamples() {
        return this.examples;
    }

    public void setExamples(List<Example> examples) {
        this.examples = examples;
    }

   
}