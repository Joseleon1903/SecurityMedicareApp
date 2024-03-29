package com.spring.security.medi.care.app.controller.page;

import com.spring.security.medi.care.app.catalogo.dto.MotivoEstadoPaginatedDto;
import com.spring.security.medi.care.app.catalogo.dto.MunicipioPaginatedDto;
import com.spring.security.medi.care.app.catalogo.dto.NacionalidadPaginatedDto;
import com.spring.security.medi.care.app.catalogo.service.CatalogoService;
import com.spring.security.medi.care.app.commons.ViewBaseContext;
import com.spring.security.medi.care.app.commons.service.ApplicationMessageUtil;
import com.spring.security.medi.care.app.controller.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

@Controller
public class CatalogoController extends ViewBaseContext {

    private final MessageSource messageSource;
    private final LocaleResolver localeResolver;
    public ApplicationMessageUtil applicationMessageUtil;

    private final CatalogoService catalogoService;

    private SystemInfoDTO systemInfoDTO;

    private MotivoEstadoFilterDTO motivoFilterDTO = new MotivoEstadoFilterDTO();
    private NacionalidadFilterDTO nacionalidadFilterDTO = new NacionalidadFilterDTO();
    private MunicipioFilterDto municipioFilterDto= new MunicipioFilterDto();

    private TablePaginationDto motivoPaginationDto;
    private TablePaginationDto nacionalidadPaginationDto;
    private TablePaginationDto municipioPaginationDto;

    private MunicipioPaginatedDto paginatedMunicipio;
    private MotivoEstadoPaginatedDto paginatedMotivoEstado;
    private NacionalidadPaginatedDto paginatedNacionalidad;

    @Autowired
    public CatalogoController(CatalogoService catalogoService, MessageSource messageSource,LocaleResolver localeResolver ) {
        this.messageSource = messageSource;
        this.localeResolver = localeResolver;
        this.catalogoService = catalogoService;
    }

