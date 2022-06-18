package com.spring.security.medi.care.app.controller;

import com.spring.security.medi.care.app.controller.dto.SolicitudDepFilterDTO;
import com.spring.security.medi.care.app.controller.dto.SystemInfoDTO;
import com.spring.security.medi.care.app.solicitud.dependiente.domain.SolicitudDependiente;
import com.spring.security.medi.care.app.solicitud.dependiente.service.AfiDependienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class AfiDependienteController {


    private static final Logger logger = LoggerFactory.getLogger(AfiDependienteController.class);

    private final AfiDependienteService afiDependienteService;

    private SystemInfoDTO systemInfoDTO;

    private SolicitudDepFilterDTO solicitudDepFilterDTO;

    private List<SolicitudDependiente> solicitudesDependientes;

    @Autowired
    public AfiDependienteController(AfiDependienteService afiDependienteService, SolicitudDepFilterDTO solicitudDepFilterDTO ) {
        this.afiDependienteService = afiDependienteService;
        this.solicitudDepFilterDTO =solicitudDepFilterDTO;
    }

    /***
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/afi_dependiente", method = RequestMethod.GET , produces = MediaType.TEXT_HTML_VALUE )
    public String showAfiDependiente(Model model) {
        logger.info("entering  in show showAfiDependiente");

        logger.info("Generando systemInfoDTO");
        systemInfoDTO = new SystemInfoDTO("Unipago Solicitud Afiliacion Dependiente para titualar ",new Date());
        logger.info("systemInfoDTO: "+ systemInfoDTO);

        logger.info("filter parameters : " + solicitudDepFilterDTO);
        solicitudesDependientes = new ArrayList<>();
        logger.info("iniciando busqueda dependientes para titular "+solicitudDepFilterDTO.getSolicitudAfiTitular());

        solicitudesDependientes = afiDependienteService.buscarDependientePorInfoTitular(solicitudDepFilterDTO.getSolicitudAfiTitular(),
                solicitudDepFilterDTO.getEstado(), solicitudDepFilterDTO.getTipoDependiente());
        logger.info("termiando busqueda dependientes para titular ");

        logger.info("total dependientes count: "+ solicitudesDependientes.size());

        model.addAttribute("SystemInfoBean", systemInfoDTO);
        model.addAttribute("solicitudDepFilterBean",solicitudDepFilterDTO);
        model.addAttribute("solDependienteList", solicitudesDependientes);

        // Return the view to use for rendering the response
        return "/pages/afi_dependiente/show";
    }

    @RequestMapping(value = "/dependiente/filter", method = RequestMethod.POST)
    public String showAfiDependienteFilter(@ModelAttribute SolicitudDepFilterDTO filterDto, Model model) {
        logger.info("entering  in show showAfiDependienteFilter");
        logger.info("post filter: "+ filterDto);

        if("T".equals(filterDto.getEstado())){
            filterDto.setEstado(null);
        }
        if("T".equals(filterDto.getTipoDependiente())){
            filterDto.setTipoDependiente(null);
        }
        this.solicitudDepFilterDTO = filterDto;

        logger.info("Return the view to use for rendering the response");
        // Return the view to use for rendering the response
        return "redirect:/afi_dependiente";
    }
}
