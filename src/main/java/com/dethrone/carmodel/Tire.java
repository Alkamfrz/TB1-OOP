/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dethrone.carmodel;

/**
 *
 * @author alkam
 */
public class Tire {
    private float width;
    private float airPressure;

    public Tire(float width, float airPressure) {
        this.width = width;
        this.airPressure = airPressure;
    }

    public float getWidth() {
        return width;
    }

    public float getAirPressure() {
        return airPressure;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public void setAirPressure(float airPressure) {
        this.airPressure = airPressure;
    }
}
