import java.util.Scanner;

/**
 * The Binary Search Tree.
 * @author Biao Zhang
 * @version 07/19/2020
 * @param <T> The type
 */
public class BST<T extends Comparable> implements Tree<T> {

    /**
     * The inner Node.
     */
    public class Node implements Tree.Node<T> {

        /**
         * All attributes.
         */
        private T value;
        private Node left;
        private Node right;
        private Node parent;

        /**
         * The constructor for Node.
         *
         * @param value the initial value of the node.
         */
        public Node(T value) {
            this.value = value;
        }

        /**
         * Set the value of this node.
         *
         * @param value Value
         */
        @Override
        public void setValue(T value) {
            this.value = value;
        }

        /**
         * Get the value of this node.
         *
         * @return T Value
         */
        @Override
        public T getValue() {
            return value;
        }

        /**
         * Gets the left child of this node.
         *
         * @return Node the left node.
         */
        public Node getLeft() {
            return left;
        }

        /**
         * Gets the right child of this node.
         *
         * @return Node the right node.
         */
        public Node getRight() {
            return right;
        }

        /**
         * Gets the parent of this node.
         *
         * @return Node the parent node.
         */
        public Node getParent() {
            return parent;
        }
    }

    /**
     * All attributes.
     */
    private Node root;
    private int size;

    /**
     * The constructor for BST.
     */
    public BST() {
        root = null;
        size = 0;
    }

    /**
     * Returns the root of the BST.
     *
     * @return Node the root
     */
    public Node getRoot() {
        return root;
    }

    /**
     * Appends the specified value to this tree. Does not allow duplicates.
     *
     * @param value T The value to add
     * @return boolean True if the value is inserted, false otherwise
     */
    @Override
    public boolean add(T value) {
        boolean added = true;
        if (root == null) {
            root = new Node(value);
        } else {
            added = addNode(root, value);
        }
        if (added) {
            size++;
        }

        return added;
    }

    /**
     * A recursive method to add a new Type value to the subtree
     * rooted at the first argument.
     *
     * @param parent Node       subtree to which value is to be added
     * @param newVal T          Value to be added to the tree
     * @return boolean          true if add was successful
     */
    @SuppressWarnings("unchecked")
    private boolean addNode(Node parent, T newVal) {
        boolean added = true;
        int cmp = parent.value.compareTo(newVal);
        if (cmp > 0) {
            if (parent.left != null) {
                added = addNode(parent.left, newVal);
            } else {
                parent.left = new Node(newVal);
                parent.left.parent = parent;
            }
        } else if (cmp == 0) {
            added = false;
        } else {
            if (parent.right != null) {
                added = addNode(parent.right, newVal);
            } else {
                parent.right = new Node(newVal);
                parent.right.parent = parent;
            }
        }
        return added;
    }

    /**
     * Generate a string representation of the tree.
     *
     * @return String       a string representation of the tree.
     */
    public String toString() {
        String ret = toString(root, "  ", "");

        return ret.replaceAll("\n$", "");
    }

    /**
     * Recursively generate a string representation for a Node of a tree;
     * indent is increased for increasing depth.
     * Branch is a short string that prefixes each node indicating
     * whether the node is a left (L) or right (R) child.
     *
     * @param n      Node         subtree to convert to string
     * @param indent String  prefix string for indentation level
     * @param branch String  (L) or (R)
     * @return String        string rep of subtree
     */
    private String toString(Node n, String indent, String branch) {
        String s = "";
        if (n != null) {
            if (n.left != null) {
                s += toString(n.left, indent + "      ", "L ");
            }
            String prefix = indent.substring(0, indent.length() - 2)
                    + branch;
            //The toString here is a default method.
            s += prefix + n.value.toString() + "\n";
            if (n.right != null) {
                s += toString(n.right, indent + "      ", "R ");
            }
        }
        return s;
    }

