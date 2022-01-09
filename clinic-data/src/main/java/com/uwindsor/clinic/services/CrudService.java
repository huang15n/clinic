package com.uwindsor.clinic.services;

import java.util.Set;


public interface CrudService <T, ID>{

    Set<T> findAll();
    T findById(ID id);

    default T save(T object) {
        return null;
    }

    void delete(T object);
    void deleteById(ID id);
}
