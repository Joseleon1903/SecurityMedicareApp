package com.spring.security.medi.care.app.controller.page;

import com.spring.security.medi.care.app.afiliacion.repository.AfiDaoUtil;
import com.spring.security.medi.care.app.afiliacion.service.SolicitudAfiliacionService;
import com.spring.security.medi.care.app.catalogo.service.CatalogoService;
import com.spring.security.medi.care.app.commons.DaoUtil;
import com.spring.security.medi.care.app.commons.ViewBaseContext;
import com.spring.security.medi.care.app.commons.domain.Seguro;
import com.spring.security.medi.care.app.commons.domain.SolicitudAfiliacion;
import com.spring.security.medi.care.app.controller.dto.SolicituFromFilterDto;
import com.spring.security.medi.care.app.controller.dto.SolicitudAfiliacionOutputDto;
import com.spring.security.medi.care.app.controller.dto.SystemInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.List;

@Controller
public class DespachoSolicitudController extends ViewBaseContext {

    private SystemInfoDTO systemInfoDTO;

    private List<SolicitudAfiliacionOutputDto> solicitudList;
    private SolicituFromFilterDto solicituFromFilterDto;
    private List<Seguro> segurosSistema;

    private final SolicitudAfiliacionService solicitudAfiliacionService;
    private final CatalogoService catalogoService;

    @Autowired
    public DespachoSolicitudController(SolicitudAfiliacionService solicitudAfiliacionService,
            CatalogoService catalogoService, SolicituFromFilterDto solicituFromFilterDto) {
        this.solicitudAfiliacionService = solicitudAfiliacionService;
        this.catalogoService = catalogoService;
        this.solicituFromFilterDto = solicituFromFilterDto;
    }

    @GetMapping("/despacho")
    public String showPage(Model model) {
        logger.info("------- entering -----------");
        logger.info("Entering in method showPage:{/despacho}");

        logger.info("buscar catalogo seguros");
        cargarCatalogoSeguro();
        logger.info("terminando busqueda catalogo seguros");

        logger.info("iniciando busqueda solicitudes ");
        Integer regimenId = (solicituFromFilterDto.getRegimenId() != null
                && !solicituFromFilterDto.getRegimenId().isEmpty())
                        ? Integer.parseInt(solicituFromFilterDto.getRegimenId())
                        : null;
        String estado = (solicituFromFilterDto.getEstado() != null && solicituFromFilterDto.getEstado() == "T") ? null
                : solicituFromFilterDto.getEstado();

        List<SolicitudAfiliacion> solListDomain = solicitudAfiliacionService.buscarSolicitudesAfiliacionPorParametros(
                solicituFromFilterDto.getCedula(),
                solicituFromFilterDto.getServicioId(),
                solicituFromFilterDto.getSeguroId(),
                regimenId,
                estado, DaoUtil.DEFAULT_PAGE, DaoUtil.DEFAULT_ROW_COUNT);
        solicitudList = AfiDaoUtil.convertToDto(solListDomain);
        logger.info("terminando busqueda solicitudes ");
        model.addAttribute("SolicituFromFilterBean", solicituFromFilterDto);
        model.addAttribute("SolicitudAfiliacionListBean", solicitudList);
        model.addAttribute("ListaSeguroBean", segurosSistema);
        model.addAttribute("SystemInfoBean", systemInfoDTO);
        return "pages/despacho/showDespachoPage";
    }

    @PostMapping("/solicitud/filter")
    public String buscarSolicitudesPorParametros(@ModelAttribute SolicituFromFilterDto solicituFromFilterInput,
            Model model) {
        logger.info("------- entering -----------");
        logger.info("Entering in method buscarSolicitudesPorParametros..");
        logger.info("Form values : " + solicituFromFilterInput);

        if (solicituFromFilterInput != null && solicituFromFilterInput.getCedula().isEmpty()) {
            solicituFromFilterInput.setCedula(null);
        }

        if (solicituFromFilterInput != null && solicituFromFilterInput.getServicioId() == 0) {
            solicituFromFilterInput.setServicioId(null);
        }

        if (solicituFromFilterInput != null && solicituFromFilterInput.getRegimenId() == "T") {
            solicituFromFilterInput.setRegimenId(null);
        }

        if (solicituFromFilterInput != null && solicituFromFilterInput.getEstado().isEmpty()) {
            solicituFromFilterInput.setEstado(null);
        }
        this.solicituFromFilterDto = solicituFromFilterInput;
        logger.info("Exiting in method buscarSolicitudesPorParametros..");
        return "redirect:/despacho";
    }

    @PostMapping("/solicitud/procesar/{solicitudId}")
    public String procesarSolicitud(@PathVariable("solicitudId") String solicitudId, Model model) {
        logger.info("Entering in procesarSolicitud");
        logger.info("param solicitudId: " + solicitudId);
        Long solId = Long.parseLong(solicitudId);
        try {
            solicitudAfiliacionService.procesarSolicitudAfiliacion(solId);
        } catch (Exception ex) {
            logger.info("Error : " + ex.getMessage());

        }
        return "redirect:/despacho";
    }

    @Override
    protected void init() {
        logger.info("entering init method ");
        logger.info("Generando systemInfoDTO");
        systemInfoDTO = new SystemInfoDTO("Despacho solicitudes", new Date());
        logger.info("systemInfoDTO: " + systemInfoDTO);
        logger.info("existing init method ");
    }

    public void cargarCatalogoSeguro() {
        logger.info("entering cargarCatalogoSeguro");
        this.segurosSistema = catalogoService.buscarSegurosSistema();
        logger.info("exiting cargarCatalogoSeguro");
    }

}