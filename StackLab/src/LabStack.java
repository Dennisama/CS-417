import java.util.ArrayList;

/**
 * Here you will utilize the methods from Stack.java.
 *
 * @author Biao Zhang
 * @version 07/01/2020
 */
public class LabStack {

    /**
     * This method pops n items from st and returns an ArrayList
     * that contains all the values that were popped.
     *
     * @param st the stack
     * @param i index
     * @return array list containing elements in the stack
     * to index i
     */
    public static ArrayList<Integer> popN(Stack st, int i) {
        ArrayList<Integer> newarr = new ArrayList<Integer>();
        if (i == 0) {
            return newarr;
        }

        for (int index = 0; index < i; index++) {
            newarr.add(st.pop());
        }

        return newarr;
    }

    /**
     * This method pops all items from st and returns an ArrayList
     * that contains all the values that were popped.
     *
     * @param st the stack
     * @return array list containing all elements in the stack
     */
    public static ArrayList<Integer> popAll(Stack st) {
        ArrayList<Integer> newarr = new ArrayList<Integer>();

        while (!st.isEmpty()) {
            newarr.add(st.pop());
        }

        return newarr;
    }

    /**
     * It returns the new int array, which should
     * contain all the values from arr reversed.
     *
     * @param arr the original array
     * @return the reversed array
     */
    public static int[] reverse(int[] arr) {
        Stack st = new Stack();

        for (int value : arr) {
            st.push(value);
        }

        int[] revarr = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            revarr[i] = st.pop();
        }

        return revarr;
    }
}
