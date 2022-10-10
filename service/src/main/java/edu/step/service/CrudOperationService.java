package edu.step.service;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;

import java.util.List;

public interface CrudOperationService<T> {

    T findById(Long id);

    List<T> findAll();

    void remove(Long id);

}
