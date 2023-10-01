package br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.repository;

import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.entity.DentalClinic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DentalClinicRepository extends JpaRepository<DentalClinic, UUID> {
}
