package com.spring.security.medi.care.app.controller;

import com.spring.security.medi.care.app.commons.ViewBaseContext;
import com.spring.security.medi.care.app.controller.dto.EntidadFilterDTO;
import com.spring.security.medi.care.app.controller.dto.SystemInfoDTO;
import com.spring.security.medi.care.app.entidad.domain.EntidadType;
import com.spring.security.medi.care.app.entidad.service.EntidadService;
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
import java.util.Date;
import java.util.List;

@Controller
public class EntidadController extends ViewBaseContext {

    private static final Logger logger = LoggerFactory.getLogger(EntidadController.class);

    private final EntidadService entidadService;
    private SystemInfoDTO systemInfoDTO;
    private EntidadFilterDTO filterDTO;

    @Autowired
    public EntidadController(EntidadService entidadService, EntidadFilterDTO entidadFilterDTO) {
        this.entidadService = entidadService;
        this.filterDTO = entidadFilterDTO;
    }

    /***
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/entidad", method = RequestMethod.GET , produces = MediaType.TEXT_HTML_VALUE)
    public String show(Model model) {

        logger.info("entering  in show entidad");
        logger.info("param : "+ filterDTO);

        Short seguroId = (filterDTO.getSeguroId() != null) ? Short.parseShort(filterDTO.getSeguroId()) : null;
        Short regimenId = (filterDTO.getRegimenId() != null) ? Short.parseShort(filterDTO.getRegimenId()) : null;

        List<EntidadType> entidadList = entidadService.buscarEntidadesPorSeguroRegimen(seguroId,
                regimenId, filterDTO.getTexto());
        logger.info("cantidad de entidades encontrados: "+ entidadList.size());

        logger.info("agregando resultado al modelo");
        model.addAttribute("EntidadesListBean", entidadList);
        model.addAttribute("FilterDTO", filterDTO);
        model.addAttribute("SystemInfoBean", systemInfoDTO);
        logger.info("Return the view to use for rendering the response");
        // Return the view to use for rendering the response
        return "/pages/entidad/show";
    }

    @PostMapping("/filter")
    public String processSubmit(@ModelAttribute EntidadFilterDTO filterInDto, Model model) {
        logger.info("entering  in processSubmit entidad");

        logger.info("filter: "+filterInDto);

        if(filterInDto.getSeguroId().equals("T")){
            filterInDto.setSeguroId(null);
        }

        if(filterInDto.getRegimenId().equals("T")){
            filterInDto.setRegimenId(null);
        }

        this.filterDTO = filterInDto;
        logger.info("Return the view to use for rendering the response");

        return "redirect:/entidad";
    }

    @Override
    protected void init() {
        logger.info("entering init method ");
        logger.info("Generando systemInfoDTO");
        systemInfoDTO = new SystemInfoDTO("Unipago Entidades del sistema de seguridad social",new Date());
        logger.info("systemInfoDTO: "+ systemInfoDTO);

        logger.info("existing init method ");
    }
}