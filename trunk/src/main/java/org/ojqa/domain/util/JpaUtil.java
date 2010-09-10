package org.ojqa.domain.util;

import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.hibernate.stat.Statistics;
import org.springframework.orm.jpa.JpaTemplate;
import org.springframework.test.util.ReflectionTestUtils;

/**
 * Util which can get JPA data.
 * 
 * @author ybak
 * 
 */
public class JpaUtil {

    private JpaTemplate jpaTemplate;

    public Statistics getJpaStatistics() {
        EntityManagerFactory emf = jpaTemplate.getEntityManagerFactory();
        SessionFactory sf = (SessionFactory) ReflectionTestUtils.invokeGetterMethod(emf, "getSessionFactory");
        return sf.getStatistics();
    }

    public JpaTemplate getJpaTemplate() {
        return jpaTemplate;
    }

    public void setJpaTemplate(JpaTemplate pJpaTemplate) {
        this.jpaTemplate = pJpaTemplate;
    }

}
