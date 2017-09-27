/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package powerpackoptimization.model;

        
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import javafx.collections.ObservableList;
import powerpackoptimization.model.Limitation;


/**
 *
 * @author Stefan Loacker-Schöch
 */
public class SaveLoadConfig {
    
    public static void SaveConfig(ObservableList motor_data, ObservableList ECU_data) {
        try (PrintWriter pw = new PrintWriter(new File("test.csv"))) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0;i<motor_data.size();i++)
            {
              Limitation limitation = (Limitation) motor_data.get(i);
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
            pw.write(sb.toString());
        }
        catch(FileNotFoundException e)
        {
            System.out.println(e.toString());
        }
        
    }
}
