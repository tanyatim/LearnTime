package timofeeva.learn.time.dao;

import timofeeva.learn.time.entity.Students;

import javax.activation.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static timofeeva.learn.time.utils.DatabaseUtils.getConnection;

/**
 * Created by toshiba on 24.03.2017.
 */

public class StudentsDAO extends AbstractDAO <Students>{

    @Override
    protected String getTableName() {
        return "students";
    }

    @Override
    protected Students resultSetToEntity(ResultSet rs) throws SQLException {
        Students student = null;
            while(rs.next()){
                student = new Students(rs.getInt(1), rs.getString(2),
                    rs.getString(3), rs.getString(4));
            }
        return student;
    }


    @Override
    protected String getUpdateQuery() {
       return  "UPDATE students SET password=?, name=?, login=? WHERE id=?";
    }

    @Override
    protected List<Students> resultSetToEntities(ResultSet rs) throws SQLException {
        List <Students> students = new ArrayList<>();
        while (rs.next()){
            Students student = new Students(rs.getInt(1), rs.getString(2),
                    rs.getString(3), rs.getString(4));

            students.add(student);
        }
        return students;
    }

    @Override
    protected void updateInsertQuery(PreparedStatement ps, Students students) throws SQLException {
        ps.setInt(1,students.getId());
        ps.setString(2,students.getPassword());
        ps.setString(3, students.getName());
        ps.setString(4, students.getLogin());
    }

    @Override
    protected String getSaveQuery() {
        return "INSERT INTO students VALUES(null, ?, ?, ?)";
    }

    @Override
    protected void saveInsertQuery(PreparedStatement ps, Students students ) throws SQLException {
        ps.setString(1,students.getName());
        ps.setString(2, students.getLogin());
        ps.setString(3, students.getPassword());
    }
    public Students getByLogin(String login){
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
