package timofeeva.learn.time;

import org.flywaydb.core.Flyway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import timofeeva.learn.time.ui.Login;
import timofeeva.learn.time.ui.Registration;
import timofeeva.learn.time.utils.DatabaseUtils;

/**
 * Created by toshiba on 17.03.2017.
 */
public class App {
    private static final Logger LOG = LoggerFactory.getLogger(App.class);



    public static void main(String[] args) {

        DatabaseUtils.migrate();
        LOG.info("Hello logger");

        Login.run();
    }
}

