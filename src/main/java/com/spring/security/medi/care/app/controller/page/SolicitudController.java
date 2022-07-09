package com.spring.security.medi.care.app.controller.page;

import com.spring.security.medi.care.app.commons.ViewBaseContext;
import com.spring.security.medi.care.app.controller.dto.SystemInfoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class SolicitudController extends ViewBaseContext {

    private SystemInfoDTO systemInfoDTO;

    public SolicitudController(){
        super();
    }

    @RequestMapping("/solicitud")
    public String solicituPage(Model model){
        logger.info("------- entering -----------");
        logger.info("Entering in method solicituPage..");
        model.addAttribute("SystemInfoBean", systemInfoDTO);
        return "pages/solicitud/show";
    }

    @Override
    protected void init() {
        logger.info("entering init method ");
        logger.info("Generando systemInfoDTO");
        systemInfoDTO = new SystemInfoDTO("Solicitudes",new Date());
        logger.info("systemInfoDTO: "+ systemInfoDTO);
        logger.info("existing init method ");
    }
}
