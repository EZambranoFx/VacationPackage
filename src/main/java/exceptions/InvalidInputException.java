// Copyright (C) 2020
// All rights reserved
package exceptions;

/**
 * Excepción personalizada para representar errores de entrada inválida.
 */
public class InvalidInputException extends Exception {
    private static final long serialVersionUID = 1L;

    /**
     * Constructor de la excepción con un mensaje descriptivo.
     *
     * @param message El mensaje que describe la causa de la excepción.
     */
    public InvalidInputException(final String message) {
        super(message);
    }
}
