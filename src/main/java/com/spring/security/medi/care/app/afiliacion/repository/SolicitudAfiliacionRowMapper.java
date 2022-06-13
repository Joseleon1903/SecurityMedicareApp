package com.spring.security.medi.care.app.afiliacion.repository;

import com.spring.security.medi.care.app.afiliacion.domain.SolicitudAfiliacion;
import com.spring.security.medi.care.app.usuario.domain.Usuario;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SolicitudAfiliacionRowMapper implements RowMapper<SolicitudAfiliacion> {


    @Override
    public SolicitudAfiliacion mapRow(ResultSet rs, int rowNum) throws SQLException {

        SolicitudAfiliacion sol = new SolicitudAfiliacion();
        sol.setSolicitudId(rs.getLong("SOLICITUD_ID"));
        sol.setTipoIdentificacion(rs.getShort("TIPO_IDENTIFICACION_ID"));
        sol.setCiudadanoId(rs.getLong("CIUDADANO_ID"));
        sol.setCedula(rs.getString("CEDULA"));
        sol.setNss(rs.getString("NSS"));
        sol.setMunicipioId(rs.getShort("MUNICIPIO_CIUDADANO"));
        sol.setCodigoMunicipio(rs.getString("CODIGO_MUNICIPIO_CIUDADANO"));
        sol.setCodigoProvincia(rs.getString("CODIGO_PROVINCIA_CIUDADANO"));
        sol.setCiudadanoTitularId(rs.getLong("CIUDADANO_TITULAR_ID"));
        sol.setCedulaTitular(rs.getString("CEDULA_TITULAR"));
        sol.setTipoAfiliado(rs.getString("TIPO_AFILIADO"));
        sol.setTipoDependiente(rs.getString("TIPO_DEPENDIENTE"));
        sol.setParentescoId(rs.getLong("PARENTESCO_ID"));
        sol.setEntidadId(rs.getInt("ENTIDAD_ID"));
        sol.setSeguroId(rs.getShort("TIPO_USUARIO_ID"));
        sol.setRegimenId(rs.getShort("TIPO_USUARIO_ID"));
        sol.setInstitucionPensionadoId(rs.getLong("INSTITUCION_PENSIONADO_ID"));
        sol.setEstado(rs.getString("CODIGO"));
        sol.setMotivoId(rs.getInt("MOTIVO_ID"));
        return sol;
    }

}
