package com.spring.security.medi.care.app.afiliacion.service;

import com.spring.security.medi.care.app.commons.domain.SolicitudAfiliacion;
import com.spring.security.medi.care.app.afiliacion.repository.jpa.SolicitudAfiliacionJpaRepo;
import com.spring.security.medi.care.app.afiliacion.repository.jdbc.SolicitudAfiliacionJdbcImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import java.util.List;

@Service
public class SolicitudAfiliacionServiceImpl implements SolicitudAfiliacionService{

    private static final Logger logger = LoggerFactory.getLogger(SolicitudAfiliacionServiceImpl.class);

    private final SolicitudAfiliacionJdbcImpl solicitudAfiliacionJdbc;

    private final SolicitudAfiliacionJpaRepo solicitudAfiliacionJpaRepo;

    @Autowired
    public SolicitudAfiliacionServiceImpl(SolicitudAfiliacionJdbcImpl solicitudAfiliacionJdbc, SolicitudAfiliacionJpaRepo solicitudAfiliacionJpaRepo) {
        this.solicitudAfiliacionJdbc = solicitudAfiliacionJdbc;
        this.solicitudAfiliacionJpaRepo = solicitudAfiliacionJpaRepo;
    }

    @Override
    public List<SolicitudAfiliacion> buscarSolicitudesAfiliacion() {
        return solicitudAfiliacionJpaRepo.findAll();
    }

    @Override
    public SolicitudAfiliacion regristarSolicitudAfiliacion(SolicitudAfiliacion solicitud) throws Exception {
        logger.info("Entering in regristarSolicitudAfiliacion");
        logger.info("pram : "+solicitud);
        SolicitudAfiliacion sol = solicitudAfiliacionJpaRepo.save(solicitud);
        return sol;
    }

    @Override
    public List<SolicitudAfiliacion> buscarSolicitudesAfiliacionPorParametros(String cedula,Integer servicioId, Long seguroId, Long regimenId, String estado, int page, int size){

        logger.info("Entering in buscarSolicitudesAfiliacionPorParametros");
        logger.info("param cedula: "+cedula);
        logger.info("param servicioId: "+servicioId);
        logger.info("param seguroId: "+seguroId);
        logger.info("param regimenId: "+regimenId);
        logger.info("param estado: "+estado);
        logger.info("param page: "+page);
        logger.info("param size: "+size);
        cedula = (cedula == null || cedula.isEmpty())? null: "%"+cedula+"%";
        Pageable paging = PageRequest.of(page, size);
        List<SolicitudAfiliacion> solList = solicitudAfiliacionJpaRepo.findSolicitudAfiliacionesByParameters(cedula, servicioId, seguroId,
                regimenId, estado, paging).getContent();
        return solList;
    }


}
