package br.com.dentalclinicmanagementsoftware;

import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.app.api.dto.request.DentalClinicRequest;
import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.app.api.dto.request.PatientRequest;
import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.entity.Address;
import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.entity.Contact;

import java.time.LocalDate;

public class PatientFixture {

    public static PatientRequest anyPatient(){

        Address address = new Address();
        address.setStreet("Rua do Paciente");
        address.setNeighborhood("Bairro do Douglas");
        address.setCity("Cidade");
        address.setState("Estado");
        address.setPostcode("123456");

        Contact contact = new Contact();
        contact.setEmail("contato@patient.com");
        contact.setPhone("+1234567890");

        PatientRequest patient = new PatientRequest();
        patient.setName("João das Couves");
        patient.setDateOfBirth(LocalDate.of(2000, 10, 01));
        patient.setAddressId(address);
        patient.setGender("H");
        patient.setContactId(contact);

        return patient;
    }
}
