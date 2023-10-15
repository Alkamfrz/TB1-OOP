/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dethrone.carmodel;

/**
 *
 * @author alkam
 */
public class Body {
    private int numberOfDoors;
    private String color;
    private String remarks;

    public Body(int numberOfDoors, String color, String remarks) {
        this.numberOfDoors = numberOfDoors;
        this.color = color;
        this.remarks = remarks;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public String getColor() {
        return color;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public void openDoor() {
        System.out.println("Door opened");
    }

    public void closeDoor() {
        System.out.println("Door closed");
    }
}
