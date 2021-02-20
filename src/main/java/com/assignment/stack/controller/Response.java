package com.assignment.stack.controller;

/**
 * created 19/02/2021
 * @author adarshbajpai
 */

public class Response {

    private Integer data;

    private final boolean successFull;

    private String errorMessage;

    public Response(Integer data) {
        this.data = data;
        successFull = true;
    }

    public Response(String errorMessage) {
        this.errorMessage = errorMessage;
        this.successFull = false;
    }

    public Integer getData() {
        return data;
    }

    public boolean isSuccessFull() {
        return successFull;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public String toString() {
        return "Response{" +
                "data=" + data +
                ", successFull=" + successFull +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
