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
        Tire tire = new Tire(205, 32);
        Suspension suspension = new Suspension(100);
        Brake brake = new Brake("Disc", "ABS");
        Body body = new Body(4, "Red", "Sedan");
        Engine engine = new Engine(4.0f, 6, 0, false);
        GearBox gearBox = new GearBox(0, 1.0f, false);
        GearBoxType gearBoxType = GearBoxType.MANUAL;
        try (Scanner scanner = new Scanner(System.in)) {
            int mainchoice = 0;
            int movechoice = 0;
            int gearChoice = 0;
            boolean exit = false;
            while (!exit) {
                System.out.println("1. Start engine");
                System.out.println("2. Stop engine");
                System.out.println("3. Car Movement");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                mainchoice = scanner.nextInt();
                switch (mainchoice) {
                    case 1:
                        engine.start();
                        break;
                    case 2:
                        engine.stop();
                        break;
                    case 3:
                        boolean backToMain = false;
                        while (!backToMain) {
                            System.out.println("1. Accelerate");
                            System.out.println("2. Brake");
                            System.out.println("3. Reverse");
                            System.out.println("4. Turn left");
                            System.out.println("5. Turn right");
                            System.out.println("6. Change gear");
                            System.out.println("7. Back to main menu");
                            System.out.print("Enter your choice: ");
                            movechoice = scanner.nextInt();
                            switch (movechoice) {
                                case 1:
                                    engine.accelerate(gearBox, car, gearBoxType);
                                    break;
                                case 2:
                                    engine.brake(brake);
                                    break;
                                case 3:
                                    car.moveBackward();
                                    engine.accelerate(gearBox, car, GearBoxType.REVERSE);
                                    break;
                                case 4:
                                    car.turnLeft();
                                    break;
                                case 5:
                                    car.turnRight();
                                    break;
                                case 6:
                                    boolean backToMove = false;
                                    while (!backToMove) {
                                        System.out.println("1. Shift up");
                                        System.out.println("2. Shift down");
                                        System.out.println("3. Press clutch");
                                        System.out.println("4. Release clutch");
                                        System.out.println("5. Back to movement menu");
                                        System.out.print("Enter your choice: ");
                                        gearChoice = scanner.nextInt();
                                        switch (gearChoice) {
                                            case 1:
                                                gearBox.shiftUp(gearBoxType);
                                                break;
                                            case 2:
                                                gearBox.shiftDown();
                                                break;
                                            case 3:
                                                gearBox.pressClutch(engine);
                                                break;
                                            case 4:
                                                gearBox.releaseClutch();
                                                break;
                                            case 5:
                                                backToMove = true;
                                                break;
                                            default:
                                                System.out.println("Invalid choice");
                                        }
                                    }
                                    break;
                                case 7:
                                    backToMain = true;
                                    break;
                                default:
                                    System.out.println("Invalid choice");
                            }
                        }
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
            }
        }
    }



    public static void main(String[] args) {
        Car car = new Car(1234, "Toyota", 2021, "ABC123");
        CarModel carModel = new CarModel("Toyota Camry", (byte) 0);
        carModel.operate(car);
    }
}