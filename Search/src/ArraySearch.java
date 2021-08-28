/**
 * In this lab you will write a program that implements
 * a Java interface with some search-related methods .
 *
 * @author Biao Zhang
 * @version 1.0
 * @param <T> generic form
 */
public class ArraySearch <T extends Comparable<? super T>> implements Search {
    /**
     * an instance variable.
     */
    private Comparable[] list;

    /**
     * The default constructor.
     *
     * @param list generic array
     */
    public ArraySearch(T[] list) {
        this.list = list;
    }

    /**
     * @return true if there are no element in the list
     */
    @Override
    public boolean isEmpty() {
        return list.length == 0;
    }

    /**
     * @return the number of elements in the list
     */
    @Override
    public int size() {
        return list.length;
    }

    /**
     * @return true if the list is sorted in ascending order
     * For example: 1, 2, 3, 7, 20
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
     * @param obj object to be searched for
     * @return the location of the element in the list starting at 0 or return -1 if not present
     */
    @Override
    public int index(Object obj) {
        for (int i = 0; i < list.length; i++) {
            if (list[i].compareTo(obj) == 0) {
                return i;
            }
        }
        return -1;
    }
}
