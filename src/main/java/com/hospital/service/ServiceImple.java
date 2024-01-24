package com.hospital.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.entity.Appointment;
import com.hospital.entity.Doctor;
import com.hospital.entity.Specialty;
import com.hospital.repository.AppointmentRepository;
import com.hospital.repository.DoctorRepo;
import com.hospital.repository.SpeciltyRepository;

@Service
public class ServiceImple {
	
	@Autowired
	private AppointmentRepository repo;
	
	@Autowired
	private SpeciltyRepository spRepo;
	
	@Autowired
	private DoctorRepo doctorRepo;



	public String save(Appointment user) {
	    user.setBookingDate(LocalDateTime.now());

	    List<Appointment> existingAppointments = repo.findAll();

	    for (Appointment existingAppointment : existingAppointments) {
	        if (existingAppointment.getAppointment().equals(user.getAppointment())
	                && existingAppointment.getTimeSlot().equals(user.getTimeSlot())
	                && existingAppointment.getDoctor().equalsIgnoreCase(user.getDoctor())
	                && existingAppointment.getSpeciality().equalsIgnoreCase(user.getSpeciality())) {
	            // If there's a matching appointment, return a message indicating that the appointment cannot be saved.
	            return "Appointment already booked for the selected date, time slot, doctor, and speciality.";
	        }
	    }

	    // If no matching appointment is found, save the new appointment.
	    repo.save(user);
	    return "Appointment successfully booked.";
	}

	
	public Specialty addSpeciality(Specialty add) {
		
		return spRepo.save(add);
		
	}
	
     public List<Specialty> getSpeciality() {
		
		return spRepo.findAll();
		
	}
     
     public Doctor addDoctor(Doctor add) {
    	 add.setDoctorName("Dr "+add.getDoctorName());
    	 return doctorRepo.save(add);
    	 
     }
     
     public List<Doctor> getDoctor() {
    	 return doctorRepo.findAll();
    	 
     }
    
     public List<Appointment> getAppointment() {
    	 return repo.findAll();
    	 
     }

    
	public List<Appointment> findDoctor(String id) {
	
		return repo.findByDoctorId(id);
	}
    
	

}
