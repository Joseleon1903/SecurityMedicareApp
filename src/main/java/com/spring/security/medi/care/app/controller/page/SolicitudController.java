package com.spring.security.medi.care.app.controller.page;

import com.spring.security.medi.care.app.catalogo.service.CatalogoService;
import com.spring.security.medi.care.app.commons.ViewBaseContext;
import com.spring.security.medi.care.app.commons.domain.Municipio;
import com.spring.security.medi.care.app.commons.domain.Parentesco;
import com.spring.security.medi.care.app.commons.domain.Seguro;
import com.spring.security.medi.care.app.controller.dto.MunicipioFilterDto;
import com.spring.security.medi.care.app.controller.dto.SolicitudFormDto;
import com.spring.security.medi.care.app.controller.dto.SystemInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
public class SolicitudController extends ViewBaseContext {

    private SystemInfoDTO systemInfoDTO;

    private List<Seguro> segurosSistema;
    private List<Municipio> municipiosSistema;
    private List<Parentesco> parentescosSistema;

    private final CatalogoService catalogoService;

    private final SolicitudFormDto solicitudForm;

    @Autowired
    public SolicitudController(CatalogoService catalogoService, SolicitudFormDto solicitudForm){
       this.catalogoService = catalogoService;
       this.solicitudForm = solicitudForm;
    }

    @GetMapping("/solicitud")
    public String solicituPage(Model model){
        logger.info("------- entering -----------");
        logger.info("Entering in method solicituPage..");
        cargarCatalogoSeguro();
        cargarCatalogoMunicipio();
        cargarCatalogoParentesco();

        model.addAttribute("ListaSeguroBean", segurosSistema);
        model.addAttribute("ListaMunicipioBean", municipiosSistema);
        model.addAttribute("ListaparentescoBean", parentescosSistema);
        model.addAttribute("SystemInfoBean", systemInfoDTO);
        model.addAttribute("SolicitudFormBean", solicitudForm);
        return "pages/solicitud/show";
    }

    @PostMapping("/solicitud")
    public String formSolicituAfiPage(@ModelAttribute SolicitudFormDto solicitudForm, Model model){
        logger.info("------- entering -----------");
        logger.info("Entering in method formSolicituAfiPage..");
        logger.info("Param : "+solicitudForm);

        return "redirect:solicitud";
    }

    @Override
    protected void init() {
        logger.info("entering init method ");
        logger.info("Generando systemInfoDTO");
        systemInfoDTO = new SystemInfoDTO("Solicitudes",new Date());
        logger.info("systemInfoDTO: "+ systemInfoDTO);
        logger.info("existing init method ");
    }

    public void cargarCatalogoSeguro(){
        logger.info("entering cargarCatalogoSeguro");
        this.segurosSistema = catalogoService.buscarSegurosSistema();
        logger.info("exiting cargarCatalogoSeguro");
    }

    public void cargarCatalogoMunicipio(){
        logger.info("entering cargarCatalogoMunicipio");
        this.municipiosSistema = catalogoService.buscarMunicipiosTodos();
        logger.info("exiting cargarCatalogoMunicipio");
    }

    public void cargarCatalogoParentesco(){
        logger.info("entering cargarCatalogoParentesco");
        this.parentescosSistema = catalogoService.buscarParentescoTodos();
        logger.info("exiting cargarCatalogoParentesco");
    }

}
