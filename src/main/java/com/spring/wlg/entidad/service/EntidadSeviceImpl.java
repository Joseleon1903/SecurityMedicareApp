package com.spring.wlg.entidad.service;

import com.spring.wlg.entidad.domain.EntidadType;
import com.spring.wlg.entidad.repository.EntidadJdbcImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntidadSeviceImpl implements EntidadService{

    private final EntidadJdbcImpl entidadJdbc;

    @Autowired
    public EntidadSeviceImpl(EntidadJdbcImpl entidadJdbc) {
        this.entidadJdbc = entidadJdbc;
    }


    @Override
    public List<EntidadType> buscarTodasLasEntidades() {
        return entidadJdbc.buscarTodasLasEntidades();
    }

    @Override
    public List<EntidadType> buscarEntidadesPorSeguroRegimen(Short seguroId, Short regimenId, String texto) {
        return  entidadJdbc.buscarEntidadesSeguroRegimen(seguroId, regimenId, texto);
    }


}
