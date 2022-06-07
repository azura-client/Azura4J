package best.azura.azura4j.entities;

/**
 * Entity class, to store information about a successful Request.
 */
public class AzuraAPIResponse {

    // The user related Stats.
    private AzuraUserStats azuraUserStats;

    // The application related Stats.
    private AzuraApplicationStats azuraApplicationStats;

    // The Azura User.
    private AzuraUser azuraUser;

    /**
     * Constructor to store User related Stats.
     * @param azuraUserStats the user related Stats.
     */
    public AzuraAPIResponse(AzuraUserStats azuraUserStats) {
        this.azuraUserStats = azuraUserStats;
    }

    /**
     * Constructor to store application related Stats.
     * @param azuraApplicationStats the application related Stats.
     */
    public AzuraAPIResponse(AzuraApplicationStats azuraApplicationStats) {
        this.azuraApplicationStats = azuraApplicationStats;
    }

    /**
     * Constructor to store Azura User.
     * @param azuraUser the Azura User.
     */
    public AzuraAPIResponse(AzuraUser azuraUser) {
        this.azuraUser = azuraUser;
    }

    /**
     * Retrieve the stored User related Stats.
     * @return the User related Stats.
     */
    public AzuraUserStats getAzuraUserStats() {
        return azuraUserStats;
    }

    /**
     * Retrieve the stored Application related Stats.
     * @return the Application related Stats.
     */
    public AzuraApplicationStats getAzuraApplicationStats() {
        return azuraApplicationStats;
    }

    /**
     * Retrieve the stored Azura User.
     * @return the Azura User.
     */
    public AzuraUser getAzuraUser() {
        return azuraUser;
    }
}
