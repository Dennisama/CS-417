public class Turtle{
    private String[] curr;

    public Turtle(){
        curr = new String[5];
        curr[0] = "  _____     ____";
        curr[1] = " /      \\  |  o | ";
        curr[2] = "|        |/ ___\\| ";
        curr[3] = "|_________/     ";
        curr[4] = "|_|_| |_|_|";
    }

    

    public String toString(){
        String ret = "";

        for( String s: curr ){
            ret += s + "\n";
        }
        
        return ret;
    }
}
