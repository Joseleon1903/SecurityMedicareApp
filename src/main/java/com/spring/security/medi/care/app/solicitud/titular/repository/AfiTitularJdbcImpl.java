package com.spring.security.medi.care.app.solicitud.titular.repository;

import com.spring.security.medi.care.app.solicitud.titular.domain.SolicitudTitular;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class AfiTitularJdbcImpl {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AfiTitularJdbcImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<SolicitudTitular> buscarSolicitudesTitularPorCiudadano(Long ciuddanoId, String estado,
                                                                       Long numeroContrato, Short tipoPersona, Integer entidadId){
        String sql = AfiTitularUtil.BUSCAR_TITULAR_POR_SOLICITUD_QUERY;
        return jdbcTemplate.query(sql, new AfiTitularRowMapper(), ciuddanoId, estado,estado,
                numeroContrato, numeroContrato, tipoPersona, tipoPersona, entidadId, entidadId);
    }

}
