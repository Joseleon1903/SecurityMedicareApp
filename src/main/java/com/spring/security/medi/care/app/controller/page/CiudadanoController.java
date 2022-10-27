package com.spring.security.medi.care.app.controller.page;

import com.spring.security.medi.care.app.ciudadano.service.CiudadanoService;
import com.spring.security.medi.care.app.ciudadano.type.CiudadanoDto;
import com.spring.security.medi.care.app.ciudadano.type.CiudadanoPaginated;
import com.spring.security.medi.care.app.commons.DaoUtil;
import com.spring.security.medi.care.app.commons.ViewBaseContext;
import com.spring.security.medi.care.app.commons.domain.Ciudadano;
import com.spring.security.medi.care.app.controller.dto.CiudadanoFilterDto;
import com.spring.security.medi.care.app.controller.dto.SystemInfoDTO;
import com.spring.security.medi.care.app.controller.dto.TablePaginationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
public class CiudadanoController extends ViewBaseContext {

    private final CiudadanoService ciudadanoService;
    private List<CiudadanoDto> ciudadanos;

    private SystemInfoDTO systemInfoDTO;
    private Ciudadano detailCiudadano;
    private CiudadanoFilterDto ciudadanoFilterDto;
    private TablePaginationDto tablePagination;

    @Autowired
    public CiudadanoController(CiudadanoService ciudadanoService) {
        this.ciudadanoService = ciudadanoService;
    }

    @GetMapping("/ciudadano")
    public String showPage(@RequestParam(value = "indexPage", required = false) Integer indexPageInput, Model model) {
        logger.info("------- entering -----------");
        logger.info("Entering in method showPage..");
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
    public String filterCiudadanoPage(@ModelAttribute CiudadanoFilterDto ciudadanoFilterInput, Model model) {
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
        detailCiudadano = ciudadanoService.buscarCiudadanoPorCiudadanoId(ciudadanoId);
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
        systemInfoDTO = new SystemInfoDTO("Ciudadano","Se considera como ciudadano de un Estado a aquella persona que posee derechos civiles y políticos dentro del territorio y es considerado como tal.", LocalDate.now());
        logger.info("systemInfoDTO: " + systemInfoDTO);
        logger.info("existing init method ");
    }

}