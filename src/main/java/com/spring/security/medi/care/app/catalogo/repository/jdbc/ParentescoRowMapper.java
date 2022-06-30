package com.spring.security.medi.care.app.catalogo.repository.jdbc;

import com.spring.security.medi.care.app.commons.DaoUtil;
import com.spring.security.medi.care.app.commons.domain.Parentesco;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ParentescoRowMapper implements RowMapper<Parentesco> {

    private static String Adiccional = "A";
    private static String Directo = "D";
    private static String Femenino = "F";
    private static String Masculino = "M";

    @Override
    public Parentesco mapRow(ResultSet rs, int rowNum) throws SQLException {
        Parentesco pare = new Parentesco();
        String genero = null;
        if(Femenino.equals(rs.getString("GENERO"))){
            genero = "MUJER";
        }else if(Masculino.equals(rs.getString("GENERO"))){
            genero = "HOMBRE";
        }
        pare.setParentescoId(rs.getLong("PARENTESCO_ID"));
        pare.setDescripcionParentesco(rs.getString("DESCRIPCION"));
        pare.setTipoDependiente( (rs.getString("TIPO_DEPENDIENTE").equals(Adiccional)? "ADICCIONAL" : "DIRECTO"));
        pare.setGenero(genero);
        pare.setEstado(DaoUtil.parseEstadoColumn(rs.getString("ESTADO")));
        return pare;
    }

}
