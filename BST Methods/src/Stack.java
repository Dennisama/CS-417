public class Stack<T> {
    private LinkedList<T> linkedlist = new LinkedList<T>();

    public void push(T data) {
        linkedlist.addTail(data);
    }

    public T pop() {
        return linkedlist.remTail();
    }

    public LinkedList<T> getList() {
        return linkedlist;
    }
}
