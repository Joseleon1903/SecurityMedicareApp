package com.spring.wlg.solicitud.dependiente.repository;

import com.spring.wlg.solicitud.dependiente.domain.SolicitudDependiente;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AfiDependienteRowMapper  implements RowMapper<SolicitudDependiente> {


    @Override
    public SolicitudDependiente mapRow(ResultSet rs, int rowNum) throws SQLException {
        SolicitudDependiente sol =  new SolicitudDependiente();
        sol.setAfiliacionId(rs.getLong("AFILIACION_ID"));
        sol.setSolicitudId(rs.getLong("SOLICITUD_ID"));
        sol.setServicio(rs.getString("SERVICIO"));
        sol.setEntidadId(rs.getInt("ENTIDAD_ID"));
        sol.setNombreEntidad(rs.getString("NOMBRE_ENTIDAD"));
        sol.setTipoIdentificacionId(rs.getShort("TIPO_IDENTIFICACION_ID"));
        sol.setNui(rs.getString("NUI"));
        sol.setNss(rs.getInt("NSS"));
        sol.setCedula(rs.getString("CEDULA"));
        sol.setNombre(rs.getString("NOMBRE"));
        sol.setPrimerApellido(rs.getString("PRIMER_APELLIDO"));
        sol.setSegundoApellido(rs.getString("SEGUNDO_APELLIDO"));
        sol.setTipoDependiente(rs.getString("TIPO_DEPENDIENTE"));
        sol.setTipoAfiliado(rs.getString("TIPO_AFILIADO"));
        sol.setParentesco(rs.getString("PARENTESCO"));
        sol.setNacionalidad(rs.getString("NACIONALIDAD"));
        sol.setEstado(rs.getString("ESTADO"));
        sol.setMotivoId(rs.getInt("MOTIVO_ID"));
        sol.setSeguroId(rs.getShort("SEGURO_ID"));
        sol.setRegimenId(rs.getShort("REGIMEN_ID"));
        sol.setEstudiante(rs.getBoolean("ESTUDIANTE"));
        sol.setDiscapacitado(rs.getBoolean("DISCAPACITADO"));
        sol.setCedulaTitular(rs.getString("CEDULA_TITULAR"));
        sol.setCiudadanoTitularId(rs.getLong("CIUDADANO_TITULAR_ID"));
        sol.setSolicitudAfiliacionTitular(rs.getLong("SOLICITUD_AFI_TITULAR_ID"));
        return sol;
    }
}