package br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.service;

import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.Map;
import java.util.UUID;

public interface PatientService {
    Patient addPatient(Patient patient);
    Page<Patient> getAllPatient(Pageable pageable);
    Patient getPatientById(UUID id);
    Patient updatePatient(UUID id, Map<String, Object> params);
    void deletePatient(UUID id);
}
