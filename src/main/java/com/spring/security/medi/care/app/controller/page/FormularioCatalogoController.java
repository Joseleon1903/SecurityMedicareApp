package com.spring.security.medi.care.app.controller.page;

import com.spring.security.medi.care.app.catalogo.service.CatalogoService;
import com.spring.security.medi.care.app.commons.AplicationConstantUtil;
import com.spring.security.medi.care.app.commons.ViewBaseContext;
import com.spring.security.medi.care.app.commons.domain.MotivoEstado;
import com.spring.security.medi.care.app.controller.dto.ErrorPageDto;
import com.spring.security.medi.care.app.controller.dto.MotivoEstadoFormDTO;
import com.spring.security.medi.care.app.controller.dto.SystemInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.time.LocalDate;

@Controller
public class FormularioCatalogoController extends ViewBaseContext {

    private final CatalogoService catalogoService;

    private MotivoEstadoFormDTO motivoEstadoFormDTO;
    private ErrorPageDto errorPageBean;
    private SystemInfoDTO systemInfoDTO;

    @Autowired
    public FormularioCatalogoController(CatalogoService catalogoService) {
        this.catalogoService = catalogoService;
    }

    @GetMapping("/form_catalogo")
    public String showPage(@RequestParam(value = "hasError" ,  required = false) Boolean hasError, Model model) {
        logger.info("------- entering -----------");
        logger.info("Entering in method showPage:{/formulario/catalogo}");
        logger.info("Entering validation error : "+ hasError);

        validateError(hasError, model);

        model.addAttribute("MotivoEstadoFormBean", motivoEstadoFormDTO);
        model.addAttribute("SystemInfoBean", systemInfoDTO);
        return "pages/catalogo/formularioCatalogoPage";
    }

    @PostMapping("/create/motivo_estado")
    public String processMotivoEstadoForm(@Valid @ModelAttribute MotivoEstadoFormDTO motivoEstadoFormDTOInput, BindingResult bindingResult, Model model) {
        logger.info("------- entering -----------");
        logger.info("Entering in method processMotivoEstadoForm");
        logger.info("MotivoEstadoFormDTO; "+ motivoEstadoFormDTOInput);
        if (bindingResult.hasErrors()) {
            logger.info("bindingResult.hasErrors Error procesando formulario");
            logger.info("FieldError: " +bindingResult.getTarget().toString());
            MotivoEstado mot = catalogoService.buscarMotivoPorId(AplicationConstantUtil.EXISTEN_MOTIVO_ESTADO_SISTEMA).get();
            this.errorPageBean = new ErrorPageDto(mot.getMotivoId(), mot.getDescripcion(), true);
            this.motivoEstadoFormDTO = motivoEstadoFormDTOInput;
            return "redirect:/form_catalogo?hasError=true";
        }

        MotivoEstado mot =catalogoService.actualizarMotivoEstado(MotivoEstadoFormDTO.toEntity(motivoEstadoFormDTOInput));
        logger.info("se registro el motivo estado : "+ mot);
        this.motivoEstadoFormDTO = new MotivoEstadoFormDTO();
        return "redirect:/form_catalogo";
    }


    private void validateError(Boolean hasError, Model model ){
        if(hasError == null || !hasError){
            model.addAttribute("ErrorPageBean", new ErrorPageDto());
        }else{
            model.addAttribute("ErrorPageBean",this.errorPageBean );
        }
    }
    @Override
    protected void init() {
        logger.info("entering init method ");
        logger.info("Generando systemInfoDTO");
        motivoEstadoFormDTO =  new MotivoEstadoFormDTO();
        errorPageBean = new ErrorPageDto();
        systemInfoDTO = new SystemInfoDTO("Formulario Catalogo","Pagina que te permite agregar informacion al catalogo de informaciones..", LocalDate.now());
        logger.info("systemInfoDTO: " + systemInfoDTO);
        logger.info("existing init method ");
    }
}
