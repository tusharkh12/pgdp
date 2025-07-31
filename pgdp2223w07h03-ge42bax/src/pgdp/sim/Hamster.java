package pgdp.sim;

public class Hamster extends MovingCell {
    @Override
    public boolean canEat(Cell other) {
        return (other instanceof Plant);
    }

    @Override
    public int foodConsumption() {
        return SimConfig.hamsterFoodConsumption;
    }

    @Override
    public int consumedFood() {
        return SimConfig.hamsterConsumedFood;
    }

    @Override
    public int reproductionCost() {
        return SimConfig.hamsterReproductionCost;
    }

    @Override
    public int initialFood() {
        return SimConfig.hamsterInitialFood;
    }

    @Override
    public Cell getNew() {
        return new Hamster();
    }

    @Override
    public CellSymbol getSymbol() {
        return CellSymbol.HAMSTER;
    }
}
