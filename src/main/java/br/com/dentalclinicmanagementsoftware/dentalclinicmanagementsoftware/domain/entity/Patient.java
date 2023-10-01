package br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Slf4j
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(length = 255, nullable = false)
    private String name;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address",referencedColumnName = "id",foreignKey =
    @ForeignKey(name = "fk_address_patient"))
    private Address address;
    @Column(length = 2, nullable = false)
    private String gender;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact",referencedColumnName = "id",foreignKey =
    @ForeignKey(name = "fk_contact_patient"))
    private Contact contact;
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
        log.info("New registered patient: {}", name);
    }
    @PreUpdate
    protected void onUpdate() {
        updatedAt = Instant.now();
        log.info("Updated patient: {}", name);
    }
}
