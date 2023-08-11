package com.spring.security.medi.care.app.controller.page;

import com.spring.security.medi.care.app.catalogo.service.CatalogoService;
import com.spring.security.medi.care.app.commons.AplicationConstantUtil;
import com.spring.security.medi.care.app.commons.ApplicationUtil;
import com.spring.security.medi.care.app.commons.ViewBaseContext;
import com.spring.security.medi.care.app.commons.domain.*;
import com.spring.security.medi.care.app.commons.exception.InternalServerException;
import com.spring.security.medi.care.app.commons.exception.InvalidFormatException;
import com.spring.security.medi.care.app.commons.exception.ResourceAlreadyExistException;
import com.spring.security.medi.care.app.commons.service.ApplicationMessageUtil;
import com.spring.security.medi.care.app.commons.service.SecurityService;
import com.spring.security.medi.care.app.controller.dto.CreateUserFormData;
import com.spring.security.medi.care.app.controller.dto.ErrorPageDto;
import com.spring.security.medi.care.app.controller.dto.SystemInfoDTO;
import com.spring.security.medi.care.app.file.service.FileService;
import com.spring.security.medi.care.app.usuario.service.TipoUsuarioService;
import com.spring.security.medi.care.app.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class FormularioUsuarioController extends ViewBaseContext {

    private final MessageSource messageSource;
    private final LocaleResolver localeResolver;
    public ApplicationMessageUtil applicationMessageUtil;

    private final UsuarioService usuarioService;
    private final TipoUsuarioService tipoUsuarioService;
    private final CatalogoService catalogoService;
    private final SecurityService securityService;
    private final FileService fileService;
    private final PasswordEncoder passwordEncoder;

    private SystemInfoDTO systemInfoDTO;
    private CreateUserFormData createUserFormData;
    private ErrorPageDto errorPageBean;

    private List<TipoUsuario> listaTipoUsuario;

    private String defaultProfilePicture = ApplicationUtil.DEFAULT_PROFILE_IMAGE;

    @Autowired
    public FormularioUsuarioController(UsuarioService usuarioService, TipoUsuarioService tipoUsuarioService,
                                       CatalogoService catalogoService,SecurityService securityService, FileService fileService,
                                       PasswordEncoder passwordEncoder, MessageSource messageSource,LocaleResolver localeResolver) {
        this.usuarioService = usuarioService;
        this.tipoUsuarioService = tipoUsuarioService;
        this.catalogoService = catalogoService;
        this.securityService = securityService;
        this.fileService = fileService;
        this.passwordEncoder = passwordEncoder;
        this.messageSource = messageSource;
        this.localeResolver = localeResolver;
    }

    @GetMapping("/formulario/usuario")
    public String showPage(@RequestParam(value = "hasError" ,  required = false) Boolean hasError, Model model, HttpServletRequest request) {
        logger.info("------- entering -----------");
        logger.info("Entering in method showPage:{/formulario/usuario}");

        applicationMessageUtil =  new ApplicationMessageUtil(messageSource,localeResolver, request );
        systemInfoDTO = new SystemInfoDTO(applicationMessageUtil.getMessage("page.controller.form.usuario.create.title"),
                applicationMessageUtil.getMessage("page.controller.form.usuario.create.sub.title"), LocalDate.now());

        logger.info("Entering validation error : "+ hasError);

        listaTipoUsuario = tipoUsuarioService.buscarTodosTipoUsuario();
        logger.info("listaTipoUsuario "+ listaTipoUsuario);


        validateError(hasError, model);

        model.addAttribute("SystemInfoBean", systemInfoDTO);
        model.addAttribute("TipoUsuarioListBean", listaTipoUsuario);
        model.addAttribute("CreateUserFormBean", createUserFormData);
        model.addAttribute("ProfilePictureBean", defaultProfilePicture);
        return "pages/usuario/ShowUserForm";
    }

    @PostMapping("/create/usuario")
    public String processForm(@ModelAttribute CreateUserFormData createUserFormDataInput, BindingResult bindingResult, Model model) {
        logger.info("------- entering -----------");
        logger.info("Entering in method processForm");
        logger.info("param: "+createUserFormDataInput);

        logger.info("bindingResult: "+ bindingResult.hasErrors());

        if(!createUserFormDataInput.getPassword().equals(createUserFormDataInput.getConfirmPassword())){
            logger.info("Error PASSWORD_DE_CONFIRMACION_DIFERENTES");
            logger.info("ABORT REGISTRATION");
            MotivoEstado mot = catalogoService.buscarMotivoPorId(AplicationConstantUtil.PASSWORD_DE_CONFIRMACION_DIFERENTES).get();
            this.errorPageBean = new ErrorPageDto(mot.getMotivoId(), mot.getDescripcion(), true);
            this.createUserFormData = createUserFormDataInput;
            return "redirect:/formulario/usuario?hasError=true";
        }

        if(createUserFormDataInput.getUsername().isEmpty() || createUserFormDataInput.getCorreoprimario().isEmpty()
                || createUserFormDataInput.getTipoUsuarioId().equals(0L) || bindingResult.hasErrors()){
            logger.info("Error EXISTEN_DATOS_REQUERIDO_FORMULARIO_USUAARIO");
            logger.info("ABORT REGISTRATION");
            MotivoEstado mot = catalogoService.buscarMotivoPorId(AplicationConstantUtil.EXISTEN_DATOS_REQUERIDO_FORMULARIO_USUAARIO).get();
            this.errorPageBean = new ErrorPageDto(mot.getMotivoId(), mot.getDescripcion(), true);
            this.createUserFormData = createUserFormDataInput;
            return "redirect:/formulario/usuario?hasError=true";
        }

        TipoUsuario tipo = tipoUsuarioService.buscarTipoUsuarioPorId(createUserFormDataInput.getTipoUsuarioId());

        Usuario user = new Usuario();
        Contacto cont = new Contacto();
        cont.setDescripcion(createUserFormDataInput.getDetalle());
        cont.setEstado("AC");
        cont.setFechaCreacion(LocalDateTime.now());
        cont.setFechaUltimoCambio(LocalDateTime.now());
        cont.setPosicion(createUserFormDataInput.getPosicion());
        cont.setCorreoPrimario(createUserFormDataInput.getCorreoprimario());
        logger.info("iniciando encriptacion clave..");
        String llaveEncript = passwordEncoder.encode(createUserFormDataInput.getPassword());
        logger.info("terminado encriptacion clave..");

        user.setCodigo(createUserFormDataInput.getUsername());
        user.setLlaveEncriptacion(llaveEncript);
        user.setFechaUltimoCambio(LocalDateTime.now());
        user.setEstado("AC");
        user.setContactoId(cont);
        user.setTipoUsuarioId(tipo);
        user.setProfilePicture(defaultProfilePicture);
        try{
            logger.info("empezando registracion usuario");
            logger.info("usuario: "+ user);
            usuarioService.saveOrUpdateUser(user);
        }catch (Exception exception){
            logger.info("Error "+exception.getMessage());
            logger.error("Internal Server Error", exception);
            MotivoEstado mot = catalogoService.buscarMotivoPorId(AplicationConstantUtil.GENERAL_ERROR_INTERNO).get();
            this.errorPageBean = new ErrorPageDto(mot.getMotivoId(), mot.getDescripcion(), true);
            this.createUserFormData = createUserFormDataInput;
            return "redirect:/formulario/usuario?hasError=true";
        }
        this.defaultProfilePicture = ApplicationUtil.DEFAULT_PROFILE_IMAGE;
        return "redirect:/gestion/usuario";
    }

    @PostMapping("/upload/picture")
    public String uploadProfilePicture(@RequestParam("file") MultipartFile file) {
        logger.info("Entering in uploadProfilePicture");
        logger.info("param : "+file.getOriginalFilename());
        logger.info("param : "+file.getContentType());

        if(!file.getContentType().contains("png") && !file.getContentType().contains("jpeg")){
            throw new InvalidFormatException("Invalid format file");
        }

        ImagedStored img = null;
        try {
            img = fileService.createImage(file);
        } catch (ResourceAlreadyExistException | InternalServerException e) {
            logger.info("Error "+e.getMessage());
            logger.error("Internal Server Error", e);
            MotivoEstado mot = catalogoService.buscarMotivoPorId(AplicationConstantUtil.GENERAL_ERROR_INTERNO).get();
            this.errorPageBean = new ErrorPageDto(mot.getMotivoId(), mot.getDescripcion(), true);
            return "redirect:/formulario/usuario?hasError=true";
        }
        defaultProfilePicture = img.getFileViewUri();
        return "redirect:/formulario/usuario";
    }

    private void validateError(Boolean hasError, Model model ){
        if(hasError == null || !hasError){
            model.addAttribute("ErrorPageBean", new ErrorPageDto());
        }else{
            model.addAttribute("ErrorPageBean",this.errorPageBean );
        }
    }

    @Override
    protected void init() {
        logger.info("entering init method ");
        logger.info("Generando systemInfoDTO");
        createUserFormData = new CreateUserFormData();
        errorPageBean= new ErrorPageDto();
        systemInfoDTO = new SystemInfoDTO("Registrar Usuario","Regístrate con nosotros, Si te registras con nosotros, estarás recibiendo periódicamente noticias de la comunidad.", LocalDate.now());
        logger.info("systemInfoDTO: " + systemInfoDTO);
        logger.info("existing init method ");
    }
}