    @RequestMapping("/catalogo")
    public String showCatalogo(@RequestParam(value = "motivoIndexPage", required = false) Integer motivoIndexInput,
            @RequestParam(value = "nacionalidadIndexPage", required = false) Integer nacionalidadIndexInput,
            @RequestParam(value = "municipioIndexPage", required = false) Integer municipioIndexInput,
            Model model, HttpServletRequest request) {
        logger.info("entering  in show showCatalogo");

        applicationMessageUtil =  new ApplicationMessageUtil(messageSource,localeResolver, request );
        systemInfoDTO = new SystemInfoDTO(applicationMessageUtil.getMessage("page.controller.catalogo.list.title"),
                applicationMessageUtil.getMessage("page.controller.catalogo.list.sub.title"), LocalDate.now());

        logger.info("filter parameters : " + motivoFilterDTO);
        logger.info("filter parameters : " + nacionalidadFilterDTO);
        logger.info("filter parameters : " + municipioFilterDto);

        // catalogo motivo INICIO
        if (motivoIndexInput != null && (this.motivoPaginationDto.getPaginationIndex() + motivoIndexInput) > -1) {
            int result = this.motivoPaginationDto.getPaginationIndex() + motivoIndexInput;
            logger.info("Current page : " + result);
            this.motivoPaginationDto.setPaginationIndex(result);
        }

        logger.info("iniciando busqueda para motivos estado codigo errores..");
        logger.info("iniciando busqueda motivos " + motivoFilterDTO);
        paginatedMotivoEstado = catalogoService
                .buscarMotivosPorParametros(motivoFilterDTO.getMotivoId(), motivoFilterDTO.getDescripcion(),
                        motivoPaginationDto.getPaginationIndex(), motivoFilterDTO.getRowCounter());
        motivoPaginationDto.setPaginationIndex(paginatedMotivoEstado.getPage().getPageIndex());
        logger.info("remain row " + paginatedMotivoEstado.getPage().getTotalRowCount());
        motivoPaginationDto.setRemainCount(paginatedMotivoEstado.getPage().getTotalRowCount()
                - (motivoPaginationDto.getPaginationIndex() * motivoFilterDTO.getRowCounter()));
        if (paginatedMotivoEstado.getPage().getTotalRowCount() == 1L) {
            logger.info("SETAEANDO ZERO REGISTRO RESTANTES");
            motivoPaginationDto.setRemainCount(0L);
        }
        logger.info("termiando busqueda motivos");
        logger.info("temrinando busqueda para motivos estado codigo errores..");
        // catalogo motivo FIN

        // catalogo nacionalidad INICIO
        if (nacionalidadIndexInput != null
                && (this.nacionalidadPaginationDto.getPaginationIndex() + nacionalidadIndexInput) > -1) {
            int result = this.nacionalidadPaginationDto.getPaginationIndex() + nacionalidadIndexInput;
            logger.info("Current page : " + result);
            this.nacionalidadPaginationDto.setPaginationIndex(result);
        }

        logger.info("iniciando busqueda para nacionalidad..");
        logger.info("iniciando busqueda nacionalidadFilterDTO " + nacionalidadFilterDTO);
        paginatedNacionalidad = catalogoService.buscarNacionalidadPorParametros(nacionalidadFilterDTO.getPaisId(),
                nacionalidadPaginationDto.getPaginationIndex(),
                nacionalidadFilterDTO.getRowCounter());
        nacionalidadPaginationDto.setPaginationIndex(paginatedNacionalidad.getPage().getPageIndex());
        logger.info("remain row " + paginatedNacionalidad.getPage().getTotalRowCount());
        nacionalidadPaginationDto.setRemainCount(paginatedNacionalidad.getPage().getTotalRowCount()
                - (nacionalidadPaginationDto.getPaginationIndex() * nacionalidadFilterDTO.getRowCounter()));
        if (paginatedNacionalidad.getPage().getTotalRowCount() == 1L) {
            logger.info("SETAEANDO ZERO REGISTRO RESTANTES");
            nacionalidadPaginationDto.setRemainCount(0L);
        }
        logger.info("termiando busqueda Nacionalidad");
        logger.info("Terminando busqueda para Nacionalidad..");
        // catalogo nacionalidad FIN

        // catalogo municipio INICIO
        if (municipioIndexInput != null
                && (this.municipioPaginationDto.getPaginationIndex() + municipioIndexInput) > -1) {
            int result = this.municipioPaginationDto.getPaginationIndex() + municipioIndexInput;
            logger.info("Current page : " + result);
            this.municipioPaginationDto.setPaginationIndex(result);
        }
        logger.info("iniciando busqueda para municipio..");
        logger.info("municipioFilterDto: " + municipioFilterDto);
        paginatedMunicipio = catalogoService
                .buscarMunicipioPorParametros(municipioFilterDto.getCodigoMunicipio(),
                        municipioFilterDto.getDescripcion(), municipioPaginationDto.getPaginationIndex(),
                        municipioFilterDto.getRowCounter());
        municipioPaginationDto.setPaginationIndex(paginatedMunicipio.getPage().getPageIndex());
        logger.info("remain row " + paginatedMunicipio.getPage().getTotalRowCount());
        municipioPaginationDto.setRemainCount(paginatedMunicipio.getPage().getTotalRowCount()
                - (municipioPaginationDto.getPaginationIndex() * municipioFilterDto.getRowCounter()));
        if (paginatedMunicipio.getPage().getTotalRowCount() == 1L) {
            logger.info("SETAEANDO ZERO REGISTRO RESTANTES");
            municipioPaginationDto.setRemainCount(0L);
        }
        logger.info("termiando busqueda municipio");
        // catalogo municipio FIN

        model.addAttribute("NacionalidadFilterDTOBean", nacionalidadFilterDTO);
        model.addAttribute("MunicipioFilterDtoBean", municipioFilterDto);
        model.addAttribute("MotivoFilterDtoBean", motivoFilterDTO);
        model.addAttribute("PaginatedMunicipioBean", paginatedMunicipio);
        model.addAttribute("PaginatedNacionalidadBean", paginatedNacionalidad);
        model.addAttribute("PaginatedMotivosBean", paginatedMotivoEstado);
        model.addAttribute("SystemInfoBean", systemInfoDTO);
        model.addAttribute("MotivoMaginationBean", motivoPaginationDto);
        model.addAttribute("NacionalidadPaginationBean", nacionalidadPaginationDto);
        model.addAttribute("MunicipioPaginationBean", municipioPaginationDto);

        return "pages/catalogo/showCatalogosPage";
    }

