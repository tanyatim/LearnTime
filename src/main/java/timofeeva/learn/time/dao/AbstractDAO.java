package timofeeva.learn.time.dao;

import timofeeva.learn.time.entity.Students;

import javax.activation.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static timofeeva.learn.time.utils.DatabaseUtils.getConnection;

/**
 * Created by toshiba on 04.04.2017.
 */
public abstract class AbstractDAO <T> {

    public void delete( int id ){
        String DELETE_QUERY = "DELETE FROM " + getTableName() + " WHERE  id=?";
        try(PreparedStatement ps = getConnection().prepareStatement(DELETE_QUERY)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public T getById(int id){
        String query = "SELECT * FROM " + getTableName() + " WHERE id = ?";
        ResultSet rs = null;
        try(PreparedStatement ps = getConnection().prepareStatement(query)) {
            ps.setInt(1,id);
            rs = ps.executeQuery();
            return resultSetToEntity(rs);
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try{
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    public List<T> getAll(){
        List<T> all = null;
        ResultSet rs = null;
        String query = "SELECT * FROM " + getTableName();
        try(PreparedStatement ps = getConnection().prepareStatement(query)){
            rs = ps.executeQuery();
            all = resultSetToEntities(rs);
            /*while(rs.next()){
                all.add((T) resultSetToEntities(rs));
            }*/
        } catch (SQLException e) {
            System.out.println("can`t load all" + getTableName());
            e.printStackTrace();
        }finally{
            try{
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return all;
    }

    public void update(T o){
        String query = getUpdateQuery();
        try(PreparedStatement ps = getConnection().prepareStatement(query)){
            updateInsertQuery(ps, o);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void save(T o) {
        String query = getSaveQuery();
        try (PreparedStatement pr = getConnection().prepareStatement(query)) {
            saveInsertQuery(pr, o);
            pr.executeUpdate();
        } catch (SQLException e) {
            System.out.println("");
        }
    }

    protected  abstract T resultSetToEntity(ResultSet rs) throws SQLException;
    protected abstract String getTableName();
    protected abstract String getUpdateQuery();
    protected  abstract List<T> resultSetToEntities(ResultSet rs) throws SQLException;
    protected  abstract void updateInsertQuery(PreparedStatement ps, T o) throws SQLException;
    protected  abstract String getSaveQuery();
    protected  abstract  void saveInsertQuery(PreparedStatement ps, T o) throws SQLException;


}
