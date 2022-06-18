package com.spring.security.medi.care.app.afiliacion.repository;

import com.spring.security.medi.care.app.afiliacion.domain.SolicitudAfiliacion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SolicitudAfiliacionJdbcImpl {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SolicitudAfiliacionJdbcImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<SolicitudAfiliacion> buscarSolicitudesAfiliaciones(){
        String sql = AfiDaoUtil.FIND_SOLICTUD_AFILIACION;
        return jdbcTemplate.query(sql, new SolicitudAfiliacionRowMapper());
    }
}
