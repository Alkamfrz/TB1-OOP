package com.dethrone.carmodel;

public class Engine {
    private float capacity;
    private int cylinders;
    private int rpm;
    private boolean isRunning;
    private int minRpm;

    public Engine(float capacity, int cylinders, int rpm, boolean isRunning) {
        this.capacity = capacity;
        this.cylinders = cylinders;
        this.rpm = rpm;
        this.isRunning = isRunning;
        this.minRpm = rpm;
    }

    public float getCapacity() {
        return capacity;
    }

    public int getCylinders() {
        return cylinders;
    }

    public int getRpm() {
        return rpm;
    }

    public boolean isIsRunning() {
        return isRunning;
    }

    public void setCapacity(float capacity) {
        this.capacity = capacity;
    }

    public void setCylinders(int cylinders) {
        this.cylinders = cylinders;
    }

    public void setRpm(int rpm) {
        this.rpm = rpm;
    }

    public void setIsRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public void start() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        if (this.isRunning) {
            System.out.println("Engine already running");
        } else {
            this.isRunning = true;
            this.rpm = 1000;
            this.minRpm = 1000;
            System.out.println("Engine started");
        }
    }

    public void stop() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        if (!this.isRunning) {
            System.out.println("Engine already stopped");
        } else {
            this.isRunning = false;
            this.rpm = 0;
            this.minRpm = 0;
            System.out.println("Engine stopped");
        }
    }

    public void brake(Brake brake) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        brake.apply();
        System.out.println("Braking");
        if (this.rpm > this.minRpm) {
            this.rpm -= 1000;
        } else {
            System.out.println("You are already stationary");
        }
    }

    public void accelerate(GearBox gearBox, Car car) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        if (!gearBox.isIsClutchPressed()) {
            if (car.getRegistrationNumber() == 0) {
                System.out.println("Cannot move forward, car not registered");
            } else if (gearBox.getCurrentGear() == 0) {
                System.out.println("Cannot move forward, gear in neutral");
            } else {
                System.out.println("Accelerating");
                int maxRpm = (int) (this.capacity * this.cylinders * 1000);
                if (this.rpm < maxRpm) {
                    this.rpm += 1000;
                    car.moveForward();
                } else {
                    System.out.println("Cannot accelerate, max RPM reached");
                }
            }
        } else {
            System.out.println("Cannot accelerate, clutch is pressed");
        }
    }
}