package timofeeva.learn.time.dao;

import timofeeva.learn.time.entity.Teachers;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by toshiba on 27.03.2017.
 */
public class TeachersDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/app_for_learning";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String NEWTEACHER = "INSERT INTO teachers VALUES(id=null, password=?, name=?, login=?)";
    private static final String ALLTEACHERS = "SELECT * FROM teachers";
    private static final String IDTEACHER = "SELECT * FROM teachers WHERE id = ?";
    private static final String UPDATETEACHERS = "UPDATE teachers SET password=?, name=?, login=? WHERE id=?";
    private static final String DELETETEACHERS = "DELETE FROM teachers WHERE  id=?";

    public List<Teachers> getAllTeachers(){
        List <Teachers> allTeachers = new ArrayList<>();
        try(Connection connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement ps = connect.prepareStatement(ALLTEACHERS);
            ResultSet rs = ps.executeQuery()){

            while (rs.next()){
                int id = rs.getInt("id");
                int password = rs.getInt("password");
                String name = rs.getString("name");
                String login = rs.getString("login");
                allTeachers.add(new Teachers(id, password, name, login));
            }
        } catch (SQLException e) {
            System.out.println("can`t load all teachers");
            e.printStackTrace();
            return  new ArrayList<>();
        }
        return allTeachers;
    }

    public Teachers getTeacherById(int id){
        ResultSet rs = null;
        try(Connection connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement ps = connect.prepareStatement(IDTEACHER)) {
            ps.setInt(1,id);
            rs = ps.executeQuery();
            rs.next();
            return new Teachers(rs.getInt(1),rs.getInt(2), rs.getString(3), rs.getString(4));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void saveNewTeacher(Teachers newTeacher) {
        try (Connection connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pr = connect.prepareStatement(NEWTEACHER)) {
            pr.setString(1, newTeacher.getName());
            pr.setString(2, newTeacher.getLogin());
            pr.setInt(3, newTeacher.getPassword());
            pr.executeUpdate();
        } catch (SQLException e) {
            System.out.println("");
        }

    }

    public void updateAllTeachers(Teachers allTeachers){
        try(Connection connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement ps = connect.prepareStatement(UPDATETEACHERS)){
            ps.setInt(1, allTeachers.getId());
            ps.setInt(2, allTeachers.getPassword());
            ps.setString(3, allTeachers.getName());
            ps.setString(4, allTeachers.getLogin());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteOldTeachers(Teachers oldTeachers ){
        try(Connection connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement ps =connect.prepareStatement(DELETETEACHERS)) {
            ps.setInt(1,oldTeachers.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
