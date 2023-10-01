package br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.exception;

import java.util.UUID;

public class DentistNotFoundException extends RuntimeException{
    public DentistNotFoundException(UUID id) {
        super("Dentist %s not found".formatted(id));
    }
}
