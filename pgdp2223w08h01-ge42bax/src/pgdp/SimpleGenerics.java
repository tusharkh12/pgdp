package pgdp;

import java.lang.reflect.Array;
import java.util.*;

public final class SimpleGenerics {

    private SimpleGenerics() {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns a String of the given Collection.
     *
     * @param collection
     * @return String representation of the collection
     */
    public static String toString(Collection<?> collection) {
        //collection.add(collection.size());
        if (collection.size() == 0) {
            return "{}";
        }
        String result = "{";
        //result="{"+collection
        //Collection<Integer> array= (Collection<Integer>) collection;
        int a = 0;
        for (Object num : collection) {
            if (collection.size() - 1 == a) {
                result += num + "}";
                break;
            }
            result += num + ", ";
            a++;
        }
        //result+="}";
        return result;
    }

    /**
     * Returns int array of collection.
     *
     * @param collection
     * @return int array
     */
    public static int[] toIntArray(Collection<Integer> collection) {
        int[] array = new int[collection.size()];
        int i = 0;
        for (int num : collection) {
            array[i] = num;
            i++;
        }
        // TODO
        return array;
    }

    /**
     * Generates an generic array of type T with the given length.
     *
     * @param <T>
     * @param clazz
     * @param length
     * @return reference to the generated generic array
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] generateGenericArray(Class<T> clazz, int length) {
        final T[] arr = (T[]) Array.newInstance(clazz, length);
        return arr;
    }

    /**
     * Returns the given collection in a sorted array.
     *
     * @param <T>
     * @param clazz
     * @param collection
     * @param comparator dictates the order of the output
     * @return array of type T
     */
    public static <T> T[] specialSort(Class<T> clazz, Collection<T> collection, Comparator<T> comparator) {
        T[] array = generateGenericArray(clazz, collection.size());
        int x = 0;
        for (T a : collection) {
            array[x] = a;
            x++;
        }
        for (int i = 1; i < array.length; i++) {
            //comparator.compare(array[i - 1], array[i]);
            Arrays.sort(array, comparator);
        }

        return array;
    }

    /**
     * Returns a collection of all elements that are contained by each Collection of
     * collections. Collections of the input are not modified.
     *
     * @param <T>
     * @param collections not null, may not contain null values.
     * @return intersection of all collections
     */
    public static <T> Collection<T> intersection(Collection<T>[] collections) {
        if (collections.length == 0) {
            return new ArrayList<>();
        }
        //
        ArrayList<T> temp = new ArrayList<>(collections[0]);

        for (int i = 1; i < collections.length; i++) {
            temp.retainAll(collections[i]);
        }

        return temp;
    }

    /**
     * Returns the values stored in the map. Equivalent to map.values().
     *
     * @param <K> key type
     * @param <V> value type
     * @param map
     * @return set of values
     */
    public static <K, V> Set<V> getValues(Map<K, V> map) {
        Set<V> values=new HashSet<>();
        Set<K> keys=new HashSet<>(map.keySet());
        for (int i = 0; i < keys.size(); i++) {
          //  map.
            values.add(map.get(keys.toArray()[i]));
        }
        // TODO
        return values;
    }

    public static void main(String... args) {
        generateGenericArray(Integer.class, 5);
        //System.out.println(new ArrayList<>());

    }
}
