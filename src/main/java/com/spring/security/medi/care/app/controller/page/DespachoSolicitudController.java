package com.spring.security.medi.care.app.controller.page;

import com.spring.security.medi.care.app.afiliacion.repository.AfiDaoUtil;
import com.spring.security.medi.care.app.afiliacion.service.SolicitudAfiliacionService;
import com.spring.security.medi.care.app.afiliacion.types.PaginatedSolAfiliacionDto;
import com.spring.security.medi.care.app.catalogo.service.CatalogoService;
import com.spring.security.medi.care.app.commons.DaoUtil;
import com.spring.security.medi.care.app.commons.ViewBaseContext;
import com.spring.security.medi.care.app.commons.domain.Seguro;
import com.spring.security.medi.care.app.commons.service.ApplicationMessageUtil;
import com.spring.security.medi.care.app.controller.dto.SolicituFromFilterDto;
import com.spring.security.medi.care.app.controller.dto.SolicitudAfiliacionOutputDto;
import com.spring.security.medi.care.app.controller.dto.SystemInfoDTO;
import com.spring.security.medi.care.app.controller.dto.TablePaginationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;

@Controller
public class DespachoSolicitudController extends ViewBaseContext {

    private final MessageSource messageSource;
    private final LocaleResolver localeResolver;
    public ApplicationMessageUtil applicationMessageUtil;

    private SystemInfoDTO systemInfoDTO;

    private PaginatedSolAfiliacionDto paginatedSolAfiliacionDto;
    private List<SolicitudAfiliacionOutputDto> solicitudList;
    private SolicituFromFilterDto solicituFromFilterDto;
    private TablePaginationDto tablePagination;
    private List<Seguro> segurosSistema;

    private final SolicitudAfiliacionService solicitudAfiliacionService;
    private final CatalogoService catalogoService;

    @Autowired
    public DespachoSolicitudController(SolicitudAfiliacionService solicitudAfiliacionService, CatalogoService catalogoService,
                                       MessageSource messageSource,LocaleResolver localeResolver ) {
        this.solicitudAfiliacionService = solicitudAfiliacionService;
        this.catalogoService = catalogoService;
        this.messageSource = messageSource;
        this.localeResolver = localeResolver;
    }

    @GetMapping("/despacho")
    public String showPage(@RequestParam(value = "indexPage", required = false) Integer indexPageInput, Model model, HttpServletRequest request) {
        logger.info("------- entering -----------");
        logger.info("Entering in method showPage:{/despacho}");

        applicationMessageUtil =  new ApplicationMessageUtil(messageSource,localeResolver, request );
        systemInfoDTO = new SystemInfoDTO(applicationMessageUtil.getMessage("page.controller.despacho.list.title"),
                applicationMessageUtil.getMessage("page.controller.despacho.list.sub.title"), LocalDate.now());

        logger.info("validando paginacion");
        if (indexPageInput != null && (this.tablePagination.getPaginationIndex() + indexPageInput) > -1) {
            int result = this.tablePagination.getPaginationIndex() + indexPageInput;
            logger.info("Current page : " + result);
            this.tablePagination.setPaginationIndex(result);
        }
        logger.info("terminado validar  paginacion");

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

        paginatedSolAfiliacionDto = solicitudAfiliacionService.buscarSolicitudesAfiliacionPorParametros(
                solicituFromFilterDto.getCedula(),
                solicituFromFilterDto.getServicioId(),
                solicituFromFilterDto.getSeguroId(),
                regimenId,
                estado, tablePagination.getPaginationIndex(), DaoUtil.DEFAULT_ROW_COUNT);
        this.tablePagination.setPaginationIndex(paginatedSolAfiliacionDto.getPagination().getPageIndex());
        this.tablePagination.setRemainCount(paginatedSolAfiliacionDto.getPagination().getTotalRowCount());
        solicitudList = AfiDaoUtil.convertToDto(paginatedSolAfiliacionDto.getSolicitudes());
        logger.info("terminando busqueda solicitudes ");
        model.addAttribute("SolicituFromFilterBean", solicituFromFilterDto);
        model.addAttribute("SolicitudAfiliacionListBean", solicitudList);
        model.addAttribute("ListaSeguroBean", segurosSistema);
        model.addAttribute("SystemInfoBean", systemInfoDTO);
        model.addAttribute("TablePaginationBean", tablePagination);
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
        solicituFromFilterDto = new SolicituFromFilterDto();
        tablePagination = new TablePaginationDto();
        systemInfoDTO = new SystemInfoDTO("Despacho solicitudes","Disfruta de nuestros Planes de Beneficios Humano Sonrisas, procesar tu solicitud de manera exitosa en nuestra pagina web.", LocalDate.now());
        logger.info("systemInfoDTO: " + systemInfoDTO);
        logger.info("existing init method ");
    }

    public void cargarCatalogoSeguro() {
        logger.info("entering cargarCatalogoSeguro");
        this.segurosSistema = catalogoService.buscarSegurosSistema();
        logger.info("exiting cargarCatalogoSeguro");
    }

}