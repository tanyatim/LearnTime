package timofeeva.learn.time.dao;

import timofeeva.learn.time.entity.Students;
import timofeeva.learn.time.entity.Teachers;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static timofeeva.learn.time.utils.DatabaseUtils.getConnection;

/**
 * Created by toshiba on 27.03.2017.
 */
public class TeachersDAO extends AbstractDAO <Teachers>{

    @Override
    protected Teachers resultSetToEntity(ResultSet rs) throws SQLException {
        Teachers teacher = null;
        while(rs.next()){
            teacher = new Teachers();
            teacher.setId(rs.getInt(1));
            teacher.setName(rs.getString(2));
            teacher.setLogin(rs.getString(3));
            teacher.setPassword(rs.getString(4));

            /*teacher = new Teachers(rs.getInt(1), rs.getString(2),
                    rs.getString(3), rs.getString(4));*/
        }
        return teacher;
    }

    @Override
    protected String getTableName() {
        return "teachers";
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE teachers SET password=?, name=?, login=? WHERE id=?";
    }

    @Override
    public List<Teachers> resultSetToEntities(ResultSet rs) throws SQLException {
        List <Teachers> teachers = new ArrayList<>();
        while (rs.next()){
            Teachers teacher = new Teachers(rs.getInt(1), rs.getString(2),
                    rs.getString(3), rs.getString(4));

            teachers.add(teacher);
        }
        return teachers;
    }

    @Override
    protected void updateInsertQuery(PreparedStatement ps, Teachers teachers) throws SQLException {
        ps.setInt(1, teachers.getId());
        ps.setString(2, teachers.getPassword());
        ps.setString(3, teachers.getName());
        ps.setString(4, teachers.getLogin());
    }

    @Override
    protected String getSaveQuery() {
        return  "INSERT INTO teachers VALUES(null, ?, ?, ?)";
    }

    @Override
    protected void saveInsertQuery(PreparedStatement ps, Teachers teachers) throws SQLException {
        ps.setString(1,teachers.getName());
        ps.setString(2, teachers.getLogin());
        ps.setString(3, teachers.getPassword());
    }
    public Teachers getByLogin(String login){
        String query = "SELECT * FROM " + getTableName() + " WHERE login = ?";
        ResultSet rs = null;
        try(PreparedStatement ps = getConnection().prepareStatement(query)){
            ps.setString(1, login);
            rs = ps.executeQuery();
            return resultSetToEntity(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try{
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
