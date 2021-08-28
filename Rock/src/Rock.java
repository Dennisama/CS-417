public class Rock {
    //Fields
    private String Name;
    private double NumPounds;
    private double Volume;

    //Constructor
    public Rock(String Name){
        this.Name = Name;
    }

    //Mutator
    public void setName(String Name){
        this.Name = Name;
    }
    public void setNumPounds(double NumPounds){
        this.NumPounds = NumPounds;
    }
    public void setVolume(double Volume){
        this.Volume = Volume;
    }

    //Accessors
    public String getName(){return Name;}
    public double getNumPounds(){return NumPounds;}
    public double getVolume(){return Volume;}

    //Methods
    public int calculateDensity(){
        int Density = (int) (NumPounds / Volume);
        return Density;
    }

    public void increasePounds(double incPounds){
        NumPounds += incPounds;
    }

    public double decreasePounds(double decPounds){
        NumPounds -= decPounds;
        return NumPounds;
    }

    public String toString(){
        int Density = (int) (NumPounds / Volume);
        String ret = "Rock " + Name + " weighs " + String.format("%.3f",NumPounds)
                + " pounds with a density of " + Density;
        return ret;
    }

    public static void main(String[] args){
        //Test 1
        /*Rock r = new Rock("pet");
        r.setVolume(2.0);
        r.setNumPounds(10.0);
        System.out.println(r.calculateDensity());*/
        //5

        //Test 2
        /*Rock r = new Rock("pet");
        r.setNumPounds(10.0);
        r.increasePounds(5.0);
        System.out.println(r.getNumPounds());*/
        //15.0

        //Test 3
        /*Rock r = new Rock("pet");
        r.setNumPounds(10.0);
        System.out.println(r.decreasePounds(5.0));*/
        //5.0

        //Test 4
        Rock r = new Rock("pet");
        r.setVolume(2.0);
        r.setNumPounds(10.0);
        System.out.println(r);
        //Rock pet weighs 10.000 pounds with a density of 5
    }

}
