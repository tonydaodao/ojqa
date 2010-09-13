package org.ojqa.domain.pojo;

import java.util.Date;

import javax.persistence.Entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTagNames() {
        return tagNames;
    }

    public void setTagNames(String tagNames) {
        this.tagNames = tagNames;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
