public class NodeList {

    public class Node {
        int data;
        int next;
    }

    int head;
    int tail;
    int size;
    Node[] arr;

    public NodeList() {
        head = 0;
        tail = -1;
        size = 0;
        arr = new Node[10];
    }

    public void addHead(int val) {
        if(size >= arr.length) {
            System.out.println("List is full!");
            return;
        }

        size++;

        Node n = new Node();
        n.data = val;

        if(tail == -1) { // list was empty
            arr[0] = n;
            head = 0;
            tail = 0;
            return;
        }

        // find an empty space: O(n)
        int i;
        for(i=0; i < arr.length; i++) {
            if(arr[i] == null)
                break;
        }

        n.next = head;
        arr[i] = n;
        head = i;
    }

    public void addTail(int val) {
        if(size >= arr.length) {
            System.out.println("List is full!");
            return;
        }

        size++;

        Node n = new Node();
        n.data = val;
        n.next = -1;

        if(tail == -1) { // list was empty
            arr[0] = n;
            head = 0;
            tail = 0;
            return;
        }

        // find an empty space: O(n)
        int i;
        for(i=0; i < arr.length; i++) {
            if(arr[i] == null)
                break;
        }

        arr[tail].next = i;
        tail = i;
        arr[tail] = n;

    }

}
