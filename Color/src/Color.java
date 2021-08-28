/**
 * This is the 2nd project.
 * @author Biao Zhang
 * @version 1.0
 */
public class Color {
    //Static Vars
    static final Color BLACK = new Color(0, 0, 0);
    static final Color RED = new Color(255, 0, 0);
    static final Color GREEN = new Color(0, 255, 0);
    static final Color YELLOW = new Color(255, 255, 0);
    static final Color BLUE = new Color(0, 0, 255);
    static final Color MAGENTA = new Color(202, 31, 123);
    static final Color CYAN = new Color(0, 183, 235);
    static final Color WHITE = new Color(255, 255, 255);

    /**
     * Attributes in the class.
     */
    private int red;
    private int blue;
    private int green;

    /**
     *
     * @param red basic color
     * @param green basic color
     * @param blue basic color
     */
    public Color(int red, int green, int blue) {
        if (red < 0) {
            this.red = 0;
        } else if (red > 255) {
            this.red = 255;
        } else {
            this.red = red;
        }

        if (green < 0) {
            this.green = 0;
        } else if (green > 255) {
            this.green = 255;
        } else {
            this.green = green;
        }

        if (blue < 0) {
            this.blue = 0;
        } else if (blue > 255) {
            this.blue = 255;
        } else {
            this.blue = blue;
        }
    }

    /**
     *
     * @return String
     */
    public String toString() {
        String ret = String.format("#%02x%02x%02x", red, green, blue);
        return ret;
    }

    /**
     *
     * @param color it is an object
     * @return Object Color
     */
    public Color add(Color color) {

        this.red += color.red;
        if (this.red > 255) {
            this.red = 255;
        }

        this.green += color.green;
        if (this.green > 255) {
            this.green = 255;
        }

        this.blue += color.blue;
        if (this.blue > 255) {
            this.blue = 255;
        }

        return new Color(this.red, this.green, this.blue);
    }

    /**
     *
     * @param color it is an object
     * @return object Color
     */
    public Color sub(Color color) {

        this.red -= color.red;
        if (this.red < 0) {
            this.red = 0;
        }

        this.green -= color.green;
        if (this.green < 0) {
            this.green = 0;
        }

        this.blue -= color.blue;
        if (this.blue < 0) {
            this.blue = 0;
        }

        return new Color(this.red, this.green, this.blue);
    }

    /**
     *
     * @return object Color
     */
    public Color dim() {

        this.red = (int) Math.floor(this.red * 0.8);
        this.green = (int) Math.floor(this.green * 0.8);
        this.blue = (int) Math.floor(this.blue * 0.8);

        if (this.red < 0) {
            this.red = 0;
        }
        if (this.green < 0) {
            this.green = 0;
        }
        if (this.blue < 0) {
            this.blue = 0;
        }

        return new Color(this.red, this.green, this.blue);
    }

    /**
     *
     * @return object Color
     */
    public Color brighten() {

        this.red = (int) Math.floor(this.red * 1.2);
        this.green = (int) Math.floor(this.green * 1.2);
        this.blue = (int) Math.floor(this.blue * 1.2);

        if (this.red > 255) {
            this.red = 255;
        }
        if (this.green > 255) {
            this.green = 255;
        }
        if (this.blue > 255) {
            this.blue = 255;
        }

        return new Color(this.red, this.green, this.blue);
    }

    /**
     *
     * @return object Color
     */
    public Color darken() {

        this.red -= 32;
        if (this.red < 0) {
            this.red = 0;
        }

        this.green -= 32;
        if (this.green < 0) {
            this.green = 0;
        }

        this.blue -= 32;
        if (this.blue < 0) {
            this.blue = 0;
        }

        return new Color(this.red, this.green, this.blue);
    }

    /**
     *
     * @return object Color
     */
    public Color lighten() {

        this.red += 32;
        if (this.red > 255) {
            this.red = 255;
        }

        this.green += 32;
        if (this.green > 255) {
            this.green = 255;
        }

        this.blue += 32;
        if (this.blue > 255) {
            this.blue = 255;
        }

        return new Color(this.red, this.green, this.blue);
    }

    /**
     *
     * @param color it is an object
     * @return boolean
     */
    public boolean equals(Color color) {
        if (this.red == color.red && this.green == color.green && this.blue == color.blue) {
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @param args unused
     */
    public static void main(String[] args) {
        //Test 1
        /*Color c = new Color(255, 0, 0);
        System.out.println(c);*/
        //#ff0000

        //Test 2
        /*Color c = new Color(25,100,500);
        Color newColor = c.add(Color.BLUE);
        System.out.println("Color(" + newColor.red + "," + newColor.green + "," + newColor.blue + ")");*/
        //Color(25,100,255)

        //Test 3
        /*Color c = new Color(25,100,50);
        Color newColor = c.sub(new Color(35, 50, 10));
        System.out.println("Color(" + newColor.red + "," + newColor.green + "," + newColor.blue + ")");*/
        //Color(0,50,40)

        //Test 4
        /*Color c = new Color(25,100,50);
        Color newColor = c.dim();
        System.out.println("Color(" + newColor.red + "," + newColor.green + "," + newColor.blue + ")");*/
        //Color(20,80,40)

        //Test 5
        /*Color c = new Color(25,100,50);
        Color newColor = c.darken();
        System.out.println("Color(" + newColor.red + "," + newColor.green + "," + newColor.blue + ")");*/
        //Color(0,68,18)

        //Test 6
        /*Color c = new Color(255,255,0);
        System.out.println(c.equals(Color.YELLOW));*/
        //true

        //Test 7
        /*Color c = new Color(100,255,50);
        Color newColor = c.lighten();
        System.out.println("Color(" + newColor.red + "," + newColor.green + "," + newColor.blue + ")");*/
        //Color(132,255,82)

        //Test 8
        /*Color c = new Color(100,255,50);
        c.brighten();
        System.out.println("Color(" + c.red + "," + c.green + "," + c.blue + ")");*/
        //Color(120,255,60)
    }
}
