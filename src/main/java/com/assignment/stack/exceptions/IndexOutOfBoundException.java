package com.assignment.stack.exceptions;

/**
 * created 19/02/2021
 * @author adarshbajpai
 */

public class IndexOutOfBoundException extends Exception {

    public static final String ERROR_MESSAGE = "Requested Element Not Present In The Stack" ;

    /**
     * Constructs a new exception with {@code null} as its detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     */
    public IndexOutOfBoundException() {
        super(ERROR_MESSAGE);
    }

    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public IndexOutOfBoundException(String message) {
        super(message);
    }
}
