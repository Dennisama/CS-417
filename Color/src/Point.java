public class Point {

    // FIELDS OR INSTANCE VARIABLES (USUALLY PRIVATE)
    // a copy exists for every instance of this class (every Point object created)
    private int x;
    private int y;

    // STATIC VARIABLES
    // one copy exists for the class itself (not individual objects)
    private static int numPoints = 0;
    private static int maxX = 100;
    private static int maxY = 100;

    // CONSTRUCTOR
    public Point(int x, int y) {
        numPoints++;
        if(x <= maxX) {
            this.x = x;
        } else {
            this.x = maxX;
        }
        if(x <= maxY) {
            this.y = y;
        } else {
            y = maxY;
        }
    }

    // STATIC METHODS
    public static int getNumPoints() {
        return numPoints;
    }

    public static Point addPoints(Point p1, Point p2) {
        return new Point(p1.x + p2.x, p1.y + p2.y);
    }

    // MUTATOR
    public void setX(int x) {
        // x = x would only set the parameter equal to itself
        if(x <= maxX) {
            this.x = x; //change this point's x to be the parameter x
        } else {
            this.x = maxX;
        }
    }

    public void setY(int y) {

        if(x <= maxY) {
            this.y = y;
        } else {
            y = maxY;
        }
    }

    /*
    public void move(int dx,  int dy) {
        x += dx;
        y += dy;
    }
     */

    //////////////////////////////

    // ACCESSORS
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String toString() {
        String ret = "(" + x + ", " + y + ")";

        return ret;
    }

    public String coordinates() {
        String ret = x + " " + y;

        return ret;
    }

     /////////////////////////////


    public static void main(String[] args) {

        System.out.println("numPoints: " + Point.getNumPoints());
        Point p1 = new Point(0, 0); //stored as references to objects
        System.out.println("numPoints: " + Point.getNumPoints());
        Point p2 = new Point(0, 0);
        System.out.println("numPoints: " + Point.getNumPoints());
        Point p3 = new Point(1, 1 );
        System.out.println("numPoints: " + Point.getNumPoints());
        Point p4 = p1;
        System.out.println("numPoints: " + Point.getNumPoints());

        System.out.println("p1: " + p1);
        System.out.println("p2: " + p2);
        System.out.println("p3: " + p3);
        System.out.println("p4: " + p4);

        System.out.println("p1: " + p1);
        System.out.println("p4: " + p4);

        p4.setX(20);

        System.out.println("p1: " + p1);
        System.out.println("p4: " + p4);


        System.out.println("p1 == p2: " + (p1==p2));

        Point p5 = Point.addPoints(p1, p3);

        System.out.println("p5: " + p5);
    }
}
