package com.spring.security.medi.care.app.catalogo.repository;

import com.spring.security.medi.care.app.catalogo.domain.Nacionalidad;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NacionalidadJdbcImpl {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public NacionalidadJdbcImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Nacionalidad> buscarCatalogoNacionalidad(String paisId, String nombrePais, int rowCount){
        String sql = CatalogoDaoUtil.FIND_CATALOGO_NACIONALIDAD;
        if(paisId != null ) {
            paisId.trim();
            paisId = '%'+paisId+'%';
        }
        if(nombrePais != null ) {
            nombrePais.trim();
            nombrePais = '%'+nombrePais+'%';
        }
        return jdbcTemplate.query(sql, new NacionalidadRowMapper(), paisId,paisId, nombrePais, nombrePais, rowCount);
    }

}
