package edu.chdtu.carverif.controllers;

import edu.chdtu.carverif.ApplicationLauncher;
import edu.chdtu.carverif.dbutil.HibernateUtil;
import edu.chdtu.carverif.entity.Client;
import edu.chdtu.carverif.entity.Vehicle;
import edu.chdtu.carverif.entity.Verification;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class WorkspaceController extends BasicController {

    @FXML
    private
    Button addClientBtn;
    @FXML
    private
    Button searchClientBtn;
    @FXML
    private
    Button addCarBtn;
    @FXML
    private
    Button searchCarBtn;
    @FXML
    private
    Button addVerificationResultBtn;
    @FXML
    private
    Button searchVerificationResultBtn;

    @FXML
    private
    TextField searchClientTF;
    @FXML
    private
    TextField searchVehicleTF;
    @FXML
    private
    TextField searchVerificationResultTF;

    @FXML
    private
    TableView<Client> clientsTable;
    @FXML
    private
    ObservableList<Client> clientsList;
    @FXML
    private
    TableView<Vehicle> vehiclesTable;
    @FXML
    private
    ObservableList<Vehicle> vehiclesList;
    @FXML
    private
    TableView<Verification> verificationsTable;
    @FXML
    private
    ObservableList<Verification> verificationsList;

    @FXML
    private void initialize() {
        initClientsTable();
        initVehiclesTable();
        initVerificationsTable();
    }


    private TableColumn<Client, Integer> clientColId;
    private TableColumn<Client, String> clientColName;
    private TableColumn<Client, String> clientColPassport;
    private TableColumn<Client, String> clientColAddress;
    private TableColumn<Client, String> clientColBirthDate;

    private void initClientsTable() {
        clientsList = FXCollections.observableArrayList(HibernateUtil.getAllClients());
        clientColId = new TableColumn<Client, Integer>("Id");
        clientColId.setCellValueFactory(new PropertyValueFactory<Client, Integer>("id"));
        clientColName = new TableColumn<Client, String>("Ім'я");
        clientColName.setCellValueFactory(new PropertyValueFactory<Client, String>("name"));
        clientColPassport = new TableColumn<>("Паспорт");
        clientColPassport.setCellValueFactory(new PropertyValueFactory<Client, String>("passport"));
        clientColAddress = new TableColumn<Client, String>("Адреса");
        clientColAddress.setCellValueFactory(new PropertyValueFactory<Client, String>("address"));
        clientColBirthDate = new TableColumn<Client, String>("Дата народження");
        clientColBirthDate.setCellValueFactory(
                Client -> {
                    SimpleStringProperty property = new SimpleStringProperty();
                    DateFormat timeFormat = new SimpleDateFormat("dd-MM-YYYY");
                    property.setValue(timeFormat.format(Client.getValue().getBirthDate()));
                    return property;
                });
        clientsTable.getColumns().clear();
        clientsTable.getColumns().addAll(
                clientColId,
                clientColName,
                clientColPassport,
                clientColAddress,
                clientColBirthDate);
        clientsTable.setItems(clientsList);
    }

    private TableColumn<Vehicle, Integer> vehicleColId;
    private TableColumn<Vehicle, String> vehicleColModel;
    private TableColumn<Vehicle, String> vehicleColColor;
    private TableColumn<Vehicle, String> vehicleColRegistrationNumber;
    private TableColumn<Vehicle, String> vehicleColTechnicalPassport;
    private TableColumn<Vehicle, String> vehicleColEngineNumber;
    private TableColumn<Vehicle, String> vehicleColOwner;

    private void initVehiclesTable() {
        vehiclesList = FXCollections.observableArrayList(HibernateUtil.getAllVehicles());
        vehicleColId = new TableColumn<>("Id");
        vehicleColId.setCellValueFactory(new PropertyValueFactory<>("id"));
        vehicleColModel = new TableColumn<>("Модель і марка");
        vehicleColModel.setCellValueFactory(new PropertyValueFactory<>("model"));
        vehicleColColor = new TableColumn<>("Колір");
        vehicleColColor.setCellValueFactory(new PropertyValueFactory<>("color"));
        vehicleColRegistrationNumber = new TableColumn<>("Номер автомобіля");
        vehicleColColor.setCellValueFactory(new PropertyValueFactory<>("registrationNumber"));
        vehicleColTechnicalPassport = new TableColumn<>("Технічний паспорт");
        vehicleColColor.setCellValueFactory(new PropertyValueFactory<>("technicalPassport"));
        vehicleColEngineNumber = new TableColumn<>("Номер двигуна");
        vehicleColColor.setCellValueFactory(new PropertyValueFactory<>("engineNumber"));
        vehicleColOwner = new TableColumn<>("Власник");
        vehicleColOwner.setCellValueFactory(Vehicle -> {
            SimpleStringProperty property = new SimpleStringProperty();
            property.setValue(Vehicle.getValue().getOwner().getName());
            return property;
        });
        vehiclesTable.getColumns().clear();
        vehiclesTable.getColumns().addAll(
                vehicleColId,
                vehicleColModel,
                vehicleColColor,
                vehicleColRegistrationNumber,
                vehicleColTechnicalPassport,
                vehicleColEngineNumber,
                vehicleColOwner
        );
        vehiclesTable.setItems(vehiclesList);
    }

    private TableColumn<Verification, String> verificationColVehicleNumber;
    private TableColumn<Verification, String> verificationColResult;
    private TableColumn<Verification, String> verificationColDateTime;
    private TableColumn<Verification, String> verificationColUser;
    private TableColumn<Verification, String> verificationColRemarks;

    private void initVerificationsTable() {
        verificationsList = FXCollections.observableArrayList(HibernateUtil.getVerificationHistory());
        verificationColVehicleNumber = new TableColumn<>("Номер автомобіля");
        verificationColVehicleNumber.setCellValueFactory(new PropertyValueFactory<>("registrationNumber"));
        verificationColResult = new TableColumn<>("Результат");
        verificationColResult.setCellValueFactory(new PropertyValueFactory<>("result"));
        verificationColDateTime = new TableColumn<>("Дата");
        verificationColDateTime.setCellValueFactory(
                Verification -> {
                    SimpleStringProperty property = new SimpleStringProperty();
                    DateFormat timeFormat = new SimpleDateFormat("dd-MM-YYYY");
                    property.setValue(timeFormat.format(Verification.getValue().getDateTime()));
                    return property;
                }
        );
        verificationColUser = new TableColumn<>("Ім'я перевіряючого");
        verificationColUser.setCellValueFactory(
                Verification -> {
                    SimpleStringProperty property = new SimpleStringProperty();
                    property.setValue(Verification.getValue().getUser().getName());
                    return property;
                }
        );
        verificationColRemarks = new TableColumn<>("Відмітки/Зауваження");
        verificationColRemarks.setCellValueFactory(new PropertyValueFactory<>("remarks"));
        verificationsTable.getColumns().clear();
        verificationsTable.getColumns().addAll(
                verificationColVehicleNumber,
                verificationColResult,
                verificationColDateTime,
                verificationColUser,
                verificationColRemarks
        );
        verificationsTable.setItems(verificationsList);
    }

    @FXML
    public void updateClientsTable() {
        clientsList = FXCollections.observableArrayList(HibernateUtil.getAllClients());
        clientsTable.setItems(clientsList);
    }

    @FXML
    private void searchForClientsAndUpdate() {
        clientsList = FXCollections.observableArrayList(HibernateUtil.getAllClientsByName(searchClientTF.getText()));
        clientsTable.setItems(clientsList);
    }

    @FXML
    public void updateVehiclesTable() {
        vehiclesList = FXCollections.observableArrayList(HibernateUtil.getAllVehicles());
        vehiclesTable.setItems(vehiclesList);
    }

    @FXML
    private void searchForVehiclesAndUpdate() {
        vehiclesList = FXCollections.observableArrayList(HibernateUtil.getAllVehiclesByOwner(searchVehicleTF.getText()));
        vehiclesTable.setItems(vehiclesList);
    }

    @FXML
    public void updateVerificationsTable() {
        verificationsList = FXCollections.observableArrayList(HibernateUtil.getVerificationHistory());
        verificationsTable.setItems(verificationsList);
    }

    @FXML
    private void searchForVerificationsAndUpdate() {
        verificationsList = FXCollections.observableArrayList(HibernateUtil.
                getVerificationHistoryByCarNumberOrInspector(searchVerificationResultTF.getText()));
        verificationsTable.setItems(verificationsList);
    }

    @FXML
    public void showAddClient() {
        ApplicationLauncher.getMainController().getWorkspaceStage().hide();
        ApplicationLauncher.getMainController().getAddClientStage().show();
    }

    @FXML
    public void showAddVehicle() {
        ApplicationLauncher.getMainController().getWorkspaceStage().hide();
        ApplicationLauncher.getMainController().getAddVehicleStage().show();
    }

    @FXML
    public void showAddVerificationResult() {
        ApplicationLauncher.getMainController().getWorkspaceStage().hide();
        ApplicationLauncher.getMainController().getAddVerificationResultStage().show();
    }

    @FXML
    public void updateAllTables(){
        updateClientsTable();
        updateVehiclesTable();
        updateVerificationsTable();
    }

    public Button getAddClientBtn() {
        return addClientBtn;
    }

    public Button getSearchClientBtn() {
        return searchClientBtn;
    }

    public Button getAddCarBtn() {
        return addCarBtn;
    }

    public Button getSearchCarBtn() {
        return searchCarBtn;
    }

    public Button getAddVerificationResultBtn() {
        return addVerificationResultBtn;
    }

    public Button getSearchVerificationResultBtn() {
        return searchVerificationResultBtn;
    }

    public TextField getSearchClientTF() {
        return searchClientTF;
    }

    public TextField getSearchVehicleTF() {
        return searchVehicleTF;
    }

    public TextField getSearchVerificationResultTF() {
        return searchVerificationResultTF;
    }

    public TableView<Client> getClientsTable() {
        return clientsTable;
    }

    public TableView<Vehicle> getVehiclesTable() {
        return vehiclesTable;
    }

    public TableView<Verification> getVerificationsTable() {
        return verificationsTable;
    }

    public void setAddClientBtn(Button addClientBtn) {
        this.addClientBtn = addClientBtn;
    }

    public void setSearchClientBtn(Button searchClientBtn) {
        this.searchClientBtn = searchClientBtn;
    }

    public void setAddCarBtn(Button addCarBtn) {
        this.addCarBtn = addCarBtn;
    }

    public void setSearchCarBtn(Button searchCarBtn) {
        this.searchCarBtn = searchCarBtn;
    }

    public void setAddVerificationResultBtn(Button addVerificationResultBtn) {
        this.addVerificationResultBtn = addVerificationResultBtn;
    }

    public void setSearchVerificationResultBtn(Button searchVerificationResultBtn) {
        this.searchVerificationResultBtn = searchVerificationResultBtn;
    }

    public void setSearchClientTF(TextField searchClientTF) {
        this.searchClientTF = searchClientTF;
    }

    public void setSearchVehicleTF(TextField searchVehicleTF) {
        this.searchVehicleTF = searchVehicleTF;
    }

    public void setSearchVerificationResultTF(TextField searchVerificationResultTF) {
        this.searchVerificationResultTF = searchVerificationResultTF;
    }

    public void setClientsTable(TableView<Client> clientsTable) {
        this.clientsTable = clientsTable;
    }

    public void setClientsList(ObservableList<Client> clientsList) {
        this.clientsList = clientsList;
    }

    public void setVehiclesTable(TableView<Vehicle> vehiclesTable) {
        this.vehiclesTable = vehiclesTable;
    }

    public void setVehiclesList(ObservableList<Vehicle> vehiclesList) {
        this.vehiclesList = vehiclesList;
    }

    public void setVerificationsTable(TableView<Verification> verificationsTable) {
        this.verificationsTable = verificationsTable;
    }

    public void setVerificationsList(ObservableList<Verification> verificationsList) {
        this.verificationsList = verificationsList;
    }
}
