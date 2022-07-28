package com.spring.security.medi.care.app.entidad.service;

import com.spring.security.medi.care.app.commons.domain.Entidad;
import com.spring.security.medi.care.app.entidad.types.EntidadType;
import java.util.List;

public interface EntidadService {

    List<EntidadType> buscarTodasLasEntidades();

    List<EntidadType> buscarEntidadesPorSeguroRegimen(Short seguroId, Short regimenId, String texto);

    Entidad buscarEntidadPorId(Long id);

    List<Entidad> buscarEntidades();

    Long asignarAutomaticamenteEntidad(Integer regimen);

}
