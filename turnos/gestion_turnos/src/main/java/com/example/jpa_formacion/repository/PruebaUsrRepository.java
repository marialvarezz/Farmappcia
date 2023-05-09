package com.example.jpa_formacion.repository;


import com.example.jpa_formacion.model.Employee;
import com.example.jpa_formacion.model.PruebaUsr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PruebaUsrRepository extends JpaRepository<PruebaUsr, Long>{}
