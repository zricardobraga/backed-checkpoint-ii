package br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.service.impl;

import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.entity.Appointment;
import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.exception.AppointmentNotFoundException;
import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.repository.AppointmentRepository;
import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Appointment addAppointment(Appointment appointment) {
        return this.appointmentRepository.save(appointment);
    }

    @Override
    public Page<Appointment> getAllAppointment(Pageable pageable) {
        return this.appointmentRepository.findAll(pageable);
    }

    @Override
    public Appointment getAppointmentById(UUID id) {
        return this.appointmentRepository.findById(id).orElseThrow(() -> new AppointmentNotFoundException(id));
    }

    @Override
    public Appointment updateAppointment(UUID id, Map<String, Object> params) {
        return null;
    }

    @Override
    public void deleteAppointment(UUID id) {
        Appointment appointment = appointmentRepository.findById(id).orElseThrow(() -> new AppointmentNotFoundException(id));
        this.appointmentRepository.delete(appointment);
    }
}
