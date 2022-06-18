package com.spring.security.medi.care.app.entidad.repository;

import com.spring.security.medi.care.app.entidad.domain.EntidadType;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EntidadRowMapper implements RowMapper<EntidadType> {

    @Override
    public EntidadType mapRow(ResultSet rs, int rowNum) throws SQLException {
        EntidadType ent = new EntidadType();
        ent.setEntidadId(rs.getInt("ENTIDAD_ID"));
        ent.setClaveEntidad(rs.getInt("CLAVE_ENTIDAD"));
        ent.setSigla(rs.getString("SIGLA"));
        ent.setDescripcionEntidad(rs.getString("DESCRIPCION_ENTIDAD"));
        ent.setRnc(rs.getString("RNC"));
        ent.setEntidadSupervisoraId(rs.getInt("ENTIDAD_SUPERVISORA_ID"));
        ent.setTipoentidadId(rs.getInt("TIPO_ENTIDAD_ID"));
        ent.setDescripcionTipoEntidad(rs.getString("DESCRIPCION_TIPO_ENTIDAD"));
        ent.setSeguroId(rs.getShort("SEGURO_ID"));
        ent.setDescripcionSeguro(rs.getString("DESCRIPCION_SEGURO"));
        ent.setRegimenId(rs.getShort("REGIMEN_ID"));
        ent.setDescripcionRegimen(rs.getString("DESCRIPCION_REGIMEN"));
        ent.setEstado(rs.getString("ESTADO"));

        ent.setIconUrl(EntidadDaoUtil.getIconUrl(rs.getString("DESCRIPCION_ENTIDAD")));
        return ent;
    }

}