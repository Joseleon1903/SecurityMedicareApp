package com.spring.security.medi.care.app.controller.page;

import com.spring.security.medi.care.app.commons.DaoUtil;
import com.spring.security.medi.care.app.commons.ViewBaseContext;
import com.spring.security.medi.care.app.commons.domain.Usuario;
import com.spring.security.medi.care.app.controller.dto.SystemInfoDTO;
import com.spring.security.medi.care.app.controller.dto.TablePaginationDto;
import com.spring.security.medi.care.app.controller.dto.UsuarioInfoDto;
import com.spring.security.medi.care.app.usuario.service.UsuarioService;
import com.spring.security.medi.care.app.usuario.types.PaginatedUsuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.security.Principal;
import java.util.Date;

@Controller
public class GestionUsuarioController extends ViewBaseContext {

    private static final Logger logger = LoggerFactory.getLogger(GestionUsuarioController.class);

    private SystemInfoDTO systemInfoDTO;
    private final UsuarioService usuarioService;

    private PaginatedUsuario paginatedUsuario;
    private UsuarioInfoDto usuarioInfoDto;

    private final TablePaginationDto tablePagination;

    private String usarnametest= "Administrador";


    @Autowired
    public GestionUsuarioController(UsuarioService usuarioService, TablePaginationDto tablePagination, UsuarioInfoDto usuarioInfoDto){
        this.usuarioService = usuarioService;
        this.tablePagination =tablePagination;
        this.usuarioInfoDto = usuarioInfoDto;
    }

    @RequestMapping("/gestion/usuario")
    public String GestionUsuarioPage(@RequestParam(value = "indexPage", required = false) Integer indexPageInput, Model model, Principal principal){
        logger.info("------- entering -----------");
        logger.info("Entering in method GestionUsuarioPage..");
        logger.info("nombre usuario : "+usarnametest);

        Usuario user = usuarioService.buscarUsuariosSistemaporCodigoJpa(usarnametest);
        this.usuarioInfoDto = new UsuarioInfoDto(user);

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

        model.addAttribute("PaginatedUsuarioBean", paginatedUsuario);
        model.addAttribute("TablePaginationBean", tablePagination);
        model.addAttribute("SystemInfoBean", systemInfoDTO);
        model.addAttribute("UsuarioBean", usuarioInfoDto);
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
