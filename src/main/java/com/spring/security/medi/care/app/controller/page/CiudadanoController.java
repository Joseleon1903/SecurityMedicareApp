package com.spring.security.medi.care.app.controller.page;

import com.spring.security.medi.care.app.ciudadano.service.CiudadanoService;
import com.spring.security.medi.care.app.ciudadano.type.CiudadanoDto;
import com.spring.security.medi.care.app.ciudadano.type.CiudadanoPaginated;
import com.spring.security.medi.care.app.commons.DaoUtil;
import com.spring.security.medi.care.app.commons.ViewBaseContext;
import com.spring.security.medi.care.app.commons.domain.Ciudadano;
import com.spring.security.medi.care.app.commons.service.ApplicationMessageUtil;
import com.spring.security.medi.care.app.controller.dto.CiudadanoFilterDto;
import com.spring.security.medi.care.app.controller.dto.SystemInfoDTO;
import com.spring.security.medi.care.app.controller.dto.TablePaginationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;

@Controller
public class CiudadanoController extends ViewBaseContext {

    private final MessageSource messageSource;
    private final LocaleResolver localeResolver;
    public ApplicationMessageUtil applicationMessageUtil;

    private final CiudadanoService ciudadanoService;
    private List<CiudadanoDto> ciudadanos;

    private SystemInfoDTO systemInfoDTO;
    private Ciudadano detailCiudadano;
    private CiudadanoFilterDto ciudadanoFilterDto;
    private TablePaginationDto tablePagination;

    @Autowired
    public CiudadanoController(CiudadanoService ciudadanoService, MessageSource messageSource, LocaleResolver localeResolver) {
        this.ciudadanoService = ciudadanoService;
        this.messageSource = messageSource;
        this.localeResolver = localeResolver;
    }

    @GetMapping("/ciudadano")
    public String showPage(@RequestParam(value = "indexPage", required = false) Integer indexPageInput, Model model, HttpServletRequest request) {
        logger.info("------- entering -----------");
        logger.info("Entering in method showPage..");
        applicationMessageUtil =  new ApplicationMessageUtil(messageSource,localeResolver, request );
        systemInfoDTO = new SystemInfoDTO(applicationMessageUtil.getMessage("page.controller.ciudadano.list.title"),
                applicationMessageUtil.getMessage("page.controller.ciudadano.list.sub.title"), LocalDate.now());
        logger.info("param: ciudadanoFilterDto " + ciudadanoFilterDto);
        if (indexPageInput != null && (this.tablePagination.getPaginationIndex() + indexPageInput) > -1) {
            int result = this.tablePagination.getPaginationIndex() + indexPageInput;
            logger.info("Current page : " + result);
            this.tablePagination.setPaginationIndex(result);
        }
        logger.info("buscando ciudadanos ...");
        CiudadanoPaginated paginated = ciudadanoService.buscarCiudadanosPorParametros(
                ciudadanoFilterDto.getTipoIdentificacion(),
                ciudadanoFilterDto.getNombre(), ciudadanoFilterDto.getEstado(), tablePagination.getPaginationIndex(),
                DaoUtil.DEFAULT_ROW_COUNT);
        this.ciudadanos = paginated.getCiudadanos();
        this.tablePagination.setPaginationIndex(paginated.getPagination().getPageIndex());
        this.tablePagination.setRemainCount(paginated.getPagination().getTotalRowCount());
        logger.info("terminando buscando ");

        logger.info("terminando buscando ciudadanos size:" + ciudadanos.size());

        model.addAttribute("CiudadanosList", ciudadanos);
        model.addAttribute("SystemInfoBean", systemInfoDTO);
        model.addAttribute("DetailCiudadanoBean", detailCiudadano);
        model.addAttribute("TablePaginationBean", tablePagination);
        model.addAttribute("CiudadanoFilterBean", ciudadanoFilterDto);
        return "pages/ciudadano/showCiudadanoPage";
    }

    @PostMapping("/listado/filter")
    public String filterCiudadanoPage(@ModelAttribute CiudadanoFilterDto ciudadanoFilterInput) {
        logger.info("------- entering -----------");
        logger.info("Entering in method filterCiudadanoPage..");
        logger.info("param ciudadanoFilterDto " + ciudadanoFilterDto);
        if (ciudadanoFilterInput.getEstado().equals("T")) {
            ciudadanoFilterInput.setEstado(null);
        }
        this.tablePagination.setPaginationIndex(0);
        this.ciudadanoFilterDto = ciudadanoFilterInput;
        return "redirect:/ciudadano";
    }

    @GetMapping("/ciudadano/{ciudadanoId}")
    public String updateDetailCiudadanoPage(@PathVariable("ciudadanoId") Long ciudadanoId, Model model) {
        logger.info("------- entering -----------");
        logger.info("Entering in method updateDetailCiudadanoPage..");
        logger.info("param detalle ciudadanoId = " + ciudadanoId);

        logger.info("buscando ciudadanos ...");
        detailCiudadano = ciudadanoService.buscarCiudadanoPorCiudadanoId(ciudadanoId).get();
        logger.info("terminando buscando ciudadanos:" + detailCiudadano);

        model.addAttribute("CiudadanosList", ciudadanos);
        model.addAttribute("SystemInfoBean", systemInfoDTO);
        model.addAttribute("DetailCiudadanoBean", detailCiudadano);
        model.addAttribute("TablePaginationBean", tablePagination);
        model.addAttribute("CiudadanoFilterBean", ciudadanoFilterDto);
        return "pages/ciudadano/showCiudadanoPage";
    }

    @PostMapping("/delete")
    public String deleteCiudadanoRequest(@ModelAttribute Ciudadano ciudadanoInput) {
        logger.info("------- entering -----------");
        logger.info("Entering in method deleteCiudadanoRequest..");
        logger.info("param: " + ciudadanoInput);
        ciudadanoService.eliminarCiudadanoId(ciudadanoInput.getCiudadanoId());
        logger.info("Exiting in method deleteCiudadanoRequest..");
        return "redirect:/ciudadano";
    }

    @PostMapping("/update")
    public String actualizarCiudadanoRequest(@ModelAttribute Ciudadano ciudadanoInput) {
        logger.info("------- entering -----------");
        logger.info("Entering in method actualizarCiudadanoRequest..");
        logger.info("param: " + ciudadanoInput);
        logger.info("Exiting in method deleteCiudadanoRequest..");
        return "redirect:/ciudadano";
    }

    @Override
    protected void init() {
        logger.info("entering init method ");
        logger.info("Generando systemInfoDTO");
        detailCiudadano = new Ciudadano();
        ciudadanoFilterDto = new CiudadanoFilterDto();
        tablePagination = new TablePaginationDto();
        logger.info("systemInfoDTO: " + systemInfoDTO);
        logger.info("existing init method ");
    }

}