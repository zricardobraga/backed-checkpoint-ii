package br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.app.api.controller;

import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.app.api.DentistApi;
import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.app.api.dto.request.DentistRequest;
import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.app.api.dto.response.detailed.DentistDetailedResponse;
import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.app.api.dto.response.summary.DentistSummaryResponse;
import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.entity.Dentist;
import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.service.DentistService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController

public class DentistController implements DentistApi {

    private final DentistService dentistService;
    private final ObjectMapper mapper;

    @Autowired
    public DentistController(DentistService dentistService, ObjectMapper mapper) {
        this.dentistService = dentistService;
        this.mapper = mapper;
    }


    @Override
    public ResponseEntity<Page<DentistSummaryResponse>> getAllDentists(Pageable pageable) {
        Page<Dentist> dentistPage = dentistService.getAllDentist(pageable);

        Page<DentistSummaryResponse> responses = dentistPage
                .map(dentist -> new DentistSummaryResponse(dentist.getId(), dentist.getName()));

        return null;
    }

    @Override
    public ResponseEntity<DentistDetailedResponse> addDentist(DentistRequest request) {
        Dentist dentist = mapper.convertValue(request, Dentist.class);
        Dentist createdDentist = dentistService.addDentist(dentist);

        DentistDetailedResponse dentistDetailedResponse = dentistToDentistDetailedResponse(createdDentist);

        return ResponseEntity.status(HttpStatus.CREATED).body(dentistDetailedResponse);
    }

    @Override
    public ResponseEntity<DentistDetailedResponse> getDentistById(UUID id) {
            Dentist dentist = dentistService.getDentistById(id);

            DentistDetailedResponse dentistDetailedResponse = dentistToDentistDetailedResponse(dentist);

            return ResponseEntity.ok(dentistDetailedResponse);

    }

    @Override
    public ResponseEntity<DentistDetailedResponse> updateDentistById(UUID id, Map<String, Object> params) {
        Dentist dentist = dentistService.updateDentist(id, params);

        DentistDetailedResponse dentistDetailedResponse = dentistToDentistDetailedResponse(dentist);
        return ResponseEntity.accepted().body(dentistDetailedResponse);
    }

    @Override
    public ResponseEntity<Void> deleteDentistById(UUID id) {
        dentistService.deleteDentist(id);
        return ResponseEntity.noContent().build();


    }

    private DentistDetailedResponse dentistToDentistDetailedResponse(Dentist dentist) {
        return mapper.convertValue(dentist, DentistDetailedResponse.class);
    }
}
