package pgdp.messenger;

import java.time.*;


public class List {
    private ListElement head;
    private ListElement tail;

    private int size;

    public List() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Fügt die übergebene 'message' am übergebenen 'index' ein.
     * Wenn der 'index' out of bounds liegt oder die 'message' 'null' ist, geschieht nichts.
     *
     * @param index   Ein beliebiger Integer
     * @param message Eine beliebige Message-Referenz
     */
    public void insertAt(int index, Message message) {
        if (index > size || index < 0 || message == null) {
            return;
        }
        if (head == null) {
            head = tail = new ListElement(message, null);
        } else if (index == 0) {
            head = new ListElement(message, head);
        } else if (index == size) {
            add(message);
            return;
        } else {
            ListElement prev = null;
            ListElement current = head;
            for (int i = 0; i < index; i++) {
                prev = current;
                current = current.getNext();
            }
            prev.setNext(new ListElement(message, current));
        }
        size++;
    }

    /**
     * Fügt die übergebene 'message' am Ende dieser Liste hinzu. Wenn die Message 'null' ist, geschieht nichts.
     *
     * @param message Eine beliebige Message-Referenz
     */
    public void add(Message message) {
        if (message == null) {
            return;
        }
        if (tail == null) {
            head = tail = new ListElement(message, null);
        } else {
            tail.setNext(new ListElement(message, null));
            tail = tail.getNext();
        }
        size++;
    }

    /**
     * Entfernt die übergebene 'message' (das konkrete Objekt) aus der Liste.
     * Wenn es nicht enthalten ist (oder 'message == null' ist), geschieht nichts.
     *
     * @param message Eine beliebige Message-Referenz
     */
    public void delete(Message message) {
        ListElement prev = null;
        ListElement current = head;
        while (current != null) {
            if (current.getMessage() == message) {
                if (prev == null) {
                    head = head.getNext();
                } else {
                    prev.setNext(current.getNext());
                    if (current.getNext() == null) {
                        tail = prev;
                    }
                }
                size--;
                return;
            }
            prev = current;
            current = current.getNext();
        }
    }

    /**
     * Gibt die aktuelle Größe dieser Liste zurück.
     *
     * @return Die Größe dieser Liste
     */
    public int size() {
        return size;
    }

    /**
     * Gibt die Message an der 'index'-ten Stelle dieser Liste zurück.
     * Wenn der übergebene 'index' out of bounds liegt, wird 'null' zurückgegeben.
     *
     * @param index Ein beliebiger Integer
     * @return Die gefundene Message oder 'null'
     */
    public Message getByIndex(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        ListElement current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getMessage();
    }

    /**
     * Gibt die Message mit der übergebenen ID zurück, falls sie sich in der Liste befindet, 'null' sonst.
     *
     * @param id Ein beliebiger Long
     * @return Die gefundene Message oder 'null'
     */
    public Message getByID(long id) {
        ListElement current = head;
        for (int i = 0; i < size; i++) {
            if (current.getMessage().getId() == id) {
                return current.getMessage();
            }
            current = current.getNext();

        }
        return null;
    }

//    public static List helperSort(List messages4, int n) {
//        if (n < 2) {
//            return messages4;
//        }
//        List left = new List();
//       // ListElement current = left.head;
//        int mid = n / 2;
//        int a = messages4.size / 2;
//        for (int i = 0; i < messages4.size / 2; i++) {
//            left.add(messages4.getByIndex(i));
//            //current = current.getNext();
//
//        }
//
//
//        List right = new List();
//       // current = right.head;
//        int b = messages4.size() - (messages4.size() / 2);
//        // int y=a;
//        for (int i = b-1; i < messages4.size; i++) {
//            right.add(messages4.getByIndex(i));
//           // b++;
//         //   current = current.getNext();
//
//        }
//
//        helperSort(left, mid);
//        //System.out.println("helper");
//        //System.out.println(messages4.toString());
//        helperSort(right, n - mid);
//       // System.out.println("helper");
//        // System.out.println(messages4.toString());
//      return HelperMerge(messages4, left, right, mid, n - mid);
//       //return messages4;
//
//
//
//    }

