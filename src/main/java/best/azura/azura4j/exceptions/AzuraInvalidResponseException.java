package best.azura.azura4j.exceptions;

/**
 * Exception for an Invalid response from the Server.
 */
public class AzuraInvalidResponseException extends Exception {

    /**
     * Generates a generic Invalid-Response Exception.
     */
    public AzuraInvalidResponseException() {
        super("The Response from the Server couldn't be validated!");
    }

    /**
     * Generates a generic Invalid-Response Exception, but with the content of the response.
     * @param content the response.
     */
    public AzuraInvalidResponseException(String content) {
        super("The Response from the Server couldn't be validated!\nResponse: " + content);
    }

}
