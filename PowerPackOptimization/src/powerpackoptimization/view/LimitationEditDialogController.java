/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package powerpackoptimization.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import powerpackoptimization.model.Limitation;

/**
 * FXML Controller class
 *
 * @author Stefan Loacker-Schöch
 */
public class LimitationEditDialogController {

    @FXML
    private Label NameField = new Label("");
    
    @FXML
    private Label UnitField = new Label ("");
    @FXML
    private Label UnitField2 = new Label ("");
    @FXML
    private Label UnitField3 = new Label ("");
    @FXML
    private TextField MinField;
    @FXML
    private TextField MaxField;
    @FXML
    private TextField StepField;



    private Stage dialogStage;
    private Limitation limitation;
    private boolean okClicked = false;
    
    
    
    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    }    
    
    /**
     * Sets the stage of this dialog.
     * 
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
    public void setLimitation(Limitation limitation) {
        this.limitation = limitation;

        NameField.setText(limitation.getName());
        UnitField.setText(limitation.getUnit());
        UnitField2.setText(UnitField.getText());
        UnitField3.setText(UnitField.getText());
        MinField.setText(Double.toString(limitation.getMin()));
        MaxField.setText(Double.toString(limitation.getMax()));
        StepField.setText(Double.toString(limitation.getStep()));
      
    }

    /**
     * Returns true if the user clicked OK, false otherwise.
     * 
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }
    
     /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {

            limitation.setMin(Double.parseDouble(MinField.getText()));
            limitation.setMax(Double.parseDouble(MaxField.getText()));
            limitation.setStep(Double.parseDouble(StepField.getText()));

            okClicked = true;
            dialogStage.close();
        }
    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Validates the user input in the text fields.
     * 
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (MaxField.getText() == null || MaxField.getText().length() == 0) {
            errorMessage += "No valid max value!\n"; 
        } else {
            // try to parse the postal code into an int.
            try {
                Double.parseDouble(MaxField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid max value (must be a double)!\n"; 
            }
        }
         if (MinField.getText() == null || MinField.getText().length() == 0) {
            errorMessage += "No valid min value!\n"; 
        } else {
            // try to parse the postal code into an int.
            try {
                Double.parseDouble(MinField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid min value (must be a double)!\n"; 
            }
        }
        if (StepField.getText() == null || StepField.getText().length() == 0) {
            errorMessage += "No valid step value!\n"; 
        } else {
            // try to parse the postal code into an int.
            try {
                Double.parseDouble(StepField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid step value (must be a double)!\n"; 
            }
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}
