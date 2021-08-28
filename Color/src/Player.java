public class Player {
    private String name;
    private Point loc;

    public Player(String name, Point loc) {
        this.name = name;
        this.loc = loc;
    }


    public String toString() {
        String ret = "";

        ret = "The name: " + this.name + " at points (" + this.loc.getX() + "," + this.loc.getY() + ")";

        return ret;
    }

    public void move(int x, int y){
        this.loc.setX(this.loc.getX() + x);
        this.loc.setY(this.loc.getY() + y);
    }


    public static void main(String[] args) {
        Player p1 = new Player("Sofia", new Point(0,0));
        Player p2 = new Player("Steve", new Point(0,0));
        Player p3 = new Player("Sarah", new Point(3,3));

        System.out.println("p1: " + p1);
        System.out.println("p2: " + p2);
        System.out.println("p3: " + p3);


        p1.move(5, 10); //move's player 1's x by 5 and y by 10
        p2.move(5, 10);
        p3.move(5, 10);


        System.out.println("p1: " + p1);
        System.out.println("p2: " + p2);
        System.out.println("p3: " + p3);

    }
}
