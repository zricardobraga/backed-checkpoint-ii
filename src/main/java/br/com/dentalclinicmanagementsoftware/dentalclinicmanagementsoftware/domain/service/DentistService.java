package br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.service;

import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.entity.Dentist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;
import java.util.UUID;
public interface DentistService {
    Dentist addDentist(Dentist dentist);
    Page<Dentist> getAllDentist(Pageable pageable);
    Dentist getDentistById(UUID id);
    Dentist updateDentist(UUID id, Map<String, Object> params);
    void deleteDentist(UUID id);
}
