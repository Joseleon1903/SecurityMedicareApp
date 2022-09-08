package com.spring.security.medi.care.app.controller.page;

import com.spring.security.medi.care.app.commons.ViewBaseContext;
import com.spring.security.medi.care.app.controller.dto.SystemInfoDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller ///gestion/usuario
public class GestionUsuarioController extends ViewBaseContext {

    private static final Logger logger = LoggerFactory.getLogger(GestionUsuarioController.class);

    private SystemInfoDTO systemInfoDTO;

    public GestionUsuarioController(){
        super();
    }

    @RequestMapping("/gestion/usuario")
    public String GestionUsuarioPage(Model model){
        logger.info("------- entering -----------");
        logger.info("Entering in method GestionUsuarioPage..");
        model.addAttribute("SystemInfoBean", systemInfoDTO);
        return "pages/usuario/ShowGestionUsuario";
    }


    @Override
    protected void init() {
        logger.info("entering init method ");
        logger.info("Generando systemInfoDTO");
        systemInfoDTO = new SystemInfoDTO("Gestion Usuario",new Date());
        logger.info("SystemInfoDTO: "+ systemInfoDTO);
        logger.info("existing init method ");
    }
}
