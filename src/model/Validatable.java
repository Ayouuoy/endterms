package model;

import exceptions.InvalidInputException;

public interface Validatable {

    boolean isValid();

    default void validate() {
        if (!isValid()) {
            throw new InvalidInputException("Validation failed");
        }
    }

    static void info() {
        System.out.println("Validatable interface");
    }
}
