package edu.chdtu.carverif.controllers;

import edu.chdtu.carverif.ApplicationLauncher;
import edu.chdtu.carverif.dbutil.HibernateUtil;
import edu.chdtu.carverif.entity.Client;
import edu.chdtu.carverif.entity.Vehicle;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class AddVehicleController extends BasicController {

    @FXML
    TextField modelTF;
    @FXML
    TextField colorTF;
    @FXML
    TextField numberTF;
    @FXML
    TextField techPassportTF;
    @FXML
    TextField engineTF;
    @FXML
    TextField ownerPassportTF;


    @FXML
    void returnToMain() {
        ApplicationLauncher.getMainController().getAddVehicleStage().hide();
        ApplicationLauncher.getMainController().getWorkspaceStage().show();
    }

    @FXML
    void addVehicle() {
        if (modelTF.getText().isEmpty() ||
                colorTF.getText().isEmpty() ||
                numberTF.getText().isEmpty() ||
                techPassportTF.getText().isEmpty() ||
                engineTF.getText().isEmpty() ||
                ownerPassportTF.getText().isEmpty()) {
            MainController.showAlert(
                    "Помилка!",
                    "Необхідно заповнити всі поля!",
                    Alert.AlertType.ERROR
            );
            returnToMain();
            return;
        }
        Client owner;
        owner = HibernateUtil.getClientByPassport(ownerPassportTF.getText());

        if (owner == null) {
            MainController.showAlert(
                    "Помилка",
                    "Власника із заданою серією та номером паспорта не знайдено!",
                    Alert.AlertType.ERROR
            );
            returnToMain();
            return;
        }
        Vehicle newVehicle = new Vehicle(
                numberTF.getText(),
                engineTF.getText(),
                modelTF.getText(),
                colorTF.getText(),
                techPassportTF.getText(),
                owner
        );

        HibernateUtil.getSession().save(newVehicle);
        MainController.showAlert(
                "Інфо",
                "Клієнта успішно зареєстровано",
                Alert.AlertType.INFORMATION
        );
        returnToMain();
    }
}
