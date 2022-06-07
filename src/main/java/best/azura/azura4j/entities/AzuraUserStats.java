package best.azura.azura4j.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Entity class, used to store information.
 */
public class AzuraUserStats {

    // The Amount of Users.
    @SerializedName("users")
    private final int userCount;

    // The Amount of locked Users.
    @SerializedName("locked")
    private final int lockedUserCount;

    /**
     * Constructor to store the Data.
     * @param userCount the Amount of Users.
     * @param lockedUserCount the Amount of locked Users.
     */
    public AzuraUserStats(int userCount, int lockedUserCount) {
        this.userCount = userCount;
        this.lockedUserCount = lockedUserCount;
    }

    /**
     * Retrieve the amount of Users.
     * @return the amount of  Users.
     */
    public int getUserCount() {
        return userCount;
    }

    /**
     * Retrieve the amount of locked Users.
     * @return the amount of locked Users.
     */
    public int getLockedUserCount() {
        return lockedUserCount;
    }
}
