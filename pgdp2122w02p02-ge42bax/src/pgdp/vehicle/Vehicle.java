package pgdp.vehicle;

public class Vehicle {
    private int seats;
    private int vehicleNumber;
    private String licensePlate;
    private double currentPosition;

    private FuelTank fuelTank;
    private Engine engine;

    public Vehicle(int seats, int vehicleNumber, String licensePlate, String engineModel, double engineCapacity,
                   double engineFuelConsumption) {
        this.seats = seats;
        this.vehicleNumber = vehicleNumber;
        this.licensePlate = licensePlate;

        this.currentPosition = 0.0;

        this.fuelTank = new FuelTank();
        this.engine = new Engine(engineModel, engineCapacity, engineFuelConsumption);
    }

    public double getCurrentPosition() {
        return currentPosition;
    }

    public double fillUpTank(double amount) {
        return fuelTank.fillUp(amount);
    }

    public void drive(double fuelToUse) {
        fuelTank.letFuelOut(fuelToUse);
        double distance = engine.burnFuel(fuelToUse);
        currentPosition += distance;
    }
@Override
    public String toString()  {
        return "Fahrzeug #" + vehicleNumber + " mit Kennzeichen " + licensePlate + " hat " + seats
                + " Sitzplätze.\nTank: " + fuelTank.toString() + "\nMotor: " + engine.toString();
    }
}
