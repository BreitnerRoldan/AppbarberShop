package com.Spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Spring.entity.Cita;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {

// Aquí se pueden agregar métodos personalizados para consultas específicas
    List<Cita> findAll();

    // Guardar una cita
    Cita save(Cita cita);
}