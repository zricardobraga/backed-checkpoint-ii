package br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.app.api.dto.request;

import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.entity.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AppointmentRequest {
    @NotNull
    private Patient patientId;
    @NotNull
    private Dentist dentistId;
    @NotNull
    private DentalClinic clinicId;
    @NotNull
    private LocalDate dateOfAppointment;
    @NotNull
    private String description;
    @NotNull
    private Boolean canceled;
    @NotNull
    private String reasonForCancellation;
}
