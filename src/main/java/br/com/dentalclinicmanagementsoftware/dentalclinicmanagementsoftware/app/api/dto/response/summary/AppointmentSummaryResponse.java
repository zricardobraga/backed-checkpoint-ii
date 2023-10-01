package br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.app.api.dto.response.summary;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class AppointmentSummaryResponse {
    private UUID id;
    private String name;
}
