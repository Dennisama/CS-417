/**
 * A Stack is a Last In First Out (LIFO) data structure.
 * It supports two basic operations called push and pop.
 *
 * @author Biao Zhang
 * @version 07/01/2020
 */
public class Stack {
    /**
     * All attributes.
     */
    private int[] arr = new int[10];
    private int index;

    /**
     * The default constructor.
     */
    public Stack() {
        index = -1;
    }

    /**
     * This method returns true if the Stack
     * is empty and false if the Stack is
     * not empty.
     *
     * @return whether it is empty.
     */
    public boolean isEmpty() {
        return index == -1;
    }

    /**
     * This method pushes, or adds, the int to
     * the stack if there is available space.
     *
     * @param e the new element
     * @return whether the method has
     * been done.
     */
    public boolean push(int e) {
        if (index == 9) {
            return false;
        }

        index += 1;
        arr[index] = e;
        return true;
    }

    /**
     * This method removes the next int
     * from the stack and returns it.
     *
     * @return the newest value.
     */
    public int pop() {
        int rem = arr[index];
        index -= 1;
        return rem;
    }

    /**
     * This method returns the next int from t
     * he Stack without removing.
     *
     * @return the newest value.
     */
    public int peek() {
        return arr[index];
    }

    /**
     * Override the toString() method to be able to
     * print the values in the stack separated by a
     * comma.
     *
     * @return the string representation.
     */
    public String toString() {
        if (index == -1) {
            return "";
        }

        StringBuilder ret = new StringBuilder();

        for (int i = index; i > 0; i--) {
            ret.append(arr[i]).append(",").append(" ");
        }

        ret.append(arr[0]);

        return ret.toString();
    }
}
