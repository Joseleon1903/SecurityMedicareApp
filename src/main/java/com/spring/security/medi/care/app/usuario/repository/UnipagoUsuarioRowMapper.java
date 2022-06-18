package com.spring.security.medi.care.app.usuario.repository;

import com.spring.security.medi.care.app.usuario.domain.UnipagoUsuario;
import com.spring.security.medi.care.app.usuario.domain.Usuario;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UnipagoUsuarioRowMapper implements RowMapper<UnipagoUsuario> {


    @Override
    public UnipagoUsuario mapRow(ResultSet rs, int rowNum) throws SQLException {
        UnipagoUsuario user = new UnipagoUsuario();
        user.setUsuarioId(rs.getLong("USUARIO_ID"));
        user.setCodigo(rs.getString("CODIGO"));
        user.setContactoId(rs.getLong("CONTACTO_ID"));
        user.setTipoUsuarioId(rs.getShort("TIPO_USUARIO_ID"));
        user.setDescripcionTipoUsuario(rs.getString("TIPO_USUARIO_DESCRIPCION"));
        user.setPosicion(rs.getString("POSICION"));
        user.setCorreoCorporativo(rs.getString("CORREO_CORPORATIVO"));
        user.setCedula(rs.getString("CEDULA"));
        user.setNss(rs.getString("NSS"));
        user.setNombre(rs.getString("NOMBRE"));
        user.setPrimerApellido(rs.getString("PRIMER_APELLIDO"));
        user.setSegundoApellido(rs.getString("SEGUNDO_APELLIDO"));
        user.setFechaNacimiento(rs.getTimestamp("FECHA_NACIMIENTO").toLocalDateTime());
        user.setGenero(rs.getString("GENERO"));
        user.setNacionalidad(rs.getString("NACIONALIDAD"));
        return user;
    }
}
