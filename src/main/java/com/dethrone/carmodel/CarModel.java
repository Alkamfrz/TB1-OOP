/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.dethrone.carmodel;

import java.util.Scanner;

/**
 *
 * @author alkam
 */
public class CarModel {
    private Engine engine;
    private GearBox gearBox;
    private GearBoxType gearBoxType;
    private Body body;
    private Brake brake;
    private Suspension suspension;
    private Tire tire;
    private String title;
    private byte attribute;

    public CarModel(String title, byte attribute) {
        this.title = title;
        this.attribute = attribute;
    }

    public String getTitle() {
        return title;
    }

    public byte getAttribute() {
        return attribute;
    }

    public void operate(Car car) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("1. Start engine");
            System.out.println("2. Stop engine");
            System.out.println("3. Accelerate");
            System.out.println("4. Brake");
            System.out.println("5. Shift gear");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    engine.start();
                    break;
                case 2:
                    engine.stop();
                    break;
                case 3:
                    engine.accelerate(gearBox, car);
                    break;
                case 4:
                    engine.brake(brake);
                    break;
                case 5:
                    switch (gearBoxType) {
                        case MANUAL:
                            System.out.print("Enter gear: ");
                            int gear = scanner.nextInt();
                            car.shiftGear(gear);
                            break;
                        case AUTOMATIC:
                            car.shiftGear();
                            break;
                        default:
                            System.out.println("Invalid choice");
                    }
                    break;
                default:
                    System.out.println("Invalid choice");
            }

    public static void main(String[] args) {
        Tire tire = new Tire(205, 32);
        Suspension suspension = new Suspension(100);
        Brake brake = new Brake("Disc", "ABS");
        Body body = new Body(4, "Red", "Sedan");
        Engine engine = new Engine(4.0f, 6, 0, false);
        GearBox gearBox = new GearBox(0, 1.0f, false);
        GearBoxType gearBoxType = GearBoxType.MANUAL;
        Car car = new Car(1234, "Toyota", 2021, "ABC123");
        CarModel carModel = new CarModel("Toyota Camry", (byte) 0);
        carModel.operate(car);
    }
}