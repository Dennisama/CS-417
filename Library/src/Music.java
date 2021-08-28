import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Part 1 of the Library.
 * @author Biao Zhang
 * @version 2.0
 */
public class Music extends Item {
    /**
     * All Attributes.
     */
    private String title;
    private String artist;
    private String format;
    private int year;
    private ArrayList<String> tracks;

    /**
     * The default constructor.
     * @param title the title of the music
     * @param artist the artist of the music
     * @param format the format of the music
     * @param year the year when music was published
     * @param tracks the tracks contained in the music
     */
    public Music(String title, String artist, String format, int year, ArrayList<String> tracks) {
        this.title = title;
        this.artist = artist;
        this.format = format;
        this.year = year;
        this.tracks = tracks;
    }

    /**
     * Changes the checked out status of the item to true and sets the due date.
     *
     * @param currDate The current date.
     */
    @Override
    public void checkOut(LocalDate currDate) {
        super.setCheckedOut();
        LocalDate dueDate = currDate.plusDays(7);
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

        if (artist.toUpperCase().contains(uppersearch) || title.toUpperCase().contains(uppersearch)) {
            iscontain = true;
        } else {
            for (String track : tracks) {
                if (track.toUpperCase().contains(uppersearch)) {
                    iscontain = true;
                    break;
                }
            }
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
        return String.format("%s by %s (%s)", title, artist, format);
    }

    /**
     * Provides a detailed representation of this object's data.
     *
     * @return String A detailed representation of this object.
     */
    @Override
    public String detailedInfo() {
        StringBuilder ret = new StringBuilder();
        ret.append("Title: ").append(title).append("\n")
                .append("Artist: ").append(artist).append("\n")
                .append("Format: ").append(format).append("\n")
                .append("Year of release: ").append(year).append("\n")
                .append("Track list: \n");

        //sublist(from_index, to_index), where to_index is exclusive.
        for (String track : tracks.subList(0, tracks.size() - 1)) {
            ret.append("    ").append(track).append("\n");
        }
        ret.append("    ").append(tracks.get(tracks.size() - 1));

        return ret.toString();
    }
}
