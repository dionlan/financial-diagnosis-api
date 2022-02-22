package com.mcf.diagnosis.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mcf.diagnosis.api.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
