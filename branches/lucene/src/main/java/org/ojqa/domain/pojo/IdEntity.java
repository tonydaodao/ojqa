package org.ojqa.domain.pojo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * base RMDB entity which has id property.
 * 
 * @author ybak
 */
@MappedSuperclass
public class IdEntity {

    /**
     * Entity Id generated by hibernate.
     */
    private Long id;

    /**
     * Constructor.
     */
    public IdEntity() {
        super();
    }

    /**
     * Get the id of Entity.
     * 
     * @return id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return this.id;
    }

    /**
     * set id of Entity.
     * 
     * @param pId
     *            id
     */
    public void setId(final Long pId) {
        this.id = pId;
    }

}
