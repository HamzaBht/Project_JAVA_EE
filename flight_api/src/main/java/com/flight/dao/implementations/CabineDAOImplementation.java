package com.flight.dao.implementations;


import com.flight.dao.DAOException;
import com.flight.dao.IDAO;
import com.flight.api.beans.Cabine;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public class CabineDAOImplementation implements IDAO<Cabine> {
    private final DAOFactory instance = DAOFactory.getInstance();

    private void SetStringPrep(Cabine cabine, PreparedStatement prep) throws DAOException{
        try {
            prep.setString(1,cabine.getType());
            prep.setString(2,String.valueOf(cabine.getCapacity()));
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
    @Override
    public int Create(Cabine cabine) throws DAOException {
        Connection connection = null;
        try {
            connection = instance.getConnection();
            String sql = "insert into cabine (typecabine,capacite) values(?,?)";
            PreparedStatement prep = connection.prepareStatement(sql);
            SetStringPrep(cabine, prep);
            int status = prep.executeUpdate();
            connection.close();
            return status;
        }
        catch (SQLException e){
            throw new DAOException(e);
        }
        finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throw new DAOException(throwables);
                }
            }
        }
    }

    @Override
    public Cabine Find(int id) throws DAOException {
        Connection connection = null;
        try{
            String sql="select * from cabine where idcabine=?  limit 1";
            connection = instance.getConnection();
            PreparedStatement prep= connection.prepareStatement(sql);
            prep.setString(1,String.valueOf(id));
            ResultSet res=prep.executeQuery();
            Cabine cabine=null;
            if(res.next()){
                cabine= map(res);
            }
            connection.close();
            return cabine;
        }
        catch (SQLException e){
            throw new DAOException(e);
        }
        finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throw new DAOException(throwables);
                }
            }
        }
    }

    private Cabine map(ResultSet res) throws SQLException {
        Cabine cabine;
        String type = res.getString(1);
        int capacity = res.getInt(2);
        int id = res.getInt(3);
        cabine = new Cabine(type,capacity,0);
        cabine.setID(id);
        return cabine;
    }

    @Override
    public boolean Update(Cabine cabine) throws DAOException {
        Connection connection = null;
        try{
            String sql="update cabine set typecabine=? and capacite=? where idcabine=?";
            connection = instance.getConnection();
            PreparedStatement prep=connection.prepareStatement(sql);
            SetStringPrep(cabine,prep);
            prep.setString(3,String.valueOf(cabine.getID()));
            prep.executeUpdate();
            connection.close();
            return true;
        }
        catch (SQLException e){
            throw new DAOException(e);
        }
        finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throw new DAOException(throwables);
                }
            }
        }
    }

    @Override
    public boolean Remove(int id) throws DAOException {
        Connection connection = null;
        try{
            connection = instance.getConnection();
            PreparedStatement prep=connection.prepareStatement("delete from cabine where idcabine=?");
            prep.setString(1, String.valueOf(id));
            prep.executeUpdate();
            connection.close();
            return true;
        }
        catch (SQLException e){
            throw new DAOException(e);
        }
        finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throw new DAOException(throwables);
                }
            }
        }

    }

    @Override
    public Collection<Cabine> findAll() throws DAOException {
        return null;
    }
}
