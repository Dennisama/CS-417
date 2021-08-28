public class SinglyLinked {

    public class Node {
        private int data;
        private Node next;

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
    }

    public void remTail() {
        if (tail == head) {
            tail = null;
            head = null;
            return;
        }

        Node curr = head;
        while (curr.next != tail) {
            curr = curr.next;
        }

        curr.next = null;
        tail = curr;
    }

    public static void main(String[] args) {
        SinglyLinked l = new SinglyLinked();

        System.out.println("Building the list.");
        l.addHead(7);
        l.addHead(12);
        l.addHead(5);
        l.addTail(10);
        System.out.println(l.getHead());
        System.out.println(l.getTail());
        System.out.println(l);

        System.out.println("Removing from the list");
        l.remHead();
        l.remTail();
        System.out.println(l.getHead());
        System.out.println(l.getTail());
        System.out.println(l);
    }
}
