package com.flight.api.DAOImplementations;

import com.flight.api.DAO.DAOException;
import com.flight.api.DAO.IDAO;
import com.flight.api.flight_api.Pays;

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
        try{
            String sql="insert into pays (nom) values(?) ";
            PreparedStatement prep= instance.getConnection().prepareStatement(sql);
            SetStringPrep(pays,prep);
            return prep.executeUpdate();
        }
        catch (SQLException e){
            throw new DAOException(e);
        }
    }

    @Override
    public Pays Find(int id) throws DAOException {
        try{
            String sql="select * from pays where idpays=?  limit 1";
            PreparedStatement prep=instance.getConnection().prepareStatement(sql);
            prep.setString(1,String.valueOf(id));
            ResultSet res=prep.executeQuery();
            Pays pays=null;
            if(res.next()){
                pays = map(res);
            }
            return pays;
        }
        catch (SQLException e){
            throw new DAOException(e);
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
        try{
            String sql="update pays set nom=? where idpays=?";
            PreparedStatement prep=instance.getConnection().prepareStatement(sql);
            SetStringPrep(pays,prep);
            prep.setString(2,String.valueOf(pays.getID()));
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
            PreparedStatement prep=instance.getConnection().prepareStatement("delete from pays where idpays=?");
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
    public Collection<Pays> findAll() throws DAOException {
        return null;
    }
}
