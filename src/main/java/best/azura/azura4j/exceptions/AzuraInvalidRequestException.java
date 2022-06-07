package best.azura.azura4j.exceptions;

/**
 * Exception for an Invalid Request send my the Wrapper.
 */
public class AzuraInvalidRequestException extends Exception {

    /**
     * Generates a generic Invalid-Request Exception.
     */
    public AzuraInvalidRequestException() {
        super("The created Request is not valid.");
    }

    /**
     * Generates a generic Invalid-Request Exception.
     *
     * @param reason The Reason of why it is Invalid.
     */
    public AzuraInvalidRequestException(String reason) {
        super("The created Request is not valid. Reason for this is, " + reason);
    }

}
