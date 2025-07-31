package pgdp.datastructures;

import java.util.*;

public class QuarternarySearchTree<T extends Comparable<T>> implements Iterable<T> {

    private QuarternaryNode<T> root;

    // HELPERS

//    private int counter = 0;
//    private ArrayList<T> list = new ArrayList<>();


    public QuarternarySearchTree() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        return root == null ? 0 : root.size();
    }

    public boolean contains(T value) {
        if (isEmpty()) {
            return false;
        }
        return root.contains(value);
    }

    public void insert(T value) {
        if (value == null) {
            return;
        }
        if (isEmpty()) {
            root = new QuarternaryNode<T>(value);
        } else {
            root.insert(value);
        }
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        } else {
            return root.toString();
        }
    }

    public String toGraphvizString() {
        StringBuilder sb = new StringBuilder();
        sb.append("digraph G {\n");
        sb.append(root == null ? "" : root.toGraphvizStringHelper());
        sb.append("}");
        return sb.toString();
    }

    public QuarternaryNode<T> getRoot() {
        return root;
    }

    public void setRoot(QuarternaryNode<T> root) {
        this.root = root;
    }

    @Override
    public Iterator<T> iterator() {
//       // nextNode = root;
//        if (root != null) {
//            fetchNext();
//        }


        // TODO
        // Throw exception using the following line of code
        // throw new NoSuchElementException("Trying to call next on an empty QuarternarySearchTreeIterator");
        return new Iterator<T>(root);
    }

//            @Override
//            public boolean hasNext() {
////                if (root == null) {
////                    return false;
////                }
//                if (counter >= list.size()) {
//                    return false;
//                }else {
//                    return true;
//                }
//            }

