package com.example.jpa_formacion.service;

import com.example.jpa_formacion.dto.UsuarioDto;
import com.example.jpa_formacion.dto.UsuarioDtoPsw;
import com.example.jpa_formacion.model.PruebaUsr;
import com.example.jpa_formacion.model.Usuario;
import com.example.jpa_formacion.repository.PruebaUsrRepository;
import com.example.jpa_formacion.repository.UsuarioRepository;
import com.example.jpa_formacion.service.mapper.UsuarioMapper;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;


@Service
public class PruebaUsrService extends AbstractBusinessServiceSoloEnt<PruebaUsr,Long, PruebaUsrRepository>  {
    protected PruebaUsrService(PruebaUsrRepository pruebaUsrRepository) {
        super(pruebaUsrRepository);
    }





}
