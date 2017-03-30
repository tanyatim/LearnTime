package timofeeva.learn.time.dao;

import timofeeva.learn.time.entity.Students;
import timofeeva.learn.time.entity.Topic;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by toshiba on 28.03.2017.
 */
public class TopicDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/app_for_learning";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String NEWTOPIC = "INSERT INTO topic VALUES(id=null, name=?, courseId=?)";
    private static final String ALLTOPICS = "SELECT * FROM topic";
    private static final String IDTOPIC = "SELECT * FROM topic WHERE id = ?";
    private static final String UPDATETOPIC = "UPDATE topic SET name=?, courseId=? WHERE id=?";
    private static final String DELETETOPIC = "DELETE FROM topic WHERE  id=?";

    public List<Topic> getAllTopics(){
        List <Topic> allTopics = new ArrayList<>();
        try(Connection connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement ps = connect.prepareStatement(ALLTOPICS);
            ResultSet rs = ps.executeQuery()){

            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int courseId = rs.getInt("courseId");
                allTopics.add(new Topic(id, name, courseId));
            }
        } catch (SQLException e) {
            System.out.println("can`t load all topics");
            e.printStackTrace();
            return  new ArrayList<>();
        }
        return allTopics;
    }

    public Topic getTopicById(int id){
        ResultSet rs = null;
        try(Connection connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement ps = connect.prepareStatement(IDTOPIC)) {
            ps.setInt(1,id);
            rs = ps.executeQuery();
            rs.next();
            return new Topic(rs.getInt(1), rs.getString(2), rs.getInt(3));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void saveNewTopic(Topic newTopic) {
        try (Connection connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pr = connect.prepareStatement(NEWTOPIC)) {
            pr.setString(1, newTopic.getName());
            pr.setInt(2, newTopic.getCourseId());
            pr.executeUpdate();
        } catch (SQLException e) {
            System.out.println("");
        }
    }

    public void updateTopics(Topic allTopics){
        try(Connection connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement ps = connect.prepareStatement(UPDATETOPIC)){
            ps.setInt(1, allTopics.getId());
            ps.setString(2, allTopics.getName());
            ps.setInt(3, allTopics.getCourseId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteOldTopics(Topic oldTopics){
        try(Connection connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement ps =connect.prepareStatement(DELETETOPIC)) {
            ps.setInt(1,oldTopics.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
