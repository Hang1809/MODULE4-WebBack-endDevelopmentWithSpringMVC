package com.cg.service;

import java.util.List;

public interface IGeneralService<T>{
    boolean exists(Long id);

    List<T> findAll();
    T findOne(Long id);
    T save(T customer);
    void delete(Long id);
    void delete (T customer);

}