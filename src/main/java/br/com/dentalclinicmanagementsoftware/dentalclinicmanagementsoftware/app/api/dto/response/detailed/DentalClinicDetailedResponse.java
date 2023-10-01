package br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.app.api.dto.response.detailed;

import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.entity.Address;
import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.entity.Contact;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
public class DentalClinicDetailedResponse {
    private UUID id;
    private String name;
    private String employerNumber;
    private String companyName;
    private Instant createdAt;
    private Instant updatedAt;
    private Address addressId;
    private Contact contactId;
}
