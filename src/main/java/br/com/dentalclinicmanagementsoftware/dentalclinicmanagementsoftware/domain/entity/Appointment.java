package br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.entity;

import jakarta.persistence.*;
import jdk.jfr.BooleanFlag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "date_of_appointment", nullable = false)
    private LocalDateTime AppointmentDate;
    @Column(length = 255, nullable = false)
    private String description;
    @Column(length = 255, nullable = false)
    private String reasonForCancellation;

    @BooleanFlag
    private Boolean canceled;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "patient_id",
            referencedColumnName = "id",
            foreignKey =
            @ForeignKey(name = "fk_patient_appointment"))
    private Patient patient;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "dentist_id",
            referencedColumnName = "id",
            foreignKey =
            @ForeignKey(name = "fk_dentist_appointment")
    )
    private Dentist dentist;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "dental_clinic_id",
            referencedColumnName = "id",
            foreignKey =
            @ForeignKey(name = "fk_dentalClinic_appointment")
    )
    private DentalClinic clinic;
    @Transient
    @Column(columnDefinition = "DATETIME")
    private Instant createdAt;
    @Transient
    @Column(columnDefinition = "DATETIME")
    private Instant updatedAt;
    @PrePersist
    protected void onCreate() {
        createdAt = Instant.now();
        updatedAt = Instant.now();
        log.info("New appointment registered for the patient: {}", patient.getName());
    }
    @PreUpdate
    protected void onUpdate() {
        updatedAt = Instant.now();
        log.info("Updated appointment for the patient: {}", patient.getName());
    }
}
