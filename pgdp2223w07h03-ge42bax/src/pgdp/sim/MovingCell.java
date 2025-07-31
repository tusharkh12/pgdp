package pgdp.sim;

public abstract class MovingCell implements Cell {
    private long food;

    public MovingCell() {
        this.food = initialFood();
    }

    public abstract boolean canEat(Cell other);

    public abstract int foodConsumption();

    public abstract int consumedFood();

    public abstract int reproductionCost();

    public abstract int initialFood();

    public abstract Cell getNew();

    @Override
    public int priority() {
        return 1;
    }

    //  @Override
//    public CellSymbol getSymbol() {
//        return null;
//    }

    @Override
    public void tick(Cell[] cells, Cell[] newCells, int width, int height, int x, int y) {
        if (x > width - 1 || y > height - 1) {
            return;
        }


        Cell cell = getNew();
        if (food >= reproductionCost()) {
            if (cell.place(cells, newCells, width, height, x, y)) {


                // System.out.println((getNew()).place(cells, newCells, width, height, x, y));
                food = initialFood();
            }
        }
        food = food - foodConsumption();

        if (food >= 0) {
            move(cells, newCells, width, height, x, y);
        }


    }



    public void move(Cell[] cells, Cell[] newCells, int width, int height, int x, int y) {
        int index = width * y + x;
        int random = RandomGenerator.nextInt(0, 9);
        int newX = x + ((random % 3) - 1);
        int newY;
        //CHECK IF new y is in 1st line 2nd or 3rd
        if (random < 3) {
            newY = y - 1;
        } else if (random < 6) {
            newY = y;
        } else {
            newY = y + 1;
        }
        int newIndex = (width * newY) + newX;


        if (newX < 0 || newY < 0 || newX >= width || newY >= height || cells[newIndex] != null || newCells[newIndex] != null) {
            newCells[index] = this;
        }
        else if (cells[newIndex] == null && newCells[newIndex] == null) {
            newCells[newIndex] = this;
            cells[index] = null;

        }
    }


    public void eat(Cell[] cells, Cell[] newCells, int width, int height, int x, int y) {
        if (x > width - 1 || y > height - 1) {
            // System.out.println("aa");
            return;
        }
//        System.out.println(Arrays.toString(cells));
//        System.out.println(Arrays.toString(newCells));
        //System.out.println("aaa");

        int index = x + y * width;
        int value = 0;

        int[] array = new int[9];
//        // LEFT RAND
        if (index % width == 0) {
            // left = true;
            for (int i = 0; i < array.length; i++) {
                if (i == 0 || i == 3 || i == 6) {
                    array[i] = Integer.MIN_VALUE;
                } else if (i == 1) {
                    array[i] = index - width;
                } else if (i == 2) {
                    array[i] = index - width + 1;
                } else if (i == 4) {
                    array[i] = index;
                } else if (i == 5) {
                    array[i] = index + 1;
                } else if (i == 7) {
                    array[i] = index + width;
                } else if (i == 8) {
                    array[i] = index + width + 1;
                }
            }
        }

        // RIGHT RAND
        else if ((index % width) == (width - 1)) {
            //  right = true;
            for (int i = 0; i < array.length; i++) {
                if (i == 2 || i == 5 || i == 8) {
                    array[i] = Integer.MIN_VALUE;
                } else if (i == 0) {
                    array[i] = index - width - 1;
                } else if (i == 1) {
                    array[i] = index - width;
                } else if (i == 4) {
                    array[i] = index;
                } else if (i == 3) {
                    array[i] = index - 1;
                } else if (i == 6) {
                    array[i] = index + width - 1;
                } else if (i == 7) {
                    array[i] = index + width;
                }
            }
        } else {
            array[0] = index - (width + 1);
            array[1] = index - width;
            array[2] = index - (width - 1);
            array[3] = index - 1;
            array[4] = index;
            array[5] = index + 1;
            array[6] = index + (width - 1);
            array[7] = index + (width);
            array[8] = index + width + 1;
        }
        //  System.out.println(Arrays.toString(array));


        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0 || array[i] >= cells.length || i == 4) {
                // return;

            } else if (canEat(cells[array[i]])) {
                newCells[array[i]] = null;
                food = food + consumedFood();
            }

        }
//        System.out.println(Arrays.toString(cells));
//        System.out.println(Arrays.toString(newCells));


    }

    public long getFood() {
        return food;
    }

    public void setFood(long food) {
        this.food = food;
    }

//    public static void main(String[] args) {
//        MovingCell movingCell = new Hamster();
//        Pingu pingu = new Pingu();
//        Plant plant1 = new Plant();
//        Plant plant2 = new Plant();
//        Hamster ham = new Hamster();
//        Wolf wolf = new Wolf();
//
//        movingCell.move(new Cell[]{null, null, null,
//                null, null, null,
//                wolf, null, null}, new Cell[9], 3, 3, 0, 2);
//        // System.out.println(movingCell);
//
//
//    }
}
