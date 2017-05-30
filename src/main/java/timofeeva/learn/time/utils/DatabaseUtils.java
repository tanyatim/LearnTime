package timofeeva.learn.time.utils;

import org.flywaydb.core.Flyway;
import timofeeva.learn.time.dao.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by toshiba on 05.04.2017.
 */
public class DatabaseUtils {
    private static Connection connection;
    private static String url;
    private static String username;
    private static String password;

    public static final TeachersDAO teachersDAO = new TeachersDAO();
    public static final StudentsDAO studentsDAO = new StudentsDAO();
    public static final AnswersDAO answersDAO = new AnswersDAO();
    public static final CoursesDAO coursesDAO = new CoursesDAO();
    public static final GivenAnswersDAO givenAnswersDAO = new GivenAnswersDAO();
    public static final QuestionsDAO questionsDAO = new QuestionsDAO();
    public static final StudentsCoursesDAO studentsCoursesDAO = new StudentsCoursesDAO();
    public static final TeachersCoursesDAO teachersCoursesDAO = new TeachersCoursesDAO();
    public static final TestsDAO testsDAO = new TestsDAO();
    public static final TestsHistoryDAO testsHistoryDAO = new TestsHistoryDAO();
    public static final TopicsDAO topicsDAO = new TopicsDAO();









    static {
        Runtime.getRuntime().addShutdownHook(new Thread(DatabaseUtils::closeConnection));
    }

    static {
        Properties properties = new Properties();
        try (InputStream is = DatabaseUtils.class.getClassLoader().getResourceAsStream("db.properties")){
            properties.load(is);
            url =  properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void migrate(){
        Flyway flyway = new Flyway();
        flyway.setDataSource(url, username, password);
        flyway.clean();
        flyway.migrate();
    }

    public static Connection getConnection() {
        try {
            if(connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(url, username, password);
            }
        } catch (SQLException e) {
           e.printStackTrace();
        }
        return connection;
    }
    public static void closeConnection(){
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }






}
