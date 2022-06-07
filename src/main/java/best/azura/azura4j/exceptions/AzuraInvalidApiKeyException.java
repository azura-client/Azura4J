package best.azura.azura4j.exceptions;

/**
 * Exception for an Invalid or Blacklisted Key.
 */
public class AzuraInvalidApiKeyException extends Exception {

    /**
     * Generates a generic Invalid-Key Exception.
     */
    public AzuraInvalidApiKeyException() {
        super("The provided API-Key is Invalid or Blacklisted.");
    }

}
