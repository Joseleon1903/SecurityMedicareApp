package com.spring.security.medi.care.app.catalogo.repository.jdbc;

import com.spring.security.medi.care.app.commons.DaoUtil;
import com.spring.security.medi.care.app.commons.domain.MotivoEstado;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MotivoEstadoRowMapper implements RowMapper<MotivoEstado> {


    @Override
    public MotivoEstado mapRow(ResultSet rs, int rowNum) throws SQLException {
        MotivoEstado motivo = new MotivoEstado();
        motivo.setMotivoId(rs.getLong("MOTIVO_ID"));
        motivo.setDescripcion(rs.getString("DESCRIPCION"));
        motivo.setEstado(DaoUtil.parseEstadoColumn(rs.getString("ESTADO")));
        return motivo;
    }

}