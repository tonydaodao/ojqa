package org.ojqa.domain.pojo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * base RMDB entity which has id property.
 * 
 * @author ybak
 * 
 */
@MappedSuperclass
public class IdEntity {

    private Long id;

    public IdEntity() {
        super();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long pId) {
        this.id = pId;
    }

}
