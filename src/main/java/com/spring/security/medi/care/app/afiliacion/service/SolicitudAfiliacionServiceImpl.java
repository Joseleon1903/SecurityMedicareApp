package com.spring.security.medi.care.app.afiliacion.service;

import com.spring.security.medi.care.app.catalogo.service.CatalogoService;
import com.spring.security.medi.care.app.ciudadano.service.CiudadanoService;
import com.spring.security.medi.care.app.commons.AfiliacionDtoUtil;
import com.spring.security.medi.care.app.commons.AplicationConstantUtil;
import com.spring.security.medi.care.app.commons.domain.Ciudadano;
import com.spring.security.medi.care.app.commons.domain.MotivoEstado;
import com.spring.security.medi.care.app.commons.domain.SolicitudAfiliacion;
import com.spring.security.medi.care.app.afiliacion.repository.jpa.SolicitudAfiliacionJpaRepo;
import com.spring.security.medi.care.app.controller.dto.DetalleSolicitudAfiliacionDto;
import com.spring.security.medi.care.app.entidad.service.EntidadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import java.util.List;

@Service
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
    public List<SolicitudAfiliacion> buscarSolicitudesAfiliacionPorParametros(String cedula, Integer servicioId,
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
        List<SolicitudAfiliacion> solList = solicitudAfiliacionJpaRepo
                .findSolicitudAfiliacionesByParameters(cedula, servicioId, seguroId,
                        regimenId, estado, paging)
                .getContent();
        return solList;
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
        String nombreEntidad = entidadService.buscarEntidadPorId(sol.getEntidadId()).getDescripcion();
        Ciudadano ciu = ciudadanoService.buscarCiudadanoPorCiudadanoId(sol.getCiudadanoId());
        MotivoEstado mot = catalogoService.buscarMotivoPorId(sol.getMotivoId());
        String descmotivo = null;
        if (mot != null) {
            descmotivo = mot.getMotivoId() + ":" + mot.getDescripcion();
        }

        String segundoApellido = null;
        if (ciu != null) {
            segundoApellido = ciu.getSegundoApellido();
        }

        String institucionpensionado = "";
        return new DetalleSolicitudAfiliacionDto(sol, nombreEntidad, segundoApellido, institucionpensionado,
                descmotivo);
    }

    @Override
    public void procesarSolicitudAfiliacion(Long solicitudId) throws Exception {
        logger.info("Entering in procesarSolicitudAfiliacion");

        SolicitudAfiliacion sol = solicitudAfiliacionJpaRepo.findById(solicitudId).get();
        // TODO validacion ciudadano por NSS y cedula validar que exista un ciudadano
        // con Nss y cedula de la solicitud y asigna el ciudadano

        Ciudadano ciudadano = ciudadanoService.buscarCiudadanoPorIdentifiacion(sol.getCedula(), sol.getNss());

        if (ciudadano == null) {
            Long motivo = catalogoService.buscarMotivoPorId(AplicationConstantUtil.NO_EXISTE_IDENTIFICACION_SOLICITUD)
                    .getMotivoId();
            sol.setMotivoId(motivo);
            sol.setEstado(AfiliacionDtoUtil.C_ESTADO_RE);
            solicitudAfiliacionJpaRepo.save(sol);
            return;
        }

        sol.setNombre(ciudadano.getNombre());
        sol.setPrimerApellido(ciudadano.getPrimerApellido());
        sol.setCedula(ciudadano.getCedula());
        sol.setNss(ciudadano.getNss());

        // TODO si tiene asignacion pensionado y pertenece al seguro de pensiones asigna
        // una instutucion pensionado a la solicitud

        // TODO

        // TODO realizando persistencia de datos
        sol.setEstado(AfiliacionDtoUtil.C_ESTADO_OK);
        solicitudAfiliacionJpaRepo.save(sol);
    }

}
