package com.assignment.stack.exceptions;

public class StackFullException extends Exception {

    public static final String ERROR_MESSAGE = "Stack Is Full, Cannot Push!";

    /**
     * Constructs a new exception with {@code null} as its detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     */
    public StackFullException() {
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
    public StackFullException(String message) {
        super(message);
    }
}
