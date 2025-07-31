package pgdp.datastructures;

import java.util.*;

public class Iterator<T extends Comparable<T>> implements java.util.Iterator {
    private QuarternaryNode<T> root;
    private int counter = 0;
    private ArrayList<T> list = new ArrayList<>();


    public Iterator(QuarternaryNode<T> root) {
        // this.root=new QuarternaryNode<>();
        ArrayList<T> temp = new ArrayList<>();
        if (root != null) {
            for (int i = 0; i < 3; i++) {
                if (root.getValue(i) != null) {
                    temp.add(root.getValue(i));
                }
            }

            List<QuarternaryNode<T>> qn = new ArrayList<>();

            if (root.getChildren() != null) {
                qn = root.getChildren();
            }

            if (qn != null) {
                while (qn.size() > 0) {
                    List<QuarternaryNode<T>> help = new ArrayList<>();
                    for (int i = 0; i < qn.size(); i++) {
                        if (qn.get(i) != null) {
                            temp.addAll(qn.get(i).getValues());
                            for (int j = 0; j < 4; j++) {
                                if (qn.get(i).getChild(j) != null) {
                                    help.add(qn.get(i).getChild(j));
                                }
                            }
                        }
                    }
                    qn = help;
                }
            }

            int count = 0;
            for (int i = 0; i < temp.size(); i++) {
                if (temp.get(i) != null) {
                    list.add(count, temp.get(i));
                    count++;
                }
            }
            Collections.sort(list);


        }
    }

    @Override
    public boolean hasNext() {
//        if (counter >= list.size()) {
//                    return false;
//                }else {
//                    return true;
//                }
        return counter < list.size();

    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Trying to call next on an empty QuarternarySearchTreeIterator");
        }

        T result = list.get(counter);
        counter++;
        return result;
    }
}

