package best.azura.azura4j.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Entity class, used to store information.
 */
public class AzuraApplicationStats {

    // The amount of approved Applications.
    @SerializedName("apps.approvedApps")
    private final int approvedApplications;

    // The amount of denied Applications.
    @SerializedName("apps.deniedApps")
    private final int deniedApplications;

    // The amount of open Applications.
    @SerializedName("apps.openApps")
    private final int openApplications;

    // The amount of Applications.
    @SerializedName("apps.allApps")
    private final int allApplications;

    // The amount of Applications created in a Month.
    @SerializedName("apps.stats.monthly.created")
    private final int monthlyCreated;

    // The amount of Applications accepted in a Month.
    @SerializedName("apps.stats.monthly.accepted")
    private final int monthlyAccepted;

    // The amount of Applications denied in a Month.
    @SerializedName("apps.stats.monthly.denied")
    private final int monthlyDenied;

    // The amount of Applications created today.
    @SerializedName("apps.stats.daily.created")
    private final int dailyCreated;

    // The amount of Applications accepted today.
    @SerializedName("apps.stats.daily.accepted")
    private final int dailyAccepted;

    // The amount of Applications denied today.
    @SerializedName("apps.stats.daily.denied")
    private final int dailyDenied;

    /**
     * Constructor to store the Data.
     *
     * @param approvedApplications the Amount of approved Applications.
     * @param deniedApplications   the Amount of denied Applications.
     * @param openApplications     the Amount of open Applications.
     * @param allApplications      the Amount of Applications.
     * @param monthlyCreated       the Amount of Applications created in a Month.
     * @param monthlyAccepted      the Amount of Applications accepted in a Month.
     * @param monthlyDenied        the Amount of Applications denied in a Month.
     * @param dailyCreated         the Amount of Applications created today.
     * @param dailyAccepted        the Amount of Applications accepted today.
     * @param dailyDenied          the Amount of Applications denied today.
     */
    public AzuraApplicationStats(int approvedApplications, int deniedApplications, int openApplications, int allApplications, int monthlyCreated, int monthlyAccepted, int monthlyDenied, int dailyCreated, int dailyAccepted, int dailyDenied) {
        this.approvedApplications = approvedApplications;
        this.deniedApplications = deniedApplications;
        this.openApplications = openApplications;
        this.allApplications = allApplications;
        this.monthlyCreated = monthlyCreated;
        this.monthlyAccepted = monthlyAccepted;
        this.monthlyDenied = monthlyDenied;
        this.dailyCreated = dailyCreated;
        this.dailyAccepted = dailyAccepted;
        this.dailyDenied = dailyDenied;
    }

    /**
     * Retrieve the amount of approved Applications.
     *
     * @return the amount of approved Applications.
     */
    public int getApprovedApplications() {
        return approvedApplications;
    }

    /**
     * Retrieve the amount of denied Applications.
     *
     * @return the amount of denied Applications.
     */
    public int getDeniedApplications() {
        return deniedApplications;
    }

    /**
     * Retrieve the amount of open Applications.
     *
     * @return the amount of open Applications.
     */
    public int getOpenApplications() {
        return openApplications;
    }

    /**
     * Retrieve the amount of Applications.
     *
     * @return the amount of Applications.
     */
    public int getAllApplications() {
        return allApplications;
    }

    /**
     * Retrieve the amount of Applications created in a Month.
     *
     * @return the amount of Applications created in a Month.
     */
    public int getMonthlyCreated() {
        return monthlyCreated;
    }

    /**
     * Retrieve the amount of Applications accepted in a Month.
     *
     * @return the amount of Applications accepted in a Month.
     */
    public int getMonthlyAccepted() {
        return monthlyAccepted;
    }

    /**
     * Retrieve the amount of Applications denied in a Month.
     *
     * @return the amount of Applications denied in a Month.
     */
    public int getMonthlyDenied() {
        return monthlyDenied;
    }

    /**
     * Retrieve the amount of Applications created today.
     *
     * @return the amount of Applications created today.
     */
    public int getDailyCreated() {
        return dailyCreated;
    }

    /**
     * Retrieve the amount of Applications accepted today.
     *
     * @return the amount of Applications accepted today.
     */
    public int getDailyAccepted() {
        return dailyAccepted;
    }

    /**
     * Retrieve the amount of Applications denied today.
     *
     * @return the amount of Applications denied today.
     */
    public int getDailyDenied() {
        return dailyDenied;
    }
}
