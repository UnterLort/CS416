/**
 * 
 * @author Kyle Stewart
 * @version 1
 * @param <T> Comparable type
 */
public class ArraySearch<T extends Comparable<? super T>> implements Search<T> {

    private Comparable[] list; // Array of Comparable objects

    /**
     * Constructs an ArraySearch object with the given list.
     * 
     * @param list array of Comparable objects
     */
    public ArraySearch(T[] list) {
        this.list = list;
    }

    /**
     * Checks if list is empty.
     * 
     * @return true if the list contains no elements
     */
    @Override
    public boolean isEmpty() {
        return list.length == 0;
    }

    /**
     * 
     * @return the number of elements in the list
     */
    @Override
    public int size() {
        return list.length;
    }

    /**
     * 
     * @return true if the list is sorted in ascending order
     */
    @Override
    public boolean isSorted() {
        for (int i = 0; i < list.length - 1; i++) {
            if (list[i].compareTo(list[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Searches for the specified object in the list.
     * 
     * @param obj object to be searched for
     * @return index of the element in the list if found, -1 otherwise
     */
    @Override
    public int index(Object obj) {
        for (int i = 0; i < list.length; i++) {
            if (list[i].equals(obj)) {
                return i;
            }
        }
        return -1;
    }
}