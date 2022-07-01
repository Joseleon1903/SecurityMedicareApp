package com.spring.security.medi.care.app.catalogo.service;

import com.spring.security.medi.care.app.catalogo.repository.jdbc.MotivoEstadoJdbcImpl;
import com.spring.security.medi.care.app.catalogo.repository.jdbc.NacionalidadJdbcImpl;
import com.spring.security.medi.care.app.catalogo.repository.jdbc.ParentescoJdbcImpl;
import com.spring.security.medi.care.app.catalogo.repository.jpa.*;
import com.spring.security.medi.care.app.commons.domain.*;
import com.spring.security.medi.care.app.controller.rest.MotivoEstadoRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class CatalogoServiceImpl implements CatalogoService {

    private static final Logger logger = LoggerFactory.getLogger(MotivoEstadoRestController.class);

    private final ParentescoJdbcImpl parentescoJdbc;

    private final MotivoEstadoJdbcImpl motivoEstadoJdbc;

    private final NacionalidadJdbcImpl nacionalidadJdbcImpl;

    private final MotivoEstadoJpaRepo motivoEstadoJpaRepo;

    private final ParentescoJpaRepo parentescoJpaRepo;

    private final NacionalidadJpaRepo nacionalidadJpaRepo;

    private final MunicipioJpaRepo municipioJpaRepo;

    private final GradoConsanguinidadJpaRepo gradoConsanguinidadJpaRepo;

    @Autowired
    public CatalogoServiceImpl(ParentescoJdbcImpl parentescoJdbc, MotivoEstadoJdbcImpl motivoEstadoJdbc, NacionalidadJdbcImpl nacionalidadJdbcImpl,
                               MotivoEstadoJpaRepo motivoEstadoJpaRepo, ParentescoJpaRepo parentescoJpaRepo, NacionalidadJpaRepo nacionalidadJpaRepo,
                               MunicipioJpaRepo municipioJpaRepo, GradoConsanguinidadJpaRepo gradoConsanguinidadJpaRepo) {
        this.parentescoJdbc = parentescoJdbc;
        this.motivoEstadoJdbc = motivoEstadoJdbc;
        this.nacionalidadJdbcImpl = nacionalidadJdbcImpl;
        this.motivoEstadoJpaRepo = motivoEstadoJpaRepo;
        this.parentescoJpaRepo =parentescoJpaRepo;
        this.nacionalidadJpaRepo =nacionalidadJpaRepo;
        this.municipioJpaRepo = municipioJpaRepo;
        this.gradoConsanguinidadJpaRepo = gradoConsanguinidadJpaRepo;
    }

    @Override
    public List<Parentesco> buscarCatalogoParentescoPorParametros(String tipoDependiente, String genero, int rowCount) {
        return parentescoJdbc.buscarCatalogoParentesco(tipoDependiente, genero, rowCount);
    }

    @Override
    public List<MotivoEstado> buscarCatalogomotivoEstadooPorParametros(Long motivoId, String descripcion, int rowCount) {
        return motivoEstadoJdbc.buscarCatalogoMotivoEstado(motivoId, descripcion, rowCount);
    }

    @Override
    public List<Nacionalidad> buscarCatalogoNacionalidad(String paisId, String nombrePais, int rowCount) {
        return nacionalidadJdbcImpl.buscarCatalogoNacionalidad(paisId, nombrePais, rowCount);
    }

    @Override
    public MotivoEstado buscarMotivoPorId(Long id){
        logger.info("Entering in buscarPorId");
        logger.info("param id: "+id);
        return motivoEstadoJpaRepo.findByMotivoId(id);
    }

    @Override
    public List<MotivoEstado> buscarMotivosTodos(){
        logger.info("Entering in buscarTodos");
        return motivoEstadoJpaRepo.findAll();
    }

    @Override
    public Parentesco buscarParentescoPorId(Long id){
        logger.info("Entering in buscarPorId");
        logger.info("param id: "+id);
        return parentescoJpaRepo.findByParentescoId(id);
    }

    @Override
    public List<Parentesco> buscarParentescoTodos(){
        logger.info("Entering in buscarTodos");
        return parentescoJpaRepo.findAll();
    }

    @Override
    public Nacionalidad buscarNacionalidadPorId(Long id){
        logger.info("Entering in buscarNacionalidadPorId");
        logger.info("param id: "+id);
        return nacionalidadJpaRepo.findByNacionalidadId(id);
    }

    @Override
    public List<Nacionalidad> buscarNacionalidadTodos(){
        logger.info("Entering in buscarNacionalidadTodos");
        return nacionalidadJpaRepo.findAll();
    }

    @Override
    public Municipio buscarMunicipioPorId(Long id){
        return municipioJpaRepo.findByMunicipioId(id);
    }

    @Override
    public List<Municipio> buscarMunicipiosTodos(){
        return municipioJpaRepo.findAll();
    }

    @Override
    public GradoConsanguinidad buscarGradoConsanguinidadPorId(Long id){
        return gradoConsanguinidadJpaRepo.findByGradoConsanguinidadId(id);
    }

    @Override
    public List<GradoConsanguinidad> buscarGradoConsanguinidadesTodos(){
        return gradoConsanguinidadJpaRepo.findAll();
    }
}