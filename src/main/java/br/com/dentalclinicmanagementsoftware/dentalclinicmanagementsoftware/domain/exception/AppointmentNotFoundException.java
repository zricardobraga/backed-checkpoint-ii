package br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.exception;

import java.util.UUID;

public class AppointmentNotFoundException extends RuntimeException{
    public AppointmentNotFoundException(UUID id) {
        super("Appointment %s not found".formatted(id));
    }
}
