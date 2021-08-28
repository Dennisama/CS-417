import java.util.Scanner;

/**
 * @author Biao Zhang
 * @version 1.0
 */
public class InputOutput {
    //Instance variable
    private Scanner scan = new Scanner(System.in);

    /**
     * The default constructor.
     */
    public InputOutput() {
        System.out.println("Enter 1 or 2");

        int input = scan.nextInt();

        if (input == 1) {
            tipCalculator();
        } else if (input == 2) {
            changeMachine();
        }
    }

    /**
     * This method will calculate the tip and total bill based on user
     * input and print the correct result.
     */
    public void tipCalculator() {
        System.out.println("Enter bill amount: ");
        double bill = scan.nextDouble();
        System.out.println("Percentage to tip: ");
        double ptip = scan.nextDouble();
        System.out.println("Number of people: ");
        int nperson = scan.nextInt();
        /*scan.nextInt()*/
        System.out.println();

        //Use Math.round(), not the format to show the result.
        double tip = bill * (ptip / 100);
        tip = Math.round(tip * 100.0) / 100.0;
        double total = Math.round((bill + tip) * 100.0) / 100.0;
        double pertip = Math.round(tip / nperson * 100.0) / 100.0;
        double pamount = Math.round(total / nperson * 100.0) / 100.0;

        System.out.print("Tip amount: $" +  tip + "\n");
        System.out.print("Total amount: $" + total + "\n");
        System.out.println();
        System.out.print("Tip per person: $" + pertip + "\n");
        System.out.print("Total per person: $" + pamount + "\n");
    }

    /**
     * This method will calculate the change due and the appropriate coins
     * that would be received base on user input.
     */
    public void changeMachine() {
        System.out.println("Total amount? ");
        double total = scan.nextDouble();
        System.out.println("Cash payment? ");
        double payment = scan.nextDouble();
        /*scan.nextInt()*/
        System.out.println();

        //Here I use the format, to do the comparison.
        double change = payment - total;
        System.out.print("Change Due " + String.format("$%.2f", change) + "\n");
        System.out.println();

        //Round changes up to two decimals
        int pchange = (int) Math.round(change * 100.0);
        int dollars = pchange / 100;
        int quarters = (pchange - dollars * 100) / 25;
        int dimes = (pchange - dollars * 100 - quarters * 25) / 10;
        int nickles = (pchange - dollars * 100 - quarters * 25 - dimes * 10) / 5;
        int pennies = pchange - dollars * 100 - quarters * 25 - dimes * 10 - nickles * 5;

        System.out.println("Dollars: " + dollars);
        System.out.println("Quarters: " + quarters);
        System.out.println("Dimes: " + dimes);
        System.out.println("Nickels: " + nickles);
        System.out.println("Pennies: " + pennies);

    }

    /**
     * Testing codes.
     * @param args no use
     */
    public static void main(String[] args) {
        InputOutput inoutput = new InputOutput();
    }
}
