package pgdp.maps;

public class PinguMaps {

    public static int[][] matrixMult(int[][] matrixA, int[][] matrixB) {
        if (matrixA[0].length != matrixB.length) {
            return null;
        }

        int[][] result = new int[matrixA.length][matrixB[0].length];

        for (int x = 0; x < matrixA.length; x++) {

            for (int y = 0; y < matrixB[0].length; y++) {

                for (int n = 0; n < matrixA[0].length; n++) {

                    result[x][y] += matrixA[x][n]*matrixB[n][y];
                }
            }
        }

        return result;
    }




}
