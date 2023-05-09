package com.example.jpa_formacion.service;

import com.example.jpa_formacion.dto.RoleDTO;
import com.example.jpa_formacion.model.Event;
import com.example.jpa_formacion.model.Role;
import com.example.jpa_formacion.repository.EventRepository;
import com.example.jpa_formacion.repository.RoleRepository;
import com.example.jpa_formacion.repository.UsuarioRepository;
import com.example.jpa_formacion.service.mapper.RoleServiceMapper;
import org.springframework.stereotype.Service;

@Service
public class EventService extends AbstractBusinessServiceSoloEnt<Event,Long, EventRepository> {


    protected EventService(EventRepository eventRepository) {
        super(eventRepository);
    }
}
