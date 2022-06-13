package com.spring.wlg.controller;

import com.spring.wlg.controller.dto.SystemInfoDTO;
import com.spring.wlg.controller.dto.TitularFilterDTO;
import com.spring.wlg.solicitud.titular.domain.SolicitudTitular;
import com.spring.wlg.solicitud.titular.service.AfiTitularService;
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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class AfiliacionTitularController {


    private static final Logger logger = LoggerFactory.getLogger(AfiliacionTitularController.class);

    private final AfiTitularService afiTitularService;

    private SystemInfoDTO systemInfoDTO;

    private TitularFilterDTO titularFilterDTO;

    private List<SolicitudTitular> solicitudesTitular;

    @Autowired
    public AfiliacionTitularController(AfiTitularService afiTitularService,TitularFilterDTO titularFilterDTO ) {
        this.afiTitularService = afiTitularService;
        this.titularFilterDTO = titularFilterDTO;
    }

    /***
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/afi_titular", method = RequestMethod.GET , produces = MediaType.TEXT_HTML_VALUE)
    public String showAfiTitular(Model model) {
        logger.info("entering  in show showAfiTitular");
        logger.info("Generando systemInfoDTO");
        systemInfoDTO = new SystemInfoDTO("Unipago información Afiliación Titular ",new Date());
        logger.info("systemInfoDTO: "+ systemInfoDTO);
        logger.info("filter parameters : "+titularFilterDTO);

        solicitudesTitular = new ArrayList<>();

        logger.info("iniciando busqueda titular "+titularFilterDTO.getCiudadanoId());

        Long ciudId = (titularFilterDTO.getCiudadanoId() != null)? Long.parseLong(titularFilterDTO.getCiudadanoId()) : null;
        Long numContract = (titularFilterDTO.getNumeroContrato() != null && !titularFilterDTO.getNumeroContrato().isEmpty())? Long.parseLong(titularFilterDTO.getNumeroContrato()) : null;
        Integer entidadId = (titularFilterDTO.getEntidadId() != null && !titularFilterDTO.getEntidadId().isEmpty())? Integer.parseInt(titularFilterDTO.getEntidadId()) : null;
        Short tipoPersona = (titularFilterDTO.getTipoPersona() != null)? Short.parseShort(titularFilterDTO.getTipoPersona()) : null;

        solicitudesTitular = afiTitularService.buscarSolicitudesTitularPorCiudadano(ciudId,titularFilterDTO.getEstado(),
                numContract, tipoPersona, entidadId);
        logger.info("termiando busqueda titular" );
        logger.info("total dependientes count: "+ solicitudesTitular.size());

        model.addAttribute("SystemInfoBean", systemInfoDTO);
        model.addAttribute("TitularFilterBean", titularFilterDTO);

        model.addAttribute("solicitudesTitularList", solicitudesTitular);
        return "/pages/afi_titular/show";
    }

    /**
     *
     * @return
     */
    @PostMapping("/titular/filter")
    public String processAfiTitularFilter(@ModelAttribute TitularFilterDTO titularFilterDTO , Model model) {
        logger.info("entering  in show processAfiTitularFilter");

        logger.info("post filter: "+ titularFilterDTO);

        if("T".equals(titularFilterDTO.getEstado())){
            titularFilterDTO.setEstado(null);
        }

        if("T".equals(titularFilterDTO.getTipoPersona())){
            titularFilterDTO.setTipoPersona(null);
        }
        this.titularFilterDTO = titularFilterDTO;

        logger.info("Return the view to use for rendering the response");
        // Return the view to use for rendering the response
        return "redirect:/afi_titular";
    }


}