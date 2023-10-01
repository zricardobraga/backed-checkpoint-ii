package br.com.dentalclinicmanagementsoftware;

import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.app.api.dto.request.DentalClinicRequest;
import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.entity.Address;
import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.entity.Contact;
import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.entity.DentalClinic;

public class DentalClinicFixture {
    public static DentalClinicRequest anyDentalClinic() {

        Address address = new Address();
        address.setStreet("Rua da Clínica");
        address.setNeighborhood("Bairro do Douglas");
        address.setCity("Cidade");
        address.setState("Estado");
        address.setPostcode("123456");

        Contact contact = new Contact();
        contact.setEmail("contato@clinica.com");
        contact.setPhone("+1234567890");

        DentalClinicRequest dentalClinic = new DentalClinicRequest();
        dentalClinic.setName("Clínica Dois");
        dentalClinic.setEmployerNumber("44.167.376/0001-60");
        dentalClinic.setCompanyName("Nome da Empresa");
        dentalClinic.setDescription("Descrição da Clínica");
        dentalClinic.setAddressId(address);
        dentalClinic.setContactId(contact);

        return dentalClinic;
    }
}
