import java.util.Scanner;

/**
 * The pay stub will show take-home pay for each pay period after
 * withholdings for taxes and retirement fund.
 * @author Biao Zhang
 * @version 1.0
 */
public class PayStub {
    private String name;
    private int anniversaryMonth;
    private int anniversaryYear;
    private int hours;
    private String title;
    private double payRate;
    private int monthWorked;
    private double vaHours;
    private double grPay;
    private double retWithhold;
    private double taxWithhold;
    private double ntPay;

    /**
     * The default constructor.
     */
    public PayStub() {
        /*this.name = "NoName";
        this.anniversaryMonth = 1;
        this.anniversaryYear = 1900;
        this.hours = 0;
        this.title = "NoTitle";
        this.payRate = 0;*/
    }

    /**
     * The overloading constructor, initializing all fields.
     * @param name employee name
     * @param anniversaryMonth Anniversary Month
     * @param anniversaryYear Anniversary Year
     * @param hours hours worked
     * @param title the job title
     * @param payRate the pay rate
     */
    public PayStub(String name, int anniversaryMonth, int anniversaryYear, int hours, String title, double payRate) {
        this.name = name;
        this.anniversaryMonth = anniversaryMonth;
        this.anniversaryYear = anniversaryYear;
        this.title = title;
        this.payRate = payRate;
        this.hours = hours;
        if (hours > 350) {
            this.hours = 350;
        } else if (hours < 0) {
            this.hours = 0;
        }
        this.monthWorked = this.numMonthsWorked();
        this.vaHours = this.vacationHours();
        this.grPay = this.grossPay();
        this.retWithhold = this.retHold();
        this.taxWithhold = this.tax();
        this.ntPay = this.netPay();
    }

    /**
     * @return employee name String
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return anniversary month int
     */
    public int getMonth() {
        return this.anniversaryMonth;
    }

    /**
     * @return anniversary year int
     */
    public int getYear() {
        return this.anniversaryYear;
    }

    /**
     * @return hours worked int
     */
    public int getHours() {
        return this.hours;
    }

    /**
     * @return job title String
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * @return the pay rate double
     */
    public double getPayRate() {
        return this.payRate;
    }

    /**
     * @return the number of months worked int
     */
    public int numMonthsWorked() {
        int yearsWorked;
        int monthsWorked;
        //It calculates Years worked first.
        if (this.anniversaryYear <= 2019) {
            yearsWorked = 2019 - this.anniversaryYear;
        } else {
            yearsWorked = 0;
        }

        //Based on the value of Years worked, we decide the value
        //of months worked.
        if (yearsWorked != 0) {
            monthsWorked = (1 + 12 * yearsWorked) - this.anniversaryMonth;
        } else {
            monthsWorked = 0;
        }

        return monthsWorked;
    }

    /**
     * @return the number of vacation hours double
     */
    public double vacationHours() {
        //vacation hours = months worked * 8.25
        return this.monthWorked * 8.25;
    }

    /**
     * @return the gross pay double
     */
    public double grossPay() {
        //gross payment = hours * payrate
        return this.hours * this.payRate;
    }

    /**
     * @return the retirement withholding double
     */
    public double retHold() {
        //retirement = gross pay * 5.2%
        return this.grPay * 0.052;
    }

    /**
     * @return the tax withholding double
     */
    public double tax() {
        //tax = (gross pay - retirement) * 28%
        return (this.grPay - this.retWithhold) * 0.28;
    }

    /**
     * @return the net pay double
     */
    public double netPay() {
        //net pay = gross pay - retirement - tax
        return this.grPay - this.retWithhold - this.taxWithhold;
    }

    /**
     *  It prints out the logo of the company.
     */
    public void drawLogo() {
        System.out.println("      Gekko & Co.");
        System.out.println();
        System.out.println("          \"$\"");
        System.out.println("          ~~~");
        System.out.println("         /  \\ `.");
        System.out.println("        /    \\  /");
        System.out.println("       /_ _ _ \\/\n");
    }

    /**
     * It print out the employee's personal information.
     */
    public void printInfo() {
        System.out.println("------------------------------------------");
        System.out.println("Pay Period:     1/2019");
        System.out.println("Name:           " + this.name);
        System.out.println("Title:          " + this.title);
        System.out.println("Anniversary:    " + String.format("%d/%d", this.anniversaryMonth, this.anniversaryYear));
        System.out.println("Months Worked:  " + this.monthWorked + " months");
        System.out.println("Vacation hours: " + String.format("%.2f", this.vaHours));
        System.out.println("------------------------------------------");
        System.out.println("Gross Pay:     " + String.format("$%7.2f", this.grPay));
        System.out.println("Retirement:    " + String.format("$%7.2f", this.retWithhold));
        System.out.println("Tax:           " + String.format("$%7.2f", this.taxWithhold));
        System.out.println("------------------------");
        System.out.println("Net Pay:       " + String.format("$%7.2f", this.ntPay));
    }

    /**
     * It is mainly for the test.
     * @param args unused
     */
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        System.out.print("Enter your Fullname: ");
        String inputname = scr.nextLine();
        System.out.print("Enter your Anniversary Month(1-12): ");
        int inputAMonth = scr.nextInt();
        System.out.print("Enter your Anniversary Year: ");
        int inputAYear = scr.nextInt();
        System.out.print("Enter your hours worked this pay period(0-350): ");
        int inputHours = scr.nextInt();
        /*the Scanner.nextInt method does not read the newline character in your
        input created by hitting "Enter," and so the call to Scanner.nextLine returns
        after reading that newline.*/
        scr.nextLine();
        System.out.print("Enter your Job Title: ");
        String inputTitle = scr.nextLine();
        System.out.print("Enter your pay rate: ");
        double inputPayRate = scr.nextDouble();

        PayStub paystub = new PayStub(inputname, inputAMonth, inputAYear, inputHours, inputTitle, inputPayRate);
        System.out.println("==========================================");
        paystub.drawLogo();
        paystub.printInfo();
        System.out.print("==========================================\n");

    }
}
