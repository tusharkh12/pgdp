package pgdp.datastructures.lists;

public class RecIntList {
    private RecIntListElement head;

    public RecIntList() {
        head = null;
    }

    public void append(int value) {
        if (head == null) {
            head = new RecIntListElement(value);
        } else {
            head.append(value);
        }
    }

    public int get(int idx) {
        if (head == null) {
            System.out.println("Invalid index: list is empty!");
            return Integer.MAX_VALUE;
        }
        return head.get(idx);
    }

    public int size() {
        /**
         * can be rewritten as
         * if(head==null)
         * return 0;
         * else
         * return head.size();
         */
        return head == null ? 0 : head.size();
    }

    public boolean insert(int value, int idx) {
        if (head == null) {
            if (idx == 0) {
                append(value);
                return true;
            } else {
                System.out.println("You may only insert at index 0 to a empty list!");
                return false;
            }
        }
        return head.insert(value, idx);
    }

    @Override
    public String toString() {
        if (head != null) {
            return "List: [" + head.toString() + "]";
        } else {
            return "Empty list";
        }
    }

    public String toConnectionString() {
        if (head != null) {
            return "List: [" + head.toConnectionString() + "]";
        } else {
            return "Empty list";
        }
    }

    public long[] helperCountThresh(int threshold, long sum1, long sum2, long sum3, int index) {
        if (head.get(index) < threshold) {
            sum1 += head.get(index);
        } else if (head.get(index) == threshold) {
            sum2 += head.get(index);
        } else {
            sum3 += head.get(index);
        }
        index++;
        if (index == this.size()) {
            return new long[]{sum1, sum2, sum3};

        }
        return helperCountThresh(threshold, sum1, sum2, sum3, index);

    }

    public long[] countThresh(int threshold) {
        if (head == null) {
            return new long[]{0, 0, 0};
        }
        //long [] array=new long[]{};
        int index = 0;
        long sum1 = 0;
        long sum2 = 0;
        long sum3 = 0;
        return helperCountThresh(threshold, sum1, sum2, sum3, index);
    }

    public RecIntList helperKinguinSort(boolean increasing, RecIntList recIntList, int index, int i) {
        if (increasing) {
            if (index == 0) {
                recIntList.insert(head.get(index), i);
                i++;
            } else {
                if (recIntList.get(i - 1) <= head.get(index)) {
                    recIntList.insert(head.get(index), i);
                    i++;
                }
            }
            index++;
            if (index == this.size()) {
                return recIntList;
            }
            return helperKinguinSort(increasing, recIntList, index, i);
        } else {
            if (index == 0) {
                recIntList.insert(head.get(index), i);
                i++;
            } else {
                if (recIntList.get(i - 1) >= head.get(index)) {
                    recIntList.insert(head.get(index), i);
                    i++;
                }
            }
            index++;
            if (index == this.size()) {
                return recIntList;
            }
            return helperKinguinSort(increasing, recIntList, index, i);

        }
    }


    public void kinguinSort(boolean increasing) {
        if (head == null) {
            return;
        }
        RecIntList recIntList = new RecIntList();
        int index = 0;
        int i = 0;
        recIntList = helperKinguinSort(increasing, recIntList, index, i);
        this.head = recIntList.head;
    }


    public void helperReverse(RecIntListElement temp, RecIntListElement current) {

        temp = current.getPrev();
        current.setPrev(current.getNext());
        current.setNext(temp);
        System.out.println(current);
        current = current.getPrev();
      //  System.out.println(current);

        if (temp != null) {
          //  System.out.println(p);
            head = temp.getPrev();
            //System.out.println(head);

        }
       // System.out.println(head);
        if (current == null) {
           // System.out.println();

            //return temp.getPrev();
            return;
        }
        //i++;
         helperReverse(temp, current);

    }

