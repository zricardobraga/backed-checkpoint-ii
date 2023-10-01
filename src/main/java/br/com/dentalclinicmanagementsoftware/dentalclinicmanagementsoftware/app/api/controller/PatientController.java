package br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.app.api.controller;

import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.app.api.PatientApi;
import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.app.api.dto.request.PatientRequest;
import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.app.api.dto.response.detailed.PatientDetailedResponse;
import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.app.api.dto.response.summary.PatientSummaryResponse;
import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.entity.Patient;
import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.service.PatientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.Map;
import java.util.UUID;


public class PatientController implements PatientApi {
    private final PatientService patientService;
    private final ObjectMapper mapper;

    @Autowired
    public PatientController(PatientService patientService, ObjectMapper mapper) {
        this.patientService = patientService;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<Page<PatientSummaryResponse>> getAllPatients(Pageable pageble) {

        Page<Patient> patientPage = patientService.getAllPatient(pageble);

        Page<PatientSummaryResponse> response = patientPage
                .map(patient -> new PatientSummaryResponse(patient.getId(), patient.getName()));
        return null;
    }

    @Override
    public ResponseEntity<PatientDetailedResponse> addPatient(PatientRequest request) {
        Patient patient = mapper.convertValue(request, Patient.class);
        Patient createdPatient = patientService.addPatient(patient);

        PatientDetailedResponse patientDetailedResponse = patientToDentistDetailedResponse(createdPatient);

        return ResponseEntity.ok(patientDetailedResponse);
    }

    @Override
    public ResponseEntity<PatientDetailedResponse> getPatientById(UUID id) {
        Patient patient = patientService.getPatientById(id);
        PatientDetailedResponse patientDetailedResponse = patientToDentistDetailedResponse(patient);

        return ResponseEntity.ok(patientDetailedResponse);
    }

    @Override
    public ResponseEntity<PatientDetailedResponse> updatePatientById(UUID id, Map<String, Object> params) {
        Patient patient = patientService.updatePatient(id, params);

        PatientDetailedResponse patientDetailedResponse = patientToDentistDetailedResponse(patient);

        return ResponseEntity.accepted().body(patientDetailedResponse);
    }

    @Override
    public ResponseEntity<Void> deletePatientById(UUID id) {
        patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }

    private PatientDetailedResponse patientToDentistDetailedResponse(Patient patient) {
        return mapper.convertValue(patient,PatientDetailedResponse.class);
    }
}
