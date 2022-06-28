import java.util.Scanner;

public class Car {
  
String model;
double milesPerGallon;
double tankCapacity;
double gasRemaining;

    public Car(String model, double mpg, double gasTankCapacity) {
      this.model = model;
      this.milesPerGallon = mpg;
      this.tankCapacity = gasTankCapacity;
      this.gasRemaining = 0.0;
    }

    public static void main(String[] args) {
        // Create a new Car object, asking the user (using the scanner class) for the model, mpg, and gasTankCapacity
        Scanner sc = new Scanner(System.in);
        System.out.print("Model: ");
        String model = sc.nextLine();
        System.out.print("MPG: ");
        double mpg = sc.nextDouble();
        System.out.print("Gas Tank Capacity: ");
        double gasTankCapacity = sc.nextDouble();
        Car car = new Car(model, mpg, gasTankCapacity);

        // Refuel the car to its maximum gas capacity
        car.refuel(gasTankCapacity);

        // Print out car information
        System.out.println(car);

        // Ask the user how many miles they want to drive, then drive that distance, and then report back the car's remaining gas and range after the drive.
        System.out.print("How many miles do you want to drive? ");
        double miles = sc.nextDouble();
        car.drive(miles);
        System.out.println("Remaining Gas: " + car.getGasRemaining() + " gallons, Remaining Range: " + car.getRange() + " miles.");

        // Ask the user how much gas they want to add, and then refuel the car that amount
        System.out.print("How many gallons of gas do you want to add? ");
        double gas = sc.nextDouble();
        car.refuel(gas);

        // Ask the user how many miles they want to drive, then drive that distance, and then report back the car's remaining gas and range after the drive.
        System.out.print("How many miles do you want to drive? ");
        miles = sc.nextDouble();
        car.drive(miles);
        System.out.println("Remaining Gas: " + car.getGasRemaining() + " gallons, Remaining Range: " + car.getRange() + " miles.");
    }

    public void drive(double distance) {
        // drive for distance (in miles), and update gas tank level accordingly (using mpg)
      if(distance < 0) {
        
        if(distance * (-1) > this.milesPerGallon * this.gasRemaining) {
          System.out.println("Your car ran out of gas after driving " + this.getRange() + " miles back.");
          this.gasRemaining = 0;
        } else {
          this.gasRemaining -= (distance * (-1) / this.milesPerGallon);
          System.out.println("Drove " + (distance * (-1)) + " miles back.");
        }
        
      } else if(distance > 0) {
        if(distance > this.gasRemaining * this.milesPerGallon) {
          System.out.println("Your car ran out of gas after driving " + this.getRange() + " miles.");
          this.gasRemaining = 0;
        } else {
          this.gasRemaining -= distance / this.milesPerGallon;
          System.out.println("Drove " + distance + " miles.");
        }
        
      }
    }

    public void refuel(double gasAmount) {
        // Add gasAmount of gas to the gas tank
      if((this.gasRemaining + gasAmount) > this.tankCapacity) {
        System.out.println("You have overfilled the gas tank and gas is likely puddling around your car.");
        this.gasRemaining = this.tankCapacity;
      } else if(gasAmount < 0) {
        System.out.println("If you wanted to remove gas from the tank, you should have used the drive method.");
      } else {
        this.gasRemaining += gasAmount;
        System.out.println("Added " + gasAmount + " gallons to the tank.");
      }
    }

    public double getGasRemaining() {
        // Return the number of gallons of gas currently in the gas tank
      return this.gasRemaining;
    }

    public double getRange() {
        // Return the estimated amount of miles the car can drive based on current gas remaining and MPG (provided to constructor)
      return(this.gasRemaining * this.milesPerGallon);
    }

    public String toString() {
        // Return a string representation of the car's current state.
        // Be sure to include range, model, and gas level.
      return("This is a " + this.model + " car, with a current gas level of " + this. gasRemaining + " gallons and a remaining range of " + (this.gasRemaining * this.milesPerGallon) + " miles.");
    }
}
