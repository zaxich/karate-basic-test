package org.example;

import java.time.Year;

class Vehicle {
    String brandName = "Volvo";
    String model = "V-12";

    int year;

    public Vehicle(int yearParam) throws InvalidYearException {
        year = yearParam;
        yearCalculation();
    }

    //overloading constructor
    public Vehicle(int yearParam, String brand, String modelType) throws InvalidYearException {
        year = yearParam;
        brandName = brand;
        model = modelType;
        yearCalculation();
    }

    public void yearCalculation() throws InvalidYearException {
        int currYear = Year.now().getValue();

        if (year > currYear) {
            throw new InvalidYearException("Year: " + year + " is invalid as it's bigger than current year (" + currYear + ")");
        }
    }

    public void vehicleSound() {
        System.out.println("honk honk, the vehicle's brand is " + brandName + " with model: " + model);
    }
}

class Motorcycle extends Vehicle {
    boolean hasSideCars = false;

    public Motorcycle(int yearParam) throws InvalidYearException {
        super(yearParam);
    }

    //overloading constructor
    public Motorcycle(int yearParam, boolean sideCar) throws InvalidYearException {
        super(yearParam);
        hasSideCars = sideCar;
    }

    @Override
    public void vehicleSound() {
        System.out.println("beep beep, the motorcycle side car type is: " + hasSideCars);
    }
}

class Car extends Vehicle {
    int numOfDoors = 4;

    public Car(int yearParam) throws InvalidYearException {
        super(yearParam);
    }

    //overloading constructor
    public Car(int yearParam, int door) throws InvalidYearException {
        super(yearParam);
        numOfDoors = door;
    }

    @Override
    public void vehicleSound() {
        System.out.println("noot noot, the car has " + numOfDoors + " doors");
    }
}

//custom checked exception
class InvalidYearException extends Exception {
    public InvalidYearException(String message) {
        super(message);
    }
}

public class PracticalAssessment3 {
    public static void main(String[] args) throws InvalidYearException {
        Vehicle vehicle = new Vehicle(2010);
        vehicle.vehicleSound();

        Vehicle vehicle2 = new Vehicle(2010, "Ford", "F-123");
        vehicle2.vehicleSound();

        Vehicle motorcycle = new Motorcycle(2015);
        motorcycle.vehicleSound();

        Vehicle motorcycle2 = new Motorcycle(2015, true);
        motorcycle2.vehicleSound();

        //exception for invalid year
        boolean exceptionThrown = false;
        try {
            Vehicle car = new Car(3000);
            car.vehicleSound();
        } catch (InvalidYearException e) {
            exceptionThrown = true;
            System.out.println("Caught invalid year exception: " + e.getMessage());
        } finally {
            String message = "successfully";
            if (exceptionThrown)
                message = "failed to be";

            System.out.println("Car object is " + message + " created");
        }

        Vehicle car2 = new Car(2023, 2);
        car2.vehicleSound();

        Vehicle car3 = new Car(2023);
        car3.vehicleSound();
    }
}
