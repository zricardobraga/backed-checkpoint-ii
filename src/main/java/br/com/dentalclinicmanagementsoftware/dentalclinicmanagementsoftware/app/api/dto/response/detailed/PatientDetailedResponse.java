package br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.app.api.dto.response.detailed;

import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.entity.Address;
import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.entity.Contact;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class PatientDetailedResponse {
    private UUID id;
    private String name;
    private LocalDate dateOfBirth;
    private Address addressId;
    private Instant createdAt;
    private Instant updatedAt;
    private String gender;
    private Contact contactId;
}
