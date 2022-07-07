package com.spring.security.medi.care.app.ciudadano.service;

import com.spring.security.medi.care.app.commons.domain.Ciudadano;
import java.util.List;

public interface CiudadanoService {

    Ciudadano buscarCiudadanoPorCiudadanoId(Long ciudadanoId);

    List<Ciudadano> buscarTodosCiudadanos();

}