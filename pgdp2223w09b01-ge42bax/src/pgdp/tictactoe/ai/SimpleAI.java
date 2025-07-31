//package pgdp.tictactoe.ai;
//
//import java.util.Random;
//
//import pgdp.tictactoe.Field;
//import pgdp.tictactoe.Move;
//import pgdp.tictactoe.PenguAI;
//
//
//public class SimpleAI extends PenguAI {
//
//    private Random random;
//
//    public SimpleAI() {
//        random = new Random();
//    }
//
//    @Override
//    public Move makeMove(Field[][] board, boolean firstPlayer, boolean[] firstPlayedPieces,
//            boolean[] secondPlayedPieces) {
//        return new Move(random.nextInt(board.length), random.nextInt(board.length),
//                random.nextInt(firstPlayedPieces.length));
//    }
//}
package pgdp.tictactoe.ai;

import pgdp.tictactoe.Field;
import pgdp.tictactoe.Game;
import pgdp.tictactoe.Move;
import pgdp.tictactoe.PenguAI;

import java.util.Arrays;
import java.util.Random;


public class SimpleAI extends PenguAI {
    private Random random;

    public SimpleAI() {
        random = new Random() ;
    }

    @Override
    public Move makeMove(Field[][] board, boolean firstPlayer, boolean[] firstPlayedPieces, boolean[] secondPlayedPieces) {
        int value = 8;
        boolean[] check = firstPlayer ? firstPlayedPieces : secondPlayedPieces;
        boolean player = firstPlayer;
        while (true) {
            if (value <= 0) {
                break;
            }
            if (check[value]) {
                value--;
            } else {
                break;
            }
        }

        Field[][] temp = Arrays.copyOf(board, board.length);
        Field obj = null;
        boolean reset = false;

        // Check if the AI can win directly
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == null || (board[i][j].firstPlayer() == !firstPlayer && value > board[i][j].value())) {
                    if (board[i][j] != null) {
                        obj = new Field(board[i][j].value(), !firstPlayer);
                        reset = true;
                    }
                    // Field obj =new Field()

                    temp[i][j] = new Field(value, firstPlayer);
                    if (currentPlayerWins(temp, firstPlayer)) {
                        temp[i][j] = null;
                        if (isValidMove(board, i, j, value, firstPlayer, firstPlayedPieces, secondPlayedPieces)) {
                            board[i][j] = new Field(value, firstPlayer);
                            // AI can win, make the move and return
                            return new Move(i, j, value);
                        }
                    }
                    // Reset the board to its original state
                    if (reset) {
                        board[i][j] = obj;
                        reset = false;
                    } else {
                        temp[i][j] = null;
                    }
                }
            }
        }


        //Gegner MAX VALUE PIECE
        int opponentValue = 8;
        boolean[] opponent = !firstPlayer ? firstPlayedPieces : secondPlayedPieces;
        while (true) {
            if (opponentValue <= 0) {
                break;
            }
            if (opponent[opponentValue]) {
                opponentValue--;
            } else {
                break;
            }
        }
        temp = Arrays.copyOf(board, board.length);
        obj = null;
        reset = false;
        // If the AI can't win directly, check if it can prevent the opponent from winning
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

                if (board[i][j] != null && board[i][j].firstPlayer() != firstPlayer) {

                    //Stop the opponent to win from both the places
                    int count = 0;
                    boolean row = false;
                    boolean col = false;
                    boolean diagonal = false;
                    // rows
                    for (int k = 0; k < 3; k++) {
                        if (board[i][k] != null)
                            if (board[i][k] != board[i][j] && board[i][k].firstPlayer() == !firstPlayer) {
                                count++;
                            }
                        if (count == 1) {
                            row = true;
                        }
                        count = 0;
                    }
                    //columns
                    for (int k = 0; k < 3; k++) {
                        if (board[k][i] != null) {
                            if (board[k][i] != board[i][j] && board[k][i].firstPlayer() == !firstPlayer) {
                                count++;
                            }
                            if (count == 1) {
                                col = true;
                            }
                            count = 0;
                        }
                    }
                    //diagonal
                    for (int k = 0; k < 3; k++) {
                        if (board[k][k] != null) {
                            if (board[k][k] != board[i][j] && board[k][k].firstPlayer() == !firstPlayer) {
                                count++;
                            }
                            if (count == 1) {
                                diagonal = true;
                            }
                            count = 0;
                        }
                    }
                    if ((row == true && col == true) || (row == true && diagonal == true) || (col == true && diagonal == true)) {
                        if (board[i][j].value() < value) {
                            board[i][j] = new Field(value, firstPlayer);
                            return new Move(i, j, value);
                        }
                    }
                }

                if (board[i][j] == null || (board[i][j].firstPlayer() == firstPlayer && opponentValue > board[i][j].value())) {

                    if (board[i][j] != null) {
                        obj = new Field(board[i][j].value(), firstPlayer);
                        reset = true;
                        temp[i][j] = new Field(opponentValue, !firstPlayer);
                        if (currentPlayerWins(board, !firstPlayer)) {
                            // board[i][j]=obj;
                            Field obj1 = opponentPlayerWins(board, !firstPlayer);
                            for (int k = 0; k < board.length; k++) {
                                for (int l = 0; l < board[i].length; l++) {
                                    if (board[k][l] != null) {
                                        if (board[k][l].equals(obj1) && board[k][l].firstPlayer() != firstPlayer) {
                                            board[k][l] = new Field(value, firstPlayer);
                                            board[i][j] = obj;
                                            return new Move(k, l, value);
                                        }
                                    }
                                }

                            }
                        } else {
                            board[i][j] = obj;

                        }
                    }

                    if (board[i][j] == null) {

                        // Temporarily make a move for the opponent
                        board[i][j] = new Field(i * 3 + j, !firstPlayer);
                        if (currentPlayerWins(board, !firstPlayer)) {
                            board[i][j] = new Field(value, firstPlayer);
                            // Opponent can win, make the move to prevent it and return
                            return new Move(i, j, value);
                        }
                    }

                    // Reset the board to its original state
                    if (reset) {
                        board[i][j] = obj;
                        reset = false;
                    } else {
                        board[i][j] = null;
                    }
                }
            }
        }

        // If the AI can't win directly and the opponent can't win either, choose a random move
        while (true) {
            int row = random.nextInt(3);
            int col = random.nextInt(3);
            int value1 = random.nextInt(9);
            //  && !(firstPlayer ? firstPlayedPieces[value] : secondPlayedPieces[value])
            if (board[row][col] == null &&
                    isValidMove(board, row, col, value1, firstPlayer, firstPlayedPieces, secondPlayedPieces)
            ) {
                board[row][col] = new Field(value1, firstPlayer);
                return new Move(row, col, value1);
            }
        }
    }

    private boolean isValidMove(Field[][] board, int row, int col, int value, boolean firstPlayer, boolean[] firstPlayedPieces, boolean[] secondPlayedPieces) {

        // Check if the value has already been played
        boolean[] playedPieces = firstPlayer ? firstPlayedPieces : secondPlayedPieces;
        if (playedPieces[value]) {
            return false;
        }
        // Check if the value is less than the opponent's piece on the same space
        if (board[row][col] != null && board[row][col].firstPlayer() != firstPlayer
                && board[row][col].value() > value) {
            return false;
        }
        // Check if the space is already occupied(same Player)
        if (board[row][col] != null) {
            return false;
        }


        return true;
    }

    private boolean currentPlayerWins(Field[][] board, boolean firstPlayer) {
        // check rows
        for (int i = 0; i < board.length; i++) {
            Field f0 = board[i][0];
            Field f1 = board[i][1];
            Field f2 = board[i][2];

            if (f0 != null && f1 != null && f2 != null) {
                if (f0.firstPlayer() == f1.firstPlayer() && f1.firstPlayer() == f2.firstPlayer() && f0.firstPlayer() == firstPlayer) {
                    return true;
                }
            }
        }

        // check columns
        for (int i = 0; i < board.length; i++) {
            Field f0 = board[0][i];
            Field f1 = board[1][i];
            Field f2 = board[2][i];

            if (f0 != null && f1 != null && f2 != null) {
                if (f0.firstPlayer() == f1.firstPlayer() && f1.firstPlayer() == f2.firstPlayer() && f0.firstPlayer() == firstPlayer) {
                    return true;
                }
            }
        }

        // check diagonals
        Field f0 = board[0][0];
        Field f1 = board[1][1];
        Field f2 = board[2][2];
        if (f0 != null && f1 != null && f2 != null) {
            if (f0.firstPlayer() == f1.firstPlayer() && f1.firstPlayer() == f2.firstPlayer() && f0.firstPlayer() == firstPlayer) {
                return true;
            }
        }
        f0 = board[0][2];
        f1 = board[1][1];
        f2 = board[2][0];
        if (f0 != null && f1 != null && f2 != null) {
            if (f0.firstPlayer() == f1.firstPlayer() && f1.firstPlayer() == f2.firstPlayer() && f0.firstPlayer() == firstPlayer) {
                return true;
            }
        }

        return false;
    }

    private Field opponentPlayerWins(Field[][] board, boolean firstPlayer) {
        // check rows
        for (int i = 0; i < board.length; i++) {
            Field f0 = board[i][0];
            Field f1 = board[i][1];
            Field f2 = board[i][2];

            if (f0 != null && f1 != null && f2 != null) {
                if (f0.firstPlayer() == f1.firstPlayer() && f1.firstPlayer() == f2.firstPlayer() && f0.firstPlayer() == firstPlayer) {
                    Field obj;
                    int[] array = new int[]{f0.value(), f1.value(), f2.value()};
                    Arrays.sort(array);
                    if (f0.value() == array[0]) {
                        return f0;
                    } else if (f1.value() == array[0]) {
                        return f1;
                    } else {
                        return f2;
                    }

                }
            }
        }

        // check columns
        for (int i = 0; i < board.length; i++) {
            Field f0 = board[0][i];
            Field f1 = board[1][i];
            Field f2 = board[2][i];

            if (f0 != null && f1 != null && f2 != null) {
                if (f0.firstPlayer() == f1.firstPlayer() && f1.firstPlayer() == f2.firstPlayer() && f0.firstPlayer() == firstPlayer) {
                    int[] array = new int[]{f0.value(), f1.value(), f2.value()};
                    Arrays.sort(array);
                    if (f0.value() == array[0]) {
                        return f0;
                    } else if (f1.value() == array[0]) {
                        return f1;
                    } else {
                        return f2;
                    }
                }
            }
        }

        // check diagonals
        Field f0 = board[0][0];
        Field f1 = board[1][1];
        Field f2 = board[2][2];
        if (f0 != null && f1 != null && f2 != null) {
            if (f0.firstPlayer() == f1.firstPlayer() && f1.firstPlayer() == f2.firstPlayer() && f0.firstPlayer() == firstPlayer) {

                int[] array = new int[]{f0.value(), f1.value(), f2.value()};
                Arrays.sort(array);
                if (f0.value() == array[0]) {
                    return f0;
                } else if (f1.value() == array[0]) {
                    return f1;
                } else {
                    return f2;
                }
            }
        }
        f0 = board[0][2];
        f1 = board[1][1];
        f2 = board[2][0];
        if (f0 != null && f1 != null && f2 != null) {
            if (f0.firstPlayer() == f1.firstPlayer() && f1.firstPlayer() == f2.firstPlayer() && f0.firstPlayer() == firstPlayer) {

                int[] array = new int[]{f0.value(), f1.value(), f2.value()};
                Arrays.sort(array);
                if (f0.value() == array[0]) {
                    return f0;
                } else if (f1.value() == array[0]) {
                    return f1;
                } else {
                    return f2;
                }
            }
        }

        return null;
    }


}