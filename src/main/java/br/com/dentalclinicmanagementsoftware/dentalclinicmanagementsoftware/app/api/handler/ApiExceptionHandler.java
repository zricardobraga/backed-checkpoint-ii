package br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.app.api.handler;

import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.entity.Dentist;
import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.exception.AppointmentNotFoundException;
import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.exception.DentalClinicNotFoundException;
import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.exception.DentistNotFoundException;
import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.exception.PatientNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(DentistNotFoundException.class)
    public ResponseEntity<?> dentistNotFoundExceptionHandler(DentistNotFoundException exception) {
        return ResponseEntity.badRequest().body(
                """
                {
                    "status" : 400,
                    "message" : "%s"
                }       \s
                """.formatted(exception.getMessage())
        );
    }

    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<?> patientNotFoundExceptionHandler(PatientNotFoundException exception) {
        return ResponseEntity.badRequest().body(
                """
                {
                    "status" : 400,
                    "message" : "%s"
                }       \s
                """.formatted(exception.getMessage())
        );
    }

    @ExceptionHandler(DentalClinicNotFoundException.class)
    public ResponseEntity<?> dentalClinicNotFoundExceptionHandler(DentalClinicNotFoundException exception) {
        return ResponseEntity.badRequest().body(
                """
                {
                    "status" : 400,
                    "message" : "%s"
                }       \s
                """.formatted(exception.getMessage())
        );
    }

    @ExceptionHandler(AppointmentNotFoundException.class)
    public ResponseEntity<?> appointmentClinicNotFoundExceptionHandler(AppointmentNotFoundException exception) {
        return ResponseEntity.badRequest().body(
                """
                {
                    "status" : 400,
                    "message" : "%s"
                }       \s
                """.formatted(exception.getMessage())
        );
    }

}
