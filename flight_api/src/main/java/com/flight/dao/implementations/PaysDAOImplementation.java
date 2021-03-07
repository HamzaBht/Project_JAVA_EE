package com.flight.dao.implementations;


import com.flight.dao.DAOException;
import com.flight.dao.IDAO;
import com.flight.api.beans.Pays;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public class PaysDAOImplementation implements IDAO<Pays> {
    private final DAOFactory instance = DAOFactory.getInstance();
    private void SetStringPrep(Pays pays, PreparedStatement prep) throws DAOException{
        try {
            prep.setString(1,pays.getName());
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
    @Override
    public int Create(Pays pays) throws DAOException {
        Connection connection = null;
        try{
            String sql="insert into pays (nom) values(?) ";
            connection = instance.getConnection();
            PreparedStatement prep= connection.prepareStatement(sql);
            SetStringPrep(pays,prep);
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
    public Pays Find(int id) throws DAOException {
        Connection connection = null;
        try{
            String sql="select * from pays where idpays=?  limit 1";
            connection = instance.getConnection();
            PreparedStatement prep=connection.prepareStatement(sql);
            prep.setString(1,String.valueOf(id));
            ResultSet res=prep.executeQuery();
            Pays pays=null;
            if(res.next()){
                pays = map(res);
            }
            connection.close();
            return pays;
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

    private Pays map(ResultSet res) throws SQLException {
        Pays pays = new Pays();
        pays.setID(res.getInt(2));
        pays.setName(res.getString(1));
        return pays;
    }

    @Override
    public boolean Update(Pays pays) throws DAOException {
        Connection connection = null;
        try{
            String sql="update pays set nom=? where idpays=?";
            connection = instance.getConnection();
            PreparedStatement prep=connection.prepareStatement(sql);
            SetStringPrep(pays,prep);
            prep.setString(2,String.valueOf(pays.getID()));
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
            PreparedStatement prep=connection.prepareStatement("delete from pays where idpays=?");
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
    public Collection<Pays> findAll() throws DAOException {
        return null;
    }
}
