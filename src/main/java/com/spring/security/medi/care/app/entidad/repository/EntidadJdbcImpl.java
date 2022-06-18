package com.spring.security.medi.care.app.entidad.repository;

import com.spring.security.medi.care.app.entidad.domain.EntidadType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EntidadJdbcImpl {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EntidadJdbcImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<EntidadType> buscarTodasLasEntidades(){
        String sql = EntidadDaoUtil.FIND_ALL_ENTIDADES;
        return jdbcTemplate.query(sql, new EntidadRowMapper());
    }

    public List<EntidadType> buscarEntidadesSeguroRegimen(Short seguroId, Short regimenId , String texto){
        String sql = EntidadDaoUtil.FIND_SEGURO_REGIMEN_PARAMETERS;
        return jdbcTemplate.query(sql, new EntidadRowMapper(), seguroId, regimenId, texto, texto, texto);
    }

}
