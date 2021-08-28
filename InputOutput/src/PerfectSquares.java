public class PerfectSquares implements Sequence {
    private int num;
    private boolean isset;

    public PerfectSquares() {
        isset = true;
        num = 1;
    }

    @Override
    public int nextVal() {
        if (isset) {
            isset = false;
            return num * num;
        }
        num += 1;
        return num * num;
    }

    @Override
    public void set(int num) {
        isset = true;
        this.num = num;
    }

    @Override
    public void reset() {
        isset = true;
        num = 1;
    }
}
