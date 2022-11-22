package com.spring.security.medi.care.app.ciudadano.service;

import com.spring.security.medi.care.app.ciudadano.type.CiudadanoPaginated;
import com.spring.security.medi.care.app.commons.domain.Ciudadano;
import java.util.List;
import java.util.Optional;

public interface CiudadanoService {

    Optional<Ciudadano> buscarCiudadanoPorCiudadanoId(Long ciudadanoId);

    List<Ciudadano> buscarTodosCiudadanos();

    List<Ciudadano> buscarTodosCiudadanos(int poage, int size);

    CiudadanoPaginated buscarCiudadanosPorParametros(String identificacion, String texto, String estado, int page, int size);

    void eliminarCiudadanoId(Long ciudadanoId);

    Optional<Ciudadano> buscarCiudadanoPorIdentifiacion(String cedula, String nss);

    Ciudadano guardarCiudadano(Ciudadano ciudadano);

}