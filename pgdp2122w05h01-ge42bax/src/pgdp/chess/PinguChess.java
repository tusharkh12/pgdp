package pgdp.chess;

import pgdp.PinguLib;

import static pgdp.PinguLib.*;

public class PinguChess {

    private GameBoard gameBoard;
    private boolean pinguPlaying;

    public PinguChess() {

    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    public boolean isPinguPlaying() {
        return pinguPlaying;
    }

    public void setPinguPlaying(boolean playing) {
        pinguPlaying=playing;
    }

    public int getTeam(char piece) {
        if (piece == 'Z' || piece == 'F' || piece == 'C' || piece == 'K') {
            return 0;
        } else if (piece == 'S' || piece == 'O' || piece == 'A' || piece == 'E') {
            return 1;
        } else {
            return -1;
        }
    }

    public int getDirection(int dX, int dY) {

        int direction ;

        //Horizontal
        if(dX> 0 && dY==0){
                       direction = 2;

                   }
                   else if(dX <0 && dY==0){
                       direction =6;

                   }


                   //Vertical
                   else if(dY>0 && dX==0){
                       direction=4;

                   }
                   else if(dY<0 && dX==0){
                       direction=0;

                   }


            //Diagonals
                  else  if(dX> 0 && dY>0 && (dX/dY)==1){
                       direction=3;

                   }
                   else if(dX< 0 && dY<0 && (dX/dY)==1){
                       direction=7;

                   }
                   else if(dX> 0 && dY<0 && (dX/dY)==-1){
                       direction=1;

                   }
                   else if(dX< 0 && dY>0 && (dX/dY)==-1){
                       direction=5;

                   }
                   else{
                       direction= -1;
                   }

        return direction;
    }

    public int getDistance(int dX, int dY) {
        int direction = getDirection(dX, dY);
        //Horizontal
        if (direction == 2) {
            return dX;
        }
       else if (direction == 6){
            return  -dX;
        }
       //Vertical
        else if(direction == 4){
            return dY;
        }
        else if(direction== 0){
            return -dY;
        }
        //Diagonals
        else if(direction ==1 || direction==3){
            return dX;
        }
        else if (direction==7 || direction==5) {
            return -dX;
        }

        else
            return -1;
    }

    public int getFriendlyNeighbours(int x, int y){
        int direction = getDirection(x,y);
        char piece = gameBoard.get(x, y);
        int team = getTeam(piece);
        int count = 0;
        if(direction==0) {
            char neighbour = gameBoard.get(x, y - 1);
            if (team == getTeam(neighbour)) {
                count++;
            } else {
            }
        }


           else if (direction == 1)  {
                char neighbour1 = gameBoard.get(x + 1, y - 1);
                if (team == getTeam(neighbour1)) {
                    count++;
                } else {
                }
            } else if (direction == 2) {
                char neighbour2 = gameBoard.get(x + 1, y);
                if (team == getTeam(neighbour2)) {
                    count++;
                } else {
                }
            } else if (direction == 3) {
                char neighbour = gameBoard.get(x - 1, y + 1);
                if (team == getTeam(neighbour)) {
                    count++;
                } else {
                }
            } else if (direction == 4) {
                char neighbour = gameBoard.get(x, y + 1);
                if (team == getTeam(neighbour)) {
                    count++;
                } else {
                }
            }
            if (direction == 5) {
                char neighbour = gameBoard.get(x - 1, y + 1);
                if (team == getTeam(neighbour)) {
                    count++;
                } else {
                }
            }
            if (direction == 6) {
                char neighbour = gameBoard.get(x - 1, y);
                if (team == getTeam(neighbour)) {
                    count++;
                } else {
                }
            }
            if (direction == 7) {
                char neighbour = gameBoard.get(x - 1, y - 1);
                if (team == getTeam(neighbour)) {
                    count++;
                } else {
                }
            }



        return -1;
    }


    public boolean checkPath(int fromX, int fromY, int toX, int toY) {
        int direction = getDirection(toX - fromX, toY - fromY);
        if (direction == 0) {
            for (int i = 0; i < toY - fromY; i++) {
                if (gameBoard.get(toX, -i) == ' ') {
                    return true;
                } else
                    return false;
            }


        } else if (direction == 1) {
            for (int i = 0; i < toY - fromY; i++) {
                if (gameBoard.get(i, -i) == ' ') {
                    return true;
                } else
                    return false;
            }
        } else if (direction == 2) {
            for (int i = 0; i < toX - fromX; i++) {
                if (gameBoard.get(i, toY) == ' ') {
                    return true;
                } else
                    return false;
            }
        } else if (direction == 3) {
            for (int i = 0; i < toY - fromY; i++) {
                if (gameBoard.get(i, i) == ' ') {
                    return true;
                } else
                    return false;
            }
        } else if (direction == 0) {
            for (int i = 0; i < toY - fromY; i++) {
                if (gameBoard.get(toX, i) == ' ') {
                    return true;
                } else
                    return false;
            }


        } else if (direction == 5) {
            for (int i = 0; i < toY - fromY; i++) {
                if (gameBoard.get(-i, i) == ' ') {
                    return true;
                } else
                    return false;
            }
        } else if (direction == 6) {
            for (int i = 0; i < toX - fromX; i++) {
                if (gameBoard.get(-i, toY) == ' ') {
                    return true;
                } else
                    return false;
            }
        } else if (direction == 7) {
            for (int i = 0; i < toY - fromY; i++) {
                if (gameBoard.get(-i, -i) == ' ') {
                    return true;
                } else
                    return false;
            }
        }

        return false;
    }

    public boolean checkJump(int fromX, int fromY, int toX, int toY) {
        if ((gameBoard.get(toX, toY)) != ' ' || getTeam(getGameBoard().get(toX, toY)) !=
                getTeam(getGameBoard().get(fromX, fromY)) && (getGameBoard().get(fromX, fromY) == 'F' ||
                getGameBoard().get(fromX, fromY) == '0')) {
            if (getDirection(toX - fromX, toY - fromY) != -1
                    && getDistance(toX - fromX, toY - fromY) <= 2
                    && getDistance(toX - fromX, toY - fromY) > 0) {
                return true;
            } else {
                return false;
            }
        }
        else{
            return false;
        }
    }

    public boolean checkMove(int fromX, int fromY, int toX, int toY) {
        if(checkPath(fromX, fromY, toX, toY)==true){
            switch(getGameBoard().get(fromX,fromY)){
                case 'Z':
                    if((getDistance(toX - fromX, toY - fromY)<=3 &&
                            getDistance(toX - fromX, toY - fromY)>0 &&
                            getDirection(toX - fromX, toY - fromY)==4) ||
                            getDistance(toX - fromX, toY - fromY)==1) {
                    return true;
                }
                else{
                      return false;
                }
                case 'K':
                    if((getDistance(toX - fromX, toY - fromY)<=5 &&

                            getDirection(toX - fromX, toY - fromY)>0) ||
                            (getFriendlyNeighbours(fromX,fromY)>=2)) {
                        return true;
                    }
                    else{
                        return false;
                    }
                case 'C':
                    if((getDistance(toX - fromX, toY - fromY)<=1 &&
                            getDistance(toX - fromX, toY - fromY)>0)){

                        return true;
                    }
                    else{
                        return false;
                    }

            }
        }
        return false;
    }

    public void runTurn() {
        int x, y, aX, aY;

        PinguLib.writeGameBoard(this.getGameBoard());
        if (this.isPinguPlaying()) {
            writeLineConsole("Die Pinguine sind am Zug");
            this.setPinguPlaying(false);
        } else {
            writeLineConsole("Die Feinde der Pinguine sind am Zug");
            this.setPinguPlaying(true);
        }
        do {
            do {
                x = readInt("Bitte X Koordinate der Figur eingeben") - 1;
                y = readInt("Bitte Y Koordinate der Figur eingeben") - 1;

            } while (this.getGameBoard().get(x, y) == '\0');
            writeLineConsole("Wohin soll die Figur gehen?");

            do {
                aX = readInt("Bitte X Koordinate der Zielfeldes eingeben") - 1;
                aY = readInt("Bitte Y Koordinate der Zielfeldes eingeben") - 1;
            }while(this.getGameBoard().get(x,y)=='\0');
        }while(!this.checkMove(x,y,aX,aY));
        
        this.getGameBoard().set(aX,aY,this.gameBoard.get(x,y));
    

    }

    public void run() {


        int winner =0;
        while(winner==0){
            winner=getGameBoard().evaluateWinner() ;
            switch (winner){
                case 0 :
                    runTurn();
                    break;
                case 1 :
                    writeLineConsole("Die⎵Pinguine⎵haben⎵gewonnen!");
                    break;
                case 2:
                    writeLineConsole("Die⎵Feinde⎵der⎵Pinguine⎵haben⎵gewonnen!");
                    break;
                case 3:
                    writeLineConsole("Beide⎵haben⎵gewonnen?");
            }
        }
    }

    public static void main(String[] args) {
        new PinguChess().run();
    }

}
