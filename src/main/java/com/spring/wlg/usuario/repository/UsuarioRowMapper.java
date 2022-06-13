package com.spring.wlg.usuario.repository;

import com.spring.wlg.usuario.domain.Usuario;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioRowMapper implements RowMapper<Usuario> {

    @Override
    public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
        Usuario user = new Usuario();
        user.setUsuarioId(rs.getLong("USUARIO_ID"));
        user.setCodigo(rs.getString("CODIGO"));
        user.setTipoUsuarioId(rs.getShort("TIPO_USUARIO_ID"));
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