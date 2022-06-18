package com.spring.security.medi.care.app.catalogo.repository;

import com.spring.security.medi.care.app.catalogo.domain.Nacionalidad;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NacionalidadRowMapper implements RowMapper<Nacionalidad> {


    @Override
    public Nacionalidad mapRow(ResultSet rs, int rowNum) throws SQLException {
        Nacionalidad nac = new Nacionalidad();
        nac.setNacionalidadId(rs.getLong("NACIONALIDAD_ID"));
        nac.setDescripcion(rs.getString("NACIONALIDAD"));
        nac.setPaisId(rs.getString("PAIS_ID"));
        nac.setNombrePais(rs.getString("NOMBRE_PAIS"));
        nac.setEstado(rs.getString("ESTADO"));
        return nac;
    }
}
