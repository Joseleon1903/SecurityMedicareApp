package com.spring.security.medi.care.app.entidad.service;

import com.spring.security.medi.care.app.entidad.domain.EntidadType;
import java.util.List;

public interface EntidadService {

    public List<EntidadType> buscarTodasLasEntidades();

    public List<EntidadType> buscarEntidadesPorSeguroRegimen(Short seguroId, Short regimenId, String texto);

}
