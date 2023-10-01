package br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.app.api.dto.request;

import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.entity.Address;
import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.entity.Contact;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

import java.time.LocalDate;
@Getter
@Setter
public class DentistRequest {
    @NotBlank
    private String name;
    @NotNull
    private LocalDate dateOfBirth;
    @NotNull
    private String speciality;
    @NotNull
    private String gender;
    @NotNull
    private Contact contactId;
}
