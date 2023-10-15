/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dethrone.carmodel;

/**
 *
 * @author alkam
 */
public class Suspension {
    private float springRate;

    public Suspension(float springRate) {
        this.springRate = springRate;
    }

    public float getSpringRate() {
        return springRate;
    }

    public void setSpringRate(float springRate) {
        this.springRate = springRate;
    }
}
