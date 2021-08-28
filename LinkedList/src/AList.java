public class AList {

    int head;
    int tail;
    int[] arr;

    public AList() {
        head = 0;
        tail = -1;
        arr = new int[10];
    }

    public void addHead(int val){ // O(n)
        if(tail == (arr.length -1)) {
            System.out.println("List is full!");
            return;
        }

        for(int i = tail+1; i > 0; i--) {
            arr[i] = arr[i-1];
        }

        arr[0] = val;

        tail++;
    }

    public void addTail(int val){ // O(1)
        if(tail == (arr.length -1)) {
            System.out.println("List is full!");
            return;
        }
        arr[tail+1] = val;
        tail++;
    }

    public int get(int index) {
        return arr[index];
    }

}