    public void reverse() {
        if (head == null) {
            return;
        }
        if (head.getNext() == null) {
            return;
        }
//        if (size() == 1) {
//            return;
//        }
//        // int count= (int) Math.ceil((double) size()/2);
//        int index = size() - 1;
//        int i = 0;
        // RecIntList recIntList = new RecIntList();
        RecIntListElement temp = null;
        RecIntListElement current = head;

        helperReverse(temp, current);
        // System.out.println(head);
        // this.head=recIntList.head;


    }

    public static RecIntListElement helperMerge(RecIntListElement one, RecIntListElement two,int count,int i,int j) {
//        if(i>= one.size()){
//            j++;
//            two.setNext(helperMerge(one,two.getNext(),i ,j ));
//            two.getNext().setPrev(two);
//            two.setPrev(null);
//            return two;
//        }
//        if(j>=two.size()){
//            i++;
//            one.setNext(helperMerge(one.getNext(),two,i ,j ));
//            one.getNext().setPrev(one);
//            one.setPrev(null);
//            return one;
//        }

        if (one == null) {
            one = two;
            return one;
        }
        // If second linked list is empty
        if (two == null) {
            return one;
        }
        count++;



        // Pick the smaller value
        if (count % 2==0 || count>j ) {
              i++;
            one.setNext(helperMerge(one.getNext(), two,count , i, j));
            one.getNext().setPrev(one);
            one.setPrev(null);
            return one;
        } else {
            j++;
            two.setNext(helperMerge(one, two.getNext(),count ,i , j));
            two.getNext().setPrev(two);
            two.setPrev(null);
            return two;
        }
    }


    public static void zip(RecIntList l1, RecIntList l2) {
        RecIntListElement one = l1.head;
        RecIntListElement two = l2.head;
//        if (l1.size()==0) {
//            l1=l2;
//            System.out.println("hayya");
//            return;
//        }
        if(l1.size()==0){
            l1.head=l2.head;
            return;
        }
        // If second linked list is empty
        if (l2==null) {
            return;
        }
        int count=-1;
        int i=l1.size();
        int j=l2.size();


        //assert one != null;
        //System.out.println(one);
        l1.head = helperMerge(one, two,count,i,j);


    }

    public static void main(String[] args) {
        RecIntList recIntList = new RecIntList();
        RecIntList l1 = new RecIntList();
        l1.append(-1);
        l1.append(1);
        l1.append(1);
        l1.append(88);


        RecIntList l2 = new RecIntList();
        l2.append(-2);
        l2.append(4);
        l2.append(6);

        zip(l1, l2 );
        //System.out.println(l1.head);


        // recIntList.append(1);
//        if (recIntList.head == null) {
//            System.out.println(recIntList);
//        }
        // recIntList.append(2);
        // recIntList.append(3);
//        recIntList.append(4);
//        recIntList.append(5);


//     }
        // System.out.println(temp.getPrev());
        // System.out.println(recIntList.get(3));

        // countThresh example
        RecIntList countThreshExample = new RecIntList();
        for (int i = 1; i <= 5; i++) {
            countThreshExample.append(i);
        }
        //   System.out.println(Arrays.toString(countThreshExample.countThresh(3)));

        // kinguinSort example (1)
        RecIntList kinguinSortExample = new RecIntList();
        int[] kinguinSortvalues = new int[]{3, 3, 2, 4, 7, 1, 6, 5, 9, 8};
        for (int i : kinguinSortvalues) {
            kinguinSortExample.append(i);
        }
        kinguinSortExample.kinguinSort(false); // false for example (2)
        // System.out.println(kinguinSortExample);

        // reverse example
        RecIntList reverseExample = new RecIntList();
        for (int i = 1; i < 6; i++) {
            reverseExample.append(i);
        }
        reverseExample.reverse();
        System.out.println(reverseExample);

 //        zip example
//        RecIntList l1 = new RecIntList();
//        RecIntList l2 = new RecIntList();
//        for (int i = 1; i <= 5; i += 2) {
//            l1.append(i);
//            l2.append(i + 1);
//        }
//        l1.append(7);
//        l1.append(8);
//          RecIntList.zip(l1, l2);
//         System.out.println(l1);
    }
}
