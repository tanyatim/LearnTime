package timofeeva.learn.time;

import org.flywaydb.core.Flyway;

/**
 * Created by toshiba on 17.03.2017.
 */
public class App {
    private static final String URL= "jdbc:mysql://localhost:3306/app_for_learning?createDatabaseIfNotExist=true&autoReconnect=true&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";


    public static void main(String[] args) {
        Flyway flyway = new Flyway();
        flyway.setDataSource(URL,USERNAME, PASSWORD);
        flyway.migrate();
    }




}

