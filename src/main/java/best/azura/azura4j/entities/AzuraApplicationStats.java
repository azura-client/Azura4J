package best.azura.azura4j.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Entity class, used to store information.
 */
public class AzuraApplicationStats {

    // The amount of approved Applications.
    @SerializedName("approvedApps")
    private final int approvedApplications;

    // The amount of denied Applications.
    @SerializedName("deniedApps")
    private final int deniedApplications;

    // The amount of open Applications.
    @SerializedName("openApps")
    private final int openApplications;

    // The amount of Applications.
    @SerializedName("allApps")
    private final int allApplications;

    /**
     * Constructor to store the Data.
     * @param approvedApplications the Amount of approved Applications.
     * @param deniedApplications the Amount of denied Applications.
     * @param openApplications the Amount of open Applications.
     * @param allApplications the Amount of Applications.
     */
    public AzuraApplicationStats(int approvedApplications, int deniedApplications, int openApplications, int allApplications) {
        this.approvedApplications = approvedApplications;
        this.deniedApplications = deniedApplications;
        this.openApplications = openApplications;
        this.allApplications = allApplications;
    }

    /**
     * Retrieve the amount of approved Applications.
     * @return the amount of approved Applications.
     */
    public int getApprovedApplications() {
        return approvedApplications;
    }

    /**
     * Retrieve the amount of denied Applications.
     * @return the amount of denied Applications.
     */
    public int getDeniedApplications() {
        return deniedApplications;
    }

    /**
     * Retrieve the amount of open Applications.
     * @return the amount of open Applications.
     */
    public int getOpenApplications() {
        return openApplications;
    }

    /**
     * Retrieve the amount of Applications.
     * @return the amount of Applications.
     */
    public int getAllApplications() {
        return allApplications;
    }
}
