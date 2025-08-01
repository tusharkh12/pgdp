package pgdp.datastructures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UnitTest {
    static int seed = 69420;

    <Type extends Comparable<Type>> void testArray(Type[] input) {
        QuarternarySearchTree<Type> tree = new QuarternarySearchTree<Type>();
        Type[] expected = Arrays.copyOf(input, input.length);
        Arrays.sort(expected);

        for (Type element : input) {
            tree.insert(element);
        }

        int position = 0;
        for (Type element : tree) {
            Type exp = expected[position++];
            assertEquals(exp, element, "Invalid Output at position [" + (position - 1) + "]: Expected [" + exp
                    + "], got [" + element + "]");
        }

        assertEquals(expected.length, position,
                "Invalid Iteration Count. Expected [" + expected.length + "] got [" + position + "]");
    }

    @Test
    @DisplayName("should iterate over empty graph")
    public void emptyTest() {
        assertThrows(NoSuchElementException.class, () -> (new QuarternarySearchTree<Integer>()).iterator().next());
    }

    @Test
    @DisplayName("should iterate over graph in artemis example")
    public void artemisTest() {
        testArray(new Integer[] { 8, 4, 12, 1, 5, 9, 13, 3, 7, 11, 15, 2, 6, 10, 14 });
    }

    @Test
    @DisplayName("should iterate over a graph of one repeat element")
    public void oneElementTest() {
        testArray(new Integer[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 });
    }

    @Test
    @DisplayName("should iterate over a numeric graph")
    public void numericTest() {
        IntStream.range(0, 10).forEach(i -> {
            var args = new Integer[i];
            var rnd = new Random(seed + i);

            for (int j = 0; j < args.length; j++) {
                args[j] = rnd.nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
            }

            testArray(args);
        });
    }

    // private static int seedDifference = 0;
    // private static Stream<Arguments> testArray() {
    // 	// TODO improve this
    // 	return Stream.generate(() -> {
    // 		return arguments((new Random(seed + seedDifference++)).ints(seedDifference, 0, Integer.MAX_VALUE).toArray());
    // 	}).limit(10);
    // }

    private String generateString(Random rnd) {
        StringBuilder s = new StringBuilder();
        rnd.ints(rnd.nextInt(100), 97, 122).mapToObj(i -> (char) i).forEach(s::append);
        return s.toString();
    }

//    @Test
//    @DisplayName("should work with two iterators in parallel")
//    public void parallelIteratorsTest() {
//        QuarternarySearchTree<Integer> t = new QuarternarySearchTree<>();
//
//        Random random = new Random();
//        int[] values = IntStream.range(0, 20).map(__ -> random.nextInt()).toArray();
//        int[] expected = Arrays.copyOf(values, values.length);
//        Arrays.sort(expected);
//
//        for (var v : values) t.insert(v);
//
//        var iter1 = t.iterator();
//        var iter2 = t.iterator();
//
//        for (int i = 0; i < values.length; i++) {
//            int exp = expected[i];
//            int element1 = (int) iter1.next();
//            int element2 = iter2.next();
//
//            assertEquals(exp, element1, "Invalid Output at position [" + i + "] in Iterator 1: Expected [" + exp
//                    + "], got [" + element1 + "]");
//
//            assertEquals(exp, element2, "Invalid Output at position [" + i + "] in Iterator 2: Expected [" + exp
//                    + "], got [" + element2 + "]");
//        }
//
//        assertFalse(iter1.hasNext(), "Iterator 1 should be empty.");
//        assertFalse(iter2.hasNext(), "Iterator 2 should be empty.");
//    }

    @Test
    @DisplayName("should iterate over a non-numeric graph")
    public void stringTest() {
        IntStream.range(0, 10).forEach(i -> {
            var args = new String[i];
            var rnd = new Random(seed + i);

            for (int j = 0; j < args.length; j++) {
                args[j] = generateString(rnd);
                // System.out.println(args[j]);
            }

            testArray(args);
        });
    }

    @Test
    @DisplayName("should return the correct values for hasNext() on full tree")
    public void hasNextTest() {
        QuarternarySearchTree<Integer> tree = new QuarternarySearchTree<>();
        int i = 100;

        // fill the tree with a bunch of numbers
        for (int j = 0; j <= i; j++) {
            tree.insert(j);
        }

        var treeIt = tree.iterator();
        Assertions.assertTrue(treeIt.hasNext());
        for (int j = 0; j <= i; j++) {
            treeIt.next();
            if(j == i) {
                assertFalse(treeIt.hasNext());
            } else {
                Assertions.assertTrue(treeIt.hasNext());
            }
        }
    }

    @Test
    @DisplayName("should return the correct value for hasNext() on empty tree")
    public void hasNextTestEmpty() {
        assertFalse((new QuarternarySearchTree<Integer>()).iterator().hasNext());
    }
}