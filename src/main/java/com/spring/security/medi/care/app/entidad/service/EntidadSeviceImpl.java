package com.spring.security.medi.care.app.entidad.service;

import com.spring.security.medi.care.app.commons.domain.Entidad;
import com.spring.security.medi.care.app.controller.rest.EntidadRestController;
import com.spring.security.medi.care.app.entidad.repository.jpa.EntidadJpaRepo;
import com.spring.security.medi.care.app.entidad.types.EntidadType;
import com.spring.security.medi.care.app.entidad.repository.jdbc.EntidadJdbcImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@Service
public class EntidadSeviceImpl implements EntidadService{

    private static final Logger logger = LoggerFactory.getLogger(EntidadRestController.class);

    private final EntidadJdbcImpl entidadJdbc;

    private final EntidadJpaRepo entidadJpaRepo;

    @Autowired
    public EntidadSeviceImpl(EntidadJdbcImpl entidadJdbc, EntidadJpaRepo entidadJpaRepo) {
        this.entidadJdbc = entidadJdbc;
        this.entidadJpaRepo = entidadJpaRepo;
    }

    @Override
    public List<EntidadType> buscarTodasLasEntidades() {
        return entidadJdbc.buscarTodasLasEntidades();
    }

    @Override
    public List<EntidadType> buscarEntidadesPorSeguroRegimen(Short seguroId, Short regimenId, String texto) {
        return  entidadJdbc.buscarEntidadesSeguroRegimen(seguroId, regimenId, texto);
    }

    @Override
    public Entidad buscarEntidadPorId(Long id){
        logger.info("Entering in method buscarEntidadPorId");
        logger.info("param id : "+id);
        return entidadJpaRepo.findById(id).get();
    }

    @Override
    public List<Entidad> buscarEntidades(){
        logger.info("Entering in method buscarEntidades");
        return entidadJpaRepo.findAll();
    }

    @Override
    public Long asignarAutomaticamenteEntidad(Long seguro, Long regimen){
        logger.info("Entering in method asignarAutomaticamenteEntidad");
        logger.info("param seguro : "+seguro);
        logger.info("param regimen : "+regimen);


        return 0L;
    }


}
