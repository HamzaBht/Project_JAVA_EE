package com.flight.dao.implementations;


import com.flight.dao.DAOException;
import com.flight.dao.IDAO;
import com.flight.api.beans.Reservation;

import java.util.Collection;

public class ReservationDAOImplementation implements IDAO<Reservation> {
    private final DAOFactory instance = DAOFactory.getInstance();
    @Override
    public int Create(Reservation obj) throws DAOException {
        return 0;
    }

    @Override
    public Reservation Find(int id) throws DAOException {
        return null;
    }

    @Override
    public boolean Update(Reservation obj) throws DAOException {
        return false;
    }

    @Override
    public boolean Remove(int id) throws DAOException {
        return false;
    }

    @Override
    public Collection<Reservation> findAll() throws DAOException {
        return null;
    }
}