    public static List HelperMerge(List left, List right) {
        //int[] result = new int[arr1.length + arr2.length];
        List messages = new List();
        int l = left.size;
        int r = right.size;
        // ListElement current = messages.head;
        int i = 0, j = 0, k = 0;
        while (i < l && j < r) {
            if (left.getByIndex(i).getTimestamp().isBefore(right.getByIndex(j).getTimestamp()) || left.getByIndex(i).getTimestamp().isEqual(right.getByIndex(j).getTimestamp())) {

                messages.add(left.getByIndex(i));
                i++;
            } else {
                messages.add(right.getByIndex(j));
                j++;
            }
            //   current = current.getNext();
        }

        while (i < l) {
            messages.add(left.getByIndex(i));
            i++;
            //current = current.getNext();
        }


        while (j < r) {
            messages.add(right.getByIndex(j));
            j++;
            //  current = current.getNext();


        }

        return messages;
    }


    /**
     * Merged die übergebenen Listen in eine große Liste. Diese wird dann zurückgegeben.
     *
     * @param input Ein beliebiges Array von beliebigen Listen
     * @return Die gemergte Liste
     */

    public static List megaMerge(List... input) {
        if (input.length == 0) {
            return new List();
        }
        List messages = new List();
        int index = 0;
        messages = input[0];
        // ListElement current = messages.head;

        for (int i = 1; i < input.length; i++) {
            //  messages.add(input[index].getByIndex(i));
//            if(i<=input[index].size-2) {
//                //current = current.getNext();
//           }

            messages = HelperMerge(input[i], messages);
            //current=current.getNext();
//            if (i == input[index].size - 1) {
//                index++;
//                i = -1;
//            }
//            if (index == input.length) {
//                break;
        }//messages.add(input[index].);

        return messages;
    }


//        List left = new List();
//       //ListElement current = left.head;
//        int mid = messages.size() / 2;
//        int a = messages.size / 2;
//        for (int i = 0; i < messages.size / 2; i++) {
//            left.add(messages.getByIndex(i));
//            //current = current.getNext();
//
//        }
//
//
//        List right = new List();
//       // current = right.head;
//        int b = messages.size() - (messages.size() / 2);
//        // int y=a;
//        for (int i = b-1; i < messages.size; i++) {
//            right.add(messages.getByIndex(i));
//           // b++;
//         //   current = current.getNext();
//
//        }
//
//     //HelperMerge()


    // TODO: Implementiere diese Methode
    //  return null;


    /**
     * Gibt eine neue Liste zurück, die alle Messages dieser Liste, deren Time-Stamp zwischen 'start' (inklusive)
     * und 'end' (exklusive) liegt, in der gleichen Reihenfolge enthält.
     *
     * @param start Ein beliebiges LocalDateTime-Objekt
     * @param end   Ein beliebiges LocalDateTime-Objekt
     * @return Die gefilterte Liste
     */
    public List filterDays(LocalDateTime start, LocalDateTime end) {
        List messages = new List();
        if (head != null) {
            ListElement current = head;
            if (start == null || end == null) {
                return new List();
            }
            if (end.isBefore(start)) {
                return new List();
            }
            for (int i = 0; i < size; i++) {
                if (current.getMessage().getTimestamp().isAfter(start) && current.getMessage().getTimestamp().isBefore(end) || current.getMessage().getTimestamp().equals(start)) {
                    messages.add(current.getMessage());

                }
                current = current.getNext();
            }
            return messages;
        }
        return new List();
    }

    /**
     * Gibt eine neue Liste zurück, die alle Messages dieser Liste, deren Nutzer gleich 'user' ist, enthält.
     *
     * @param user Eine beliebige User-Referenz
     * @return Die gefilterte Liste
     */
    public List filterUser(User user) {
        List messages = new List();
        if (head != null) {
            ListElement current = head;

            for (int i = 0; i < size; i++) {
                if (current.getMessage().getAuthor() == user) {
                    messages.add(current.getMessage());

                }
                current = current.getNext();
            }
            return messages;
        }

        return new List();
    }


    /**
     * Gibt eine String-Repräsentation dieser Liste zurück. Dabei werden die String-Repräsentationen der einzelnen
     * Messages mit Zeilenumbrüchen aneinandergehängt.
     *
     * @return Die String-Repräsentation dieser Liste.
     */
    public String toString() {
        String messages = "";
        if (head != null) {
            ListElement current = head;

            for (int i = 0; i < size; i++) {
                if (i == 0) {
                    messages = current.getMessage().toString() + "\n";
                } else {
                    // messages.insert(0, current.getMessage().toString() + "\n");
                    messages = messages + current.getMessage().toString() + "\n";
                }
                current = current.getNext();
            }
            return messages;
        }

        return "";
    }


}
