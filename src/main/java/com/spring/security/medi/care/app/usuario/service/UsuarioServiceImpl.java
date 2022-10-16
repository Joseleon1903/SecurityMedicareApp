package com.spring.security.medi.care.app.usuario.service;

import com.spring.security.medi.care.app.commons.DaoUtil;
import com.spring.security.medi.care.app.commons.PaginationOutput;
import com.spring.security.medi.care.app.commons.domain.Usuario;
import com.spring.security.medi.care.app.controller.dto.UsuarioDto;
import com.spring.security.medi.care.app.usuario.repository.jdbc.UsuarioJdbcImpl;
import com.spring.security.medi.care.app.usuario.repository.jpa.UsuarioJpaRepo;
import com.spring.security.medi.care.app.usuario.types.PaginatedUsuario;
import com.spring.security.medi.care.app.usuario.types.UnipagoUsuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class UsuarioServiceImpl implements  UsuarioService{

    private static final Logger logger = LoggerFactory.getLogger(UsuarioService.class);

    private final UsuarioJdbcImpl usuarioJdbc;

    private final UsuarioJpaRepo usuarioJpaRepo;

    @Autowired
    public UsuarioServiceImpl(UsuarioJdbcImpl usuarioJdbc, UsuarioJpaRepo usuarioJpaRepo) {
        this.usuarioJdbc = usuarioJdbc;
        this.usuarioJpaRepo =usuarioJpaRepo;
    }

    @Override
    public List<Usuario> buscarusuariosSistema() {
        return null;
    }

    @Override
    public List<UnipagoUsuario> buscarUsuariosSistemaporCodigo(String codigo) {
        return usuarioJdbc.buscarUsuariosPorCodigo(codigo);
    }

    @Override
    public List<Usuario> buscarUsuariosSistemaJpa(){
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(usuarioJpaRepo.findAll().iterator(), Spliterator.ORDERED), false)
                .collect(Collectors.toList());
    }

    @Override
    public Usuario buscarUsuariosSistemaporCodigoJpa(String codigo){
        return usuarioJpaRepo.findByCodigoIgnoreCase(codigo.toUpperCase());
    }

    @Override
    public Usuario buscarUsuariosSistemaPorEmailJpa(String email) {
        return usuarioJpaRepo.findByEmail(email.toLowerCase());

    }

    @Override
    public Usuario saveOrUpdateUser(Usuario user){
        return usuarioJpaRepo.save(user);
    }

    @Override
    public void deleteUsuarioById(Long userId) {
        usuarioJpaRepo.deleteById(userId);
    }

    @Override
    public Usuario buscarUsuarioPorId(Long id){
        return usuarioJpaRepo.findByUsuarioId(id);
    }

    @Override
    public PaginatedUsuario buscarUsuariosPorParametros(Long usuarioId, String codigo, String estado, int page, int size) {
        logger.info("Entering in method buscarUsuariosSistemaporCodigo");
        codigo = (codigo != null && !codigo.isEmpty())? "%"+codigo+"%": null;
        estado = (estado != null && !estado.isEmpty())? "%"+estado.toUpperCase()+"%": null;
        Pageable paging = PageRequest.of(page, size);
        logger.info("param page: "+page );
        logger.info("param size : "+size );
        logger.info("param codigo: "+codigo );
        logger.info("param estado: "+estado );
        logger.info("param usuarioId: "+usuarioId );
        Page<Usuario> listado = usuarioJpaRepo.findByParameters(usuarioId, codigo, estado ,paging );
        logger.info("listado count : "+listado.toList().size() );
        PaginationOutput pageOut = new PaginationOutput();
        pageOut.setPageIndex(page);
        pageOut.setTotalPages(listado.getTotalPages());
        pageOut.setRowSize(size);
        page = (page == 0)? 1: page;
        pageOut.setTotalRowCount(DaoUtil.getRegistrosRestantes(listado.getTotalElements(), page, size));
        List<UsuarioDto> usuariosDtos = new ArrayList<>();
        for (Usuario us: listado) {
            usuariosDtos.add(new UsuarioDto(us.getUsuarioId(), us.getCodigo(),us.getTipoUsuarioId().getDescripcion(),
                    us.getContactoId().getCorreoPrimario(), us.getFechaUltimoCambio(), us.getEstado()));
        }
        PaginatedUsuario paginated = new PaginatedUsuario(usuariosDtos, pageOut);
        return paginated;
    }

}
