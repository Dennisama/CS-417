import java.time.LocalDate;

/**
 * Part 1 of Library.
 * @author Biao Zhang
 * @version 2.0
 */
public class Book extends Item {
    /**
     * All attributes.
     */
    private String title;
    private String author;
    private int pages;
    private int years;

    /**
     * Default Constructor.
     * @param title the title of the book
     * @param author the author of the book
     * @param pages the total pages of the book
     * @param years the year when the book was published
     */
    public Book(String title, String author, int pages, int years) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.years = years;
    }

    /**
     * Changes the checked out status of the item to true and sets the due date.
     *
     * @param currDate The current date.
     */
    @Override
    public void checkOut(LocalDate currDate) {
        super.setCheckedOut();
        LocalDate dueDate = currDate.plusDays(14);
        super.setDueDate(dueDate);
    }

    /**
     * Checks whether the search text is contained in any of this item's fields.
     * Must be case-insensitive.
     *
     * @param search The text to search for.
     * @return boolean True if any of this item's fields contain the search text, false otherwise.
     */
    @Override
    public boolean contains(String search) {
        boolean iscontain = false;
        String uppersearch = search.toUpperCase();

        if (title.toUpperCase().contains(uppersearch) || author.toUpperCase().contains(uppersearch)) {
            iscontain = true;
        }
        return iscontain;
    }

    /**
     * Provides a simple representation of this object's data.
     *
     * @return String A simple representation of this object.
     */
    @Override
    public String basicInfo() {
        return title + ", by " + author;
    }

    /**
     * Provides a detailed representation of this object's data.
     *
     * @return String A detailed representation of this object.
     */
    @Override
    public String detailedInfo() {
        return "Title: " + title + "\n"
                + "Author: " + author + "\n"
                + "Pages: " + pages + "\n"
                + "Publication year: " + years;
    }
}
