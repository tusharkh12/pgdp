package pgdp.sim;

public class Pingu extends MovingCell {


    @Override
    public boolean canEat(Cell other) {
        return (other instanceof Plant);
    }

    @Override
    public int foodConsumption() {
        return SimConfig.pinguFoodConsumption;
    }

    @Override
    public int consumedFood() {
        return SimConfig.pinguConsumedFood;
    }

    @Override
    public int reproductionCost() {
        return SimConfig.pinguReproductionCost;
    }

    @Override
    public int initialFood() {
        return SimConfig.pinguInitialFood;
    }

    @Override
    public Cell getNew() {
        return new Pingu();
    }

    @Override
    public CellSymbol getSymbol() {
        return CellSymbol.PINGU;
    }
}


