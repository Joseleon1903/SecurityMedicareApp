package com.spring.security.medi.care.app.controller.page;

import com.spring.security.medi.care.app.catalogo.service.CatalogoService;
import com.spring.security.medi.care.app.commons.AplicationConstantUtil;
import com.spring.security.medi.care.app.commons.ViewBaseContext;
import com.spring.security.medi.care.app.commons.domain.Contacto;
import com.spring.security.medi.care.app.commons.domain.MotivoEstado;
import com.spring.security.medi.care.app.commons.domain.TipoUsuario;
import com.spring.security.medi.care.app.commons.domain.Usuario;
import com.spring.security.medi.care.app.commons.service.SecurityService;
import com.spring.security.medi.care.app.controller.dto.CreateUserFormData;
import com.spring.security.medi.care.app.controller.dto.ErrorPageDto;
import com.spring.security.medi.care.app.controller.dto.SystemInfoDTO;
import com.spring.security.medi.care.app.usuario.service.TipoUsuarioService;
import com.spring.security.medi.care.app.usuario.service.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class FormularioUsuarioController extends ViewBaseContext {

    private static final Logger logger = LoggerFactory.getLogger(GestionUsuarioController.class);

    private final UsuarioService usuarioService;
    private final TipoUsuarioService tipoUsuarioService;
    private final CatalogoService catalogoService;
    private final SecurityService securityService;

    private SystemInfoDTO systemInfoDTO;
    private CreateUserFormData createUserFormData;

    private List<TipoUsuario> listaTipoUsuario;
    private ErrorPageDto errorPageBean;

    @Autowired
    public FormularioUsuarioController(UsuarioService usuarioService, TipoUsuarioService tipoUsuarioService,
                                       CatalogoService catalogoService,CreateUserFormData createUserFormData,
                                       SecurityService securityService) {
        this.usuarioService = usuarioService;
        this.tipoUsuarioService = tipoUsuarioService;
        this.createUserFormData = createUserFormData;
        this.catalogoService = catalogoService;
        this.securityService = securityService;
    }

    @GetMapping("/formulario/usuario")
    public String showPage(@RequestParam(value = "hasError" ,  required = false) Boolean hasError, Model model) {
        logger.info("------- entering -----------");
        logger.info("Entering in method showPage:{/formulario/usuario}");
        logger.info("Entering validation error : "+ hasError);

        listaTipoUsuario = tipoUsuarioService.buscarTodosTipoUsuario();

        validateError(hasError, model);

        model.addAttribute("SystemInfoBean", systemInfoDTO);
        model.addAttribute("TipoUsuarioListBean", listaTipoUsuario);
        model.addAttribute("CreateUserFormBean", createUserFormData);
        return "pages/usuario/ShowUserForm";
    }

    @PostMapping("/create/usuario")
    public String processForm(@ModelAttribute CreateUserFormData createUserFormDataInput, Model model) {
        logger.info("------- entering -----------");
        logger.info("Entering in method processForm");
        logger.info("param: "+createUserFormDataInput);

        if(!createUserFormDataInput.getPassword().equals(createUserFormDataInput.getConfirmPassword())){
            logger.info("Error PASSWORD_DE_CONFIRMACION_DIFERENTES");
            logger.info("ABORT REGISTRATION");
            MotivoEstado mot = catalogoService.buscarMotivoPorId(AplicationConstantUtil.PASSWORD_DE_CONFIRMACION_DIFERENTES);
            this.errorPageBean = new ErrorPageDto(mot.getMotivoId(), mot.getDescripcion(), true);
            this.createUserFormData = createUserFormDataInput;
            return "redirect:/formulario/usuario?hasError=true";
        }

        if(createUserFormDataInput.getUsername().isEmpty() || createUserFormDataInput.getCorreoprimario().isEmpty()
                || createUserFormDataInput.getTipoUsuarioId().equals(0L)){
            logger.info("Error EXISTEN_DATOS_REQUERIDO_FORMULARIO_USUAARIO");
            logger.info("ABORT REGISTRATION");
            MotivoEstado mot = catalogoService.buscarMotivoPorId(AplicationConstantUtil.EXISTEN_DATOS_REQUERIDO_FORMULARIO_USUAARIO);
            this.errorPageBean = new ErrorPageDto(mot.getMotivoId(), mot.getDescripcion(), true);
            this.createUserFormData = createUserFormDataInput;
            return "redirect:/formulario/usuario?hasError=true";
        }

        TipoUsuario tipo = tipoUsuarioService.buscarTipoUsuarioPorId(createUserFormDataInput.getTipoUsuarioId());

        Usuario user = new Usuario();
        Contacto cont = new Contacto();
        cont.setDescripcion(createUserFormDataInput.getDetalle());
        cont.setEstado("AC");
        cont.setFechaCreacion(new Date());
        cont.setFechaUltimoCambio(new Date());
        cont.setPosicion(createUserFormDataInput.getPosicion());
        cont.setCorreoPrimario(createUserFormDataInput.getCorreoprimario());

        String llaveEncript = securityService.hash256String(createUserFormDataInput.getPassword());

        user.setCodigo(createUserFormDataInput.getUsername());
        user.setLlaveEncriptacion(llaveEncript);
        user.setFechaUltimoCambio(new Date());
        user.setEstado("AC");
        user.setContactoId(cont);
        user.setTipoUsuarioId(tipo);
        try{
            logger.info("empezando registracion usuario");
            logger.info("usuario: "+ user);
            usuarioService.saveOrUpdateUser(user);
        }catch (Exception exception){
            logger.info("Error "+exception.getMessage());
            logger.error("Internal Server Error", exception);
            MotivoEstado mot = catalogoService.buscarMotivoPorId(AplicationConstantUtil.GENERAL_ERROR_INTERNO);
            this.errorPageBean = new ErrorPageDto(mot.getMotivoId(), mot.getDescripcion(), true);
            this.createUserFormData = createUserFormDataInput;
            return "redirect:/formulario/usuario?hasError=true";
        }
        return "redirect:/gestion/usuario";
    }

    private void validateError(Boolean hasError, Model model ){
        if(hasError == null || !hasError){
            model.addAttribute("ErrorPageBean", new ErrorPageDto());
//            this.createUserFormData.clear();
        }else{
            model.addAttribute("ErrorPageBean",this.errorPageBean );
        }
    }


    @Override
    protected void init() {
        logger.info("entering init method ");
        logger.info("Generando systemInfoDTO");
        systemInfoDTO = new SystemInfoDTO("Registrar Usuario","Regístrate con nosotros, Si te registras con nosotros, estarás recibiendo periódicamente noticias de la comunidad.", new Date());
        logger.info("systemInfoDTO: " + systemInfoDTO);
        logger.info("existing init method ");
    }
}
