/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dethrone.carmodel;

/**
 *
 * @author alkam
 */
public class Brake {
    private String type;
    private String remarks;

    public Brake(String type, String remarks) {
        this.type = type;
        this.remarks = remarks;
    }

    public String getType() {
        return type;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public void apply() {
        System.out.println("Brake applied");
    }
}
