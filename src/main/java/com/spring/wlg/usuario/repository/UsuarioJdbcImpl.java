package com.spring.wlg.usuario.repository;

import com.spring.wlg.usuario.domain.UnipagoUsuario;
import com.spring.wlg.usuario.domain.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsuarioJdbcImpl {


    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final JdbcTemplate jdbcTemplate;


    @Autowired
    public UsuarioJdbcImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Usuario> buscarUsuarios(){
        String sql = DaoUtil.FIND_ALL_USERS_QUERY;
        return jdbcTemplate.query(sql, new UsuarioRowMapper());
    }

    public List<UnipagoUsuario> buscarUsuariosPorCodigo(String codigo){
        String sql = DaoUtil.FIND_USERS_BY_CODE_QUERY;
        return jdbcTemplate.query(sql, new UnipagoUsuarioRowMapper(), codigo);
    }

}
