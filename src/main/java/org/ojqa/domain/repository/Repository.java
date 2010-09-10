package org.ojqa.domain.repository;

import java.util.List;

import org.ojqa.domain.util.PagedQueryResult;

/**
 * Interface of Repository.
 * 
 * @author ybak
 * 
 * @param <T>
 */
public interface Repository<T> {

    T find(long id);

    void save(T entity);

    void delete(T entity);

    void delete(long id);

    List<T> findAll();

    PagedQueryResult<T> findAndPaging(int startingIndex, int pageSize);

    PagedQueryResult<T> findAndPaging(int startingIndex, int pageSize, T entity);

}
