package com.assessment1.controller;

import com.assessment1.model.Appointment;
import com.assessment1.model.Patient;
import com.assessment1.repository.AppointmentRepo;
import com.assessment1.repository.PatientRepo;
import com.assessment1.service.BookAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookAppointmentController {
    @Autowired
    private BookAppointmentService bookAppointmentService;

    @PostMapping("/bookappointment")
    public ResponseEntity bookAppointment(@RequestBody AppointmentForm appointmentForm){
        try{
            return ResponseEntity.ok(bookAppointmentService.bookAppointment(appointmentForm));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        }
    }
    @GetMapping("/getpatient")
    public List<Patient>getAllPatient(){
        return bookAppointmentService.getAllPatient();
    }
    @GetMapping("/getpatient/{pid}")
    public ResponseEntity getPatientById(@PathVariable Long pid){
        try {
            return bookAppointmentService.getPatientById(pid);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        }
    }
    @DeleteMapping("/remove/{pid}")
    public String delete(@PathVariable Long pid){
        return bookAppointmentService.delete(pid);
    }
    @DeleteMapping("/delappointment/{aid}")
    public String delAppointment(@PathVariable Long aid){
        return bookAppointmentService.delAppointment(aid);
    }
    @PutMapping("/update")
    public Patient updatePatient(@RequestBody Patient patient){
        return bookAppointmentService.updatePatient(patient);
    }

}
