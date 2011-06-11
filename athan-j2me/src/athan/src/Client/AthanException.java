/*
 * Classes d'exceptions applicatives
 */

package athan.src.Client;

/**
 *
 * @author Saad BENBOUZID
 */
public class AthanException extends Exception {

    public AthanException() {
        super();
    }

    public AthanException(String pMessage) {
        super(pMessage);
    }

    public String getMessage() {
        return super.getMessage();
    }
}