    /**
     * Removes all of the elements from this tree.
     */
    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    /**
     * Returns true if this tree contains the specified element.
     *
     * @param o Object The element to check if present in the tree
     * @return boolean
     */
    @Override
    @SuppressWarnings("unchecked")
    public boolean contains(Object o) {
        Node curr = root;

        while (curr != null) {
            if (curr.value.compareTo(o) > 0) {
                curr = curr.left;
            } else if (curr.value.compareTo(o) < 0) {
                curr = curr.right;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the element that matches the object parameter in this tree.
     *
     * @param o Object to search the tree for matching elements.
     * @return T
     */
    @Override
    @SuppressWarnings("unchecked")
    public T get(Object o) {
        Node curr = root;

        while (curr != null) {
            if (curr.value.compareTo(o) > 0) {
                curr = curr.left;
            } else if (curr.value.compareTo(o) < 0) {
                curr = curr.right;
            } else {
                return curr.value;
            }
        }

        return null;
    }

    //---------------------- addToFarRight( node, node ) ----------------

    /**
     * Add subtree Node as the right most descendant of the 1st argument.
     *
     * @param n       Node        root of tree to which subtree must be added
     * @param subtree Node  subtree to be added to far right of subtree
     */
    public void addToFarRight(Node n, Node subtree) {

        while (n.right != null) {
            n = n.right;
        }
        n.right = subtree;
        subtree.parent = n;

    }
    //----------------------- addToFarLeft( Node, Node ) --------------

    /**
     * Add subtree Node as the left most descendant of the 1st argument.
     *
     * @param n       Node        root of tree to which subtree must be added
     * @param subtree Node  subtree to be added to far left of subtree
     */

    public void addToFarLeft(Node n, Node subtree) {

        while (n.left != null) {
            n = n.left;
        }
        n.left = subtree;
        subtree.parent = n;

    }

    //-------------------- removeRight( Node, Node ) -------------------

    /**
     * Remove a node that is the right child of its parent.
     *
     * @param parent Node
     * @param n      Node
     */
    private void removeRight(Node parent, Node n) {

        if (n.right != null && n.left != null) {
            addToFarLeft(n.right, n.left);
            parent.right = n.right;
            n.right.parent = parent;
        } else if (n.right != null) {
            parent.right = n.right;
            n.right.parent = parent;
        } else if (n.left != null) {
            parent.right = n.left;
            n.left.parent = parent;
        } else {
            parent.right = null;
        }

    }
    //-------------------- removeLeft( Node, Node ) --------------------

    /**
     * Remove a node that is the left child of its parent.
     *
     * @param parent Node
     * @param n      Node
     */

    private void removeLeft(Node parent, Node n) {

        if (n.right != null && n.left != null) {
            addToFarRight(n.left, n.right);
            parent.left = n.left;
            n.left.parent = parent;
        } else if (n.right != null) {
            parent.left = n.right;
            n.right.parent = parent;
        } else if (n.left != null) {
            parent.left = n.left;
            n.left.parent = parent;
        } else {
            parent.left = null;
        }

    }
    //-------------------- removeRoot( ) ------------------------------

    /**
     * Remove the root node.
     */

    private void removeRoot() {

        if (root.right != null && root.left != null) {
            addToFarRight(root.left, root.right);
            root = root.left;
            root.parent = null;
        } else if (root.right != null) {
            root = root.right;
            root.parent = null;
        } else if (root.left != null) {
            root = root.left;
            root.parent = null;
        } else {
            root = null;
        }

    }

    /**
     * Removes the first occurrence of the specified element from this
     * tree, if it is present.
     * If tree does not contain the element, it is unchanged.
     * Returns true if this tree contained the specified element
     * (or equivalently, if this tree changed as a result of the call).
     *
     * @param o element to be removed from this tree, if present
     * @return true if this tree contained the specified element
     */
    @Override
    @SuppressWarnings("unchecked")
    public boolean remove(Object o) {

        Node curr = root;
        while (curr != null) {
            if (curr.value.compareTo(o) < 0) {
                curr = curr.right;
            } else if (curr.value.compareTo(o) > 0) {
                curr = curr.left;
            } else {
                if (curr == root) {
                    removeRoot();
                    size--;
                    return true;
                }

                if (curr.parent.left == curr) {
                    removeLeft(curr.parent, curr);
                    size--;
                    return true;
                }

                if (curr.parent.right == curr) {
                    removeRight(curr.parent, curr);
                    size--;
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Returns true if this tree contains no elements.
     *
     * @return true if this tree contains no elements
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of elements in this tree.
     *
     * @return int
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Testing codes.
     *
     * @param args no use.
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BST<String> bst = new BST<String>();
        boolean isstop = false;
        while (!isstop) {
            char command = input.next().charAt(0);
            if (command == 'a') {
                String addnode = input.next();
                bst.add(addnode);
                System.out.println(bst);
                System.out.println("------------------");
            } else if (command == 's') {
                System.out.println(bst.size());
                System.out.println("------------------");
            } else if (command == 'e') {
                System.out.println(bst.isEmpty());
                System.out.println("------------------");
            } else if (command == 'g') {
                String nodeval = input.next();
                String ret = bst.get(nodeval);
                System.out.println(ret);
                System.out.println("------------------");
            } else if (command == 'r') {
                String nodeval = input.next();
                bst.remove(nodeval);
                System.out.println(bst);
                System.out.println("------------------");
            } else if (command == 'c') {
                String nodeval = input.next();
                System.out.println(bst.contains(nodeval));
                System.out.println("------------------");
            } else if (command == 'C') {
                bst.clear();
                System.out.println(bst);
                System.out.println("------------------");
            } else if (command == 'x') {
                isstop = true;
            }
        }
    }

}
