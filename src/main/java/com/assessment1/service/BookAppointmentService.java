package com.assessment1.service;

import com.assessment1.controller.AppointmentForm;
import com.assessment1.model.Appointment;
import com.assessment1.model.Patient;
import com.assessment1.repository.AppointmentRepo;
import com.assessment1.repository.PatientRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;

@Service
public class BookAppointmentService {
    @Autowired
    private PatientRepo patientRepo;
    @Autowired
    private AppointmentRepo appointmentRepo;

    public String bookAppointment(AppointmentForm appointmentForm) throws Exception{
        if(appointmentForm.getName()==null){
            throw new Exception("Enter your name");
        }else if(appointmentForm.getMobile()==null){
            throw new Exception("Enter your mobile no.");
        }else if(appointmentForm.getAge()==null) {
            throw new Exception("Enter your age");
        }
        else {
            Patient patient = new ObjectMapper().convertValue(appointmentForm, Patient.class);
            Long patientId = patientRepo.save(patient).getPid();
            Appointment appointment = new Appointment("John Methai", new Date(System.currentTimeMillis()), patientId);
            Long appointmentId = appointmentRepo.save(appointment).getAid();
            return "Appointment booked with appointment id " + appointmentId;
        }
    }
    public List<Patient> getAllPatient(){
        return patientRepo.findAll();
    }
    public ResponseEntity getPatientById(Long pid)throws Exception{
        if(patientRepo.findById(pid).isPresent()) {
            return ResponseEntity.ok(patientRepo.findById(pid).orElse(null));
        }else{
            throw new Exception("this id does not exist");
        }
    }
    public String delete(Long pid){
        patientRepo.deleteById(pid);
        appointmentRepo.deleteById(pid);
        return "Both patient and his appointment removed";
    }
    public String delAppointment(Long aid){
        appointmentRepo.deleteById(aid);
        return "appointment deleted";
    }
    public Patient updatePatient(Patient patient){
        return patientRepo.save(patient);
    }
}
