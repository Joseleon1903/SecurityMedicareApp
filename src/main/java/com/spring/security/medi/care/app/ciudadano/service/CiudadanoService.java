package com.spring.security.medi.care.app.ciudadano.service;

import com.spring.security.medi.care.app.ciudadano.type.CiudadanoPaginated;
import com.spring.security.medi.care.app.commons.domain.Ciudadano;
import java.util.List;

public interface CiudadanoService {

    Ciudadano buscarCiudadanoPorCiudadanoId(Long ciudadanoId);

    List<Ciudadano> buscarTodosCiudadanos();

    List<Ciudadano> buscarTodosCiudadanos(int poage, int size);

    CiudadanoPaginated buscarCiudadanosPorParametros(String identificacion, String texto, String estado, int page, int size);

    void eliminarCiudadanoId(Long ciudadanoId);

    Ciudadano buscarCiudadanoPorIdentifiacion(String cedula, String nss);

    Ciudadano guardarCiudadano(Ciudadano ciudadano);

}