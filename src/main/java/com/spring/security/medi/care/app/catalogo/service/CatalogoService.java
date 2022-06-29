package com.spring.security.medi.care.app.catalogo.service;

import com.spring.security.medi.care.app.commons.repository.MotivoEstado;
import com.spring.security.medi.care.app.commons.repository.Nacionalidad;
import com.spring.security.medi.care.app.commons.repository.Parentesco;

import java.util.List;

public interface CatalogoService {

    List<Parentesco> buscarCatalogoParentescoPorParametros(String tipoDependiente, String genero, int rowCount);

    List<MotivoEstado> buscarCatalogomotivoEstadooPorParametros(Long motivoId, String descripcion, int rowCount);

    List<Nacionalidad> buscarCatalogoNacionalidad(String paisId, String nombrePais, int rowCount);

}