import java.util.Scanner;

/**
 * MAP I starter codes.
 * @author Biao Zhang
 * @version 06/30/2020
 * @param <T> Generic Type
 */
public class LinkedList<T> extends List<T> {
    /**
     * Attributes for doubly linked list.
     */
    private Node head;
    private Node tail;

    /**
     * Default constructor.
     */
    public LinkedList() {
        head = null;
        tail = null;
    }

    /**
     * Return the leading node.
     *
     * @return Node
     */
    public Node getHead() {
        return head;
    }

    /**
     * Return the tailing node.
     *
     * @return Node
     */
    public Node getTail() {
        return tail;
    }

    /**
     * Return the string representation.
     *
     * @return String representation [first, middle, last]
     */
    public String toString() {
        StringBuilder ret = new StringBuilder();
        Node curr = head;

        if (curr == null) {
            ret.append("[").append("]");
        } else {
            while (curr != null) {
                if (curr == head) {
                    ret.append("[").append(curr.value);
                } else {
                    ret.append(",").append(" ").append(curr.value);
                }
                curr = curr.next;
            }
            ret.append("]");
        }

        return ret.toString();
    }

    /**
     * Appends the specified value to the end of this list.
     *
     * @param value T The value to add
     * @return boolean True if the value is inserted, false otherwise
     */
    @Override
    boolean add(T value) {
        Node n = new Node(value);

        if (tail == null) {
            head = n;
            tail = n;
            return true;
        }

        // For the full Map I assignment, add will need to prevent duplicate values
        // being added to the list and should return true or false based on whether
        // the value was added or not. For this lab, you can ignore this requirement
        // and simply return true.
        Node curr = head;
        while (curr != null) {
            if (curr.value.equals(n.value)) {
                return false;
            }
            curr = curr.next;
        }

        tail.next = n;
        n.prev = tail;
        tail = n;

        return true;
    }

    /**
     * Inserts the specified value at the specified position in this list.
     *
     * @param index Integer The index at which to insert
     * @param value T The value to insert
     */
    @Override
    void add(int index, T value) {
        Node n = new Node(value);

        if (tail == null) {
            if (index == 0) {
                head = n;
                tail = n;
            }

            return;
        }

        Node target = null;
        int targetindex = -1;
        int i = 0;
        Node curr = head;
        while (curr != null) {
            if (curr.value.equals(n.value)) {
                return;
            }

            if (i == index) {
                target = curr;
                targetindex = i;
            }

            curr = curr.next;
            i++;
        }

        if (target != null) {
            if (targetindex == 0) {
                //Add at the head
                target.prev = n;
                n.next = target;
                head = n;
            } else if (targetindex > 0) {
                //Add in the middle
                target.prev.next = n;
                n.prev = target.prev;
                n.next = target;
                target.prev = n;
            }
        } else if (i == index) {
            //Add at the tail
            tail.next = n;
            n.prev = tail;
            tail = n;
        }

    }

    /**
     * Removes all of the elements from this list.
     */
    @Override
    void clear() {
        head = null;
        tail = null;
    }

