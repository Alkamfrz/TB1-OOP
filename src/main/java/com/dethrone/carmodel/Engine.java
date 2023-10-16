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

    public int getMinRpm() {
        return minRpm;
    }

    public void updateRpm(int rpm) {
        this.rpm = rpm;
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
        if (this.rpm == 0) {
            this.rpm = this.minRpm;
        }
    }

    public void accelerate(GearBox gearBox, Car car, GearBoxType gearBoxType) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        if (!gearBox.isIsClutchPressed()) {
            if (gearBox.getCurrentGear() == 0) {
                System.out.println("Cannot move, gear in neutral");
            } else {
                int maxRpm = gearBoxType.getNumberOfGears() * 1000;
                if (gearBoxType == GearBoxType.REVERSE) {
                    car.moveBackward();
                } else {
                    car.moveForward();
                }
                int increment = 1000;
                while (this.rpm <= maxRpm) {
                    this.rpm += increment;
                    updateRpm(this.rpm);
                    System.out.println("Accelerating... RPM: " + this.rpm);
                    System.out.println("GearBoxType: " + gearBoxType);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Max RPM reached");
                updateRpm(this.rpm);
            }
        } else {
            System.out.println("Cannot accelerate, clutch is pressed");
        }
    }
}