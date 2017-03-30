package timofeeva.learn.time.dao;

import timofeeva.learn.time.entity.Students;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by toshiba on 24.03.2017.
 */

public class StudentsDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/app_for_learning";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String NEWSTUDENT = "INSERT INTO students VALUES(id=null, password=?, name=?, login=?)";
    private static final String ALLSTUDENTS = "SELECT * FROM students";
    private static final String IDSTUDENT = "SELECT * FROM students WHERE id = ?";
    private static final String UPDATESTUDENTS = "UPDATE students SET password=?, name=?, login=? WHERE id=?";
    private static final String DELETESTUDENT = "DELETE FROM students WHERE  id=?";

    public List<Students> getAllStudents(){
        List <Students> allStudents = new ArrayList<>();
        try(Connection connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement ps = connect.prepareStatement(ALLSTUDENTS);
            ResultSet rs = ps.executeQuery()){

            while (rs.next()){
            int id = rs.getInt("id");
            int password = rs.getInt("password");
            String name = rs.getString("name");
            String login = rs.getString("login");
            allStudents.add(new Students(id, password, name, login));
            }
        } catch (SQLException e) {
            System.out.println("can`t load all students");
            e.printStackTrace();
            return  new ArrayList<>();
        }
       return allStudents;
    }

    public Students getStudentById(int id){
        ResultSet rs = null;
        try(Connection connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement ps = connect.prepareStatement(IDSTUDENT)) {
            ps.setInt(1,id);
            rs = ps.executeQuery();
            rs.next();
            return new Students(rs.getInt(1),rs.getInt(2), rs.getString(3), rs.getString(4));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void saveNewStudent(Students newStudent) {
        try (Connection connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pr = connect.prepareStatement(NEWSTUDENT)) {
            pr.setString(1, newStudent.getName());
            pr.setString(2, newStudent.getLogin());
            pr.setInt(3, newStudent.getPassword());
            pr.executeUpdate();
        } catch (SQLException e) {
            System.out.println("");
        }

    }

    public void updateAllStudents(Students allStudents){
        try(Connection connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement ps = connect.prepareStatement(UPDATESTUDENTS)){
                ps.setInt(1, allStudents.getId());
                ps.setInt(2, allStudents.getPassword());
                ps.setString(3, allStudents.getName());
                ps.setString(4, allStudents.getLogin());
                ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteOldStudents( Students oldStudents ){
        try(Connection connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement ps =connect.prepareStatement(DELETESTUDENT)) {
            ps.setInt(oldStudents.getId(), 1);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}