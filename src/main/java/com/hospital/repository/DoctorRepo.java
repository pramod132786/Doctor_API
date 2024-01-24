package com.hospital.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.entity.Doctor;
import com.hospital.entity.Specialty;

public interface DoctorRepo extends JpaRepository<Doctor, Integer> {

	  List<Doctor> findBySpecialityId(Integer specialtyId);

}
