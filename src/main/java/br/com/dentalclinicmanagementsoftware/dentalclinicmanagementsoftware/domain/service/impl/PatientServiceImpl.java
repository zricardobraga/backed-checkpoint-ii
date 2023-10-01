package br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.service.impl;

import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.entity.Patient;
import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.exception.PatientNotFoundException;
import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.repository.PatientRepository;
import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient addPatient(Patient patient) {
        return this.patientRepository.save(patient);
    }

    @Override
    public Page<Patient> getAllPatient(Pageable pageable) {
        return this.patientRepository.findAll(pageable);
    }

    @Override
    public Patient getPatientById(UUID id) {
        return this.patientRepository.findById(id).orElseThrow(() -> new PatientNotFoundException(id));
    }

    @Override
    public Patient updatePatient(UUID id, Map<String, Object> params) {
        return null;
    }

    @Override
    public void deletePatient(UUID id) {
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new PatientNotFoundException(id));
        patientRepository.delete(patient);
    }
}
