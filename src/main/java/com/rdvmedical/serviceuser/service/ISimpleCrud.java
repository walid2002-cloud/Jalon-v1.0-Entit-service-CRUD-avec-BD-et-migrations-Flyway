package com.rdvmedical.serviceuser.service;
import java.util.List;

public interface ISimpleCrud<T> {
    List<T> findAll();
    T findById(Long id);
    T create(T dto);
    T update(Long id, T dto);
    void delete(Long id);
}
