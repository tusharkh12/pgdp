package pgdp.maps;

import java.util.Arrays;

import static pgdp.maps.PinguMaps.matrixMult;

public class Main {

    public static void main(String[] args) {

        //Führe die main Methode aus, nachdem du die Matrizenmultiplikation implementiert hast.
        int[][] adjazenz = {{1,1,1,1,0,0,0,0,0},
                            {1,1,0,0,1,0,0,0,0},
                            {1,0,1,1,0,1,0,0,0},
                            {1,0,1,1,1,0,1,0,0},
                            {0,1,0,1,1,0,0,0,1},
                            {0,0,1,0,0,1,1,1,0},
                            {0,0,0,1,0,1,1,1,0},
                            {0,0,0,0,0,1,1,1,1},
                            {0,0,0,0,1,0,0,1,1}};


        int[][] paths = adjazenz;
        boolean  pathFound = false;

        for (int i = 2;; i++) {

            paths = matrixMult(paths, adjazenz);

            if (paths[1][3] != 0 && !pathFound) {
                System.out.println("Der Weg zum Fischgeschäft is " + i + " Einheiten lang.");
                pathFound = true;
            }

            boolean finished = true;

            for (int m = 0; m < adjazenz.length; m++) {

                for (int n = 0; n < adjazenz.length; n++) {

                    if (paths[m][n] == 0) {
                        finished = false;
                        break;
                    }
                }
            }

            if (finished) {
                System.out.println("Man kommt in " + i + " Einheiten von jedem Punkt zu jedem Anderen");
                break;
            }
        }
    }
}
