package com.spring.security.medi.care.app.solicitud.dependiente.repository.jdbc;

import com.spring.security.medi.care.app.solicitud.dependiente.repository.AfiDependienteUtil;
import com.spring.security.medi.care.app.solicitud.dependiente.types.SolicitudDependiente;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AfiDependienteJdbcImpl {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AfiDependienteJdbcImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<SolicitudDependiente> buscarDependientePorInfoTitular(Long solicitudAfiTitular , String estado, String tipoDependiente){
        String sql = AfiDependienteUtil.FIND_DEPENTIENTES_POR_TITULAR_QUERY;
        return jdbcTemplate.query(sql, new AfiDependienteRowMapper(), solicitudAfiTitular, estado,estado, tipoDependiente, tipoDependiente);
    }

}