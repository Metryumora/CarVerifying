package edu.chdtu.carverif.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Metr_yumora on 06.09.2017.
 */
public class MainController extends BasicController {

    private Stage loginStage;

    private Parent loginParent;

    private Stage registrationStage;

    private Parent registrationParent;

    public MainController(Stage primaryStage) throws Exception {

        registrationParent = FXMLLoader.load((getClass().getResource("/view/register.fxml")));
        registrationStage = new Stage();
        registrationStage.setScene(new Scene(registrationParent));
        registrationStage.setTitle("Зареєструватися як новий співробітник");

        loginParent = FXMLLoader.load(getClass().getResource("/view/login.fxml"));
        primaryStage.setTitle("Увійти до системи");
        primaryStage.setScene(new Scene(loginParent));
        loginStage = primaryStage;
        primaryStage.show();
    }

    public Stage getLoginStage() {
        return loginStage;
    }

    public void setLoginStage(Stage loginStage) {
        this.loginStage = loginStage;
    }

    public Parent getLoginParent() {
        return loginParent;
    }

    public void setLoginParent(Parent loginParent) {
        this.loginParent = loginParent;
    }

    public Stage getRegistrationStage() {
        return registrationStage;
    }

    public void setRegistrationStage(Stage registrationStage) {
        this.registrationStage = registrationStage;
    }

    public Parent getRegistrationParent() {
        return registrationParent;
    }

    public void setRegistrationParent(Parent registrationParent) {
        this.registrationParent = registrationParent;
    }
}
