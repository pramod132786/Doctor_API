package com.hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hospital.entity.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
	
//	 @Query("SELECT b.time_slot FROM Booking b WHERE b.appointment = :date")
//	     List<Appointment> findByAppointment(String appointment);
   List<Appointment> findByDoctorId(String doctorId);
}
