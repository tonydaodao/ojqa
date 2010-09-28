package org.ojqa.service;

import java.util.List;

/**
 * @author ybak
 * 
 * @param <T>
 */
public interface BaseService<T> {

    List<T> getAll();

    void save(T transientEntity);

    T get(Long id);

    void delete(T entity);

    void delete(Long id);

}
