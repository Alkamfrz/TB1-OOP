/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dethrone.carmodel;

/**
 *
 * @author alkam
 */

public enum GearBoxType {
    MANUAL(5),
    AUTOMATIC(6),
    SEMI_AUTOMATIC(7),
    CVT(8),
    DCT(9),
    REVERSE(1);

    private final int numberOfGears;
    private String name;
    private String remarks;

    GearBoxType(int numberOfGears) {
        this.numberOfGears = numberOfGears;
    }

    private GearBoxType(String name, String remarks, int numberOfGears) {
        this.name = name;
        this.remarks = remarks;
        this.numberOfGears = numberOfGears;
    }

    public String getName() {
        return name;
    }

    public String getRemarks() {
        return remarks;
    }

    public int getNumberOfGears() {
        return numberOfGears;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}