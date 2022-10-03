package edu.step.service.basic;

import java.util.List;

public interface BaseService<T> {

    T findOne(Long id);

    List<T> findAll();

    T save(T entity);

    void remove(Long id);

}
