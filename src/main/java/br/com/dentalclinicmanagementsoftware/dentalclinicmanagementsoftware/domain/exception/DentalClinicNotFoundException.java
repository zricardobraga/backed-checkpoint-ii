package br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.exception;

import java.util.UUID;

public class DentalClinicNotFoundException extends RuntimeException{
    public DentalClinicNotFoundException(UUID id) {
        super("Dental Clinic %s not found".formatted(id));
    }
}
