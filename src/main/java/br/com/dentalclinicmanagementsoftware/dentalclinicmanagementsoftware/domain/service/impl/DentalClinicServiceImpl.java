package br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.service.impl;
import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.entity.DentalClinic;
import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.exception.DentalClinicNotFoundException;
import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.repository.DentalClinicRepository;
import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.service.DentalClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
public class DentalClinicServiceImpl implements DentalClinicService {
    private final DentalClinicRepository dentalClinicRepository;
    @Autowired
    public DentalClinicServiceImpl(DentalClinicRepository dentalClinicRepository) {
        this.dentalClinicRepository = dentalClinicRepository;
    }
    @Override
    public DentalClinic addDentalClinic(DentalClinic dentalClinic) {
        return this.dentalClinicRepository.save(dentalClinic);
    }
    @Override
    public Page<DentalClinic> getAllDentalClinics(Pageable pageable) {
        return this.dentalClinicRepository.findAll(pageable);
    }
    @Override
    public DentalClinic getDentalClinicById(UUID id) {
        return this.dentalClinicRepository.findById(id).orElseThrow(() -> new DentalClinicNotFoundException(id));
    }
    @Override
    public DentalClinic updateDentalClinic(UUID id, Map<String, Object> params) {
        return null;
    }
    @Override
    public void deleteDentalClinic(UUID id) {
        DentalClinic dentalClinic = dentalClinicRepository.findById(id).orElseThrow(() ->  new DentalClinicNotFoundException(id));
        dentalClinicRepository.delete(dentalClinic);
    }
}
