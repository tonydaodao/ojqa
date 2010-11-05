package org.ojqa.domain.repository.jpa;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.ojqa.domain.repository.Repository;
import org.ojqa.domain.util.PagedQueryResult;
import org.ojqa.domain.util.Util;
import org.springframework.orm.jpa.JpaCallback;
import org.springframework.orm.jpa.JpaTemplate;
import org.springframework.transaction.annotation.Transactional;

/**
 * This class provides default implementations for the <tt>Repository</tt> interface. Has the CRUD operations on entity
 * functions.
 * 
 * @author ybak
 * 
 * @param <T>
 *            the Entity type
 */
@Transactional
public class JPARepositoryImpl<T> implements Repository<T> {

    private final Class<T> entityClass;

    protected final Log logger = LogFactory.getLog(getClass());

    protected JpaTemplate jpaTemplate;

    @SuppressWarnings("unchecked")
    public JPARepositoryImpl() {
        // this.entityClass = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), Repository.class);
        this.entityClass = (Class<T>) Util.getGenericType(getClass());
    }

    public void save(T entity) {
        try {
            Long id = getIdOfEntity(entity);
            if (id == null) {
                this.jpaTemplate.persist(entity);
            } else {
                this.jpaTemplate.merge(entity);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(T entity) {
        this.jpaTemplate.remove(entity);
        this.jpaTemplate.flush();
    }

    public void delete(long id) {
        T reference = this.jpaTemplate.getReference(this.entityClass, id);
        this.jpaTemplate.remove(reference);
        this.jpaTemplate.flush();
    }

    @Transactional(readOnly = true)
    public T find(long id) {
        return this.jpaTemplate.find(this.entityClass, id);
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public List<T> findAll() {
        List<T> find = this.jpaTemplate.executeFind(new JpaCallback<List<T>>() {
            public List<T> doInJpa(final EntityManager em) {
                final Query query =
                        em.createQuery("select u from " + JPARepositoryImpl.this.entityClass.getSimpleName() + " u");
                query.setHint("org.hibernate.cacheable", true);
                return query.getResultList();
            }
        });

        return find;
    }

    @Transactional(readOnly = true)
    public PagedQueryResult<T> findAndPaging(final int startingIndex, final int pageSize) {
        PagedQueryResult<T> pagedResult = this.jpaTemplate.execute(new JpaCallback<PagedQueryResult<T>>() {
            @SuppressWarnings("unchecked")
            public PagedQueryResult<T> doInJpa(final EntityManager em) {
                final Query query =
                        em.createQuery("select u from " + JPARepositoryImpl.this.entityClass.getSimpleName() + " u");
                query.setFirstResult(startingIndex);
                query.setMaxResults(pageSize + 1);
                final List<T> results = query.getResultList();
                final boolean more = results.size() > pageSize;
                if (more) {
                    results.remove(pageSize);
                }
                return new PagedQueryResult<T>(results, more);
            }
        });
        return pagedResult;
    }

    @Transactional(readOnly = true)
    public PagedQueryResult<T> findAndPaging(final int startingIndex, final int pageSize, final T entity) {
        PagedQueryResult<T> pagedResult = this.jpaTemplate.execute(new JpaCallback<PagedQueryResult<T>>() {
            @SuppressWarnings("unchecked")
            public PagedQueryResult<T> doInJpa(final EntityManager em) {
                Criteria criteria = ((Session) em.getDelegate()).createCriteria(JPARepositoryImpl.this.entityClass);
                Example example = Example.create(entity).ignoreCase();
                List<T> results = criteria.add(example).setFirstResult(startingIndex).setMaxResults(pageSize).list();
                final boolean more = results.size() > pageSize;
                if (more) {
                    results.remove(pageSize);
                }
                return new PagedQueryResult<T>(results, more);
            }
        });
        return pagedResult;
    }

    @Transactional(readOnly = true)
    private Long getIdOfEntity(T entity) throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException {
        Method method = entity.getClass().getMethod("getId");
        Long id = (Long) method.invoke(entity);
        return id;
    }

    public Class<T> getEntityClass() {
        return this.entityClass;
    }

    public JpaTemplate getJpaTemplate() {
        return this.jpaTemplate;
    }

    public void setJpaTemplate(JpaTemplate pJpaTemplate) {
        this.jpaTemplate = pJpaTemplate;
    }

}
