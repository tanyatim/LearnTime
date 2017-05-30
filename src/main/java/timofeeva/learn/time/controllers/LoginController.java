package timofeeva.learn.time.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import timofeeva.learn.time.App;
import timofeeva.learn.time.entity.Students;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by toshiba on 28.04.2017.
 */
public class LoginController implements Initializable{
    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

    @FXML
    private TextField userLogin;

    @FXML
    private PasswordField userPassword;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        LOG.debug("init login");
    }

    public void clickOk(){
        LOG.debug("OK WAS CLICK SUCCESSFULLY " + userLogin.getText());

    }



    public void clickRegistration() throws Exception {
        Stage stage = RegistrationController.getStage();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/registration.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Registration");
       // stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }
}
