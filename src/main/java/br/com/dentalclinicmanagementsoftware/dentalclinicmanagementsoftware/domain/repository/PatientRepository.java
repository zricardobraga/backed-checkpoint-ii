package br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.repository;

import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PatientRepository extends JpaRepository<Patient, UUID> {

}
