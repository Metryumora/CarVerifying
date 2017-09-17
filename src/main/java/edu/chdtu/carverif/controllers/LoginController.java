package edu.chdtu.carverif.controllers;

import edu.chdtu.carverif.ApplicationLauncher;
import edu.chdtu.carverif.dbutil.HibernateUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * Created by Metr_yumora on 01.05.2017.
 */
public class LoginController extends BasicController {

    @FXML
    TextField loginTF;
    @FXML
    PasswordField passwordTF;

    @FXML
    void login() throws Exception {
        if (HibernateUtil.authUser(loginTF.getText(), passwordTF.getText())) {
            ApplicationLauncher.getMainController().getLoginStage().hide();
            ApplicationLauncher.getMainController().initWorkspaceStage();
            ApplicationLauncher.getMainController().getWorkspaceStage().show();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Помилка!");
            alert.setHeaderText(null);
            alert.setContentText("Введено невірне ім'я користувача або/і пароль.");
            alert.showAndWait();
        }
    }

    @FXML
    void switchToRegister() throws Exception {
        ApplicationLauncher.getMainController().getLoginStage().hide();
        ApplicationLauncher.getMainController().getRegistrationStage().show();
    }

}
