package timofeeva.learn.time.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import timofeeva.learn.time.dao.AbstractDAO;
import timofeeva.learn.time.entity.Students;
import timofeeva.learn.time.entity.Teachers;
import timofeeva.learn.time.utils.DatabaseUtils;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by toshiba on 10.05.2017.
 */
public class RegistrationController implements Initializable{
    private static final Logger LOG = LoggerFactory.getLogger(RegistrationController.class);
    private static final String TEACHER = "Teacher";
    private static final String STUDENT = "Student";

    @FXML
    private ChoiceBox role;
    @FXML
    private TextField name;
    @FXML
    private TextField login;
    @FXML
    private TextField mail;
    @FXML
    private TextField password;

    private static Stage stage = new Stage();

    public static Stage getStage() {
        return stage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        LOG.debug("registration init");
        role.getItems().addAll(TEACHER, STUDENT);
    }

    @FXML
    public void onRegistration(){
        LOG.info("name {}, login {}, mail {}, password {}, role {}",
                name.getText(), login.getText(), mail.getText(), password.getText(), role.getValue());
        if(!isLoginRegistered()) {
            switch ((String) role.getValue()) {
                case TEACHER:
                    saveTeacher();
                    break;
                case STUDENT:
                    saveStudent();
                    break;
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setHeaderText("Логин занят");
            alert.showAndWait();
        }
        stage.close();
    }

// TODO подвинуть кнопку cancel
    @FXML
    public void close(){
        stage.close();
    }

    private boolean isLoginRegistered(){
        String login = this.login.getText();
        Teachers dbTeacher = DatabaseUtils.teachersDAO.getByLogin(login);
        if (dbTeacher != null){
             return true;
        }
        Students dbStusent = DatabaseUtils.studentsDAO.getByLogin(login);
        if (dbStusent != null){
            return true;
        }
        return false;
    }

    private void saveTeacher() {
        Teachers teacher = new Teachers(-1,
                password.getText(), name.getText(), login.getText());
        DatabaseUtils.teachersDAO.save(teacher);
    }

    private void saveStudent(){
        Students student = new Students(-1, password.getText(), name.getText(), login.getText());
        DatabaseUtils.studentsDAO.save(student);
    }
}
