package com.utils;

public interface CustomCRUDInterface<T> {

    //CRUD = Create Read Update Delete
    // All basic functionality that we should be able
    // to do when storing data

    // implicitly public and static, no need for access modifiers
    // here we are returning an Integer
    // and expecting a param of type T
    Integer create(T t);

    T read (Integer id);

    T update (T t);

    boolean delete (Integer id);



}
