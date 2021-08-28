public class Queue<T> {

    private LinkedList<T> linkedlist = new LinkedList<T>();

    public void add(T data) {
        linkedlist.addTail(data);
    }

    public T remove() {
        return linkedlist.remHead();
    }

    public LinkedList<T> getList() {
        return linkedlist;
    }
}
