/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package powerpackoptimization.model;

/**
 *
 * @author Stefan Loacker-Schöch
 */
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Magnet {

    public Magnet(double diameter) {
        this.diameter.set(diameter);
        this.Name.set("Wire"+Double.toString(diameter));
    }
    private final DoubleProperty diameter = new SimpleDoubleProperty();

    public double getDiameter() {
        return diameter.get();
    }

    public void setDiameter(double value) {
        diameter.set(value);
    }

    public DoubleProperty diameterProperty() {
        return diameter;
    }
    
    private StringProperty Name = new SimpleStringProperty();

    public String getName() {
        return Name.get();
    }

    public void setName(String value) {
        Name.set(value);
    }

    public StringProperty NameProperty() {
        return Name;
    }
    
    
    

}
