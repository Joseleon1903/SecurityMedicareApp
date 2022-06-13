package com.spring.security.medi.care.app.catalogo.service;

import com.spring.security.medi.care.app.catalogo.domain.MotivoEstado;
import com.spring.security.medi.care.app.catalogo.domain.Nacionalidad;
import com.spring.security.medi.care.app.catalogo.domain.Parentesco;
import com.spring.security.medi.care.app.catalogo.repository.MotivoEstadoJdbcImpl;
import com.spring.security.medi.care.app.catalogo.repository.NacionalidadJdbcImpl;
import com.spring.security.medi.care.app.catalogo.repository.ParentescoJdbcImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CatalogoServiceImpl implements CatalogoService {

    private final ParentescoJdbcImpl parentescoJdbc;

    private final MotivoEstadoJdbcImpl motivoEstadoJdbc;

    private final NacionalidadJdbcImpl nacionalidadJdbcImpl;

    @Autowired
    public CatalogoServiceImpl(ParentescoJdbcImpl parentescoJdbc, MotivoEstadoJdbcImpl motivoEstadoJdbc, NacionalidadJdbcImpl nacionalidadJdbcImpl) {
        this.parentescoJdbc = parentescoJdbc;
        this.motivoEstadoJdbc = motivoEstadoJdbc;
        this.nacionalidadJdbcImpl = nacionalidadJdbcImpl;
    }

    @Override
    public List<Parentesco> buscarCatalogoParentescoPorParametros(String tipoDependiente, String genero, int rowCount) {
        return parentescoJdbc.buscarCatalogoParentesco(tipoDependiente, genero, rowCount);
    }

    @Override
    public List<MotivoEstado> buscarCatalogomotivoEstadooPorParametros(Long motivoId, String descripcion, int rowCount) {
        return motivoEstadoJdbc.buscarCatalogoMotivoEstado(motivoId, descripcion, rowCount);
    }

    @Override
    public List<Nacionalidad> buscarCatalogoNacionalidad(String paisId, String nombrePais, int rowCount) {
        return nacionalidadJdbcImpl.buscarCatalogoNacionalidad(paisId, nombrePais, rowCount);
    }
}