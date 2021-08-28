public class DoublyLinked {

    public class Node {
        private int data;
        private Node next;
        private Node prev;

        public Node (int data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;

    public int getHead() {
        return head.data;
    }

    public int getTail() {
        return tail.data;
    }

    public void addHead(int data) {
        Node n = new Node(data);

        if (head == null) {
            head = n;
            tail = n;
            return;
        }

        head.prev = n;
        n.next = head;
        head = n;
    }

    public void addTail(int data) {
        Node n = new Node(data);

        if (tail == null) {
            head = n;
            tail = n;
            return;
        }

        tail.next = n;
        n.prev = tail;
        tail = n;
    }

    public String toString() {
        String ret = "";
        Node curr = head;
        while (curr != null) {
            ret += curr.data + " ";
            curr = curr.next;
        }

        return ret;
    }

    public void remHead() {
        if (head == tail) {
            head = null;
            tail = null;
            return;
        }

        head = head.next;
        head.prev = null;
    }

    public void remTail() {
        if (tail == head) {
            tail = null;
            head = null;
            return;
        }

        tail = tail.prev;
        tail.next = null;
    }

    public static void main(String[] args) {
        DoublyLinked l = new DoublyLinked();

        System.out.println("Building the Doubly linked list.");
        l.addHead(7);
        l.addHead(12);
        l.addHead(5);
        l.addTail(10);
        System.out.println(l.getHead());
        System.out.println(l.getTail());
        System.out.println(l);

        System.out.println("Removing from the Doubly linked list");
        l.remHead();
        l.remTail();
        System.out.println(l.getHead());
        System.out.println(l.getTail());
        System.out.println(l);
    }
}
