/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package powerpackoptimization.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *  Class for a Limitation
 * @author Stefan Loacker-Schöch
 */
public class Limitation {

    
    private final StringProperty Name;

    public String getName() {
        return Name.get();
    }

    public void setName(String value) {
        Name.set(value);
    }

    public StringProperty NameProperty() {
        return Name;
    }
    
    private final StringProperty Unit;

    public String getUnit() {
        return Unit.get();
    }

    public void setUnit(String value) {
        Unit.set(value);
    }

    public StringProperty UnitProperty() {
        return Unit;
    }
    private final DoubleProperty min;

    public double getMin() {
        return min.get();
    }

    public void setMin(double value) {
        min.set(value);
    }

    public DoubleProperty minProperty() {
        return min;
    }
    private final DoubleProperty step;

    public double getStep() {
        return step.get();
    }

    public void setStep(double value) {
        step.set(value);
    }

    public DoubleProperty stepProperty() {
        return step;
    }
    
    private final DoubleProperty max;

    public double getMax() {
        return max.get();
    }

    public void setMax(double value) {
        max.set(value);
    }

    public DoubleProperty maxProperty() {
        return max;
    }
    
    /**
    * Constructor with some initial data.
    * 
    * @param Name
    * @param Unit
    */
    
    public Limitation(String Name, String Unit) {
        this.Name = new SimpleStringProperty(Name);
        this.Unit = new SimpleStringProperty(Unit);
        
        this.max = new SimpleDoubleProperty(3.0);
        this.min = new SimpleDoubleProperty(1.0);
        this.step = new SimpleDoubleProperty(1.0);
        
  
    }
    
    }
