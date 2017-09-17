package edu.chdtu.carverif.controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

/**
 * Created by Metr_yumora on 06.09.2017.
 */
public class MainController extends BasicController {

    private Stage loginStage;
    private Stage registrationStage;
    private Stage workspaceStage;
    private Stage addClientStage;
    private Stage addVehicleStage;
    private Stage addVerificationResultStage;

    private WorkspaceController workspaceController;


    public MainController(Stage primaryStage) throws IOException {

        Parent addClientParent = FXMLLoader.load((getClass().getResource("/view/addClient.fxml")));
        addClientStage = new Stage();
        addClientStage.setScene(new Scene(addClientParent));
        addClientStage.setTitle("Зареєструвати клієнта");

        Parent addVehicleParent = FXMLLoader.load((getClass().getResource("/view/addVehicle.fxml")));
        addVehicleStage = new Stage();
        addVehicleStage.setScene(new Scene(addVehicleParent));
        addVehicleStage.setTitle("Зареєструвати автомобіль");

        Parent addVerificationResultParent = FXMLLoader.load((getClass().getResource("/view/addVerificationResult.fxml")));
        addVerificationResultStage = new Stage();
        addVerificationResultStage.setScene(new Scene(addVerificationResultParent));
        addVerificationResultStage.setTitle("Додати результат перевірки");

        Parent registrationParent = FXMLLoader.load((getClass().getResource("/view/register.fxml")));
        registrationStage = new Stage();
        registrationStage.setScene(new Scene(registrationParent));
        registrationStage.setTitle("Зареєструватися як новий співробітник");

        Parent loginParent = FXMLLoader.load(getClass().getResource("/view/login.fxml"));
        primaryStage.setTitle("Увійти до системи");
        primaryStage.setScene(new Scene(loginParent));
        loginStage = primaryStage;
        primaryStage.show();
    }

    public void initWorkspaceStage() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Parent parent = loader.load((getClass().getResource("/view/workspace.fxml")));
        workspaceController = loader.getController();
        workspaceStage = new Stage();
        workspaceStage.setScene(new Scene(parent));
        workspaceStage.setTitle("Перегляд");
    }


    public static void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public Stage getLoginStage() {
        return loginStage;
    }

    public void setLoginStage(Stage loginStage) {
        this.loginStage = loginStage;
    }

    public Stage getRegistrationStage() {
        return registrationStage;
    }

    public void setRegistrationStage(Stage registrationStage) {
        this.registrationStage = registrationStage;
    }

    public Stage getWorkspaceStage() {
        return workspaceStage;
    }

    public void setWorkspaceStage(Stage workspaceStage) {
        this.workspaceStage = workspaceStage;
    }

    public Stage getAddClientStage() {
        return addClientStage;
    }

    public void setAddClientStage(Stage addClientStage) {
        this.addClientStage = addClientStage;
    }

    public Stage getAddVehicleStage() {
        return addVehicleStage;
    }

    public void setAddVehicleStage(Stage addVehicleStage) {
        this.addVehicleStage = addVehicleStage;
    }

    public Stage getAddVerificationResultStage() {
        return addVerificationResultStage;
    }

    public void setAddVerificationResultStage(Stage addVerificationResultStage) {
        this.addVerificationResultStage = addVerificationResultStage;
    }

    public WorkspaceController getWorkspaceController() {
        return workspaceController;
    }

    public void setWorkspaceController(WorkspaceController workspaceController) {
        this.workspaceController = workspaceController;
    }
}
