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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import powerpackoptimization.PowerPackOptimization;
import powerpackoptimization.model.Limitation;
import powerpackoptimization.model.SaveLoadConfig;


public class MotorOverviewController {
  
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
    private Label Nanoseconds;
    
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
    }
    /**
 * Called when the user clicks the edit button. Opens a dialog to edit
 * details for the selected person.
 */

private void handleEditLimitation() {
   
    Limitation selectedLimitation = motorlimitationsTable.getSelectionModel().getSelectedItem();
    if (selectedLimitation != null) {
        powerpackOptimization.showLimitationEditDialog(selectedLimitation);
        Nanoseconds.setText(String.valueOf(powerpackOptimization.calc_time) + " ns");
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
