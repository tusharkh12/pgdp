package pgdp.ds;

import java.util.*;
import java.util.ArrayList;
import java.util.Iterator;

public class SparseGraph implements Graph {

    private Map<Integer, Set<Integer>> sets = new HashMap<>();
    private SimpleSet set=new SimpleSet();


    // private boolean[][] matrix;
    //private BitArray[][] bitArray;
    private int size;

    public SparseGraph(int nodes) {
        // set = new SimpleSet();
//		for (int a = 0;a<nodes;a++){
//			set.add(a);
//		}
        // matrix = new boolean[nodes][nodes];
        if (nodes < 0) {
            this.size = 0;
        } else {

            this.size = nodes;
        }


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
        }
        if(sets.containsKey(from)){
            sets.get(from).add(to);
        }
        else {
           sets.put(from,new HashSet<>());
           sets.get(from).add(to);
        }

        // TODO
    }

    @Override
    public boolean isAdj(int from, int to) {
        // TODO
        if (from < 0 || from >= size || to < 0 || to >= size) {
            return false;
        } else {

//            for (int i = 0; i < sets.get(from).size(); i++) {
            if(sets.containsKey(from)) {
                if (sets.get(from).contains(to)) {
                    return true;
                }
            }

            return false;




        }
    }

    @Override
    public int[] getAdj(int id) {
        if (id < 0 || id >= size) {
            return null;
        }

        if (sets.containsKey(id)) {
           set.setMembers(sets.get(id));
           return set.toArray();
        }

       // Iterator<Map.Entry<Integer, Integer>> itr = sets.entrySet().iterator();
        return new int[]{};

        // TODO
    }


//    public static void main(String[] args) {
//        Graph g = new SparseGraph(10);                       // oder SparseGraph
//        int start = 0;                                      // die ID des Knoten von dem aus wir losgehen möchten
//        int target = 5;
//        g.addEdge(0, 1);
////        g.addEdge(1, 5);
////        g.addEdge(2, 4);
////        g.addEdge(2, 3);
//       System.out.println(g.isAdj(0,1));
//        //System.out.println(Arrays.toString(g.getAdj(2)));
//       // int[] path = Dijkstra.dijkstra(g, start, target);
//
//
//        Map<Integer,Set<Integer>> maps=new HashMap<>();
////        List<Integer> l1=new ArrayList<>();
////        l1.add(1);
////
////        maps.put(0,l1);
////        List<Integer> l2=new ArrayList<>();
////        l2.add(2);
////        l2.add(1);
//        maps.put(0,new HashSet<>());
//        maps.get(0).add(1);
//        maps.get(0).add(2);
//        int[] aa=maps.get(0).stream().mapToInt(x -> x.intValue()).toArray();
////        System.out.println(maps.get(0).contains(3));
////        boolean a=maps.get(0).contains(1);
//        System.out.println(maps.get(0));
//
//
//        // der kürzeste Pfad
//        // System.out.println(Arrays.toString(path));          // eine Ausgabe in der Konsole
//    }
}

