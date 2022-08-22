package best.azura.azura4j.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Entity class, used to store information.
 */
public class AzuraUserStats {

    // The Amount of Users.
    @SerializedName("users.users")
    private final int userCount;

    // The Amount of locked Users.
    @SerializedName("users.locked")
    private final int lockedUserCount;

    // The Amount of soft-locked Users.
    @SerializedName("users.softlocked")
    private final int softLockedUserCount;

    // The Amount of monthly registered Users.
    @SerializedName("users.stats.monthly.registered")
    private final int monthlyRegistered;

    // The Amount of daily registered Users.
    @SerializedName("users.stats.daily.registered")
    private final int dailyRegistered;

    /**
     * Constructor to store the Data.
     *
     * @param userCount       the Amount of Users.
     * @param lockedUserCount the Amount of locked Users.
     */
    public AzuraUserStats(int userCount, int lockedUserCount, int softLockedUserCount, int monthlyRegistered, int dailyRegistered) {
        this.userCount = userCount;
        this.lockedUserCount = lockedUserCount;
        this.softLockedUserCount = softLockedUserCount;
        this.monthlyRegistered = monthlyRegistered;
        this.dailyRegistered = dailyRegistered;
    }

    /**
     * Retrieve the amount of Users.
     *
     * @return the amount of  Users.
     */
    public int getUserCount() {
        return userCount;
    }

    /**
     * Retrieve the amount of locked Users.
     *
     * @return the amount of locked Users.
     */
    public int getLockedUserCount() {
        return lockedUserCount;
    }

    /**
     * Retrieve the amount of soft-locked Users.
     *
     * @return the amount of soft-locked Users.
     */
    public int getSoftLockedUserCount() {
        return softLockedUserCount;
    }

    /**
     * Retrieve the amount of monthly registered Users.
     *
     * @return the amount of monthly registered Users.
     */
    public int getMonthlyRegistered() {
        return monthlyRegistered;
    }

    /**
     * Retrieve the amount of daily registered Users.
     *
     * @return the amount of daily registered Users.
     */
    public int getDailyRegistered() {
        return dailyRegistered;
    }
}
