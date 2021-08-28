import java.time.LocalDate;

/**
 * Par1 of the Library.
 * @author Biao Zhang
 * @version 2.0
 */
public class Video extends Item {
    /**
     * All attributes.
     */
    private String title;
    private String format;
    private int year;
    private int runtime;

    /**
     * The default constructor.
     * @param title the title of the video
     * @param format the format of the video
     * @param year the year when the video is published
     * @param runtime the runtime of the video
     */
    public Video(String title, String format, int year, int runtime) {
        this.title = title;
        this.format = format;
        this.year = year;
        this.runtime = runtime;
    }

    /**
     * Changes the checked out status of the item to true and sets the due date.
     *
     * @param currDate The current date.
     */
    @Override
    public void checkOut(LocalDate currDate) {
        super.setCheckedOut();
        LocalDate dueDate = currDate.plusDays(3);
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
        return title.toUpperCase().contains(search.toUpperCase());
    }

    /**
     * Provides a simple representation of this object's data.
     *
     * @return String A simple representation of this object.
     */
    @Override
    public String basicInfo() {
        return String.format("%s (%s)", title, format);
    }

    /**
     * Provides a detailed representation of this object's data.
     *
     * @return String A detailed representation of this object.
     */
    @Override
    public String detailedInfo() {
        return "Title: " + title + "\n"
                + "Format: " + format + "\n"
                + "Year of release: " + year + "\n"
                + "Runtime (minutes): " + runtime;
    }
}
