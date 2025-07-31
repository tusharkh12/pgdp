package pgdp.chess;

import java.util.Arrays;

public class GameBoard {
    private int sizeX;
    private int sizeY;
    private char[][] boardArray;


    public GameBoard(int sizeX, int sizeY) {
        if (sizeX > 0 && sizeX <= 100 && sizeY > 0 && sizeY <= 100) {
            this.sizeX = sizeX;
            this.sizeY = sizeY;
            this.boardArray = new char[sizeY][sizeX];
            for (int i = 0; i < sizeY; i++) {
                for (int j = 0; j < sizeX; j++) {
                    boardArray[i][j] = ' ';
                }
            }
        } else {

        }

    }


    public static GameBoard newDefault() {
        GameBoard gameBoard = new GameBoard(8, 16);  //recalling the constructor

        //Teamchicks

        //Row 1 y=0
        gameBoard.set(0, 0, 'Z');
        gameBoard.set(1, 0, 'F');
        gameBoard.set(2, 0, 'F');
        gameBoard.set(3, 0, 'K');
        gameBoard.set(4, 0, 'C');
        gameBoard.set(5, 0, 'F');
        gameBoard.set(6, 0, 'F');
        gameBoard.set(7, 0, 'Z');

        //Row 2 y=1
        gameBoard.set(2, 1, 'Z');
        gameBoard.set(3, 1, 'Z');
        gameBoard.set(4, 1, 'Z');
        gameBoard.set(5, 1, 'Z');


        //TeamaustralianSeaLions

        //Row 16 & y=15

        gameBoard.set(0, 15, 'S');
        gameBoard.set(1, 15, 'O');
        gameBoard.set(2, 15, 'O');
        gameBoard.set(3, 15, 'A');
        gameBoard.set(4, 15, 'E');
        gameBoard.set(5, 15, 'O');
        gameBoard.set(6, 15, 'O');
        gameBoard.set(7, 15, 'S');

        //Row 15 & y=14
        gameBoard.set(2, 14, 'S');
        gameBoard.set(3, 14, 'S');
        gameBoard.set(4, 14, 'S');
        gameBoard.set(5, 14, 'S');


        return gameBoard;
    }

    public char get(int x, int y) {

        char piece;
        if (x >= 0 && x < sizeX && y >= 0 && y < sizeY) {
            piece = boardArray[y][x];      //0...99//get the piece
            return piece;
        } else {
            return '\0';
        }
    }

    public boolean set(int x, int y, char piece) {
        if (x >= 0 && x < sizeX && y >= 0 && y < sizeY) {
            boardArray[y][x] = piece;
            return true;
        } else {
            return false;
        }
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public int evaluateWinner() {
        boolean chicks = false;
        boolean australianSeaLion = false;
        for (int i = 0; i < sizeY;  i++) {
            for (int j = 0; j < sizeX; j++) {
                if (get(j, i) == 'C' ) {
                    chicks = true;
                }

                if (get(j, i) == 'A') {
                    australianSeaLion = true;
                }
            }

        }

        if (chicks == true && australianSeaLion == true) {
            return 0;
        } else {
            if (chicks == true && australianSeaLion == false) {
                return 1;
            } else {
                if ((chicks == false && australianSeaLion == true)) {
                    return 2;
                } else {
                    return -1;
                }

            }

        }
    }

    /*public static void printGameBoard(char[][] boardArray){
        System.out.println("");
        for(char[]sizeY:boardArray)

            System.out.println(Arrays.toString(sizeY));
    }*/


//    public static void main(String[] args){
//        GameBoard g = new GameBoard(2, 4);
//        System.out.println(g.boardArray[3][1]);
//        GameBoard f = GameBoard.newDefault();
//        System.out.println(f.evaluateWinner());
//     }






    }

