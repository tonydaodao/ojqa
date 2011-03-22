package org.ojqa.domain.pojo;

import java.util.Date;

import javax.persistence.Entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Type;

/**
 * Question entity class.
 * 
 * @author Isaac.Yu
 * 
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Question extends IdEntity {

    private String title;
    private String tagNames;
    private String body;
    private Date createTime;

    public Question() {
        super();
    }

    public Question(String title, String tagNames, String body, Date createTime) {
        super();
        this.title = title;
        this.tagNames = tagNames;
        this.body = body;
        this.createTime = createTime;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTagNames() {
        return this.tagNames;
    }

    public void setTagNames(String tagNames) {
        this.tagNames = tagNames;
    }

    @Type(type = "text")
    public String getBody() {
        return this.body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
