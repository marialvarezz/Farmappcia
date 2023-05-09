package com.example.jpa_formacion.repository;


import com.example.jpa_formacion.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long>{
    List<Event> findEventByFechahoraBetween(LocalDateTime from, LocalDateTime to);
}
