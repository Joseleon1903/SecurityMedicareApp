package com.spring.security.medi.care.app.catalogo.service;

import com.spring.security.medi.care.app.commons.domain.*;

import java.util.List;

public interface CatalogoService {

    MotivoEstado buscarMotivoPorId(Long id);

    List<MotivoEstado> buscarMotivosTodos();

    Parentesco buscarParentescoPorId(Long id);

    List<Parentesco> buscarParentescoTodos();

    Nacionalidad buscarNacionalidadPorId(Long id);

    List<Nacionalidad> buscarNacionalidadTodos();

    Municipio buscarMunicipioPorId(Long id);

    List<Municipio> buscarMunicipiosTodos();

    GradoConsanguinidad buscarGradoConsanguinidadPorId(Long id);

    List<GradoConsanguinidad> buscarGradoConsanguinidadesTodos();

    List<Parentesco> buscarCatalogoParentescoPorParametros(String tipoDependiente, String genero, int rowCount);

    List<MotivoEstado> buscarCatalogomotivoEstadooPorParametros(Long motivoId, String descripcion, int rowCount);

    List<Nacionalidad> buscarCatalogoNacionalidad(String paisId, String nombrePais, int rowCount);

    GradoConsanguinidad actualizarGradoConsanguinidad(GradoConsanguinidad grado);

    MotivoEstado actualizarMotivoEstado(MotivoEstado motivo);

}