package com.spring.security.medi.care.app.afiliacion.service;

import com.spring.security.medi.care.app.afiliacion.repository.jpa.SolicitudAfiliacionJpaRepo;
import com.spring.security.medi.care.app.afiliacion.types.PaginatedSolAfiliacionDto;
import com.spring.security.medi.care.app.catalogo.service.CatalogoService;
import com.spring.security.medi.care.app.ciudadano.service.CiudadanoService;
import com.spring.security.medi.care.app.commons.AfiliacionDtoUtil;
import com.spring.security.medi.care.app.commons.AplicationConstantUtil;
import com.spring.security.medi.care.app.commons.DaoUtil;
import com.spring.security.medi.care.app.commons.PaginationOutput;
import com.spring.security.medi.care.app.commons.domain.Ciudadano;
import com.spring.security.medi.care.app.commons.domain.InstitucionPensionado;
import com.spring.security.medi.care.app.commons.domain.MotivoEstado;
import com.spring.security.medi.care.app.commons.domain.SolicitudAfiliacion;
import com.spring.security.medi.care.app.controller.dto.DetalleSolicitudAfiliacionDto;
import com.spring.security.medi.care.app.entidad.service.EntidadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;

@Service
@Transactional
public class SolicitudAfiliacionServiceImpl implements SolicitudAfiliacionService {

    private static final Logger logger = LoggerFactory.getLogger(SolicitudAfiliacionServiceImpl.class);

    private final SolicitudAfiliacionJpaRepo solicitudAfiliacionJpaRepo;

    private final EntidadService entidadService;

    private final CiudadanoService ciudadanoService;

    private final CatalogoService catalogoService;

    @Autowired
    public SolicitudAfiliacionServiceImpl(SolicitudAfiliacionJpaRepo solicitudAfiliacionJpaRepo,
            EntidadService entidadService,
            CatalogoService catalogoService, CiudadanoService ciudadanoService) {
        this.solicitudAfiliacionJpaRepo = solicitudAfiliacionJpaRepo;
        this.ciudadanoService = ciudadanoService;
        this.entidadService = entidadService;
        this.catalogoService = catalogoService;
    }

    @Override
    public List<SolicitudAfiliacion> buscarSolicitudesAfiliacion() {
        return solicitudAfiliacionJpaRepo.findAll();
    }

    @Override
    public SolicitudAfiliacion regristarSolicitudAfiliacion(SolicitudAfiliacion solicitud) throws Exception {
        logger.info("Entering in regristarSolicitudAfiliacion");
        logger.info("pram : " + solicitud);
        SolicitudAfiliacion sol = solicitudAfiliacionJpaRepo.save(solicitud);
        return sol;
    }

    @Override
    public PaginatedSolAfiliacionDto buscarSolicitudesAfiliacionPorParametros(String cedula, Integer servicioId,
                                                                              Long seguroId, Integer regimenId, String estado, int page, int size) {

        logger.info("Entering in buscarSolicitudesAfiliacionPorParametros");
        logger.info("param cedula: " + cedula);
        logger.info("param servicioId: " + servicioId);
        logger.info("param seguroId: " + seguroId);
        logger.info("param regimenId: " + regimenId);
        logger.info("param estado: " + estado);
        logger.info("param page: " + page);
        logger.info("param size: " + size);
        cedula = (cedula == null || cedula.isEmpty()) ? null : "%" + cedula + "%";
        Pageable paging = PageRequest.of(page, size);
        Page<SolicitudAfiliacion> solList = solicitudAfiliacionJpaRepo
                .findSolicitudAfiliacionesByParameters(cedula, servicioId, seguroId,
                        regimenId, estado, paging);
        logger.info("listado count : "+solList.toList().size() );
        PaginationOutput pageOut = new PaginationOutput();
        pageOut.setPageIndex(page);
        pageOut.setTotalPages(solList.getTotalPages());
        pageOut.setRowSize(size);
        page = (page == 0)? 1: page;
        pageOut.setTotalRowCount(DaoUtil.getRegistrosRestantes(solList.getTotalElements(), page, size));
        PaginatedSolAfiliacionDto paginated = new PaginatedSolAfiliacionDto(solList.getContent(), pageOut);
        return paginated;
    }

    public SolicitudAfiliacion buscarSolicitudAfiliacionPorId(Long solicitudId) {
        logger.info("Entering in buscarSolicitudAfiliacionPorId");
        logger.info("param solicitudId: " + solicitudId);
        return solicitudAfiliacionJpaRepo.findById(solicitudId).get();
    }

