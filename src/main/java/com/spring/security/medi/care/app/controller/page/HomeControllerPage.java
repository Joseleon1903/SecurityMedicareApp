package com.spring.security.medi.care.app.controller.page;

import com.spring.security.medi.care.app.commons.ViewBaseContext;
import com.spring.security.medi.care.app.controller.dto.SystemInfoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.time.LocalDate;
import java.util.Date;

@Controller
public class HomeControllerPage extends ViewBaseContext {

    private SystemInfoDTO systemInfoDTO;


    public HomeControllerPage(){
        super();
    }

    @RequestMapping({"/home", "/"})
    public String homePage(Model model, Principal principal){
        logger.info("------- entering -----------");
        logger.info("Entering in method homePage..");
        model.addAttribute("SystemInfoBean", systemInfoDTO);
        return "pages/home/HomePage";
    }

    @Override
    protected void init() {
        logger.info("entering init method ");
        logger.info("Generando systemInfoDTO");
        systemInfoDTO = new SystemInfoDTO("Home Page", LocalDate.now());
        logger.info("systemInfoDTO: "+ systemInfoDTO);
        logger.info("existing init method ");
    }
}
