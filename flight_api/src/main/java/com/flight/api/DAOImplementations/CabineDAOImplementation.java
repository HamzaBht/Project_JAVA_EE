package com.flight.api.DAOImplementations;

import com.flight.api.DAO.DAOException;
import com.flight.api.DAO.IDAO;
import com.flight.api.flight_api.Airport;
import com.flight.api.flight_api.Cabine;
import com.flight.api.flight_api.CabineClasses;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public class CabineDAOImplementation implements IDAO<Cabine> {
    private final DAOFactory instance = DAOFactory.getInstance();

    private void SetStringPrep(Cabine cabine, PreparedStatement prep) throws DAOException{
        try {
            prep.setString(1,cabine.getType().name());
            prep.setString(2,String.valueOf(cabine.getCapacity()));
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
    @Override
    public int Create(Cabine cabine) throws DAOException {
        try {
            String sql = "insert into cabine (typecabine,capacite) values(?,?)";
            PreparedStatement prep = instance.getConnection().prepareStatement(sql);
            SetStringPrep(cabine, prep);
            return prep.executeUpdate();
        }
        catch (SQLException e){
            throw new DAOException(e);
        }
    }

    @Override
    public Cabine Find(int id) throws DAOException {
        try{
            String sql="select * from cabine where idcabine=?  limit 1";
            PreparedStatement prep=instance.getConnection().prepareStatement(sql);
            prep.setString(1,String.valueOf(id));
            ResultSet res=prep.executeQuery();
            Cabine cabine=null;
            if(res.next()){
                cabine= map(res);
            }
            return cabine;
        }
        catch (SQLException e){
            throw new DAOException(e);
        }
    }

    private Cabine map(ResultSet res) throws SQLException {
        Cabine cabine;
        CabineClasses type = CabineClasses.valueOf(res.getString(1));
        int capacity = res.getInt(2);
        int id = res.getInt(3);
        cabine = new Cabine(type,capacity,0);
        cabine.setID(id);
        return cabine;
    }

    @Override
    public boolean Update(Cabine cabine) throws DAOException {
        try{
            String sql="update cabine set typecabine=? and capacite=? where idcabine=?";
            PreparedStatement prep=instance.getConnection().prepareStatement(sql);
            SetStringPrep(cabine,prep);
            prep.setString(3,String.valueOf(cabine.getID()));
            try {
                prep.executeUpdate();
            }catch (Exception e){
                return false;
            }
            return true;
        }
        catch (SQLException e){
            throw new DAOException(e);
        }
    }

    @Override
    public boolean Remove(int id) throws DAOException {
        try{
            PreparedStatement prep=instance.getConnection().prepareStatement("delete from cabine where idcabine=?");
            prep.setString(1, String.valueOf(id));
            try{
                prep.executeUpdate();
            }catch (Exception e){
                return  false;
            }
            return true;
        }
        catch (SQLException e){
            throw new DAOException(e);
        }

    }

    @Override
    public Collection<Cabine> findAll() throws DAOException {
        return null;
    }
}