    /**
     * Returns true if this list contains the specified element.
     *
     * @param o Object The element to check if present in the list
     * @return boolean
     */
    @Override
    boolean contains(Object o) {
        Node curr = head;

        while (curr != null) {
            if (curr.value.equals(o)) {
                return true;
            }
            curr = curr.next;
        }

        return false;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index Integer The index at which to insert
     * @return T
     */
    @Override
    T get(int index) {
        int i = 0;
        Node curr = head;

        while (curr != null) {
            if (i == index) {
                return curr.value;
            }

            curr = curr.next;
            i++;
        }

        return null;
    }

    /**
     * Get the list entry corresponding to the value provided in the parameter.
     *
     * @param o to search for
     * @return T matching data in the list
     */
    @Override
    T get(Object o) {
        Node curr = head;

        while (curr != null) {
            if (curr.value.equals(o)) {
                return curr.value;
            }
            curr = curr.next;
        }

        return null;
    }

    /**
     * Removes the element at the specified position in this list.
     * Returns the element from the list or null if index is invalid.
     *
     * @param index the index of the element to be removed
     * @return the element previously at the specified position or null
     */
    @Override
    T remove(int index) {
        Node curr = head;
        int i = 0;

        while (curr != null) {
            if (i == index) {
                if (head == tail) {
                    //Only one Node
                    head = null;
                    tail = null;
                } else if (curr == head) {
                    //Remove the head
                    head = curr.next;
                    head.prev = null;
                } else if (curr == tail) {
                    //Remove the tail
                    tail = curr.prev;
                    tail.next = null;
                } else {
                    //Remove the middle
                    curr.next.prev = curr.prev;
                    curr.prev.next = curr.next;
                }
            }

            curr = curr.next;
            i++;
        }

        return null;
    }

    /**
     * Removes the first occurrence of the specified element from this
     * list, if it is present.
     * If this list does not contain the element, it is unchanged.
     * Returns true if this list contained the specified element
     * (or equivalently, if this list changed as a result of the call).
     *
     * @param o element to be removed from this list, if present
     * @return true if this list contained the specified element
     */
    @Override
    boolean remove(Object o) {
        Node curr = head;
        while (curr != null) {
            if (curr.value.equals(o)) {
                if (head == tail) {
                    //Only one Node
                    head = null;
                    tail = null;
                } else if (curr == head) {
                    //Remove the head
                    head = curr.next;
                    head.prev = null;
                } else if (curr == tail) {
                    //Remove the tail
                    tail = curr.prev;
                    tail.next = null;
                } else {
                    //Remove the middle
                    curr.next.prev = curr.prev;
                    curr.prev.next = curr.next;
                }

                return true;
            }
            curr = curr.next;
        }

        return false;
    }

    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements
     */
    @Override
    boolean isEmpty() {
        if (head == null) {
            return true;
        }

        return false;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return int
     */
    @Override
    int size() {
        int s = 0;
        Node curr = head;
        while (curr != null) {
            s++;
            curr = curr.next;
        }

        return s;
    }

    /**
     * Testing for the codes.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedList<String> list = new LinkedList<String>();
        boolean isstop = false;
        while (!isstop) {
            char command = input.next().charAt(0);
            if (command == 'a') {
                String addnode = input.next();
                list.add(addnode);
                System.out.println(list);
                System.out.println("------------------");
            } else if (command == 'A') {
                int index = Integer.parseInt(input.next());
                String addnode = input.next();
                list.add(index, addnode);
                System.out.println(list);
                System.out.println("------------------");
            } else if (command == 's') {
                System.out.println(list.size());
                System.out.println("------------------");
            } else if (command == 'e') {
                System.out.println(list.isEmpty());
                System.out.println("------------------");
            } else if (command == 'g') {
                int index = Integer.parseInt(input.next());
                String ret = list.get(index);
                System.out.println(ret);
                System.out.println("------------------");
            } else if (command == 'R') {
                int index = Integer.parseInt(input.next());
                list.remove(index);
                System.out.println(list);
                System.out.println("------------------");
            } else if (command == 'r') {
                String nodeval = input.next();
                list.remove(nodeval);
                System.out.println(list);
                System.out.println("------------------");
            } else if (command == 'c') {
                String nodeval = input.next();
                System.out.println(list.contains(nodeval));
                System.out.println("------------------");
            } else if (command == 'C') {
                list.clear();
                System.out.println(list);
                System.out.println("------------------");
            } else if (command == 'x') {
                isstop = true;
            }

        }
        /*
        System.out.println(list.getHead());

        System.out.println(list.getTail());

        list.add("first");

        list.add("middle");

        list.add("last");

        System.out.println(list.getHead().value);

        System.out.println(list.getTail().value);

        System.out.println(list);
        */

    }
}
