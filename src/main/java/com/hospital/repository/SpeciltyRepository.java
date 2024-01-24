package com.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.entity.Specialty;

public interface SpeciltyRepository extends JpaRepository<Specialty, Integer> {

}
