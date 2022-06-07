package best.azura.azura4j.exceptions;

/**
 * Exception for an Operation or Parsing Exception.
 */
public class AzuraInvalidOperationException extends NullPointerException {

    /**
     * Generates a generic Invalid-Operation Exception.
     */
    public AzuraInvalidOperationException() {
        super("The created Request is not valid.");
    }

    /**
     * Generates a generic Invalid-Operation Exception, but with the reason of the exception.
     * @param content the reason.
     */
    public AzuraInvalidOperationException(String content) {
        super(content);
    }

}
