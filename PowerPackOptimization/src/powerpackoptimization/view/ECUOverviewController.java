/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package powerpackoptimization.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import powerpackoptimization.PowerPackOptimization;

/**
 * FXML Controller class
 *
 * @author stefa
 */
public class ECUOverviewController{
    private PowerPackOptimization powerpackOptimization;
    /**
     * Initializes the controller class.
     */
    
    public void initialize() {
        // TODO
    }    
    
    public void setPowerPackOptimization(PowerPackOptimization powerpackOptimization) {
        this.powerpackOptimization = powerpackOptimization; 
    }
    
}
