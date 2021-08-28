public class LinkedList {
    public static class Node{
        String key;
        int value;
        Node next;
        Node prev;

        public Node(String key, int value) {
            this.key = key;
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public Node getPrev() {
            return prev;
        }

        public String getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }
    }

    private Node head;
    private Node tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public void addHead(String key, int val) {
        Node n = new Node(key, val);

        if(head == null) {
            head = n;
            tail = n;
        } else {
            head.prev = n;
            n.next = head;
            head = n;
        }
    }

    public void addTail(String key, int val) {
        Node n = new Node(key, val);

        if(tail == null) {
            head = n;
            tail = n;
        } else {
            tail.next = n;
            n.prev = tail;
            tail = n;
        }
    }

    public String toString() {
        String ret = "";

        Node curr = head;

        while(curr != null) {
            if(curr.next != null)
                ret += curr.key + ":" + curr.value + ", ";
            else
                ret += curr.key + ":" + curr.value;
                
            curr = curr.next;
        }
        
        return ret;
    }

    public Node find(String key) {
        Node curr = head;

        while(curr != null) {
            if(curr.key.equals(key))
                return curr;

            curr = curr.next;
        }

        return null;
    }


    //////////////////////// YOUR CODE HERE ////////////////////////

    public void unlinkNode(Node n) {
        if (n.prev == null && n.next == null) {
            head = null;
            tail = null;
            return;
        }

        if (n.prev == null) {
            n.next.prev = null;
            head = n.getNext();
            return;
        }

        if (n.next == null) {
            tail = n.getPrev();
            n.prev.next = null;
            return;
        }

        n.prev.next = n.getNext();
        n.next.prev = n.getPrev();
    }

    public void addAfter(Node n, Node before) {
        n.prev = before;
        n.next = before.getNext();

        if (before.next != null) {
            before.next.prev = n;
        } else {
            tail = n;
        }

        before.next = n;
    }

    public boolean swapIfNeeded(Node n) {
        if (n.next == null) {
            return false;
        }

        if (n.getKey().compareTo(n.getNext().getKey()) > 0) {
            Node temp = n.getNext();
            unlinkNode(n);
            addAfter(n, temp);
            return true;
        }

        return false;
    }

    public void sort() {
        boolean issort = false;
        boolean isswap;
        Node n;

        while (!issort) {
            isswap = false;
            n = head;

            if (n == null) {
                return;
            }

            while (n != null) {
                if (swapIfNeeded(n)) {
                    isswap = true;
                }
                n = n.getNext();
            }

            if (!isswap) {
                issort = true;
            }
        }
    }
    ///////////////////////////////////////////////////////////////

}
