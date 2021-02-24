package com.flight.dao;

import java.util.Collection;

public interface IDAO<T> {
    default int Create(T obj) throws DAOException{
        return 0;
    }
    default T Find(int id) throws DAOException{
        return null;
    }
    default boolean Update(T obj) throws DAOException{
        return false;
    }
    default boolean Remove(int id) throws DAOException{
        return false;
    }
    default Collection<T> findAll() throws DAOException{
        return null;
    }
}