//            @Override
//            public T next() {
//                if (!hasNext()) {
//                    throw new NoSuchElementException("Trying to call next on an empty QuarternarySearchTreeIterator");
//                }
//                //counter++;
//                T result=list.get(counter);
//                counter++;
//                return result;
//            }
//        };
//    }
////
//    private void fetchNext() {
//      ArrayList<T> temp = new ArrayList<>();
//        for (int i = 0; i < 3; i++) {
//            if(root.getValue(i)!=null){
//                temp.add(root.getValue(i));
//            }
//        }
//
//        List<QuarternaryNode<T>> qn=new ArrayList<>();
//
//       if(root.getChildren()!=null) {
//            qn= root.getChildren();
//       }
//        List<QuarternaryNode<T>> help = new ArrayList<>();
//
//        if(qn!=null) {
//            while (qn.size() > 0) {
//                help.clear();
//                for (int i = 0; i < qn.size(); i++) {
//                    if (qn.get(i) != null) {
//                        temp.addAll(qn.get(i).getValues());
//                        for (int j = 0; j < 4; j++) {
//                            if (qn.get(i).getChild(j) != null) {
//                                help.add(qn.get(i).getChild(j));
//                            }
//                        }
//                    }
//                }
//                qn.clear();
//                for (int i = 0; i < help.size(); i++) {
//                    if (help.get(i) != null) {
//                        temp.addAll(help.get(i).getValues());
//                        for (int j = 0; j < 4; j++) {
//                            if (help.get(i).getChild(j) != null) {
//                                qn.add(help.get(i).getChild(j));
//                            }
//                        }
//
//                    }
//                }
//            }
//        }
//
//        int count=0;
//        for (int i = 0; i < temp.size(); i++) {
//            if(temp.get(i)!=null){
//                list.add(count,temp.get(i));
//                count++;
//            }
//        }
//        Collections.sort(list);
//
//        }


    public static void main(String[] args) {
      // int[] values = new int[] { 8, 4, 12, 1, 5, 9, 13, 3, 7, 11, 15, 2, 6, 10, 14 };
        //int[] values = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        // int[] values=new int[]{29,30,40,16,20,50,70,18,7,8,9,10,3,6,2,1,21,27,28,22,23,24,25,4,19,15,75,72,60,52,55,65,44,80};
        int[] values = new int[]{1,6,9,4,11};
        QuarternarySearchTree<Integer> n = new QuarternarySearchTree<Integer>();
        for (int i : values) {
            n.insert(i);
        }
        // System.out.println(n.root);
        // System.out.println(n.size());
        //  System.out.println(n);
        //System.out.println(n.toGraphvizString());


//        List<Integer> a=new ArrayList<>();
//        List<QuarternaryNode<Integer>> qn = n.root.getChildren();
//        List<QuarternaryNode<Integer>> help = new ArrayList<>();
//      //  System.out.println(qn.get(0).getValues());
//
//       while(qn.size()>0) {
//           help.clear();
//           for (int i = 0; i < qn.size(); i++) {
//               if (qn.get(i) != null) {
//                   a.addAll(qn.get(i).getValues());
//                   for (int j = 0; j < 4; j++) {
//                       if (qn.get(i).getChild(j) != null) {
//                           help.add(qn.get(i).getChild(j));
//                       }
//                   }
//               }
//           }
//           qn.clear();
//           for (int i = 0; i < help.size(); i++) {
//               if (help.get(i) != null) {
//                   a.addAll(help.get(i).getValues());
//                   for (int j = 0; j < 4; j++) {
//                       if (help.get(i).getChild(j) != null) {
//                           qn.add(help.get(i).getChild(j));
//                       }
//                   }
//
//                   //  qn.add(help.get(i).getChild());
//               }
//           }
//       }
//
//
//       System.out.println(a);

//        for (int i = 0; i < 4; i++) {
//            if(qn.get(i)!=null){
//               // help.add(qn.get(i));
//                qn=qn.get(i).getChildren();
//                for (int j = 0; j < 4; j++) {
//                    if(qn.get(i)!=null){
//                        a.addAll(qn.get(j).getValues());
//                    }
//
//                }
//                qn=help;
//
//            }
//
//
//            }
        // System.out.println(a);


//        for (int i = 0; i < 3; i++) {
//            if(n.root.getChild(i)!=null) {
//              qn  = n.root.getChild(i);
//            }
//        //System.out.println(qn.getChild(0).getValues());
//            int count=4;
//            int x=0;
//            while(x<3) {
//                for (int j = 0; j < count; j++) {
//                    if (qn.getChild(j)!= null) {
//                        a.addAll(qn.getChild(j).getValues());
//                    }
//
//                }
//               // for (int j = 0; j < 4; j++) {
//                    qn=qn.getChild(x);
//
//                }
//                qn=qn.getChildren()
//              count*=4;
//                x++;
//            }
//
//
//        }

        // String ss=n.root.getChildren().toString().replaceAll("[^0-9]", "");
        //System.out.println(ss);

        //   System.out.println(n.root.toGraphvizStringHelper());
//        System.out.println(n.root.height());

        //qn=qn.getChildren().get(2);
        // System.out.println(qn.getChildren().get(3).getValues());
//
//        System.out.println(qn.getValues());
//        System.out.println(qn);

        //   System.out.println(n.root.getChildren().get(1).getValues());
//        qn=qn.getChild(3);
//        qn=qn.getChild(3);
//        System.out.println(qn);
        // System.out.println(n.root);
        //r.insert(r.getValue(0));
//        QuarternaryNode<Integer> l=n.root.getChildren().get(3);
//       // System.out.println(l.getValues());
//        List<QuarternaryNode<Integer>> a= Arrays.asList(l);

        //  System.out.println(n.root.getChildren().get(3).getChild(3).getChild(3));
        //String a=l.toString().replaceAll("[^0-9]", "");
        //System.out.println(a.charAt(0));


        // System.out.println(n.root.getChildren().get(3));

//        System.out.println(n.toGraphvizString());

//        // uncomment after implementing the iterator for testing the large example
        for (int i : n) {
            System.out.print(i + " - ");
        }
    }
}

