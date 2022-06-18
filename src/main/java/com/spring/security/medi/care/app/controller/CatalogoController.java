package com.spring.security.medi.care.app.controller;

import com.spring.security.medi.care.app.catalogo.domain.MotivoEstado;
import com.spring.security.medi.care.app.catalogo.domain.Nacionalidad;
import com.spring.security.medi.care.app.catalogo.domain.Parentesco;
import com.spring.security.medi.care.app.catalogo.service.CatalogoService;
import com.spring.security.medi.care.app.commons.ViewBaseContext;
import com.spring.security.medi.care.app.controller.dto.MotivoEstadoFilterDTO;
import com.spring.security.medi.care.app.controller.dto.NacionalidadFilterDTO;
import com.spring.security.medi.care.app.controller.dto.ParentescoFilterDTO;
import com.spring.security.medi.care.app.controller.dto.SystemInfoDTO;
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

    private ParentescoFilterDTO parentescoInputDto;
    private MotivoEstadoFilterDTO motivoFilterDTO;
    private NacionalidadFilterDTO nacionalidadFilterDTO;

    private List<Parentesco> listaParentesco;
    private List<MotivoEstado> listaMotivos;
    private List<Nacionalidad> listaNacionalidades;

    @Autowired
    public CatalogoController(CatalogoService catalogoService, ParentescoFilterDTO parentescoInputDto,MotivoEstadoFilterDTO motivoFilterDTO, NacionalidadFilterDTO nacionalidadFilterDTO) {
        super();
        this.catalogoService = catalogoService;
        this.parentescoInputDto = parentescoInputDto;
        this.motivoFilterDTO = motivoFilterDTO;
        this.nacionalidadFilterDTO = nacionalidadFilterDTO;
    }

    /***
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/catalogo", method = RequestMethod.GET , produces = MediaType.TEXT_HTML_VALUE)
    public String showCatalogo(Model model) {
        logger.info("entering  in show showCatalogo");

        logger.info("filter parameters : "+parentescoInputDto);
        logger.info("filter parameters : "+motivoFilterDTO);
        logger.info("filter parameters : "+nacionalidadFilterDTO);

        listaParentesco = new ArrayList<>();
        listaMotivos = new ArrayList<>();
        listaNacionalidades = new ArrayList<>();

        logger.info("iniciando busqueda para parentesco..");

        if(parentescoInputDto.getTipoDependiente() != null || parentescoInputDto.getGenero() != null){
           logger.info("iniciando busqueda parentesco "+parentescoInputDto);

           listaParentesco = catalogoService
                   .buscarCatalogoParentescoPorParametros(parentescoInputDto.getTipoDependiente(),parentescoInputDto.getGenero(),
                           parserRowCounter(parentescoInputDto.getRowCounter()));
           logger.info("termiando busqueda Parentescos" );
        }else{
           listaParentesco = catalogoService
                   .buscarCatalogoParentescoPorParametros(parentescoInputDto.getTipoDependiente(),parentescoInputDto.getGenero(),
                           parserRowCounter(parentescoInputDto.getRowCounter()));
       }
        logger.info("Terminando busqueda para parentesco..");
        logger.info("total paretescos count: "+ listaParentesco.size());

        logger.info("iniciando busqueda para motivos estado codigo errores..");

        if(motivoFilterDTO.getMotivoId() != null || motivoFilterDTO.getDescripcion() != null){
            logger.info("iniciando busqueda motivos "+motivoFilterDTO);

            listaMotivos = catalogoService
                    .buscarCatalogomotivoEstadooPorParametros(motivoFilterDTO.getMotivoId(),motivoFilterDTO.getDescripcion(), parserRowCounter(motivoFilterDTO.getRowCounter()));
            logger.info("termiando busqueda motivos" );
        }else{
            listaMotivos = catalogoService
                    .buscarCatalogomotivoEstadooPorParametros(motivoFilterDTO.getMotivoId(),motivoFilterDTO.getDescripcion(), parserRowCounter(motivoFilterDTO.getRowCounter()));
        }
        logger.info("temrinando busqueda para motivos estado codigo errores..");

        logger.info("iniciando busqueda para nacionalidad..");

        if(nacionalidadFilterDTO.getNombre() != null || nacionalidadFilterDTO.getPaisId() != null){
            logger.info("iniciando busqueda parentesco "+nacionalidadFilterDTO);

            listaNacionalidades = catalogoService
                    .buscarCatalogoNacionalidad(nacionalidadFilterDTO.getPaisId(),nacionalidadFilterDTO.getNombre(),
                            parserRowCounter(nacionalidadFilterDTO.getRowCounter()));
            logger.info("termiando busqueda Nacionalidad" );
        }else{
            listaNacionalidades = catalogoService
                    .buscarCatalogoNacionalidad(nacionalidadFilterDTO.getPaisId(),nacionalidadFilterDTO.getNombre(),
                            parserRowCounter(nacionalidadFilterDTO.getRowCounter()));
        }
        logger.info("Terminando busqueda para parentesco..");
        logger.info("total paretescos count: "+ listaNacionalidades.size());


        model.addAttribute("parentescoFilterBean",parentescoInputDto);
        model.addAttribute("listadoParentescoBean", listaParentesco);
        model.addAttribute("listadoNacionalidadBean", listaNacionalidades);

        model.addAttribute("SystemInfoBean", systemInfoDTO);
        model.addAttribute("motivoFilterBean",motivoFilterDTO);
        model.addAttribute("NacionalidadFilterBean",nacionalidadFilterDTO);

        model.addAttribute("listadoMotivosBean", listaMotivos);
        return "/pages/catalogo/show";
    }

    @PostMapping("/parentesco/filter")
    public String buscarParentescosPorParametros(@ModelAttribute ParentescoFilterDTO parentescoFilterDTO, Model model){
        logger.info("------- entering -----------");
        logger.info("Entering in method buscarParentescosPorParametros..");

        logger.info("Form values : "+parentescoFilterDTO);

        if(parentescoFilterDTO.getGenero().equals("T")){
            parentescoFilterDTO.setGenero(null);
        }

        if(parentescoFilterDTO.getTipoDependiente().equals("T")){
            parentescoFilterDTO.setTipoDependiente(null);
        }

        this.parentescoInputDto = parentescoFilterDTO;
        logger.info("Exiting in method buscarParentescosPorParametros..");
        return "redirect:/catalogo";
    }

    @PostMapping("/motivo/filter")
    public String buscarMotivosEstadosPorParametros(@ModelAttribute MotivoEstadoFilterDTO motivoFilterDTO, Model model){
        logger.info("------- entering -----------");
        logger.info("Entering in method buscarMotivosEstadosPorParametros..");
        logger.info("Form values : "+motivoFilterDTO);

        if(motivoFilterDTO != null && motivoFilterDTO.getMotivoId() != null && motivoFilterDTO.getMotivoId() <=0){
            motivoFilterDTO.setMotivoId(null);
        }

        if(motivoFilterDTO != null && motivoFilterDTO.getDescripcion() != null && motivoFilterDTO.getDescripcion().isEmpty()){
            motivoFilterDTO.setDescripcion(null);
        }

        this.motivoFilterDTO = motivoFilterDTO;
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

        if(nacionalidadFilterInput != null && nacionalidadFilterInput.getNombre().isEmpty()){
            nacionalidadFilterInput.setNombre(null);
        }

        this.nacionalidadFilterDTO = nacionalidadFilterInput;
        logger.info("Exiting in method buscarNacionalidadPorParametros..");
        return "redirect:/catalogo";
    }

    @Override
    protected void init() {
        logger.info("entering init method ");
        logger.info("Generando systemInfoDTO");
        systemInfoDTO = new SystemInfoDTO("Unipago información Catalogada",new Date());
        logger.info("systemInfoDTO: "+ systemInfoDTO);

        logger.info("existing init method ");
    }
}