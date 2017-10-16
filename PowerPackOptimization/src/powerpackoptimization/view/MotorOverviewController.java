/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package powerpackoptimization.view;

/**
 *
 * @author Stefan Loacker-Schöch
 */

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import powerpackoptimization.PowerPackOptimization;
import powerpackoptimization.model.Limitation;
import powerpackoptimization.model.LoadPoint;
import powerpackoptimization.model.SaveLoadConfig;
import powerpackoptimization.model.Wire;


public class MotorOverviewController {
  
    
    @FXML
    private ScatterChart<Number,Number> loadpointChart;
    @FXML
    private TableView<Limitation> motorlimitationsTable;
    @FXML
    private TableColumn<Limitation, String> NameColumn;
    @FXML
    private TableColumn<Limitation, String> UnitColumn;
    @FXML
    private TableColumn<Limitation, String> MinColumn;
    @FXML
    private TableColumn<Limitation, String> MaxColumn;
    @FXML
    private TableColumn<Limitation, String> StepColumn;
    @FXML
    private TableView<Wire> WireTable;
    @FXML
    private TableColumn<Wire, String> WireDiameterColumn;
    @FXML
    private TableColumn<Wire, String> WireNameColumn;
    @FXML
    private TableView<LoadPoint> LoadPointTable;
    @FXML
    private TableColumn<LoadPoint, String> LoadPointNameColumn;
    @FXML
    private TableColumn<LoadPoint, String> LoadPointTorqueColumn;
    @FXML
    private TableColumn<LoadPoint, String> LoadPointRPMColumn;
    
    
    
    
     // Reference to the main application.
    private PowerPackOptimization powerpackOptimization;
    
    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public MotorOverviewController(){
             
    }
    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the limitations table with the five columns.
        NameColumn.setCellValueFactory(cellData -> cellData.getValue().NameProperty());
        UnitColumn.setCellValueFactory(cellData -> cellData.getValue().UnitProperty());
        MinColumn.setCellValueFactory(cellData -> cellData.getValue().minProperty().asString());
        MinColumn.setCellValueFactory(cellData -> cellData.getValue().minProperty().asString());
        MaxColumn.setCellValueFactory(cellData -> cellData.getValue().maxProperty().asString());
        StepColumn.setCellValueFactory(cellData -> cellData.getValue().stepProperty().asString());
        
        WireNameColumn.setCellValueFactory(cellData -> cellData.getValue().NameProperty());
        WireDiameterColumn.setCellValueFactory(cellData -> cellData.getValue().diameterProperty().asString());
        
        LoadPointNameColumn.setCellValueFactory(cellData -> cellData.getValue().NameProperty());
        LoadPointTorqueColumn.setCellValueFactory(cellData -> cellData.getValue().TorqueProperty().asString());
        LoadPointRPMColumn.setCellValueFactory(cellData -> cellData.getValue().RPMProperty().asString()); 
        


    }
     /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setPowerPackOptimization(PowerPackOptimization powerpackOptimization) {
        this.powerpackOptimization = powerpackOptimization; 
       
        // Add observable list data to the table
        motorlimitationsTable.setItems(powerpackOptimization.getMotorLimitationsData());
        
        motorlimitationsTable.setOnMouseClicked(new EventHandler<MouseEvent>(){
                @Override    
                public void handle(MouseEvent mouseEvent){
                    if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                        if(mouseEvent.getClickCount() == 2){
                            handleEditLimitation();
                        }
                    }
                }
            });
        
                // Add observable list data to the table
        WireTable.setItems(powerpackOptimization.getWireData());
        
        WireTable.setOnMouseClicked(new EventHandler<MouseEvent>(){
                @Override    
                public void handle(MouseEvent mouseEvent){
                    if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                        if(mouseEvent.getClickCount() == 2){
                            handleEditWire();
                        }
                    }
                }
            });
        LoadPointTable.setItems(powerpackOptimization.getLoadPointData());
        
        LoadPointTable.setOnMouseClicked(new EventHandler<MouseEvent>(){
                @Override    
                public void handle(MouseEvent mouseEvent){
                    if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                        if(mouseEvent.getClickCount() == 2){
                            handleEditWire();
                        }
                    }
                }
            });
                
           loadpointChart.setTitle("LoadPoints");
   
            XYChart.Series seriesLoadPoints = new XYChart.Series();
   
            powerpackOptimization.getLoadPointData().forEach((loadPoint) -> {
                seriesLoadPoints.getData().add(new XYChart.Data(loadPoint.getRPM(),loadPoint.getTorque()));
                
                 });
            
            loadpointChart.getData().add(seriesLoadPoints);
       
    }
    /**
 * Called when the user clicks the edit button. Opens a dialog to edit
 * details for the selected person.
 */

private void handleEditLimitation() {
   
    Limitation selectedLimitation = motorlimitationsTable.getSelectionModel().getSelectedItem();
    if (selectedLimitation != null) {
        powerpackOptimization.showLimitationEditDialog(selectedLimitation);
    } else {
        // Nothing selected.
        Alert alert = new Alert(AlertType.WARNING);
        alert.initOwner(powerpackOptimization.getPrimaryStage());
        alert.setTitle("No Selection");
        alert.setHeaderText("No Limitation Selected");
        alert.setContentText("Please select a limitation in the table.");

        alert.showAndWait();
    }
}
private void handleEditWire() {
   
    Wire selectedWire = WireTable.getSelectionModel().getSelectedItem();
    if (selectedWire != null) {
        //powerpackOptimization.showLimitationEditDialog(selectedWire);
    } else {
        // Nothing selected.
        Alert alert = new Alert(AlertType.WARNING);
        alert.initOwner(powerpackOptimization.getPrimaryStage());
        alert.setTitle("No Selection");
        alert.setHeaderText("No Limitation Selected");
        alert.setContentText("Please select a limitation in the table.");

        alert.showAndWait();
    }
}
@FXML
private void handleSaveConfig() {
     SaveLoadConfig.SaveConfig(powerpackOptimization);
    
    }
@FXML
private void handleLoadConfig() {
     SaveLoadConfig.LoadConfig(powerpackOptimization);
    
    }
}
