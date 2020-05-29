package com.company.lesson2205;

public abstract class Controller<T> {
    DAO<T> dao;

    public Controller(DAO<T> dao) {
        this.dao = dao;
    }

    abstract boolean validate(T entity);

}
