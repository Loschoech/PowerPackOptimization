/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package powerpackoptimization.model;

        
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import powerpackoptimization.PowerPackOptimization;
import powerpackoptimization.model.Limitation;


/**
 *
 * @author Stefan Loacker-Schöch
 */
public class SaveLoadConfig {
    
    private static FileChooser filechooser = new FileChooser();
    private static ExtensionFilter extensionfilter = new ExtensionFilter("PPO-Dokumente",".ppo");
    
    
    public static void SaveConfig(PowerPackOptimization powerpackOptimization) {
        filechooser.setTitle("Select Limitations File");
        filechooser.setInitialFileName("Limitations.ppo");
        filechooser.setInitialDirectory(new File(System.getProperty("user.home")));
        filechooser.setSelectedExtensionFilter(extensionfilter);
        
        File file = filechooser.showSaveDialog(powerpackOptimization.getPrimaryStage());
        if(file != null)
        {
            try (PrintWriter pw = new PrintWriter(file)) {
                StringBuilder sb = new StringBuilder();
                for(int i = 0;i<powerpackOptimization.getMotorLimitationsData().size();i++)
                {
                  Limitation limitation = (Limitation) powerpackOptimization.getMotorLimitationsData().get(i);
                  sb.append(limitation.getName());
                  sb.append(';');
                  sb.append(limitation.getUnit());
                  sb.append(';');
                  sb.append(Double.toString(limitation.getMin()));
                  sb.append(';');
                  sb.append(Double.toString(limitation.getMax()));
                  sb.append(';');
                  sb.append(Double.toString(limitation.getStep()));
                  sb.append('\n');
                }
                sb.append('$');
                pw.write(sb.toString());
            }
            catch(FileNotFoundException e)
            {
                System.out.println(e.toString());
            }
        }
    }
    public static void LoadConfig(PowerPackOptimization powerpackOptimization) {
        filechooser.setTitle("Select Limitations File");
        filechooser.setInitialFileName("Limitations.ppo");
        filechooser.setInitialDirectory(new File(System.getProperty("user.home")));
        filechooser.setSelectedExtensionFilter(extensionfilter);

        File file = filechooser.showOpenDialog(powerpackOptimization.getPrimaryStage());
        if(file != null)
        {
            try (FileReader fr = new FileReader(file)) {
                if(fr.ready())
                {
                    try (BufferedReader br = new BufferedReader(fr)) {
                        String string = "";
                        String[] stringArray;
                        powerpackOptimization.getMotorLimitationsData().clear();
                        while(string.equals("$") == false)
                        {
                            string = br.readLine();
                            if(string.equals("$")== false)
                            {
                                stringArray = string.split(";",5);
                                if(isInputValid(stringArray))
                                {
                                    Limitation limitation = new Limitation(stringArray[0],stringArray[1]);
                                    limitation.setMax(Double.parseDouble(stringArray[2]));
                                    limitation.setMax(Double.parseDouble(stringArray[3]));
                                    limitation.setStep(Double.parseDouble(stringArray[4]));
                                    powerpackOptimization.getMotorLimitationsData().add(limitation);
                                }
                            }
                        }
                    }
                }
            }
            catch(IOException e)
            {
                System.out.println(e.toString());
            }
        }

    }
    
    /**
     * Validates the user input in the text fields.
     * @param Array
     * @return true if the input is valid
     */
    public static boolean isInputValid(String[] Array) {
        String errorMessage = "";

        if (Array[3] == null || Array[3].length() == 0) {
            errorMessage += "No valid max value!\n"; 
        } else {
            // try to parse the postal code into an int.
            try {
                Double.parseDouble(Array[3]);
            } catch (NumberFormatException e) {
                errorMessage += "No valid max value (must be a double)!\n"; 
            }
        }
         if (Array[2] == null || Array[2].length() == 0) {
            errorMessage += "No valid min value!\n"; 
        } else {
            // try to parse the postal code into an int.
            try {
                Double.parseDouble(Array[2]);
            } catch (NumberFormatException e) {
                errorMessage += "No valid min value (must be a double)!\n"; 
            }
        }
        if (Array[4] == null || Array[4].length() == 0) {
            errorMessage += "No valid step value!\n"; 
        } else {
            // try to parse the postal code into an int.
            try {
                Double.parseDouble(Array[4]);
            } catch (NumberFormatException e) {
                errorMessage += "No valid step value (must be a double)!\n"; 
            }
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            return false;
        }
    }
 }

