package br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.service;

import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.entity.DentalClinic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface DentalClinicService {

    DentalClinic addDentalClinic(DentalClinic dentalClinic);
    Page<DentalClinic> getAllDentalClinics(Pageable pageable);
    DentalClinic getDentalClinicById(UUID id);
    DentalClinic updateDentalClinic(UUID id, Map<String, Object> params);
    void deleteDentalClinic(UUID id);
}
