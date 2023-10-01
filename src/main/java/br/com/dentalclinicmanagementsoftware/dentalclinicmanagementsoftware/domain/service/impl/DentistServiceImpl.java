package br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.service.impl;

import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.entity.Dentist;
import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.exception.DentistNotFoundException;
import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.repository.DentistRepository;
import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.service.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class DentistServiceImpl implements DentistService {

    private final DentistRepository dentistRepository;

    @Autowired
    public DentistServiceImpl(DentistRepository dentistRepository) {this.dentistRepository = dentistRepository;}

    @Override
    public Dentist addDentist(Dentist dentist) {
        return this.dentistRepository.save(dentist);
    }

    @Override
    public Page<Dentist> getAllDentist(Pageable pageable) {
        return this.dentistRepository.findAll(pageable);
    }

    @Override
    public Dentist getDentistById(UUID id) {return this.dentistRepository.findById(id).orElseThrow(() -> new DentistNotFoundException(id));}

    @Override
    public Dentist updateDentist(UUID id, Map<String, Object> params) {
        return null;
    }

    @Override
    public void deleteDentist(UUID id) {
        Dentist dentist = dentistRepository.findById(id).orElseThrow(() -> new DentistNotFoundException(id));
    }
}
