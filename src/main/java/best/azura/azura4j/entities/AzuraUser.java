package best.azura.azura4j.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Entity class, to store information..
 */
public class AzuraUser {

    // The Username of the User.
    @SerializedName("username")
    private final String username;

    // The Username of the User.
    @SerializedName("rank")
    private final String rank;

    // The Username of the User.
    @SerializedName("creation")
    private final long creation;

    // The Username of the User.
    @SerializedName("last")
    private final long last;


    /**
     * Constructor to store the Data.
     * @param username the Username.
     * @param rank the Rank-Name.
     * @param creation the creation Date (UNIX-Timestamp).
     * @param last the last login date (UNIX-Timestamp).
     */
    public AzuraUser(String username, String rank, long creation, long last) {
        this.username = username;
        this.rank = rank;
        this.creation = creation;
        this.last = last;
    }

    /**
     * Retrieve the Username.
     * @return the Username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Retrieve the Rank.
     * @return the Rank.
     */
    public String getRank() {
        return rank;
    }

    /**
     * Retrieve the creation Time.
     * @return the creation Time.
     */
    public long getCreation() {
        return creation;
    }

    /**
     * Retrieve the last Login.
     * @return the last Login.
     */
    public long getLast() {
        return last;
    }
}
