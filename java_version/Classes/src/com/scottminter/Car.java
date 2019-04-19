package com.scottminter;

public class Car {

    private int doors;
    private int wheels;
    private String model;
    private String engine;
    private String color;

    public Car() {
        doors = 0;
        wheels = 0;
        model = "";
        engine = "";
        color = "";
    }

    public Car(int doors, int wheels, String model, String engine, String color) {
        this.doors = doors;
        this.wheels = wheels;
        this.model = model;
        this.engine = engine;
        this.color = color;
    }

    public int getDoors() {
        return this.doors;
    }

    public int getWheels() {
        return this.wheels;
    }

    public String getModel() {
        return this.model;
    }

    public String getEngine() {
        return this.engine;
    }

    public String getColor() {
        return this.engine;
    }

    public void printer() {
        System.out.println(
            "doors: " + this.doors
            + "\nwheels: " + this.wheels
            + "\nmodel: " + this.model
            + "\nengine: " + this.engine
            + "\ncolor: " + this.color
        );
    }
}
