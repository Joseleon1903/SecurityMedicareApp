package com.spring.security.medi.care.app.controller.page;

import com.spring.security.medi.care.app.catalogo.service.CatalogoService;
import com.spring.security.medi.care.app.ciudadano.service.CiudadanoService;
import com.spring.security.medi.care.app.commons.AfiliacionDtoUtil;
import com.spring.security.medi.care.app.commons.AplicationConstantUtil;
import com.spring.security.medi.care.app.commons.ViewBaseContext;
import com.spring.security.medi.care.app.commons.domain.Ciudadano;
import com.spring.security.medi.care.app.commons.domain.MotivoEstado;
import com.spring.security.medi.care.app.commons.domain.Municipio;
import com.spring.security.medi.care.app.commons.domain.Nacionalidad;
import com.spring.security.medi.care.app.controller.dto.CiudadanoFormDto;
import com.spring.security.medi.care.app.controller.dto.ErrorPageDto;
import com.spring.security.medi.care.app.controller.dto.SystemInfoDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Controller
public class FormularioCiudadanoController extends ViewBaseContext {

    private static final Logger logger = LoggerFactory.getLogger(FormularioCiudadanoController.class);

    private SystemInfoDTO systemInfoDTO;

    private List<Nacionalidad> listaNacionalidad;
    private List<Municipio> listaMunicipio;

    private final CatalogoService catalogoService;
    private final CiudadanoService ciudadanoService;

    private CiudadanoFormDto ciudadanoDto;

    private ErrorPageDto errorPageBean;

    @Autowired
    public FormularioCiudadanoController(ErrorPageDto errorPageBean, CiudadanoFormDto ciudadanoDto, CatalogoService catalogoService, CiudadanoService ciudadanoService) {
        this.catalogoService = catalogoService;
        this.ciudadanoService = ciudadanoService;
        this.ciudadanoDto = ciudadanoDto;
        this.errorPageBean = errorPageBean;
    }

    @GetMapping("/form_ciudadano")
    public String show( @RequestParam(value = "hasError" ,  required = false) Boolean hasError,  Model model) {
        logger.info("entering  in show formulario ciudadano");
        cargarCatalogoNacionalidad();
        cargarCatalogoMunicipio();
        logger.info("Entering validation error : "+ hasError);
        validateError(hasError, model);
        model.addAttribute("SystemInfoBean", systemInfoDTO);
        model.addAttribute("ListadoNacionalidadBean", listaNacionalidad);
        model.addAttribute("ListadoMunicipioBean", listaMunicipio);
        model.addAttribute("CiudadanoBean", ciudadanoDto);

        logger.info("Return the view to use for rendering the response");
        // Return the view to use for rendering the response
        return "/pages/ciudadano/formularioCiudadanoPage";
    }

    @PostMapping("/inscription")
    public String formCiudadanoPage(@ModelAttribute CiudadanoFormDto ciudadanoForm, Model model) {
        logger.info("------- entering -----------");
        logger.info("Entering in method formCiudadanoPage..");
        logger.info("Param : " + ciudadanoForm);
        LocalDate date = LocalDate.parse(ciudadanoForm.getFechaNacimiento());
        logger.info("FechaNacimiento : " + date);

        Ciudadano ciudadano =  new Ciudadano(ciudadanoForm.getCedula(), ciudadanoForm.getNss(), ciudadanoForm.getNombre(), ciudadanoForm.getPrimerApellido(),
                ciudadanoForm.getSegundoApellido(), ciudadanoForm.getMunicipio(), ciudadanoForm.getNacionalidad(),
                ciudadanoForm.getGenero(), date, AfiliacionDtoUtil.C_ESTADO_AC);

        try{
            if(!ciudadanoService.buscarCiudadanoPorIdentifiacion(ciudadanoForm.getCedula(), ciudadanoForm.getNss()).isEmpty()){
                logger.info("Error existe un ciudadano con la misma identificacion");
                logger.info("ABORT REGISTRATION");
                MotivoEstado mot = catalogoService.buscarMotivoPorId(AplicationConstantUtil.EXISTE_ACTIVO_CON_IDENTIFCACION);
                logger.error("Throw motivo : "+ mot);
                this.errorPageBean = new ErrorPageDto(mot.getMotivoId(), mot.getDescripcion(), true);
                this.ciudadanoDto = ciudadanoForm;
                return "redirect:form_ciudadano?hasError=true";
            }
            this.errorPageBean = new ErrorPageDto();
            Ciudadano ciudadanoOut = ciudadanoService.guardarCiudadano(ciudadano);
            logger.info("SAVE CIUDADANO : " + ciudadanoOut);
        }
        catch (Exception ex){
            logger.info("Error existe un ciudadano con la misma identificacion");
            logger.error("error no identificado..", ex);
            MotivoEstado mot = catalogoService.buscarMotivoPorId(AplicationConstantUtil.GENERAL_ERROR_INTERNO);
            this.errorPageBean = new ErrorPageDto(mot.getMotivoId(), mot.getDescripcion(), true);
            this.ciudadanoDto = ciudadanoForm;
            return "redirect:form_ciudadano?hasError=true";
        }
        return "redirect:form_ciudadano?hasError=false";
    }

    @Override
    protected void init() {
        logger.info("entering init method ");
        logger.info("Generando systemInfoDTO");
        systemInfoDTO = new SystemInfoDTO("Formulario Ciudadano","Es un Formulario que permite al ciudadano registrarse, en la Plataforma de Servicios en Línea, a través del cual podrá solicitar cualquier servicio o trámite de forma electrónica.", new Date());
        logger.info("systemInfoDTO: "+ systemInfoDTO);
        logger.info("existing init method ");
    }

    public void cargarCatalogoNacionalidad() {
        logger.info("entering cargarCatalogoNacionalidad");
        this.listaNacionalidad = catalogoService.buscarNacionalidadTodos();
        logger.info("exiting cargarCatalogoNacionalidad");
    }

    public void cargarCatalogoMunicipio() {
        logger.info("entering cargarCatalogoMunicipio");
        this.listaMunicipio = catalogoService.buscarMunicipiosTodos();
        logger.info("exiting cargarCatalogoMunicipio");
    }

    private void validateError(Boolean hasError, Model model ){
        if(hasError == null || !hasError){
            model.addAttribute("ErrorPageBean", new ErrorPageDto());
            this.ciudadanoDto = new CiudadanoFormDto();
        }else{
            model.addAttribute("ErrorPageBean",this.errorPageBean );
        }
    }

}