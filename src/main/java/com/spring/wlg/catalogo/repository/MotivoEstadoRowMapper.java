package com.spring.wlg.catalogo.repository;

import com.spring.wlg.catalogo.domain.MotivoEstado;
import com.spring.wlg.commons.DaoUtil;
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