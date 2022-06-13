package com.spring.wlg.entidad.service;

import com.spring.wlg.entidad.domain.EntidadType;
import java.util.List;

public interface EntidadService {

    public List<EntidadType> buscarTodasLasEntidades();

    public List<EntidadType> buscarEntidadesPorSeguroRegimen(Short seguroId, Short regimenId, String texto);

}
