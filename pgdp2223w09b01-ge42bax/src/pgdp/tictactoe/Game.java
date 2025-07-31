package pgdp.tictactoe;

import pgdp.tictactoe.ai.HumanPlayer;
import pgdp.tictactoe.ai.SimpleAI;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Game {
    PenguAI first;
    PenguAI second;
    private PenguAI winner=null;
    public Field[][] board;


    public Game(PenguAI first, PenguAI second) {
        this.first = first;
        this.second = second;
        this.board = new Field[3][3];

    }


    public PenguAI getWinner() {
        if(winner!=null){
            return winner;
        }
        Field[][] board = this.board;

        // check columns
        for (int i = 0; i < board.length; i++) {
            Field f0 = board[i][0];
            Field f1 = board[i][1];
            Field f2 = board[i][2];
            if (f0 != null && f1 != null && f2 != null) {
                if (f0.firstPlayer() == f1.firstPlayer() && f1.firstPlayer() == f2.firstPlayer() && f0.firstPlayer()) {
                    return first;
                } else if (!f0.firstPlayer() == !f1.firstPlayer() && !f1.firstPlayer() == !f2.firstPlayer()) {
                    return second;
                }

            }
        }

        // check rows
        for (int i = 0; i < board.length; i++) {
            Field f0 = board[0][i];
            Field f1 = board[1][i];
            Field f2 = board[2][i];

            if (f0 != null && f1 != null && f2 != null) {
                if (f0.firstPlayer() == f1.firstPlayer() && f1.firstPlayer() == f2.firstPlayer() && f0.firstPlayer()) {
                    return first;
                } else if (!f0.firstPlayer() == !f1.firstPlayer() && !f1.firstPlayer() == !f2.firstPlayer()) {
                    return second;
                }

            }
        }

        // check diagonals
        Field f0 = board[0][0];
        Field f1 = board[1][1];
        Field f2 = board[2][2];
        if (f0 != null && f1 != null && f2 != null) {
            if (f0.firstPlayer() == f1.firstPlayer() && f1.firstPlayer() == f2.firstPlayer() && f0.firstPlayer()) {
                return first;
            } else if (!f0.firstPlayer() == !f1.firstPlayer() && !f1.firstPlayer() == !f2.firstPlayer()) {
                return second;
            }

        }
        f0 = board[0][2];
        f1 = board[1][1];
        f2 = board[2][0];
        if (f0 != null && f1 != null && f2 != null) {
            if (f0.firstPlayer() == f1.firstPlayer() && f1.firstPlayer() == f2.firstPlayer() && f0.firstPlayer()) {
                return first;
            } else if (f0.firstPlayer() == f1.firstPlayer() && f1.firstPlayer() == f2.firstPlayer() ) {
                return second;
            }

        }

        // check for illegal moves
        boolean[] firstPlayedPieces = new boolean[9];
        boolean[] secondPlayedPieces = new boolean[9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != null) {
                    boolean[] playedPieces = board[i][j].firstPlayer() ? firstPlayedPieces : secondPlayedPieces;
                    if (playedPieces[board[i][j].value()]) {
                        // player has already played a piece with the same value, player loses
                        return board[i][j].firstPlayer() ? second : first;
                    }
                    playedPieces[board[i][j].value()] = true;
                }
            }
        }

        // check if game is still ongoing
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == null) {
                    return null;
                }
            }
        }

        // game ended in draw
        return null;
    }

    public void playGame() {
        boolean[] firstPlayedPieces = new boolean[9];
        boolean[] secondPlayedPieces = new boolean[9];

        boolean firstPlayer = true;
        // Keep playing until there is a winner or the board is full
        while (getWinner() == null) {
            PenguAI currentPlayer = firstPlayer ? first : second;
            boolean[] playedPieces = firstPlayer ? firstPlayedPieces : secondPlayedPieces;



            int wert = 8;
            boolean[] check = firstPlayer ? firstPlayedPieces : secondPlayedPieces;
            while (true) {
                if (wert <= 0) {
                    break;
                }
                if (check[wert]) {
                    wert--;
                } else {
                    break;
                }
            }
            // Check if the current player has any valid moves left
            boolean hasValidMove = false;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == null || (board[i][j].firstPlayer() != firstPlayer
                            && wert > board[i][j].value())) {
                        hasValidMove = true;
                        break;
                    }
                }
            }
            if (!hasValidMove) {
                // Current player has no valid moves left, set winner to other player and return
                winner = firstPlayer ? second : first;
                return;
            }

            Move move = currentPlayer.makeMove(board, firstPlayer, firstPlayedPieces, secondPlayedPieces);

            // Check if the move is illegal
            if (move.value() < 0 || move.value() > 8 || playedPieces[move.value()] ||
                    move.x()<0 || move.x()>2 ||  move.y()<0 || move.y()>2 ) {
                if(firstPlayer) {
                   winner=second;
                }else {
                    winner=first;
                }
                //getWinner();
                return;
            } // If the move is illegal, the current player loses
            if (board[move.x()][move.y()] != null ){
                if((board[move.x()][move.y()].firstPlayer() == firstPlayer) ||
                        move.value() <= board[move.x()][move.y()].value()){
                    if(firstPlayer) {
                        winner=second;
                    }else {
                        winner=first;
                    }
                   // getWinner();
                    return;
                }
            }

                // Place the piece on the board and mark it as played
                board[move.x()][move.y()] = new Field(move.value(), firstPlayer);
            playedPieces[move.value()] = true;
            if (firstPlayer) {
                firstPlayedPieces[move.value()] = true;
            } else {
                secondPlayedPieces[move.value()] = true;
            }


//            Check if the game ended in a draw
            int count =0;
            for (int i = 0; i < playedPieces.length; i++) {
                if(firstPlayedPieces[i] && secondPlayedPieces[i]){
                    count++;
                }
                if(count>=9){
                    return;
                }
            }

            // Switch turns
            firstPlayer = !firstPlayer;
        }
    }


    public Field[][] getBoard() {
        return board;
    }


    public static void printBoard(Field[][] board) {
        System.out.println("┏━━━┳━━━┳━━━┓");
        for (int y = 0; y < board.length; y++) {
            System.out.print("┃");
            for (int x = 0; x < board.length; x++) {
                if (board[x][y] != null) {
                    System.out.print(board[x][y] + "┃");
                } else {
                    System.out.print("   ┃");
                }
            }
            System.out.println();
            if (y != board.length - 1) {
                System.out.println("┣━━━╋━━━╋━━━┫");
            }
        }
        System.out.println("┗━━━┻━━━┻━━━┛");
    }

    public static void main(String[] args) {
        PenguAI firstPlayer = new HumanPlayer();
        PenguAI secondPlayer = new HumanPlayer();
        Game game = new Game(firstPlayer, secondPlayer);
        game.playGame();
        if (firstPlayer == game.getWinner()) {
            System.out.println("Herzlichen Glückwunsch erster Spieler");
        } else if (secondPlayer == game.getWinner()) {
            System.out.println("Herzlichen Glückwunsch zweiter Spieler");
        } else {
            System.out.println("Unentschieden");
        }
//        Field[][] board = new Field[3][3];
//        board[0][0] = new Field(1, true);
//        board[0][1] = new Field(2, false);
//        boolean a = board[0][1].firstPlayer();
//        System.out.println(a);
//        printBoard(board);

    }
}

