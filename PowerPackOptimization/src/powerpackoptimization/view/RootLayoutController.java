/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package powerpackoptimization.view;

import javafx.fxml.FXML;
import powerpackoptimization.PowerPackOptimization;
import powerpackoptimization.model.SaveLoadConfig;

/**
 *
 * @author stefa
 */
public class RootLayoutController {
  
private PowerPackOptimization powerpackOptimization; 

    public RootLayoutController() {
    }


    
    @FXML
    private void handleSaveConfig() {
         SaveLoadConfig.SaveConfig(powerpackOptimization);

        }
    @FXML
    private void handleLoadConfig() {
         SaveLoadConfig.LoadConfig(powerpackOptimization);

        }

    /**
         * Is called by the main application to give a reference back to itself.
         * 
         * @param mainApp
         */
        public void setPowerPackOptimization(PowerPackOptimization powerpackOptimization) {
            this.powerpackOptimization = powerpackOptimization; 

        }


    
}

