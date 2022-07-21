package com.spring.security.medi.care.app.controller.page;

import com.spring.security.medi.care.app.ciudadano.service.CiudadanoService;
import com.spring.security.medi.care.app.commons.ViewBaseContext;
import com.spring.security.medi.care.app.commons.domain.Ciudadano;
import com.spring.security.medi.care.app.controller.dto.SystemInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Date;
import java.util.List;

@Controller
public class CiudadanoController extends ViewBaseContext {


    private SystemInfoDTO systemInfoDTO;

    private final CiudadanoService ciudadanoService;

    private List<Ciudadano> ciudadanos;

    private Ciudadano detailCiudadano = new Ciudadano();

    @Autowired
    public CiudadanoController(CiudadanoService ciudadanoService){
        this.ciudadanoService = ciudadanoService;
    }

    @GetMapping("/ciudadano")
    public String showPage(Model model){
        logger.info("------- entering -----------");
        logger.info("Entering in method showPage..");

        logger.info("buscando ciudadanos ...");
        ciudadanos = ciudadanoService.buscarTodosCiudadanos();
        logger.info("terminando buscando ciudadanos size:"+ ciudadanos.size());

        model.addAttribute("CiudadanosList", ciudadanos);
        model.addAttribute("SystemInfoBean", systemInfoDTO);
        model.addAttribute("DetailCiudadanoBean", detailCiudadano);

        return "pages/ciudadano/show";
    }

    @GetMapping("/ciudadano/{ciudadanoId}")
    public String updateDetailCiudadanoPage(@PathVariable("ciudadanoId") Long ciudadanoId, Model model){
        logger.info("------- entering -----------");
        logger.info("Entering in method updateDetailCiudadanoPage..");
        logger.info("param detalle ciudadanoId = "+ ciudadanoId);

        logger.info("buscando ciudadanos ...");
        this.detailCiudadano = ciudadanoService.buscarCiudadanoPorCiudadanoId(ciudadanoId);
        logger.info("terminando buscando ciudadanos:"+ detailCiudadano);

        model.addAttribute("CiudadanosList", ciudadanos);
        model.addAttribute("SystemInfoBean", systemInfoDTO);
        model.addAttribute("DetailCiudadanoBean", detailCiudadano);
        return "pages/ciudadano/show";
    }

    @PostMapping("/delete")
    public String deleteCiudadanoRequest(@ModelAttribute Ciudadano ciudadanoInput){
        logger.info("------- entering -----------");
        logger.info("Entering in method deleteCiudadanoRequest..");
        logger.info("param: "+ ciudadanoInput);
        ciudadanoService.eliminarCiudadanoId(ciudadanoInput.getCiudadanoId());
        logger.info("Exiting in method deleteCiudadanoRequest..");
        return "redirect:/ciudadano";
    }

    @Override
    protected void init() {
        logger.info("entering init method ");
        logger.info("Generando systemInfoDTO");
        systemInfoDTO = new SystemInfoDTO("Ciudadano",new Date());
        logger.info("systemInfoDTO: "+ systemInfoDTO);
        logger.info("existing init method ");
    }


}