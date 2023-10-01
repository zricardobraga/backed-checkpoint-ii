package br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.app.api.dto.request;

import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.entity.Address;
import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.entity.Contact;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PatientRequest {
    @NotBlank
    private String name;
    @NotNull
    private LocalDate dateOfBirth;
    @NotNull
    private Address addressId;
    @NotNull
    private String gender;
    @NotNull
    private Contact contactId;
}
