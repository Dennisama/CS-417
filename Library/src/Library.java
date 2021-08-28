import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class representing a library and providing an interactive user interface for
 * checking items in and out of the library.
 *
 * @author Sofia Lemons
 * @version 1.0
 */
public class Library {

    private ArrayList<Item> catalog;
    private ArrayList<Item> searches;
    private Scanner scn;
    private int year;
    private int month;
    private int day;
    private boolean isopen;
    private boolean ispatronset;
    private boolean issearched;
    private ArrayList<Patron> patrons;
    private Patron currentpatron;


    /**
     * Constructor for the Library class.
     *
     * @param catalog The catalog of all available items.
     * @param input The source of user input.
     * @param year The current year.
     * @param month The current month.
     * @param day The current day.
     */
    public Library(ArrayList<Item> catalog, Scanner input,
                   int year, int month, int day) {
        this.catalog = catalog;
        this.scn = input;
        this.year = year;
        this.month = month;
        this.day = day;

        searches = new ArrayList<Item>();
        patrons = new ArrayList<Patron>();

        isopen = false;
        ispatronset = false;
        issearched = false;
    }

    /**
     * Returns the complete library catalog of all available items.
     * @return available items
     */
    public ArrayList<Item> getCatalog() {
        ArrayList<Item> availablelist = new ArrayList<Item>();
        for (Item item : catalog) {
            if (!item.isCheckedOut()) {
                availablelist.add(item);
            }
        }
        return availablelist;
    }

    /**
     * Returns the current date stored for the library.
     *
     * @return LocalDate
     */
    public LocalDate getCurrDate() {
        LocalDate currdate = LocalDate.of(year, month, day);

        return currdate;
    }

    /**
     * Opens the library for the day, modifying instance variables to
     * represent the library being open.
     *
     * @return printing overdue items.
     */
    public String open() {
        StringBuilder ret = new StringBuilder();
        currentpatron = new Patron("", 000);
        if (!isOpen()) {
            ret.append("Overdue items:");
            if (patrons != null) {
                for (Patron patron : patrons) {
                    for (Item item : patron.getItems()) {
                        if (getCurrDate().isAfter(item.getDueDate())) {
                            ret.append("\n").append("    ").append(patron.basicInfo())
                                    .append(": ").append(item.basicInfo()).append(" was due on ")
                                    .append(item.getDueDate());
                        }

                    }
                }
            }
            isopen = true;
        }

        return ret.toString();
    }

    /**
     * Closes the library for the day, clearing the current patron,
     * advancing the current date, and possibly modifying other fields.
     */
    public void close() {
        if (isOpen()) {
            LocalDate currentDate = LocalDate.of(year, month, day);
            currentDate = currentDate.plusDays(1);
            year = currentDate.getYear();
            month = currentDate.getMonthValue();
            day = currentDate.getDayOfMonth();
            //Attention ! ! !
            currentpatron = null;
            isopen = false;
            issearched = false;
            ispatronset = false;
        }
    }

    /**
     * Returns true if the library is currently open, false otherwise.
     *
     * @return whether it is open
     */
    public boolean isOpen() {
        return isopen;
    }

    /**
     * Creates a new patron, sets it as the current patron,
     * and adds it to the patron list.
     *
     * @param name the name of the Patron
     * @param cardNumber the card number of the Patron
     */
    public void addPatron(String name, int cardNumber) {
        if (isOpen()) {
            currentpatron = new Patron(name, cardNumber);
            patrons.add(currentpatron);
            ispatronset = true;
        }
    }

    /**
     * Returns the complete list of all patrons.
     *
     * @return Patrons
     */
    public ArrayList<Patron> getPatrons() {
        return patrons;
    }

    /**
     * Sets the current patron from the patron list.
     *
     * @param index Numbering for index will begin at 1
     */
    public void setPatron(int index) {
        if (isOpen()) {
            currentpatron = patrons.get(index - 1);
        }
        ispatronset = true;
    }

    /**
     * Returns the patron currently being served, or
     * null if no patron has been selected.
     *
     * @return Patron object
     */
    public Patron getCurrPatron() {
        return currentpatron;
    }

    /**
     * Returns the results from the most recent search, or
     * null if no results are currently stored.
     *
     * @param search search text
     */
    public void search(String search) {
        searches = new ArrayList<Item>();
        if (isOpen() && ispatronset) {
            for (Item item : getCatalog()) {
                if (item.contains(search)) {
                    searches.add(item);
                }
            }
            issearched = true;
        }
    }

    /**
     * Returns the results from the most recent search,
     * or null if no results are currently stored.
     *
     * @return searches
     */
    public ArrayList<Item> getSearchResults() {
        return searches;
    }

    /**
     * Check in an item from the current patron's checked out items.
     *
     * @param index Numbering for index will begin at 1
     */
    public void checkIn(int index) {
        if (isOpen() && ispatronset) {
            ArrayList<Item> checkoutlist = currentpatron.getItems();
            if (checkoutlist != null) {
                checkoutlist.get(index - 1).checkIn();
                currentpatron.getItems().remove(checkoutlist.get(index - 1));
            }
        }
    }

    /**
     * Check out an item from the most recent search result list.
     *
     * @param index Numbering for index will begin at 1
     */
    public void checkOut(int index) {
        if (isOpen() && issearched) {
            searches.get(index - 1).checkOut(getCurrDate());
            currentpatron.getItems().add(searches.get(index - 1));
        }
    }

