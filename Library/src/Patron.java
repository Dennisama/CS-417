import java.util.ArrayList;

/**
 * A class to represent a patron of the library.
 * @author Biao Zhang
 * @version 1.0
 */
public class Patron implements Printable {

    /**
     * Attributes. items are never updated ! ?
     */
    private String name;
    private int cardNumber;
    private ArrayList<Item> items = new ArrayList<Item>();

    /**
     * Decault instructor.
     * @param name the name of the patron
     * @param cardNumber the card number of the patron
     */
    public Patron(String name, int cardNumber) {
        this.name = name;
        this.cardNumber = cardNumber;
        items = new ArrayList<Item>();
    }

    /**
     * Provides a simple representation of this object's data.
     *
     * @return String A simple representation of this object.
     */
    @Override
    public String basicInfo() {
        return name + " (" + cardNumber + ")";
    }

    /**
     * Provides a detailed representation of this object's data.
     *
     * @return String A detailed representation of this object.
     */
    @Override
    public String detailedInfo() {
        StringBuilder ret = new StringBuilder();
        ret.append("Name: ").append(name).append("\n")
                .append("Card number: ").append(cardNumber);

        for (Item item : items) {
            ret.append("\n").append("    ").append(item.basicInfo())
                    .append(" due on ").append(item.getDueDate());
        }

        return ret.toString();
    }

    /**
     *
     * @return Returns the list of items checked out to this patron.
     */
    public ArrayList<Item> getItems() {
        /*ArrayList<Item> checkoutlist = new ArrayList<Item>();
        for (Item item : items) {
            if (item.isCheckedOut()) {
                checkoutlist.add(item);
            }
        }*/
        return items;
    }
}
