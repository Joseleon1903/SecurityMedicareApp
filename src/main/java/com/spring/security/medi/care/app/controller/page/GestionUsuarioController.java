package com.spring.security.medi.care.app.controller.page;

import com.spring.security.medi.care.app.commons.DaoUtil;
import com.spring.security.medi.care.app.commons.ViewBaseContext;
import com.spring.security.medi.care.app.commons.domain.Usuario;
import com.spring.security.medi.care.app.commons.service.ApplicationMessageUtil;
import com.spring.security.medi.care.app.controller.dto.GestionUsuarioStatisticDTO;
import com.spring.security.medi.care.app.controller.dto.SystemInfoDTO;
import com.spring.security.medi.care.app.controller.dto.TablePaginationDto;
import com.spring.security.medi.care.app.controller.dto.UsuarioInfoDto;
import com.spring.security.medi.care.app.usuario.service.UsuarioService;
import com.spring.security.medi.care.app.usuario.types.PaginatedUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.time.LocalDate;

@Controller
public class GestionUsuarioController extends ViewBaseContext {

    private final MessageSource messageSource;
    private final LocaleResolver localeResolver;
    public ApplicationMessageUtil applicationMessageUtil;

    private final UsuarioService usuarioService;
    private SystemInfoDTO systemInfoDTO;
    private PaginatedUsuario paginatedUsuario;
    private UsuarioInfoDto usuarioInfoDto;
    private TablePaginationDto tablePagination;
    private GestionUsuarioStatisticDTO gestionUsuarioStatisticDTO;


    private String usarnametest= "Administrador";
    private String defaultProfilePicture = "../assets/img/app/unknown-user-Image.png";


    @Autowired
    public GestionUsuarioController(UsuarioService usuarioService, MessageSource messageSource,
                                    LocaleResolver localeResolver){
        this.usuarioService = usuarioService;
        this.messageSource = messageSource;
        this.localeResolver = localeResolver;
    }

    @RequestMapping("/gestion/usuario")
    public String GestionUsuarioPage(@RequestParam(value = "indexPage", required = false) Integer indexPageInput,
                                     Model model, Principal principal, HttpServletRequest request){
        logger.info("------- entering -----------");
        logger.info("Entering in method GestionUsuarioPage..");

        applicationMessageUtil =  new ApplicationMessageUtil(messageSource,localeResolver, request );
        systemInfoDTO = new SystemInfoDTO(applicationMessageUtil.getMessage("page.controller.usuario.gestion.title"),
                applicationMessageUtil.getMessage("page.controller.usuario.gestion.sub.title"), LocalDate.now());

        logger.info("nombre usuario : "+principal.getName());
        usarnametest = principal.getName();
        usuarioService.buscarUsuariosSistemaporCodigoJpa(usarnametest).ifPresent( user ->{
            this.usuarioInfoDto = new UsuarioInfoDto(user);
        });

        logger.info("validando paginacion");
        if (indexPageInput != null && (this.tablePagination.getPaginationIndex() + indexPageInput) > -1) {
            int result = this.tablePagination.getPaginationIndex() + indexPageInput;
            logger.info("Current page : " + result);
            this.tablePagination.setPaginationIndex(result);
        }
        logger.info("terminado validar  paginacion");

        logger.info("iniciando busqueda ususario");
        paginatedUsuario =usuarioService.buscarUsuariosPorParametros(null, null, null, tablePagination.getPaginationIndex(), DaoUtil.DEFAULT_ROW_COUNT);
        this.tablePagination.setPaginationIndex(paginatedUsuario.getPagination().getPageIndex());
        this.tablePagination.setRemainCount(paginatedUsuario.getPagination().getTotalRowCount());
        logger.info("terminando busqueda ususario");

        logger.info("iniciando buscar statistic");
        usuarioService.getSystemUserStatistic().ifPresent( stat ->{
            this.gestionUsuarioStatisticDTO = stat;
        });
        logger.info("terminando buscar statistic");

        model.addAttribute("PaginatedUsuarioBean", paginatedUsuario);
        model.addAttribute("TablePaginationBean", tablePagination);
        model.addAttribute("SystemInfoBean", systemInfoDTO);
        model.addAttribute("UsuarioBean", usuarioInfoDto);
        model.addAttribute("GestionUsuarioStatisticBean", gestionUsuarioStatisticDTO);

        return "pages/usuario/ShowGestionUsuario";
    }

    @DeleteMapping("/delete/{id}")
    public String doDeleteUser(@PathVariable("id") Long userId, RedirectAttributes redirectAttributes) {
        usuarioService.deleteUsuarioById(userId);
        redirectAttributes.addFlashAttribute("deletedUserName", usarnametest);
        return "redirect:/gestion/usuario";
    }

    @Override
    protected void init() {
        logger.info("entering init method ");
        logger.info("Generando systemInfoDTO");
        paginatedUsuario = new PaginatedUsuario();
        usuarioInfoDto = new UsuarioInfoDto();
        tablePagination= new TablePaginationDto();
        systemInfoDTO = new SystemInfoDTO("Gestion Usuario", LocalDate.now());
        logger.info("SystemInfoDTO: "+ systemInfoDTO);
        logger.info("existing init method ");
    }
}
