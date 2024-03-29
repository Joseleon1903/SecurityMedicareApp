package com.spring.security.medi.care.app.controller.page;

import com.spring.security.medi.care.app.afiliacion.service.SolicitudAfiliacionService;
import com.spring.security.medi.care.app.catalogo.service.CatalogoService;
import com.spring.security.medi.care.app.commons.AplicationConstantUtil;
import com.spring.security.medi.care.app.commons.ViewBaseContext;
import com.spring.security.medi.care.app.commons.domain.*;
import com.spring.security.medi.care.app.commons.service.ApplicationMessageUtil;
import com.spring.security.medi.care.app.controller.dto.ErrorPageDto;
import com.spring.security.medi.care.app.controller.dto.SolicitudFormDto;
import com.spring.security.medi.care.app.controller.dto.SystemInfoDTO;
import com.spring.security.medi.care.app.entidad.service.EntidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Controller
public class SolicitudController extends ViewBaseContext {

    private final MessageSource messageSource;
    private final LocaleResolver localeResolver;
    public ApplicationMessageUtil applicationMessageUtil;

    private SystemInfoDTO systemInfoDTO;

    private List<Seguro> segurosSistema;
    private List<Municipio> municipiosSistema;
    private List<Nacionalidad> nacionalidadesSistema;

    private final CatalogoService catalogoService;
    private final EntidadService entidadService;
    private final SolicitudAfiliacionService solicitudAfiliacionService;

    private SolicitudFormDto solicitudForm;
    private SolicitudAfiliacion solicitudOut;
    private ErrorPageDto errorPageDto;

    @Autowired
    public SolicitudController(CatalogoService catalogoService, SolicitudAfiliacionService solicitudAfiliacionService, EntidadService entidadService,
                               MessageSource messageSource, LocaleResolver localeResolver) {
        this.catalogoService = catalogoService;
        this.solicitudAfiliacionService = solicitudAfiliacionService;
        this.entidadService = entidadService;
        this.messageSource = messageSource;
        this.localeResolver = localeResolver;
    }

    @GetMapping("/solicitud")
    public String solicituPage(Model model, HttpServletRequest request) {
        logger.info("------- entering -----------");
        logger.info("Entering in method solicituPage..");

        applicationMessageUtil =  new ApplicationMessageUtil(messageSource,localeResolver, request );
        systemInfoDTO = new SystemInfoDTO(applicationMessageUtil.getMessage("page.controller.solicitudes.list.title"),
                applicationMessageUtil.getMessage("page.controller.solicitudes.list.sub.title"), LocalDate.now());

        cargarCatalogoSeguro();
        cargarCatalogoMunicipio();
        cargarCatalogoParentesco();

        model.addAttribute("ListaSeguroBean", segurosSistema);
        model.addAttribute("ListaMunicipioBean", municipiosSistema);
        model.addAttribute("ListaNacionalidadBean", nacionalidadesSistema);
        model.addAttribute("SystemInfoBean", systemInfoDTO);
        model.addAttribute("SolicitudFormBean", solicitudForm);
        model.addAttribute("SolicitudReponseBean", solicitudOut);
        model.addAttribute("ErrorPageBean", errorPageDto);

        return "pages/solicitud/showSolicitudPage";
    }

    @PostMapping("/solicitud")
    public String formSolicituAfiPage(@ModelAttribute SolicitudFormDto solicitudForm) {
        logger.info("------- entering -----------");
        logger.info("Entering in method formSolicituAfiPage..");
        logger.info("Param : " + solicitudForm);
        SolicitudAfiliacion solicitudIn = new SolicitudAfiliacion();
        ServicioSistema servicioEntity = catalogoService.buscarServicioSistemaPorId(AplicationConstantUtil.SERVICIO_PANTALLA_SOLICITUD_AFILIACION).get();
        solicitudIn.setServicioId(servicioEntity);
        solicitudIn.setLoteId(AplicationConstantUtil.generateLoteId());
        solicitudIn.setEntidadId(entidadService.asignarAutomaticamenteEntidad(solicitudForm.getRegimenId()));
        Seguro seguroEntity = catalogoService.buscarSegurosSistemaPorId(solicitudForm.getSeguroId()).get();
        solicitudIn.setSeguroId(seguroEntity);
        solicitudIn.setRegimenId(solicitudForm.getRegimenId());
        solicitudIn.setTipoAfiliado(solicitudForm.getTipoAfiliado());
        solicitudIn.setTipoIdentificacionId(solicitudForm.getTipoIdentificacion());
        solicitudIn.setCedula(solicitudForm.getCedula());
        solicitudIn.setNss(solicitudForm.getNss());
        solicitudIn.setNombre(AplicationConstantUtil.PARAMETRO_PENDIENTE_DEFINICION);
        solicitudIn.setPrimerApellido(AplicationConstantUtil.PARAMETRO_PENDIENTE_DEFINICION);
        solicitudIn.setAutomatica(solicitudForm.getAplicaInsitucionAutomtica());
        solicitudIn.setEstado(AplicationConstantUtil.ESTADO_PE);
        solicitudIn.setFechaRecepcion(LocalDate.now());
        solicitudIn.setMunicipioId(solicitudForm.getMunicipioId());
        solicitudIn.setFechaUltimoCambio(LocalDateTime.now());
        solicitudIn.setNacionalidadId(solicitudForm.getNacionalidadId());
        logger.info("Inicinado registro de la solicitud");
        try {
            this.solicitudOut = solicitudAfiliacionService.regristarSolicitudAfiliacion(solicitudIn);
            this.errorPageDto = new ErrorPageDto();
        } catch (Exception e) {
            logger.info(e.getLocalizedMessage());
            this.errorPageDto = new ErrorPageDto(500L, "Internal server error : " + e.getLocalizedMessage(), true);
            e.printStackTrace();
        }
        logger.info("Solicitud realizado con exito : " + this.solicitudOut);
        return "redirect:solicitud";
    }

    @Override
    protected void init() {
        logger.info("entering init method ");
        logger.info("Generando systemInfoDTO");
        solicitudForm = new SolicitudFormDto();
        solicitudOut = new SolicitudAfiliacion();
        errorPageDto=  new ErrorPageDto();
        systemInfoDTO = new SystemInfoDTO("Solicitudes","Soliciudes realizadas por un afiliado a los servicios de salud (medicamentos, procedimientos,\n" +
                " medios diagnósticos, pruebas de laboratorio, materiales, terapias, etc.)\n" +
                " dentro del Plan de Servicios de Salud (PDSS), así como la disponibilidad económica o agotamiento para\n" +
                " que pueda gestionar la colaboración por otros medios.", LocalDate.now());
        logger.info("systemInfoDTO: " + systemInfoDTO);
        logger.info("existing init method ");
    }

    public void cargarCatalogoSeguro() {
        logger.info("entering cargarCatalogoSeguro");
        this.segurosSistema = catalogoService.buscarSegurosSistema();
        logger.info("exiting cargarCatalogoSeguro");
    }

    public void cargarCatalogoMunicipio() {
        logger.info("entering cargarCatalogoMunicipio");
        this.municipiosSistema = catalogoService.buscarMunicipiosTodos();
        logger.info("exiting cargarCatalogoMunicipio");
    }

    public void cargarCatalogoParentesco() {
        logger.info("entering cargarCatalogoParentesco");
        this.nacionalidadesSistema = catalogoService.buscarNacionalidadTodos();
        logger.info("exiting cargarCatalogoParentesco");
    }

}
