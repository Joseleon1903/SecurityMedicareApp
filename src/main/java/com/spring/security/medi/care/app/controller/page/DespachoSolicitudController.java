package com.spring.security.medi.care.app.controller.page;

import com.spring.security.medi.care.app.commons.ViewBaseContext;
import com.spring.security.medi.care.app.controller.dto.SystemInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Date;


@Controller
public class DespachoSolicitudController extends ViewBaseContext {

    private SystemInfoDTO systemInfoDTO;

    @Autowired
    public DespachoSolicitudController(){
    }

    @GetMapping("/despacho")
    public String showPage(Model model){
        logger.info("------- entering -----------");
        logger.info("Entering in method showPage:{/despacho}");

        model.addAttribute("SystemInfoBean", systemInfoDTO);
        return "pages/despacho/show";
    }

    @Override
    protected void init() {
        logger.info("entering init method ");
        logger.info("Generando systemInfoDTO");
        systemInfoDTO = new SystemInfoDTO("Despacho solicitudes",new Date());
        logger.info("systemInfoDTO: "+ systemInfoDTO);
        logger.info("existing init method ");
    }

}