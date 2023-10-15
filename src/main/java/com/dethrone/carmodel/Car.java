/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dethrone.carmodel;

/**
 *
 * @author alkam
 */
public class Car {
    private int registrationNumber;
    private String brand;
    private int year;
    private String licenseNumber;

    public Car(int registrationNumber, String brand, int year, String licenseNumber) {
        this.registrationNumber = registrationNumber;
        this.brand = brand;
        this.year = year;
        this.licenseNumber = licenseNumber;
    }

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public void moveForward() {
        System.out.println("Car moving forward");
    }

    public void moveBackward() {
        System.out.println("Car moving backward");
    }

    public void turnLeft() {
        System.out.println("Car turning left");
    }

    public void turnRight() {
        System.out.println("Car turning right");
    }

    public void stop() {
        System.out.println("Car stopped");
    }
}
