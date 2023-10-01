package br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.app.api.dto.request;

import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.entity.Address;
import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.entity.Contact;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CNPJ;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class DentalClinicRequest {
    @NotBlank
    private String name;
    @CNPJ
    private String employerNumber;
    @NotNull
    private String companyName;
    @NotNull
    private String description;
    @NotNull
    private Address addressId;
    @NotNull
    private Contact contactId;
}
