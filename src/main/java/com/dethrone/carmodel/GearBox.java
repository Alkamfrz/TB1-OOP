/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dethrone.carmodel;

/**
 *
 * @author alkam
 */

public class GearBox {
    private int currentGear;
    private float gearRatio;
    private boolean isClutchPressed;

    public GearBox(int currentGear, float gearRatio, boolean isClutchPressed) {
        this.currentGear = currentGear;
        this.gearRatio = gearRatio;
        this.isClutchPressed = isClutchPressed;
    }

    public int getCurrentGear() {
        return currentGear;
    }

    public float getGearRatio() {
        return gearRatio;
    }

    public boolean isIsClutchPressed() {
        return isClutchPressed;
    }

    public void setCurrentGear(int currentGear) {
        this.currentGear = currentGear;
    }

    public void setGearRatio(float gearRatio) {
        this.gearRatio = gearRatio;
    }

    public void setIsClutchPressed(boolean isClutchPressed) {
        this.isClutchPressed = isClutchPressed;
    }

    public void shiftUp(GearBoxType gearBoxType) {
        if (isClutchPressed) {
            int numGears = gearBoxType.getNumberOfGears();
            if (currentGear < numGears) {
                currentGear++;
                System.out.println("Shifted up to gear " + currentGear);
            } else if (currentGear == numGears && gearBoxType == GearBoxType.REVERSE) {
                currentGear = 1;
                System.out.println("Shifted up to reverse gear");
            } else {
                System.out.println("Cannot shift up, already in highest gear.");
            }
        } else {
            System.out.println("Cannot shift up, clutch not pressed.");
        }
    }
    
    public void shiftDown() {
        if (isClutchPressed) {
            if (currentGear > 1) {
                currentGear--;
                System.out.println("Shifted down to gear " + currentGear);
            } else if (currentGear == 1) {
                currentGear = GearBoxType.REVERSE.getNumberOfGears();
                System.out.println("Shifted down to reverse gear");
            } else {
                System.out.println("Cannot shift down, already in lowest gear.");
            }
        } else {
            System.out.println("Cannot shift down, clutch not pressed.");
        }
    }

    public void pressClutch() {
        this.isClutchPressed = true;
        System.out.println("Clutch pressed");
    }

    public void releaseClutch() {
        this.isClutchPressed = false;
        System.out.println("Clutch released");
    }
}