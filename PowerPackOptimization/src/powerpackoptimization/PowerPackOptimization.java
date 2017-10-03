/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package powerpackoptimization;


import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import powerpackoptimization.model.Limitation;
import powerpackoptimization.view.LimitationEditDialogController;
import powerpackoptimization.view.PowerPackOverviewController;

/**
 *
 * @author Stefan Loacker-Schöch
 */
public class PowerPackOptimization extends Application {
    
    private Stage primaryStage;
    private BorderPane rootLayout;
    public long calc_time;
    
    /**
     * The data as an observable list of Limitations.
     */
    private final ObservableList<Limitation> MotorLimitations = FXCollections.observableArrayList();
    private final ObservableList<Limitation> ECULimitations = FXCollections.observableArrayList();

    public PowerPackOptimization() {
        this.calc_time = 0;
    }
    
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("PowerPack Optimization");
        
        initRootLayout();
        showPowerPackOverview();
        
        /**
         * Add Limitations
         */
        
        MotorLimitations.add(new Limitation("StackLength","mm"));
        MotorLimitations.add(new Limitation("StatorInnerDiameter","mm"));
        
        /** 
         * Measure one Calculationtime
         */
        final long timeStart = System.nanoTime(); 
        for (int i = 0; i < 1000000; i++) { 
            int x = i/2; 
        } 
        final long timeEnd = System.nanoTime();
        calc_time = (timeEnd-timeStart)/1000000;
    }
    
  
     /**
     * Returns the data as an observable list of Limitations. 
     * @return
     */
    public ObservableList<Limitation> getMotorLimitationsData() {
        return MotorLimitations;
    }
    
    public ObservableList<Limitation> getECULimitationsData() {
        return ECULimitations;
    }
    
    /**
     * Initializes the root layout.
     */
    public void initRootLayout(){
        
        try{
            // Load root layout
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(PowerPackOptimization.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
        
            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
        /**
     * Shows the person overview inside the root layout.
     */
    public void showPowerPackOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(PowerPackOptimization.class.getResource("view/PowerPackOverview.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(personOverview);
            
            // Give the controller access to the main app.
            PowerPackOverviewController controller = loader.getController();
            controller.setPowerPackOptimization(this);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
        /**
     * Opens a dialog to edit details for the specified person. If the user
     * clicks OK, the changes are saved into the provided person object and true
     * is returned.
     * 
     * @param Limitation the limitation object to be edited
     * @return true if the user clicked OK, false otherwise.
     */
    public void showLimitationEditDialog(Limitation Limitation) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(PowerPackOptimization.class.getResource("view/LimitationEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Limitation");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the limitation into the controller.
            LimitationEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setLimitation(Limitation);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();
  
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
