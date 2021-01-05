package pojo;

public class Mean{
    private Integer id;
    private String title;
    private String level;
    private String mean;
    private String grammar_id;

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
        this.title = title == null ? "" : title.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel (String level) {
        this.level = level == null ? "" : level.trim();
    }


    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean == null ? "" : mean.trim();
    }


    public String getGrammar_id() {
        return grammar_id;
    }

    public void setGrammar_id(String grammar_id) {
        this.grammar_id = grammar_id == null ? "" : grammar_id.trim();
    }
}