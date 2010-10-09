package org.ojqa.domain.pojo;

/**
 * @author Isaac.yu
 * 
 */
public class Hit {
    private String keyword;
    private float probability;
    private String location;
    private String text;
    private String linenumber;

    public Hit() {
    }

    public Hit(String keyword, float probability, String location, String text, String linenumber) {
        super();
        this.keyword = keyword;
        this.probability = probability;
        this.location = location;
        this.text = text;
        this.linenumber = linenumber;
    }

    public String getKeyword() {
        return this.keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public float getProbability() {
        return this.probability;
    }

    public void setProbability(float probability) {
        this.probability = probability;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLinenumber() {
        return this.linenumber;
    }

    public void setLinenumber(String linenumber) {
        this.linenumber = linenumber;
    }
}
