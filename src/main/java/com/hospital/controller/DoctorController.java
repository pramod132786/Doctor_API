package com.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.entity.Appointment;
import com.hospital.entity.Doctor;
import com.hospital.entity.Specialty;
import com.hospital.repository.DoctorRepo;
import com.hospital.service.ServiceImple;
@CrossOrigin(origins = "*")
@RestController
public class DoctorController {

	@Autowired
	private ServiceImple service;
	
	 @Autowired
	    private DoctorRepo doctorRepository;
	
	@PostMapping("/doctor/save")
	public String Register(@RequestBody Appointment user ) {
		 
		return service.save(user);
		
		
	}
	
	@PostMapping("/docotor/specialty")
	public Specialty saveSpecialty(@RequestBody Specialty add) {
		service.addSpeciality(add);
		return add;
		
	}
	

	@GetMapping("/specialty/all")
	public List<Specialty> getSpecialty() {
		return service.getSpeciality();		
	  }
	
	@PostMapping("/doctor")
	public Doctor addDoctor(@RequestBody Doctor add) {
		return service.addDoctor(add);		
	  }
	
	@GetMapping("/doctor/all")
	public List<Doctor> getDoctor() {
		return service.getDoctor();		
	  }
	
	@GetMapping("/doctors/{id}")
	public List<Appointment> findDoctors(@PathVariable String id){
		 return service.findDoctor(id);
		
	}
	
	@GetMapping("/appoint/all")
	public List<Appointment> getAppoitntment() {
		return service.getAppointment();		
	  }
	
	 @GetMapping("/doctor/{specialtyId}")
	    public List<Doctor> getDoctorsBySpeciality(@PathVariable Integer specialtyId) {
	        return doctorRepository.findBySpecialityId(specialtyId);
	    }
	 

//	    @GetMapping("getDate/{date}")
//	    public List<Appointment> getBookedTimeSlots(@PathVariable String date) {
//	        return service.getBookedTimeSlotsByDate(date);
//	    }
}
