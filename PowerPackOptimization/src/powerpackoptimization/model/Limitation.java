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

    private String getName() {
        return Name.get();
    }

    private void setName(String value) {
        Name.set(value);
    }

    private StringProperty NameProperty() {
        return Name;
    }
    
    private final StringProperty Unit;

    private String getUnit() {
        return Unit.get();
    }

    private void setUnit(String value) {
        Unit.set(value);
    }

    private StringProperty UnitProperty() {
        return Unit;
    }
    private final DoubleProperty min;

    private double getMin() {
        return min.get();
    }

    private void setMin(double value) {
        min.set(value);
    }

    private DoubleProperty minProperty() {
        return min;
    }
    private final DoubleProperty step;

    private double getStep() {
        return step.get();
    }

    private void setStep(double value) {
        step.set(value);
    }

    private DoubleProperty stepProperty() {
        return step;
    }
    
    private final DoubleProperty max;

    private double getMax() {
        return max.get();
    }

    private void setMax(double value) {
        max.set(value);
    }

    private DoubleProperty maxProperty() {
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
