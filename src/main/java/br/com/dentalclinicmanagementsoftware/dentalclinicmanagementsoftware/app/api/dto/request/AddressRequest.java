package br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.app.api.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
public class AddressRequest {
    private String street;
    private String neighbourhood;
    private String city;
    private String state;
    private String postcode;
}
