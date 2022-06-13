package com.spring.security.medi.care.app.solicitud.titular.repository;

import com.spring.security.medi.care.app.solicitud.titular.domain.SolicitudTitular;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AfiTitularRowMapper implements RowMapper<SolicitudTitular> {

    @Override
    public SolicitudTitular mapRow(ResultSet rs, int rowNum) throws SQLException {
        SolicitudTitular sol =  new SolicitudTitular();
        sol.setAfiliacionId(rs.getLong("AFILIACION_ID"));
        sol.setSolicitudId(rs.getLong("SOLICITUD_ID"));
        sol.setLoteId(rs.getLong("LOTE_ID"));
        sol.setServicioId(rs.getInt("SERVICIO_ID"));
        sol.setNumeroContrato(rs.getLong("NUMERO_CONTRATO"));
        sol.setTipoPersona((rs.getShort("TIPO_PERSONA") == 1) ? "FISICA" : "MORAL");
        sol.setEntidadId(rs.getInt("ENTIDAD_ID"));
        sol.setSeguroId(rs.getShort("SEGURO_ID"));
        sol.setRegimenId(rs.getShort("REGIMEN_ID"));
        sol.setFechaAfiliacion(rs.getDate("FECHA_AFILIACION"));
        sol.setTipoAfiliacion(rs.getString("TIPO_AFILIACION"));
        sol.setTipoIdentificacion(rs.getShort("TIPO_IDENTIFICACION_ID"));
        sol.setCedula(rs.getString("CEDULA"));
        sol.setNombre(rs.getString("NOMBRE"));
        sol.setPrimerApellido(rs.getString("PRIMER_APELLIDO"));
        sol.setSegundoApellido(rs.getString("SEGUNDO_APELLIDO"));
        sol.setEstado(rs.getString("ESTADO"));
        sol.setMotivoId(rs.getInt("MOTIVO_ID"));
        sol.setDescripcionMotivo(rs.getString("DESCRIPCION_MOTIVO"));
         return sol;
    }
}


