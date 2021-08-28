public class LinkedList {
    public class Node{ //inner class
        int data;
        Node next;
        Node prev;

        public Node(int data){
            this.data = data;
        }
    }

    public Node head;
    public Node tail;

    public LinkedList(){
        head = null;
        tail = null;
    }

    // YOUR CODE HERE
    public void addInOrder(int val) {

        if (head == null) {
            addHead(val);
            return;
        }

        Node n = new Node(val);
        Node curr = head;
        boolean isadded = false;

        while (curr != null) {
            if (n.data <= curr.data) {
                if (curr == head) {
                    addHead(val);
                    isadded = true;
                    break;
                } else {
                    curr.prev.next = n;
                    n.prev = curr.prev;
                    n.next = curr;
                    curr.prev = n;
                    isadded = true;
                    break;
                }
            }
            curr = curr.next;
        }

        if (!isadded) {
            addTail(val);
        }
    }

    public void addHead( int data ){
        Node n = new Node( data );
        if(head == null){ //empty list
            tail = n;
        }
        else{
            head.prev = n;
        }
        n.next = head;

        head = n;
    }

    public void addTail( int data ){
        Node n = new Node( data );
        if(tail == null){ //empty list
            head = n;
        }
        else{
            tail.next = n;
        }
        n.prev = tail;
        tail = n;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public String toString() {
        String res = "";

        Node curr = head;

        if (curr != null) {
            res += curr.data;
            curr = curr.next;
        }

        while (curr != null) {
            res += ", " + curr.data;
            curr = curr.next;
        }

        return res;
    }
}
