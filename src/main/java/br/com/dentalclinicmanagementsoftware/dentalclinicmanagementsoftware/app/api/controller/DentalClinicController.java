package br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.app.api.controller;

import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.app.api.DentalClinicApi;
import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.app.api.dto.request.DentalClinicRequest;
import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.app.api.dto.response.detailed.DentalClinicDetailedResponse;
import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.app.api.dto.response.summary.DentalClinicSummaryResponse;
import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.entity.DentalClinic;
import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.service.DentalClinicService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;

@RestController
public class DentalClinicController implements DentalClinicApi {

    private final DentalClinicService dentalClinicService;
    private final ObjectMapper mapper;

    public DentalClinicController(DentalClinicService dentalClinicService, ObjectMapper mapper) {
        this.dentalClinicService = dentalClinicService;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<Page<DentalClinicSummaryResponse>> getAllDentalClinics(Pageable pageable) {
        Page<DentalClinic> dentalClinicPage = dentalClinicService.getAllDentalClinics(pageable);

        Page<DentalClinicSummaryResponse> response = dentalClinicPage
                .map(dentalClinic -> new DentalClinicSummaryResponse(dentalClinic.getId(), dentalClinic.getName()));

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<DentalClinicDetailedResponse> addDentalClinic(DentalClinicRequest request) {
        DentalClinic dentalClinic = mapper.convertValue(request, DentalClinic.class);
        DentalClinic createdDentalClinic = dentalClinicService.addDentalClinic(dentalClinic);

        DentalClinicDetailedResponse dentalClinicDetailedResponse = dentalClinicDetailedResponse(createdDentalClinic);

        return ResponseEntity.status(HttpStatus.CREATED).body(dentalClinicDetailedResponse);
    }

    @Override
    public ResponseEntity<DentalClinicDetailedResponse> getDentalClinicById(UUID id) {
        DentalClinic dentalClinic = dentalClinicService.getDentalClinicById(id);
        DentalClinicDetailedResponse dentalClinicDetailedResponse = dentalClinicDetailedResponse(dentalClinic);
        return ResponseEntity.ok(dentalClinicDetailedResponse);
    }

    @Override
    public ResponseEntity<DentalClinicDetailedResponse> updateDentalClinicById(UUID id, Map<String, Object> params) {
        DentalClinic dentalClinic = dentalClinicService.updateDentalClinic(id, params);
        DentalClinicDetailedResponse dentalClinicDetailedResponse = dentalClinicDetailedResponse(dentalClinic);
        return ResponseEntity.accepted().body(dentalClinicDetailedResponse);
    }

    @Override
    public ResponseEntity<Void> deleteDentalClinicById(UUID id) {
        dentalClinicService.deleteDentalClinic(id);
        return ResponseEntity.noContent().build();
    }

    private DentalClinicDetailedResponse dentalClinicDetailedResponse(DentalClinic dentalClinic) {
        return mapper.convertValue(dentalClinic, DentalClinicDetailedResponse.class);
    }
}
