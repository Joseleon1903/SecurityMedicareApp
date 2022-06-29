package com.spring.security.medi.care.app.catalogo.repository;

import com.spring.security.medi.care.app.commons.repository.Parentesco;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ParentescoJdbcImpl {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ParentescoJdbcImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Parentesco> buscarCatalogoParentesco(String tipoDependiente, String genero, int rowCount){
        String sql = CatalogoDaoUtil.FIND_CATALOGO_PARENTESCO;
        return jdbcTemplate.query(sql, new ParentescoRowMapper(), tipoDependiente, tipoDependiente, genero, genero, rowCount);
    }


}