package pgdp.vehicle;

public class Engine{

    private String model;
    private double capacity;
    private double fuelConsumption;

    public Engine(String model, double capacity, double fuelConsumption) {
        this.model = model;
        this.capacity = capacity;
        this.fuelConsumption = fuelConsumption;
    }

    public double burnFuel(double amount) {
        return fuelConsumption * amount / 2;
    }

@Override
    public String toString()  {
        return "Motor des Models " + model + " hat eine Kapazität von " + capacity + " und verbraucht "
                + fuelConsumption + " Litres.";
    }
}