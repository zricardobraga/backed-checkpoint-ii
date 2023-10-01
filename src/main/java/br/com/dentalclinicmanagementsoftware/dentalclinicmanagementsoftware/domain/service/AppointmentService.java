package br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.service;

import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.entity.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;
import java.util.UUID;

public interface AppointmentService {
    Appointment addAppointment(Appointment appointment);
    Page<Appointment> getAllAppointment(Pageable pageable);
    Appointment getAppointmentById(UUID id);
    Appointment updateAppointment(UUID id, Map<String, Object> params);
    void deleteAppointment(UUID id);
}
