package edu.chdtu.carverif.controllers;

import edu.chdtu.carverif.ApplicationLauncher;
import edu.chdtu.carverif.dbutil.HibernateUtil;
import edu.chdtu.carverif.entity.User;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * Created by Metr_yumora on 01.05.2017.
 */
public class RegistrationController extends BasicController {

    @FXML
    TextField nameTF;
    @FXML
    TextField loginTF;
    @FXML
    PasswordField passwordTF;
    @FXML
    PasswordField verifyTF;
    @FXML
    TextField rankTF;
    @FXML
    TextField positionTF;

    @FXML
    void register() {
        if (passwordTF.getText().equals(verifyTF.getText()) && HibernateUtil.getUserByLogin(loginTF.getText()) == null) {
            User newUser = new User(
                    nameTF.getText(),
                    loginTF.getText(),
                    passwordTF.getText(),
                    positionTF.getText(),
                    rankTF.getText());
            HibernateUtil.getSession().save(newUser);
            MainController.showAlert(
                    "Інфо",
                    "Користувача '" + newUser.getName() + "' успішно зареєстровано",
                    Alert.AlertType.INFORMATION
            );
            returnToLogin();
        } else {
            MainController.showAlert(
                    "Помилка",
                    "Неможливо зареєструвати користувача: введені паролі не співпадають або обраний логін вже використовується",
                    Alert.AlertType.ERROR);
        }
    }

    @FXML
    void returnToLogin() {
        ApplicationLauncher.getMainController().getRegistrationStage().hide();
        ApplicationLauncher.getMainController().getLoginStage().show();
    }
}
