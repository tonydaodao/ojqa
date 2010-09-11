package org.ojqa.domain.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * Entity present user comment.
 * 
 * @author ybak
 * 
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Comment extends IdEntity {
    private String content;
    private Date createDate;
    private Date lastModified;

    /**
     * getter
     * 
     * @return create date
     */
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(final Date pCreateDate) {
        this.createDate = pCreateDate;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(final Date pLastModified) {
        this.lastModified = pLastModified;
    }

    @Column(nullable = false)
    public String getContent() {
        return content;
    }

    public void setContent(final String pContent) {
        this.content = pContent;
    }
}
