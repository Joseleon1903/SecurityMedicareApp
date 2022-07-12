package com.spring.security.medi.care.app.controller.page;

import com.spring.security.medi.care.app.catalogo.dto.MotivoEstadoPaginatedDto;
import com.spring.security.medi.care.app.catalogo.dto.MunicipioPaginatedDto;
import com.spring.security.medi.care.app.catalogo.dto.NacionalidadPaginatedDto;
import com.spring.security.medi.care.app.catalogo.service.CatalogoService;
import com.spring.security.medi.care.app.commons.ViewBaseContext;
import com.spring.security.medi.care.app.commons.domain.MotivoEstado;
import com.spring.security.medi.care.app.commons.domain.Nacionalidad;
import com.spring.security.medi.care.app.commons.domain.Parentesco;
import com.spring.security.medi.care.app.controller.dto.*;
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
public class CatalogoController extends ViewBaseContext {

    private final CatalogoService catalogoService;

    private SystemInfoDTO systemInfoDTO;

    private MotivoEstadoFilterDTO motivoFilterDTO;
    private NacionalidadFilterDTO nacionalidadFilterDTO;
    private MunicipioFilterDto municipioFilterDto;

    private MunicipioPaginatedDto paginatedMunicipio;
    private MotivoEstadoPaginatedDto paginatedMotivoEstado;
    private NacionalidadPaginatedDto paginatedNacionalidad;

    @Autowired
    public CatalogoController(CatalogoService catalogoService ,MotivoEstadoFilterDTO motivoFilterDTO, NacionalidadFilterDTO nacionalidadFilterDTO, MunicipioFilterDto municipioFilterDto) {
        super();
        this.catalogoService = catalogoService;
        this.motivoFilterDTO = motivoFilterDTO;
        this.nacionalidadFilterDTO = nacionalidadFilterDTO;
        this.municipioFilterDto = municipioFilterDto;
    }

