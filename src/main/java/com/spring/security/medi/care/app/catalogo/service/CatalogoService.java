package com.spring.security.medi.care.app.catalogo.service;

import com.spring.security.medi.care.app.catalogo.domain.MotivoEstado;
import com.spring.security.medi.care.app.catalogo.domain.Nacionalidad;
import com.spring.security.medi.care.app.catalogo.domain.Parentesco;

import java.util.List;

public interface CatalogoService {

    List<Parentesco> buscarCatalogoParentescoPorParametros(String tipoDependiente, String genero, int rowCount);

    List<MotivoEstado> buscarCatalogomotivoEstadooPorParametros(Long motivoId, String descripcion, int rowCount);

    List<Nacionalidad> buscarCatalogoNacionalidad(String paisId, String nombrePais, int rowCount);

}