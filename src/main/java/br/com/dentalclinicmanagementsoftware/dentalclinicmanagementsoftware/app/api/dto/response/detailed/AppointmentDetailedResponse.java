package br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.app.api.dto.response.detailed;

import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.entity.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class AppointmentDetailedResponse {
    private UUID id;
    private Patient patientId;
    private Dentist dentistId;
    private DentalClinic dentalClinicId;
    private LocalDate dateOfAppointment;
    private Instant createdAt;
    private Instant updatedAt;
    private Address addressId;
    private Contact contactId;
}