    /**
     * Starts the interactive library program.
     */
    public void start() {
        //While
        boolean isstop = false;
        while (!isstop) {

            System.out.println("Enter o to open the library or x to exit the program.");
            char openorexit = scn.next().charAt(0);
            scn.nextLine();

            if (openorexit == 'x') {
                isstop = true;
                close();
            } else if (openorexit == 'o') {
                System.out.println();
                System.out.println("Today's date: " + getCurrDate());
                System.out.println();
                System.out.println(open());
                System.out.println();

                //While
                boolean isstopmiddle = false;
                while (!isstopmiddle) {
                    System.out.println("Choose an existing patron by number,"
                            + " enter n to add a new patron, or enter c to close.");
                    int i = 0;
                    if (getPatrons() != null) {
                        for (Patron patron : getPatrons()) {
                            i += 1;
                            System.out.println(i + ": " + patron.basicInfo());
                        }
                    }
                    char whattodo = scn.next().charAt(0);
                    scn.nextLine();
                    /*System.out.println();*/

                    if (whattodo == 'c') {
                        isstopmiddle = true;
                        close();
                    } else if (Character.isDigit(whattodo) || whattodo == 'n') {

                        if (Character.isDigit(whattodo)) {
                            System.out.println();
                            setPatron(Character.getNumericValue(whattodo));
                            System.out.println(currentpatron.detailedInfo());
                            isstopmiddle = false;
                        } else if (whattodo == 'n') {
                            System.out.println("Enter patron name.");
                            String currname = scn.nextLine();
                            System.out.println("Enter patron card number.");
                            int currnumber = scn.nextInt();
                            scn.nextLine();
                            addPatron(currname, currnumber);
                            isstopmiddle = false;
                        }
                        System.out.println();
                        //While
                        boolean isstopinner = false;
                        while (!isstopinner) {
                            System.out.println("Enter s to search for an item to check out,"
                                    + " i to check in an item, or m to return to the previous menu.");
                            char todo = scn.next().charAt(0);
                            scn.nextLine();

                            if (todo == 's') {
                                System.out.println("Enter search text.");
                                String searchtext = scn.nextLine();
                                search(searchtext);
                                System.out.println();
                                System.out.println("Results:");
                                int j = 0;
                                if (getSearchResults() != null) {
                                    for (Item item : getSearchResults()) {
                                        j += 1;
                                        System.out.println(j + ": " + item.basicInfo());
                                    }
                                }
                                System.out.println();
                                System.out.println("Item number:");
                                int itnum = scn.nextInt();
                                scn.nextLine();
                                System.out.println();
                                System.out.println(getSearchResults().get(itnum - 1).detailedInfo());
                                System.out.println();
                                System.out.println("Do you want to check out this item? (Enter y or n)");
                                char yesorno = scn.next().charAt(0);
                                scn.nextLine();
                                if (yesorno == 'y') {
                                    checkOut(itnum);
                                }
                                System.out.println();
                            } else if (todo == 'i') {
                                Patron currpatron = getCurrPatron();
                                int k = 0;
                                if (currpatron != null) {
                                    for (Item item : currpatron.getItems()) {
                                        k += 1;
                                        System.out.println(k + ": " + item.basicInfo()
                                                + " due on " + item.getDueDate());
                                    }
                                }
                                System.out.println();
                                System.out.println("Item to check in: ");
                                int itnum = scn.nextInt();
                                scn.nextLine();
                                System.out.println();
                                checkIn(itnum);
                            } else if (todo == 'm') {
                                isstopinner = true;
                            }
                        }
                    }

                }
            }
        }
    }



    /////////////////// DO NOT CHANGE THE CODE BELOW /////////////////////

    /**
     * Utility method for reading the entire library catalog from input.
     * Input file must give the type of item first (BOOK, MUSIC, or VIDEO.)
     * Includes a blank line after each item, and END to signify the end of the data.
     *
     * @param fileName Location of input file.
     * @return The catalog.
     */
    public static ArrayList<Item> readCatalog(String fileName) {

        Scanner input = null;
        try {
            input = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("File was not found.");
            System.exit(-1);
        }

        String line = "";
        ArrayList<Item> catalog = new ArrayList<Item>();
        boolean stop = false;
        while (!stop) {
            line = input.nextLine();
            switch (line) {
                case "BOOK":
                    String title = input.nextLine();
                    String author = input.nextLine();
                    int pages = input.nextInt();
                    int year = input.nextInt();
                    catalog.add(new Book(title, author, pages, year));
                    input.nextLine();
                    break;
                case "MUSIC":
                    title = input.nextLine();
                    String artist = input.nextLine();
                    String format = input.nextLine();
                    year = input.nextInt();
                    input.nextLine();
                    ArrayList<String> tracks = new ArrayList<String>();
                    while (true) {
                        line = input.nextLine();
                        if (line.equals("")) {
                            break;
                        }
                        tracks.add(line);
                    }
                    catalog.add(new Music(title, artist, format, year, tracks));
                    break;
                case "VIDEO":
                    title = input.nextLine();
                    format = input.nextLine();
                    year = input.nextInt();
                    int runtime = input.nextInt();
                    catalog.add(new Video(title, format, year, runtime));
                    input.nextLine();
                    break;
                case "END":
                    stop = true;
                    break;
            }
        }

        return catalog;
    }

    /**
     * Main method for the library program.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter catalog file name.");
        String fileName = input.nextLine();
        int year;
        int month;
        int day;
        System.out.println("Enter the current year.");
        year = input.nextInt();
        System.out.println("Enter the current month.");
        month = input.nextInt();
        System.out.println("Enter the current day.");
        day = input.nextInt();
        input.nextLine();

        ArrayList<Item> catalog = Library.readCatalog(fileName);

        Library l = new Library(catalog, input, year, month, day);

        l.start();
    }
}
