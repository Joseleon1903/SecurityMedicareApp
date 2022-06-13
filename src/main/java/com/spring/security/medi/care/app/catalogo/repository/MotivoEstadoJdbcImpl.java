package com.spring.security.medi.care.app.catalogo.repository;

import com.spring.security.medi.care.app.catalogo.domain.MotivoEstado;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MotivoEstadoJdbcImpl {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MotivoEstadoJdbcImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<MotivoEstado> buscarCatalogoMotivoEstado(Long motivoId, String descripcion, int rowCount){
        String sql = CatalogoDaoUtil.FIND_CATALOGO_MOTIVO_ESTADO;
        if(descripcion != null ) {
            descripcion.trim();
        }
        return jdbcTemplate.query(sql, new MotivoEstadoRowMapper(), motivoId,motivoId, descripcion, descripcion, rowCount);
    }

}