    @PostMapping("/municipio/filter")
    public String buscarMunicipiosPorParametros(@ModelAttribute MunicipioFilterDto municipioFilterDtoInput) {
        logger.info("------- entering -----------");
        logger.info("Entering in method buscarMunicipiosPorParametros..");
        logger.info("Form values : " + municipioFilterDtoInput);

        if (municipioFilterDtoInput != null && municipioFilterDtoInput.getCodigoMunicipio().isEmpty()) {
            municipioFilterDtoInput.setCodigoMunicipio(null);
        }
        if (municipioFilterDtoInput != null && municipioFilterDtoInput.getDescripcion().isEmpty()) {
            municipioFilterDtoInput.setDescripcion(null);
        }
        paginatedMunicipio = catalogoService
                .buscarMunicipioPorParametros(municipioFilterDtoInput.getCodigoMunicipio(),
                        municipioFilterDtoInput.getDescripcion(), municipioFilterDtoInput.getPage(),
                        municipioFilterDtoInput.getRowCounter());
        this.municipioFilterDto = municipioFilterDtoInput;
        this.municipioPaginationDto.setPaginationIndex(0);
        logger.info("Exiting in method buscarMunicipiosPorParametros..");
        return "redirect:/catalogo";
    }

    @PostMapping("/motivoestado/filter")
    public String buscarMotivosEstadosPorParametros(@ModelAttribute MotivoEstadoFilterDTO motivoFilterDtoInput) {
        logger.info("------- entering -----------");
        logger.info("Entering in method buscarMotivosEstadosPorParametros..");
        logger.info("Form values : " + motivoFilterDtoInput);

        if (motivoFilterDtoInput != null && motivoFilterDtoInput.getMotivoId() != null
                && motivoFilterDtoInput.getMotivoId() <= 0) {
            motivoFilterDtoInput.setMotivoId(null);
        }

        if (motivoFilterDtoInput != null && motivoFilterDtoInput.getDescripcion() != null
                && motivoFilterDtoInput.getDescripcion().isEmpty()) {
            motivoFilterDtoInput.setDescripcion(null);
        }

        logger.info("iniciando busqueda motivos " + motivoFilterDtoInput);
        paginatedMotivoEstado = catalogoService
                .buscarMotivosPorParametros(motivoFilterDtoInput.getMotivoId(), motivoFilterDtoInput.getDescripcion(),
                        motivoFilterDtoInput.getPage(), motivoFilterDtoInput.getRowCounter());
        logger.info("termiando busqueda motivos");
        logger.info("terminando busqueda para motivos estado codigo errores..");

        this.motivoFilterDTO = motivoFilterDtoInput;
        this.motivoPaginationDto.setPaginationIndex(0);
        logger.info("Exiting in method buscarMotivosEstadosPorParametros..");
        return "redirect:/catalogo";
    }

    @PostMapping("/nacionalidad/filter")
    public String buscarNacionalidadPorParametros(@ModelAttribute NacionalidadFilterDTO nacionalidadFilterInput) {
        logger.info("------- entering -----------");
        logger.info("Entering in method buscarNacionalidadPorParametros..");
        logger.info("Form values : " + nacionalidadFilterInput);

        if (nacionalidadFilterInput != null && nacionalidadFilterInput.getPaisId().isEmpty()) {
            nacionalidadFilterInput.setPaisId(null);
        }
        this.nacionalidadFilterDTO = nacionalidadFilterInput;
        paginatedNacionalidad = catalogoService.buscarNacionalidadPorParametros(nacionalidadFilterDTO.getPaisId(),
                nacionalidadFilterDTO.getPage(),
                nacionalidadFilterDTO.getRowCounter());
        logger.info("Exiting in method buscarNacionalidadPorParametros..");

        this.nacionalidadFilterDTO = nacionalidadFilterInput;
        this.nacionalidadPaginationDto.setPaginationIndex(0);
        return "redirect:/catalogo";
    }

    @Override
    protected void init() {
        logger.debug("entering init method ");
        logger.debug("Generando systemInfoDTO");
        motivoPaginationDto = new TablePaginationDto();
        nacionalidadPaginationDto = new TablePaginationDto();
        municipioPaginationDto = new TablePaginationDto();
        systemInfoDTO = new SystemInfoDTO("Catalogos","Simplificar el catálogo de servicios únicamente a los servicios previamente acordados entre cliente y proveedor,\n" +
                " en automático reduce la carga de trabajo al eliminar la opción para tramitar solicitudes indebidas.", LocalDate.now());
        logger.debug("systemInfoDTO: " + systemInfoDTO);
        logger.debug("existing init method ");
    }
}