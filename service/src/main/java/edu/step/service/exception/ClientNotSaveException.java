package edu.step.service.exception;

public class ClientNotSaveException extends RuntimeException {

    public ClientNotSaveException() {
        this("Client not saved");
    }

    public ClientNotSaveException(String message) {
        super(message);
    }
}
