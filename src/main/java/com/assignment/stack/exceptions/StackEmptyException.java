package com.assignment.stack.exceptions;

/**
 * @author adarshbajpai
 * created 19/02/2021
 */
public class StackEmptyException extends Exception {

    public static final String ERROR_MESSAGE="Stack Is Empty, Cannot Pop Element!";
    /**
     * Constructs a new exception with {@code null} as its detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     */
    public StackEmptyException() {
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
    public StackEmptyException(String message) {
        super(message);
    }
}
