package br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.app.api;

import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.app.api.dto.request.DentalClinicRequest;
import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.app.api.dto.response.detailed.DentalClinicDetailedResponse;
import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.app.api.dto.response.summary.DentalClinicSummaryResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RequestMapping("v1/dental_clinics")
public interface DentalClinicApi {

    @GetMapping
    ResponseEntity<Page<DentalClinicSummaryResponse>> getAllDentalClinics(@PageableDefault Pageable page);

    @PostMapping
    ResponseEntity<DentalClinicDetailedResponse> addDentalClinic(@RequestBody @Valid DentalClinicRequest request);

    @GetMapping("{id}")
    ResponseEntity<DentalClinicDetailedResponse> getDentalClinicById(@PathVariable UUID id);

    @PatchMapping("{id}")
    ResponseEntity<DentalClinicDetailedResponse> updateDentalClinicById(@PathVariable UUID id, Map<String, Object> params);

    @DeleteMapping("{id}")
    ResponseEntity<Void> deleteDentalClinicById(@PathVariable UUID id);
}
