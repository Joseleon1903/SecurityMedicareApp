package com.spring.security.medi.care.app.controller.page;

import com.spring.security.medi.care.app.catalogo.service.CatalogoService;
import com.spring.security.medi.care.app.ciudadano.service.CiudadanoService;
import com.spring.security.medi.care.app.commons.ViewBaseContext;
import com.spring.security.medi.care.app.commons.domain.Ciudadano;
import com.spring.security.medi.care.app.commons.domain.Municipio;
import com.spring.security.medi.care.app.commons.domain.Nacionalidad;
import com.spring.security.medi.care.app.controller.dto.CiudadanoFormDto;
import com.spring.security.medi.care.app.controller.dto.SystemInfoDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @Autowired
    public FormularioCiudadanoController(CiudadanoFormDto ciudadanoDto, CatalogoService catalogoService, CiudadanoService ciudadanoService) {
        this.catalogoService = catalogoService;
        this.ciudadanoService = ciudadanoService;
        this.ciudadanoDto = ciudadanoDto;
    }

    @RequestMapping(value = "/form_ciudadano", method = RequestMethod.GET , produces = MediaType.TEXT_HTML_VALUE)
    public String show(Model model) {
        logger.info("entering  in show formulario ciudadano");
        cargarCatalogoNacionalidad();
        cargarCatalogoMunicipio();
        model.addAttribute("SystemInfoBean", systemInfoDTO);
        model.addAttribute("ListadoNacionalidadBean", listaNacionalidad);
        model.addAttribute("ListadoMunicipioBean", listaMunicipio);
        model.addAttribute("CiudadanoBean", ciudadanoDto);

        logger.info("Return the view to use for rendering the response");
        // Return the view to use for rendering the response
        return "/pages/ciudadano/form";
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
                ciudadanoForm.getGenero(), Date.from(date.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()),  ciudadanoForm.getEstado());

        if(ciudadanoService.buscarCiudadanoPorIdentifiacion(ciudadanoForm.getCedula(), ciudadanoForm.getNss()) != null){
            logger.info("Error existe un ciudadano con la misma identificacion");
            logger.info("ABORT REGISTRATION");
            return "redirect:form_ciudadano";
        }

        Ciudadano ciudadanoOut = ciudadanoService.guardarCiudadano(ciudadano);
        logger.info("SAVE CIUDADANO : " + ciudadanoOut);
        return "redirect:form_ciudadano";
    }

    @Override
    protected void init() {
        logger.info("entering init method ");
        logger.info("Generando systemInfoDTO");
        systemInfoDTO = new SystemInfoDTO("Formulario Ciudadano",new Date());
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

}