package br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.exception;

import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.entity.Patient;

import java.util.UUID;

public class PatientNotFoundException extends RuntimeException{
    public PatientNotFoundException(UUID id) {
        super("Patient %s not found".formatted(id));
    }
}
