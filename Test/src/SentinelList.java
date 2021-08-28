public class SentinelList {

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

    public SentinelList() {
        head = new Node(-1);
        tail = new Node(-1);

        head.next = tail;
        tail.prev = head;
    }

    public int getHead() {
        return head.next.data;
    }

    public int getTail() {
        return tail.prev.data;
    }

    public void addHead(int data) {
        Node n = new Node(data);

        head.next.prev = n;
        n.next = head.next;
        n.prev = head;
        head.next = n;

    }

    public void addTail(int data) {
        Node n = new Node(data);

        tail.prev.next = n;
        n.prev = tail.prev;
        n.next = tail;
        tail.prev = n;

    }

    public String toString() {
        String ret = "";
        Node curr = head.next;
        while (curr != tail) {
            ret += curr.data + " ";
            curr = curr.next;
        }

        return ret;
    }

    public void remHead() {
        // Empty list
        if (head.next == tail) {
            return;
        }

        head.next = head.next.next;
        head.next.prev = head;

    }

    public void remTail() {
        // Empty list
        if (tail.prev == head) {
            return;
        }

        tail.prev = tail.prev.prev;
        tail.prev.next = tail;

    }

    public static void main(String[] args) {
        SentinelList l = new SentinelList();

        System.out.println("Building the Sentinel list.");
        l.addHead(7);
        l.addHead(12);
        l.addHead(5);
        l.addTail(10);
        System.out.println(l.getHead());
        System.out.println(l.getTail());
        System.out.println(l);

        System.out.println("Removing from the Sentinel list");
        l.remHead();
        l.remTail();
        System.out.println(l.getHead());
        System.out.println(l.getTail());
        System.out.println(l);
    }
}