    /***
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/catalogo", method = RequestMethod.GET , produces = MediaType.TEXT_HTML_VALUE)
    public String showCatalogo(Model model) {
        logger.info("entering  in show showCatalogo");

        logger.info("filter parameters : "+motivoFilterDTO);
        logger.info("filter parameters : "+nacionalidadFilterDTO);
        logger.info("filter parameters : "+municipioFilterDto);

        if(paginatedMotivoEstado == null){
            logger.info("iniciando busqueda para motivos estado codigo errores..");
            logger.info("iniciando busqueda motivos "+motivoFilterDTO);
            paginatedMotivoEstado = catalogoService
                    .buscarMotivosPorParametros(motivoFilterDTO.getMotivoId(),motivoFilterDTO.getDescripcion(), motivoFilterDTO.getPage(), motivoFilterDTO.getRowCounter());
            logger.info("termiando busqueda motivos");
            logger.info("temrinando busqueda para motivos estado codigo errores..");
        }

        if(paginatedNacionalidad == null){
            logger.info("iniciando busqueda para nacionalidad..");
            logger.info("iniciando busqueda nacionalidadFilterDTO "+nacionalidadFilterDTO);
            paginatedNacionalidad = catalogoService.buscarNacionalidadPorParametros(nacionalidadFilterDTO.getPaisId(),nacionalidadFilterDTO.getPage(),
                    nacionalidadFilterDTO.getRowCounter());
            logger.info("termiando busqueda Nacionalidad");
            logger.info("Terminando busqueda para Nacionalidad..");
        }

        if(paginatedMunicipio == null){
            logger.info("iniciando busqueda para municipio..");
            logger.info("municipioFilterDto: "+municipioFilterDto);
            paginatedMunicipio = catalogoService
                    .buscarMunicipioPorParametros(municipioFilterDto.getCodigoMunicipio(), municipioFilterDto.getDescripcion(),0,
                            municipioFilterDto.getRowCounter());
            logger.info("termiando busqueda municipio" );
        }

        model.addAttribute("NacionalidadFilterDTOBean",nacionalidadFilterDTO);
        model.addAttribute("MunicipioFilterDtoBean",municipioFilterDto);
        model.addAttribute("MotivoFilterDtoBean",motivoFilterDTO);
        model.addAttribute("PaginatedMunicipioBean",paginatedMunicipio);
        model.addAttribute("PaginatedNacionalidadBean",paginatedNacionalidad);
        model.addAttribute("PaginatedMotivosBean", paginatedMotivoEstado);
        model.addAttribute("SystemInfoBean", systemInfoDTO);

        return "/pages/catalogo/show";
    }

    @PostMapping("/municipio/filter")
    public String buscarMunicipiosPorParametros(@ModelAttribute MunicipioFilterDto municipioFilterDtoInput, Model model){
        logger.info("------- entering -----------");
        logger.info("Entering in method buscarMunicipiosPorParametros..");

        logger.info("Form values : "+municipioFilterDtoInput);

        if(municipioFilterDtoInput != null && municipioFilterDtoInput.getCodigoMunicipio().isEmpty()){
            municipioFilterDtoInput.setCodigoMunicipio(null);
        }
        if(municipioFilterDtoInput != null && municipioFilterDtoInput.getDescripcion().isEmpty() ){
            municipioFilterDtoInput.setDescripcion(null);
        }

        paginatedMunicipio = catalogoService
                .buscarMunicipioPorParametros(municipioFilterDtoInput.getCodigoMunicipio(), municipioFilterDtoInput.getDescripcion(),municipioFilterDtoInput.getPage(),
                        municipioFilterDtoInput.getRowCounter());

        this.municipioFilterDto = municipioFilterDtoInput;
        logger.info("Exiting in method buscarMunicipiosPorParametros..");
        return "redirect:/catalogo";
    }

    @PostMapping("/motivoestado/filter")
    public String buscarMotivosEstadosPorParametros(@ModelAttribute MotivoEstadoFilterDTO motivoFilterDtoInput, Model model){
        logger.info("------- entering -----------");
        logger.info("Entering in method buscarMotivosEstadosPorParametros..");
        logger.info("Form values : "+motivoFilterDtoInput);

        if(motivoFilterDtoInput != null && motivoFilterDtoInput.getMotivoId() != null && motivoFilterDtoInput.getMotivoId() <=0){
            motivoFilterDtoInput.setMotivoId(null);
        }

        if(motivoFilterDtoInput != null && motivoFilterDtoInput.getDescripcion() != null && motivoFilterDtoInput.getDescripcion().isEmpty()){
            motivoFilterDtoInput.setDescripcion(null);
        }

        logger.info("iniciando busqueda motivos "+motivoFilterDtoInput);
        paginatedMotivoEstado = catalogoService
                .buscarMotivosPorParametros(motivoFilterDtoInput.getMotivoId(),motivoFilterDtoInput.getDescripcion(), motivoFilterDtoInput.getPage(), motivoFilterDtoInput.getRowCounter());
        logger.info("termiando busqueda motivos" );
        logger.info("terminando busqueda para motivos estado codigo errores..");

        this.motivoFilterDTO = motivoFilterDtoInput;
        logger.info("Exiting in method buscarMotivosEstadosPorParametros..");
        return "redirect:/catalogo";
    }

    @PostMapping("/nacionalidad/filter")
    public String buscarNacionalidadPorParametros(@ModelAttribute NacionalidadFilterDTO nacionalidadFilterInput, Model model){
        logger.info("------- entering -----------");
        logger.info("Entering in method buscarNacionalidadPorParametros..");
        logger.info("Form values : "+nacionalidadFilterInput);

        if(nacionalidadFilterInput != null && nacionalidadFilterInput.getPaisId().isEmpty()){
            nacionalidadFilterInput.setPaisId(null);
        }

        this.nacionalidadFilterDTO = nacionalidadFilterInput;

        paginatedNacionalidad = catalogoService.buscarNacionalidadPorParametros(nacionalidadFilterDTO.getPaisId(),nacionalidadFilterDTO.getPage(),
                nacionalidadFilterDTO.getRowCounter());

        logger.info("Exiting in method buscarNacionalidadPorParametros..");
        return "redirect:/catalogo";
    }

    @Override
    protected void init() {
        logger.info("entering init method ");
        logger.info("Generando systemInfoDTO");
        systemInfoDTO = new SystemInfoDTO("Catalogos",new Date());
        logger.info("systemInfoDTO: "+ systemInfoDTO);
        logger.info("existing init method ");
    }
}