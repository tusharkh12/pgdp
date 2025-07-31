package pgdp.vehicle;

public class FuelTank {
    private double fillLevel;

    public double getFillLevel() {
        return fillLevel;
    }

    public double fillUp(double amount) {
        fillLevel += amount;
        return fillLevel;
    }

    public double letFuelOut(double amount) {
        fillLevel -= amount;
        return fillLevel;
    }

    @Override
    public String toString() {
        return "Der Füllstand beträgt " + fillLevel + " Einheiten.";
    }
}


