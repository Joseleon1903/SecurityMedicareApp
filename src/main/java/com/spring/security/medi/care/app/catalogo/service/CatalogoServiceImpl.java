package com.spring.security.medi.care.app.catalogo.service;

import com.spring.security.medi.care.app.catalogo.dto.MotivoEstadoPaginatedDto;
import com.spring.security.medi.care.app.catalogo.dto.MunicipioPaginatedDto;
import com.spring.security.medi.care.app.catalogo.dto.NacionalidadPaginatedDto;
import com.spring.security.medi.care.app.catalogo.repository.jdbc.MotivoEstadoJdbcImpl;
import com.spring.security.medi.care.app.catalogo.repository.jdbc.NacionalidadJdbcImpl;
import com.spring.security.medi.care.app.catalogo.repository.jdbc.ParentescoJdbcImpl;
import com.spring.security.medi.care.app.catalogo.repository.jpa.*;
import com.spring.security.medi.care.app.commons.PaginationOutput;
import com.spring.security.medi.care.app.commons.domain.*;
import com.spring.security.medi.care.app.controller.rest.MotivoEstadoRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public GradoConsanguinidad actualizarGradoConsanguinidad(GradoConsanguinidad grado) {
        logger.info("Entering in actualizarGradoConsanguinidad");
        logger.info("param GradoConsanguinidad: "+grado);
        return gradoConsanguinidadJpaRepo.save(grado);
    }

    @Override
    public MotivoEstado actualizarMotivoEstado(MotivoEstado motivo) {
        logger.info("Entering in actualizarMotivoEstado");
        logger.info("param MotivoEstado: "+motivo);
        return motivoEstadoJpaRepo.save(motivo);
    }

    @Override
    public Municipio actualizarMunicipio(Municipio municipio) {
        logger.info("Entering in actualizarMunicipio");
        logger.info("param Municipio: "+municipio);
        return municipioJpaRepo.save(municipio);
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
        return motivoEstadoJpaRepo.findAllMotivos();
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
        logger.info("Entering in buscarMunicipioPorId");
        return municipioJpaRepo.findByMunicipioId(id);
    }

    @Override
    public List<Municipio> buscarMunicipiosTodos(){
        logger.info("Entering in buscarMunicipiosTodos");
        return municipioJpaRepo.findAll();
    }

    @Override
    public GradoConsanguinidad buscarGradoConsanguinidadPorId(Long id){
        logger.info("Entering in buscarGradoConsanguinidadPorId");
        return gradoConsanguinidadJpaRepo.findByGradoConsanguinidadId(id);
    }

    @Override
    public List<GradoConsanguinidad> buscarGradoConsanguinidadesTodos(){
        logger.info("Entering in buscarGradoConsanguinidadesTodos");
        return gradoConsanguinidadJpaRepo.findAllOrderByGradoConsanguinidadId();
    }

    @Override
    public MotivoEstadoPaginatedDto buscarMotivosPorParametros(Long motivoId, String description , int page, int size){
        logger.info("Entering in buscarMotivosPorParametros");
        logger.info("param motivoId: "+ motivoId);
        description = (description != null)? "%"+description.toUpperCase()+"%": null;
        logger.info("param description: "+ description);
        logger.info("param page: "+ page);
        logger.info("param size: "+ size);
        Pageable paging = PageRequest.of(page, size);
        Page<MotivoEstado> motivosPages =motivoEstadoJpaRepo.findMotivosByParameters(motivoId, description, paging);
        PaginationOutput pageOut = new PaginationOutput(page, size, motivosPages.getTotalElements(), motivosPages.getTotalPages());
        return new MotivoEstadoPaginatedDto( motivosPages.getContent(), pageOut);
    }

    @Override
    public MunicipioPaginatedDto buscarMunicipioPorParametros(String codigoMunicipio, String description, int page, int size) {
        logger.info("Entering in buscarMunicipioPorParametros");
        codigoMunicipio = (codigoMunicipio != null)? "%"+codigoMunicipio.toUpperCase()+"%": null;
        logger.info("param motivoId: "+ codigoMunicipio);
        description = (description != null)? "%"+description.toUpperCase()+"%": null;
        logger.info("param description: "+ description);
        logger.info("param page: "+ page);
        logger.info("param size: "+ size);
        Pageable paging = PageRequest.of(page, size);
        Page<Municipio> municipiosPages =municipioJpaRepo.findMotivosByParameters(codigoMunicipio, description, paging);
        PaginationOutput pageOut = new PaginationOutput(page, size, municipiosPages.getTotalElements(), municipiosPages.getTotalPages());
        return new MunicipioPaginatedDto(municipiosPages.getContent(), pageOut);
    }

    @Override
    public NacionalidadPaginatedDto buscarNacionalidadPorParametros(String paisId, int page, int size) {
        logger.info("Entering in buscarNacionalidadPorParametros");
        paisId = (paisId != null)? "%"+ paisId.toUpperCase()+"%": null;
        logger.info("param page: "+ page);
        logger.info("param size: "+ size);
        Pageable paging = PageRequest.of(page, size);
        Page<Nacionalidad> nacionalidadesPages =nacionalidadJpaRepo.findNacionalidadByParameters(paisId, paging);
        PaginationOutput pageOut = new PaginationOutput(page, size, nacionalidadesPages.getTotalElements(), nacionalidadesPages.getTotalPages());
        return new NacionalidadPaginatedDto(nacionalidadesPages.getContent(), pageOut);
    }


}