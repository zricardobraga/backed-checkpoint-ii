package br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.app.api.controller;

import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.app.api.AppointmentApi;
import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.app.api.dto.request.AppointmentRequest;
import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.app.api.dto.response.detailed.AppointmentDetailedResponse;
import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.app.api.dto.response.summary.AppointmentSummaryResponse;
import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.entity.Appointment;
import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.service.AppointmentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;

@RestController
public class AppointmentController implements AppointmentApi {

    private final AppointmentService appointmentService;

    private final ObjectMapper mapper;

    public AppointmentController(AppointmentService appointmentService, ObjectMapper mapper) {
        this.appointmentService = appointmentService;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<Page<AppointmentSummaryResponse>> getAllAppointments(Pageable page) {
        Page<Appointment> appointmentPage = appointmentService.getAllAppointment(page);

        Page<AppointmentSummaryResponse> responses = appointmentPage
                .map(appointment -> new AppointmentSummaryResponse(appointment.getId(),appointment.getDescription()) );
        return ResponseEntity.ok(responses);
    }

    @Override
    public ResponseEntity<AppointmentDetailedResponse> addAppointment(AppointmentRequest request) {
        Appointment appointment = mapper.convertValue(request, Appointment.class);
        Appointment createdAppointment = appointmentService.addAppointment(appointment);

        AppointmentDetailedResponse appointmentDetailedResponse = appoinmentToDentistDetailedResponse(createdAppointment);

        return ResponseEntity.accepted().body(appointmentDetailedResponse);
    }

    @Override
    public ResponseEntity<AppointmentDetailedResponse> getAppointmentById(UUID id) {
        Appointment appointment = appointmentService.getAppointmentById(id);

        AppointmentDetailedResponse appointmentDetailedResponse = appoinmentToDentistDetailedResponse(appointment);

        return ResponseEntity.ok(appointmentDetailedResponse);
    }

    @Override
    public ResponseEntity<AppointmentDetailedResponse> updateAppointmentById(UUID id, Map<String, Object> params) {
        Appointment appointment = appointmentService.updateAppointment(id, params);

        AppointmentDetailedResponse appointmentDetailedResponse = appoinmentToDentistDetailedResponse(appointment);
        return ResponseEntity.accepted().body(appointmentDetailedResponse);
    }

    @Override
    public ResponseEntity<Void> deleteAppointmentById(UUID id) {
        appointmentService.deleteAppointment(id);
        return ResponseEntity.noContent().build();

    }

    private AppointmentDetailedResponse appoinmentToDentistDetailedResponse(Appointment appointment) {
        return mapper.convertValue(appointment, AppointmentDetailedResponse.class);
    }

}
