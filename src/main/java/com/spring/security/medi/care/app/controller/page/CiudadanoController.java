package com.spring.security.medi.care.app.controller.page;

import com.spring.security.medi.care.app.ciudadano.service.CiudadanoService;
import com.spring.security.medi.care.app.commons.ViewBaseContext;
import com.spring.security.medi.care.app.commons.domain.Ciudadano;
import com.spring.security.medi.care.app.controller.dto.SystemInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Date;
import java.util.List;

@Controller
public class CiudadanoController extends ViewBaseContext {


    private SystemInfoDTO systemInfoDTO;

    private final CiudadanoService ciudadanoService;

    private List<Ciudadano> ciudadanos;

    @Autowired
    public CiudadanoController(CiudadanoService ciudadanoService){
        this.ciudadanoService = ciudadanoService;
    }

    @RequestMapping("/ciudadano")
    public String showPage(Model model){
        logger.info("------- entering -----------");
        logger.info("Entering in method showPage..");

        logger.info("buscando ciudadanos ...");
        ciudadanos = ciudadanoService.buscarTodosCiudadanos();
        logger.info("terminando buscando ciudadanos size:"+ ciudadanos.size());

        model.addAttribute("CiudadanosList", ciudadanos);
        model.addAttribute("SystemInfoBean", systemInfoDTO);
        return "pages/ciudadano/show";
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
