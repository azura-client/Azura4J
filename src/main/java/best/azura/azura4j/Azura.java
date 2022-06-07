package best.azura.azura4j;

import best.azura.azura4j.api.Request;
import best.azura.azura4j.api.Endpoint;
import best.azura.azura4j.entities.AzuraApplicationStats;
import best.azura.azura4j.entities.AzuraUserStats;
import best.azura.azura4j.entities.AzuraAPIResponse;
import best.azura.azura4j.entities.AzuraUser;
import best.azura.azura4j.exceptions.AzuraInvalidOperationException;

import java.io.InvalidObjectException;
import java.util.function.Consumer;

/**
 * Wrapper Main class, used to store the API-Key as well as do the direct data processing and requesting.
 *
 * @author Presti
 * @version 1.0
 */
public class Azura {

    // The API-Key.
    private final String apiKey;

    /**
     * Constructor to create an instance of the Wrapper.
     *
     * @param apiKey the API-Key that should be used.
     */
    public Azura(String apiKey) {
        this.apiKey = apiKey;
    }

    /**
     * Send a Request to the wanted Endpoint.
     *
     * @param endpoint the {@link Endpoint}.
     * @return a {@link AzuraAPIResponse} with the requested Info.
     * @throws Exception if the URL is malformed, the API-Key is invalid or blacklisted or the Server responded with an Invalid Response the Request itself is invalid.
     */
    public AzuraAPIResponse fetch(Endpoint endpoint) throws Exception {
        return fetch(endpoint, endpoint.compile());
    }

    /**
     * Send a Request to the wanted Endpoint.
     *
     * @param endpoint the {@link Endpoint}.
     * @param success  a {@link Consumer< AzuraAPIResponse >} used as Callback if the request was successful.
     * @param failed   a {@link Consumer<Throwable>} used as Callback if the request failed.
     * @throws InvalidObjectException if the given {@param success} is null.
     */
    public void fetchASync(Endpoint endpoint, Consumer<AzuraAPIResponse> success, Consumer<Throwable> failed) throws InvalidObjectException {
        fetchASync(endpoint.compile(), endpoint, success, failed);
    }

    /**
     * Send a Request to the wanted Endpoint.
     *
     * @param url the url.
     * @return a {@link AzuraAPIResponse} with the requested Info.
     * @throws Exception if the URL is malformed, the API-Key is invalid or blacklisted or the Server responded with an Invalid Response the Request itself is invalid.
     */
    public AzuraAPIResponse fetch(Endpoint endpoint, String url) throws Exception {
        return new Request(endpoint, url, apiKey).request();
    }

    /**
     * Send a Request to the wanted Endpoint.
     *
     * @param url      the url.
     * @param endpoint the Endpoint.
     * @param success  a {@link Consumer< AzuraAPIResponse >} used as Callback if the request was successful.
     * @param failed   a {@link Consumer<Throwable>} used as Callback if the request failed.
     * @throws InvalidObjectException if the given {@param success} is null.
     */
    public void fetchASync(String url, Endpoint endpoint, Consumer<AzuraAPIResponse> success, Consumer<Throwable> failed) throws InvalidObjectException {
        if (success == null) throw new InvalidObjectException("Callback Consumer success can not be null.");
        new Thread(() -> {
            try {
                success.accept(new Request(endpoint, url, apiKey).request());
            } catch (Exception exception) {
                if (failed != null) failed.accept(exception);
            }
        }).start();
    }

    /**
     * Get Stats.
     *
     * @return a new Instance of  {@link AzuraUserStats}.
     * @throws Exception if there was a problem with getting the Data.
     */
    public AzuraUserStats fetchUserStats() throws Exception {
        return fetch(Endpoint.USER_STATS).getAzuraUserStats();
    }

    /**
     * Fetch User related Stats ASync.
     *
     * @param success a {@link Consumer< AzuraUserStats >} used as Callback if the request was successful.
     * @param failed  a {@link Consumer<Throwable>} used as Callback if the request failed.
     * @throws InvalidObjectException if the given {@param success} is null.
     */
    public void fetchUserStatsASync(Consumer<AzuraUserStats> success, Consumer<Throwable> failed) throws InvalidObjectException {
        fetchASync(Endpoint.USER_STATS, azuraAPIResponse -> {
            if (success != null) success.accept(azuraAPIResponse.getAzuraUserStats());
        }, failed);
    }

    /**
     * Get Stats.
     *
     * @return a new Instance of  {@link AzuraApplicationStats}.
     * @throws Exception if there was a problem with getting the Data.
     */
    public AzuraApplicationStats fetchApplicationStats() throws Exception {
        return fetch(Endpoint.APPLICATION_STATS).getAzuraApplicationStats();
    }

    /**
     * Fetch Application related Stats ASync.
     *
     * @param success a {@link Consumer< AzuraApplicationStats >} used as Callback if the request was successful.
     * @param failed  a {@link Consumer<Throwable>} used as Callback if the request failed.
     * @throws InvalidObjectException if the given {@param success} is null.
     */
    public void fetchApplicationStatsASync(Consumer<AzuraApplicationStats> success, Consumer<Throwable> failed) throws InvalidObjectException {
        fetchASync(Endpoint.APPLICATION_STATS, azuraAPIResponse -> {
            if (success != null) success.accept(azuraAPIResponse.getAzuraApplicationStats());
        }, failed);
    }

    /**
     * Fetch the {@link AzuraUser}.
     *
     * @param username the Username.
     * @return an Instance of the {@link AzuraUser}.
     * @throws Exception if there was a problem.
     */
    public AzuraUser lookupUser(String username) throws Exception {
        return fetch(Endpoint.LOOKUP_USER, Endpoint.LOOKUP_USER.compile(username)).getAzuraUser();
    }

    /**
     * Fetch the {@link AzuraUser}.
     *
     * @param username the Username.
     * @param success  a {@link Consumer< AzuraUser >} used as Callback if the request was successful.
     * @param failed   a {@link Consumer<Throwable>} used as Callback if the request failed.
     * @throws InvalidObjectException if the given {@param success} is null.
     */
    public void lookupUserASync(String username, Consumer<AzuraUser> success, Consumer<Throwable> failed) throws InvalidObjectException {
        fetchASync(Endpoint.LOOKUP_USER.compile(username), Endpoint.LOOKUP_USER, azuraAPIResponse -> {
            if (success != null) success.accept(azuraAPIResponse.getAzuraUser());
        }, failed);
    }

    /**
     * Get the API-Key used for this instance of the Wrapper.
     *
     * @return the API-Key.
     */
    public String getApiKey() {
        return apiKey;
    }
}
