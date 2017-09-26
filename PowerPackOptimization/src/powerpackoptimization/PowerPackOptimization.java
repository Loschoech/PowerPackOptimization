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
import javafx.stage.Stage;
import powerpackoptimization.model.Limitation;


/**
 *
 * @author Stefan Loacker-Schöch
 */
public class PowerPackOptimization extends Application {
    
    private Stage primaryStage;
    private BorderPane rootLayout;
    
    /**
     * The data as an observable list of Limitations.
     */
    private final ObservableList<Limitation> MotorLimitations = FXCollections.observableArrayList();
    private final ObservableList<Limitation> ECULimitations = FXCollections.observableArrayList();
    
    
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
    
}
