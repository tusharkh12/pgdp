package pgdp.sim;

public class Plant implements Cell {
    private long growth;

    public Plant() {
        this.growth = 0;
    }

    @Override
    public int priority() {
        return 0;
    }

    @Override
    public CellSymbol getSymbol() {
        return CellSymbol.PLANT;
    }

    @Override
    public void tick(Cell[] cells, Cell[] newCells, int width, int height, int x, int y) {
//       newCells[x]=this;
//       newCells[y]=this;
        newCells[x + y * width] = this;
        growth = growth + RandomGenerator.nextInt(SimConfig.plantMinGrowth, SimConfig.plantMaxGrowth);

        while (growth >= SimConfig.plantReproductionCost ) {
            if ((new Plant()).place(cells, newCells, width, height, x, y)) {
                growth = growth - SimConfig.plantReproductionCost;
            }
            else break;
        }

    }


}
