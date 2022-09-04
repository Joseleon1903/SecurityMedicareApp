package com.spring.security.medi.care.app.controller.page;

import com.spring.security.medi.care.app.controller.dto.SystemInfoDTO;
import com.spring.security.medi.care.app.controller.dto.UsuarioFormDTO;
import com.spring.security.medi.care.app.usuario.service.UsuarioService;
import com.spring.security.medi.care.app.usuario.types.UnipagoUsuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
public class UsuarioController {

    Logger logger = LoggerFactory.getLogger(HomeControllerPage.class);

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    private SystemInfoDTO systemInfoDTO;

    private UsuarioFormDTO usuarioFormDTO;

    private List<UnipagoUsuario> usuarioUnipagoList;


    @RequestMapping("/usuario")
    public String usuarioPage(Model model){
        logger.info("------- entering -----------");
        logger.info("Entering in method usuarioPage..");
        logger.info("Generando systemInfoDTO");
        systemInfoDTO = new SystemInfoDTO("Unipago Usuario Sistema ",new Date());
        logger.info("systemInfoDTO: "+ systemInfoDTO);
        model.addAttribute("UsuarioFormBean", new UsuarioFormDTO());
        model.addAttribute("SystemInfoBean", systemInfoDTO);
        usuarioUnipagoList =  usuarioService.buscarusuariosSistemaporCodigo("");
        model.addAttribute("UsuarioUnipagoList", usuarioUnipagoList);
        return "pages/usuario/UsuarioPage";
    }

    @PostMapping("/search")
    public String buscarUsuarioPage(@ModelAttribute UsuarioFormDTO usuarioFormDTO, Model model){
        logger.info("------- entering -----------");
        logger.info("Entering in method buscarUsuarioPage..");
        logger.info("Generando systemInfoDTO");
        systemInfoDTO = new SystemInfoDTO("Unipago Usuario Sistema ",new Date());
        logger.info("systemInfoDTO: "+ systemInfoDTO);
        logger.info("Form values : "+usuarioFormDTO);
        usuarioUnipagoList = usuarioService.buscarusuariosSistemaporCodigo(usuarioFormDTO.getCodigo());
        logger.info("usuario list size :  "+usuarioUnipagoList.size());
        model.addAttribute("UsuarioUnipagoList", usuarioUnipagoList);
        model.addAttribute("UsuarioFormBean", new UsuarioFormDTO());
        model.addAttribute("SystemInfoBean", systemInfoDTO);
        return "pages/usuario/UsuarioPage";
    }

}