    public DetalleSolicitudAfiliacionDto buscarSolicitudAfiliacionDetallePorId(Long id) {
        logger.info("Entering in buscarSolicitudAfiliacionDetallePorId");
        logger.info("param id : " + id);
        SolicitudAfiliacion sol = solicitudAfiliacionJpaRepo.findById(id).get();
        logger.info("returning :" + sol);
        String nombreEntidad = entidadService.buscarEntidadPorId(sol.getEntidadId().getEntidadId()).getDescripcion();
        Ciudadano ciu = ciudadanoService.buscarCiudadanoPorCiudadanoId(sol.getCiudadanoId()).isPresent() ?
                ciudadanoService.buscarCiudadanoPorCiudadanoId(sol.getCiudadanoId()).get(): null;
        MotivoEstado mot = catalogoService.buscarMotivoPorId(sol.getMotivoId()).isPresent() ?
                catalogoService.buscarMotivoPorId(sol.getMotivoId()).get() : null;
        String descmotivo = null;
        if (mot != null) {
            descmotivo = mot.getMotivoId() + ":" + mot.getDescripcion();
        }

        String segundoApellido = null;
        if (ciu != null) {
            segundoApellido = ciu.getSegundoApellido();
        }
        String institucionpensionado = "";

        if(sol.getInstitucionPensionadoId() != null){
            institucionpensionado = catalogoService.buscarPorInstitucionPensionadoId(sol.getInstitucionPensionadoId()).get().getDescripcion();
        }
        return new DetalleSolicitudAfiliacionDto(sol, nombreEntidad, segundoApellido, institucionpensionado,
                descmotivo);
    }

    @Override
    public void procesarSolicitudAfiliacion(Long solicitudId) throws Exception {
        logger.info("Entering in procesarSolicitudAfiliacion");
        logger.info("param solicitudId : "+solicitudId);
        SolicitudAfiliacion sol = solicitudAfiliacionJpaRepo.findById(solicitudId).get();

        // TODO validacion ciudadano por NSS y cedula validar que exista un ciudadano
        // con Nss y cedula de la solicitud y asigna el ciudadano
        logger.info(">> Iniciando validaciones ");
        logger.info(" Nss y cedula de la solicitud y asigna el ciudadano");

       Boolean existeCiudadano = !ciudadanoService.buscarCiudadanoPorIdentifiacion(sol.getCedula(), sol.getNss()).isPresent();

        if (existeCiudadano) {
            Long motivo = catalogoService.buscarMotivoPorId(AplicationConstantUtil.NO_EXISTE_IDENTIFICACION_SOLICITUD).get()
                    .getMotivoId();
            sol.setMotivoId(motivo);
            sol.setEstado(AfiliacionDtoUtil.C_ESTADO_RE);
            solicitudAfiliacionJpaRepo.save(sol);
            return;
        }
        Ciudadano ciudadano = ciudadanoService.buscarCiudadanoPorIdentifiacion(sol.getCedula(), sol.getNss()).get();
        sol.setNombre(ciudadano.getNombre());
        sol.setPrimerApellido(ciudadano.getPrimerApellido());
        sol.setCedula(ciudadano.getCedula());
        sol.setNss(ciudadano.getNss());
        sol.setFechaUltimoCambio(LocalDateTime.now());

        logger.info("B) asignacion pensionado y pertenece al seguro de pensiones asigna");
        // TODO si tiene asignacion pensionado y pertenece al seguro de pensiones asigna
        if(sol.getAutomatica()){
            sol.setInstitucionPensionadoId(asignarAutoInstitucionPensionadiSolicitud());
        }

        // TODO realizando persistencia de datos
        sol.setEstado(AfiliacionDtoUtil.C_ESTADO_OK);
        solicitudAfiliacionJpaRepo.save(sol);
    }

    @Override
    public void agregarMotivoSolicitudAfiliacion(Long solicitudId , Long motivoId){
        logger.info("Entering in agregarMotivoSolicitudAfiliacion");
        logger.info("Param motivoId: "+motivoId);
        MotivoEstado mot = catalogoService.buscarMotivoPorId(motivoId).get();
        SolicitudAfiliacion sol = solicitudAfiliacionJpaRepo.findById(solicitudId).get();
        sol.setMotivoId(mot.getMotivoId());
        sol.setEstado(AfiliacionDtoUtil.C_ESTADO_RE);
        solicitudAfiliacionJpaRepo.save(sol);
    }

    @Override
    public Long asignarAutoInstitucionPensionadiSolicitud(){
        logger.info("Entering in asignarAutoInstitucionPensionadiSolicitud");
        List<InstitucionPensionado> institucionList = catalogoService.buscarInstitucionPensionadoTodas().get();
        int size = institucionList.size();
        Random rand =  new Random();
        int indiceR = rand.nextInt(size);
        logger.info("Indice random : "+Math.abs(indiceR) );
        InstitucionPensionado inst = institucionList.get(Math.abs(indiceR));
        if(inst == null){
            return 1L;
        }
        return inst.getInstitucionPensionadoId();
    }


}