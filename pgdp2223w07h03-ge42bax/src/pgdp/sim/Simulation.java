package pgdp.sim;

import java.util.Arrays;

public class Simulation {
    private Cell[] cells;
    private int width;
    private int height;

    public Simulation(Cell[] cells, int width, int height) {
        this.width = width;
        this.height = height;
        this.cells = cells;
    }


    /**
     * Simuliert einen Tick des Spiels:
     * Erst nehmen alle MovingCells Nahrung zu sich,
     * dann wird auf allen Cells die tick()-Methode aufgerufen.
     */
    public void tick() {
        Cell[] copyOfCells = new Cell[cells.length];
       System.arraycopy(cells,0,copyOfCells,0,copyOfCells.length);
//      copyOfCells= Arrays.copyOf(cells,cells.length);
///       Arrays.copyOf()
//        for (int i = 0; i < copyOfCells.length; i++) {
//
//        }

        for (int i = 0; i < cells.length; i++) {
            int x = i % width;
            int y = i / width;
            if (cells[i] instanceof MovingCell) {
                ((MovingCell) cells[i]).eat(cells, copyOfCells, width, height, x, y);
            }
        }
        for (int i = 0; i < cells.length; i++) {
            this.cells[i] = null;
        }
        for (int i = 0; i < copyOfCells.length; i++) {
            int x = i % width;
            int y = i / width;
           if (copyOfCells[i] != null) {
               copyOfCells[i].tick(copyOfCells,cells,width,height,x,y);

           }
        }
//        System.arraycopy(copyOfCells,0,cells,0,cells.length);
//
//        System.out.println("SIM");
//        System.out.println(Arrays.toString(cells));
//        System.out.println(Arrays.toString(copyOfCells));
//        for (int i = 0; i < copyOfCells.length; i++) {
//            if(cells[i]==null){
//                cells[i]=copyOfCells[i];
//            }
//        }

        // TODO: Diese Methode implementieren
    }


    public Cell[] getCells() {
        return cells;
    }

    public void setCells(Cell[] cells) {
        this.cells = cells;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
