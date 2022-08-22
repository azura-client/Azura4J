package best.azura.azura4j.api;

import best.azura.azura4j.entities.AzuraApplicationStats;
import best.azura.azura4j.entities.AzuraUser;
import best.azura.azura4j.exceptions.*;
import com.google.gson.*;
import best.azura.azura4j.entities.AzuraUserStats;
import best.azura.azura4j.entities.AzuraAPIResponse;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

/**
 * A Request-Utility class for the KingGen Request.
 */
public class Request {

    // The API-Key.
    private final String apiKey;

    // GSON Instance.
    private final Gson gson = new GsonBuilder().create();

    // The endpoint.
    private final Endpoint endpoint;

    // The formatted Request URL.
    private final String requestUrl;

    /**
     * Constructor to send a valid Request.
     *
     * @param endpoint the Endpoint.
     * @param url the URL.
     * @param apiKey the API-Key
     */
    public Request(Endpoint endpoint, String url, String apiKey) {
        this.endpoint = endpoint;
        this.requestUrl = url;
        this.apiKey = apiKey;
    }

    /**
     * Send the Request that has been build.
     *
     * @return {@link AzuraAPIResponse} with a valid Entity.
     * @throws Exception if the URL is malformed, the API-Key is invalid or blacklisted or the Server responded with an Invalid Response the Request itself is invalid.
     */
    public AzuraAPIResponse request() throws Exception {
        // Create a URL.
        URL url = new URL(requestUrl);

        // Open a Connection and set every needed Data.
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

        httpURLConnection.addRequestProperty("User-Agent", "Mozilla/5.0 Gecko/20100316 Firefox/3.6.2 AzuraX/X");
        httpURLConnection.addRequestProperty("Api-Key", apiKey);
        httpURLConnection.addRequestProperty("Accept", "application/json");

        httpURLConnection.setDoOutput(true);

        httpURLConnection.connect();

        // Parse the response to a String for later use, if needed.
        String responseContent = new BufferedReader(new InputStreamReader((100 <= httpURLConnection.getResponseCode() && httpURLConnection.getResponseCode() <= 399 ? httpURLConnection.getInputStream() : httpURLConnection.getErrorStream()), StandardCharsets.UTF_8)).lines().collect(Collectors.joining("\n"));
        JsonStreamParser jsonStreamParser = new JsonStreamParser(responseContent);
        JsonElement jsonElement = jsonStreamParser.hasNext() ? jsonStreamParser.next() : new JsonObject();
        System.out.println(jsonElement);
        // Check if the Server response was valid, if so continue parsing the data.
        if (httpURLConnection.getResponseCode() == 200) {
            if (!jsonElement.isJsonObject() || !jsonElement.getAsJsonObject().has("success") || !jsonElement.getAsJsonObject().get("success").getAsBoolean()) {
                if (jsonElement.getAsJsonObject().has("message") && jsonElement.getAsJsonObject().get("message").getAsString().equalsIgnoreCase("Invalid Key.")) {
                    throw new AzuraInvalidApiKeyException();
                } else {
                    throw new AzuraInvalidRequestException("Server return an Error: " + jsonElement.getAsJsonObject().get("message").getAsString());
                }
            }
            try {
                // Check if the Endpoint is a Profile or not, if so then try to parse it into a KingGenProfile. Same for KingGenAccount.
                switch (endpoint) {
                    case APPLICATION_STATS: {
                        return new AzuraAPIResponse(gson.fromJson(jsonElement.getAsJsonObject().get("apps"), AzuraApplicationStats.class));
                    }
                    case USER_STATS: {
                        return new AzuraAPIResponse(gson.fromJson(jsonElement.getAsJsonObject().get("users"), AzuraUserStats.class));
                    }
                    case LOOKUP_USER: {
                        return new AzuraAPIResponse(gson.fromJson(jsonElement.getAsJsonObject().get("user"), AzuraUser.class));
                    }
                    default: {
                        throw new AzuraInvalidRequestException("Endpoint not implemented.");
                    }
                }
            } catch (Exception exception) {
                throw new AzuraInvalidOperationException("Unknown failure while trying to parse data! Exception: " + exception.getMessage());
            }
        } else if (httpURLConnection.getResponseCode() == 401) {
            // Throw since a Not Authorized Response has been given.
            throw new AzuraInvalidApiKeyException();
        } else {
            // Throw since the cause of this error is unknown.
            throw new AzuraInvalidResponseException(responseContent);
        }
    }

}
