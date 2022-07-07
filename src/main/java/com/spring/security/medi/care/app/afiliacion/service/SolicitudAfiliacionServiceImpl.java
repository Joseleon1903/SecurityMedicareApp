package com.spring.security.medi.care.app.afiliacion.service;

import com.spring.security.medi.care.app.afiliacion.types.SolicitudAfiliacion;
import com.spring.security.medi.care.app.afiliacion.repository.jdbc.SolicitudAfiliacionJdbcImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SolicitudAfiliacionServiceImpl implements SolicitudAfiliacionService{

    private final SolicitudAfiliacionJdbcImpl solicitudAfiliacionJdbc;

    @Autowired
    public SolicitudAfiliacionServiceImpl(SolicitudAfiliacionJdbcImpl solicitudAfiliacionJdbc) {
        this.solicitudAfiliacionJdbc = solicitudAfiliacionJdbc;
    }

    @Override
    public List<SolicitudAfiliacion> buscarSolicitudesAfiliacion() {
        return solicitudAfiliacionJdbc.buscarSolicitudesAfiliaciones();
    }
}
