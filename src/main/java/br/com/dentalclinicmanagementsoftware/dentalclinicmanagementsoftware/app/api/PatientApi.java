package br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.app.api;

import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.app.api.dto.request.PatientRequest;
import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.app.api.dto.response.detailed.PatientDetailedResponse;
import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.app.api.dto.response.summary.PatientSummaryResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.UUID;

@RequestMapping("v1/patients")
public interface PatientApi {

    @GetMapping
    ResponseEntity<Page<PatientSummaryResponse>> getAllPatients(@PageableDefault Pageable page);

    @PostMapping
    ResponseEntity<PatientDetailedResponse> addPatient(@RequestBody @Valid PatientRequest request);

    @GetMapping("{id}")
    ResponseEntity<PatientDetailedResponse> getPatientById(@PathVariable UUID id);

    @PatchMapping("{id}")
    ResponseEntity<PatientDetailedResponse> updatePatientById(@PathVariable UUID id, Map<String, Object> params);

    @DeleteMapping("{id}")
    ResponseEntity<Void> deletePatientById(@PathVariable UUID id);
}
