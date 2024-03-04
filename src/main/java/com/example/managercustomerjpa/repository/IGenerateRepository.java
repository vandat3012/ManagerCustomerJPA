package com.example.managercustomerjpa.repository;

import java.util.List;

public interface IGenerateRepository<T>{
    List<T> findAll();
    void save (T t);
    T findById(Long id);
    void remove(Long id);

}
