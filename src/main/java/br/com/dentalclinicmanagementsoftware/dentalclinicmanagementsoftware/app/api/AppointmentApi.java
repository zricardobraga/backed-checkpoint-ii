package br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.app.api;

import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.app.api.dto.request.AppointmentRequest;
import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.app.api.dto.response.detailed.AppointmentDetailedResponse;
import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.app.api.dto.response.summary.AppointmentSummaryResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RequestMapping("v1/appointments")
public interface AppointmentApi {
    @GetMapping
    ResponseEntity<Page<AppointmentSummaryResponse>> getAllAppointments(@PageableDefault Pageable page);

    @PostMapping
    ResponseEntity<AppointmentDetailedResponse> addAppointment(@RequestBody @Valid AppointmentRequest request);

    @GetMapping("{id}")
    ResponseEntity<AppointmentDetailedResponse> getAppointmentById(@PathVariable UUID id);

    @PatchMapping("{id}")
    ResponseEntity<AppointmentDetailedResponse> updateAppointmentById(@PathVariable UUID id, Map<String, Object> params);

    @DeleteMapping("{id}")
    ResponseEntity<Void> deleteAppointmentById(@PathVariable UUID id);
}
