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

public class LoadPoint {

    public LoadPoint(String name,double torque, double rpm) {
        this.torque.set(torque);
        this.Name.set(name);
        this.rpm.set(rpm);
    }
    private final DoubleProperty torque = new SimpleDoubleProperty();

    public double getTorque() {
        return torque.get();
    }

    public void setTorque(double value) {
        torque.set(value);
    }

    public DoubleProperty TorqueProperty() {
        return torque;
    }
    
    private DoubleProperty rpm = new SimpleDoubleProperty();

    public double getRPM() {
        return rpm.get();
    }

    public void setRPM(double value) {
        rpm.set(value);
    }

    public DoubleProperty RPMProperty() {
        return rpm;
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
