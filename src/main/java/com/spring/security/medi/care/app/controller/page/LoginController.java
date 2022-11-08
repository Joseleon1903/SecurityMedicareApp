package com.spring.security.medi.care.app.controller.page;

import com.spring.security.medi.care.app.controller.dto.SystemInfoDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.time.LocalDate;

@Controller
public class LoginController {

    protected static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    public LoginController(){
        super();
    }

    @RequestMapping("/login")
    public String loginPage(@AuthenticationPrincipal UserDetails userDetails, Model model){
        logger.info("------- entering -----------");
        logger.info("Entering in method loginPage..");
        model.addAttribute("SystemInfoBean", new SystemInfoDTO("Login", LocalDate.now()));
        if (userDetails == null) {
            return "pages/login";
        } else {
            return "redirect:/";
        }
    }
}
