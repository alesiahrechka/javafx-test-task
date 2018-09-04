package by.ales.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Person {

    private String firstName;
    private String lastName;
    private String role;
//    private int counter;

    private IntegerProperty counter;

    public Person() {
        this.counter = new SimpleIntegerProperty();
    }

    public Person(String firstName, String lastName, String role, int counter) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
//        this.counter = counter;
        this.counter = new SimpleIntegerProperty(counter);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getCounter() {
        return counter.get();
    }

    public void setCounter(int counter) {
        this.counter.setValue(counter);
    }

    public IntegerProperty counterProperty() {
        return counter;
    }
}
