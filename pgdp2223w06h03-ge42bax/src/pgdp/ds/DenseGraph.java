package pgdp.ds;

import java.util.*;

public class DenseGraph implements Graph {


 //    private SimpleSet set=new SimpleSet();
    private boolean[][] matrix;
    //private BitArray[][] bitArray;
    private int size;

    public DenseGraph(int nodes) {
        //System.gc();
        //System.runFinalization();
        //  set = new SimpleSet();
//		for (int a = 0;a<nodes;a++){
//			set.add(a);
//		}
        if (nodes > 0) {
            matrix = new boolean[nodes][nodes];
        }
        this.size = nodes;

        // TODO
    }

    @Override
    public int getNumberOfNodes() {
        if (size <= 0) {
            return 0;
        }

        // TODO
        return size;

    }

    @Override
    public void addEdge(int from, int to) {
        if (from < 0 || from >= size || to < 0 || to >= size) {
            return;
        } else {
            matrix[from][to] =true;
        }

        // TODO
    }

    @Override
    public boolean isAdj(int from, int to) {

        if (from < 0 || from >= size || to < 0 || to >= size) {
            return false;
        } else {
            return matrix[from][to];

        }
    }

    @Override
    public int[] getAdj(int id) {
//		System.gc();
//		System.runFinalization();
        if (id < 0 || id >= size) {
            return null;
        } else {
            ArrayList<Integer> nachbaren = new ArrayList<>();
            for (int a = 0; a < size; a++) {
 //               System.gc();
  //              System.runFinalization();
                if (matrix[id][a]) {
                    nachbaren.add(a);
                }
            }
           // System.out.println(Arrays.toString(matrix[id]));
            int result[] = new int[nachbaren.size()];
            for (int a = 0; a < nachbaren.size(); a++) {
                result[a] = nachbaren.get(a);
            }
//            System.gc();
//         set.setMembers(nachbaren);
           return result;}
        // TODO
    }
//    public static void main(String[] args) {
//        Graph g = new DenseGraph(10);                       // oder SparseGraph
//        int start = 0;                                      // die ID des Knoten von dem aus wir losgehen möchten
//        int target = 5;
//        g.addEdge(0, 1);
//        g.addEdge(0, 5);
//        g.addEdge(2,5);
//        System.out.println(Arrays.toString(g.getAdj(0)));
//         System.out.println(g.isAdj(0, 1));
////        System.out.println(Arrays.toString(g.getAdj(0)));
////        int[] path = Dijkstra.dijkstra(g, start, target);   // der kürzeste Pfad
////        //System.out.println(Arrays.toString(path));          // eine Ausgabe in der Konsole
//    }



}
