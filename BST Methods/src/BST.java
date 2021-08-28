public class BST<T extends Comparable<T>>{

    private Node root;
    private int size;

    // YOUR CODE HERE
    public void addAll(T[] array) {
        for (int i = 0; i < array.length; i++) {
            Node newnode = new Node(array[i]);

            if (root == null) {
                root = newnode;
                size++;
                continue;
            }

            Node curr = root;

            while (curr != null) {
                if (newnode.getValue().compareTo(curr.getValue()) > 0) {
                    if (curr.getRight() == null) {
                        curr.right = newnode;
                        newnode.parent = curr;
                        size++;
                        break;
                    }
                    curr = curr.getRight();
                } else {
                    if (curr.getLeft() == null) {
                        curr.left = newnode;
                        newnode.parent = curr;
                        size++;
                        break;
                    }
                    curr = curr.getLeft();
                }
            }
        }

    }

    public Node getRoot(){
        return root;
    }

    public int getSize(){
        return size;
    }

    public String toString(){
        String ret = toString( root, "", "" );
        if( !ret.equals("") ){
            ret = ret.substring( 0, ret.length()-1 );
        }
        return ret;
    }

    public String toString( Node node, String indent, String prefix ){
        String ret = "";

        if( node != null ){
            ret += toString( node.left, indent+"    ", "L " );
            ret += indent + prefix + node.value + "\n";
            ret += toString( node.right, indent+"    ", "R " );
        }

        return ret;
    }

    public class Node{
        T value;
        Node left;
        Node right;
        Node parent;

        public Node( T value ){
            this.value = value;
        }

        public T getValue(){
            return value;
        }

        public Node getLeft(){
            return left;
        }

        public Node getRight(){
            return right;
        }

        public Node getParent(){
            return parent;
        }
    }

}