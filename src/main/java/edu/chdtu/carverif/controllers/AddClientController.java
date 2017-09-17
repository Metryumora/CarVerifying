package edu.chdtu.carverif.controllers;

import edu.chdtu.carverif.ApplicationLauncher;
import edu.chdtu.carverif.dbutil.HibernateUtil;
import edu.chdtu.carverif.entity.Client;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.util.Duration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class AddClientController extends BasicController {

    @FXML
    TextField nameTF;
    @FXML
    TextField addressTF;
    @FXML
    TextField birthDateTF;
    @FXML
    TextField passportTF;


    @FXML
    void returnToMain() {
        ApplicationLauncher.getMainController().getAddClientStage().hide();
        ApplicationLauncher.getMainController().getWorkspaceStage().show();
    }

    @FXML
    void addClient() {
        if (nameTF.getText().isEmpty() ||
                addressTF.getText().isEmpty() ||
                birthDateTF.getText().isEmpty() ||
                passportTF.getText().isEmpty()
                ) {
            MainController.showAlert(
                    "Помилка!",
                    "Необхідно заповнити всі поля!",
                    Alert.AlertType.ERROR
            );
        }
        Client newClient = null;
        try {
            Date birthDate = new SimpleDateFormat("dd-MM-yyyy").parse(birthDateTF.getText());
            newClient = new Client(
                    nameTF.getText(),
                    passportTF.getText(),
                    addressTF.getText(),
                    birthDate
            );
        } catch (ParseException e) {
            MainController.showAlert(
                    "Помилка!",
                    "Невірний формат дати. Дата має бути задана у форматі дд-ММ-рррр.",
                    Alert.AlertType.ERROR
            );
            e.printStackTrace();
        }
        if (newClient != null) {
            HibernateUtil.getSession().save(newClient);
            MainController.showAlert(
                    "Інфо",
                    "Клієнта успішно зареєстровано",
                    Alert.AlertType.INFORMATION
            );
        }
        returnToMain();
    }
}
