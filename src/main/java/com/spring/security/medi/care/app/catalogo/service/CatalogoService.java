package com.spring.security.medi.care.app.catalogo.service;

import com.spring.security.medi.care.app.catalogo.dto.MotivoEstadoPaginatedDto;
import com.spring.security.medi.care.app.catalogo.dto.MunicipioPaginatedDto;
import com.spring.security.medi.care.app.catalogo.dto.NacionalidadPaginatedDto;
import com.spring.security.medi.care.app.catalogo.repository.jpa.InstitucionPensionadoJpaRepo;
import com.spring.security.medi.care.app.commons.domain.*;

import java.util.List;

public interface CatalogoService {

    MotivoEstado buscarMotivoPorId(Long id);

    List<MotivoEstado> buscarMotivosTodos();

    Nacionalidad buscarNacionalidadPorId(Long id);

    List<Nacionalidad> buscarNacionalidadTodos();

    Municipio buscarMunicipioPorId(Long id);

    List<Municipio> buscarMunicipiosTodos();

    List<MotivoEstado> buscarCatalogomotivoEstadooPorParametros(Long motivoId, String descripcion, int rowCount);

    List<Nacionalidad> buscarCatalogoNacionalidad(String paisId, String nombrePais, int rowCount);

    MotivoEstado actualizarMotivoEstado(MotivoEstado motivo);

    Municipio actualizarMunicipio(Municipio municipio);

    MotivoEstadoPaginatedDto buscarMotivosPorParametros(Long motivoId, String description , int page, int size);

    MunicipioPaginatedDto buscarMunicipioPorParametros(String codigoMunicipio, String description , int page, int size);

    NacionalidadPaginatedDto buscarNacionalidadPorParametros(String paisId , int page, int size);

    List<Seguro> buscarSegurosSistema();

    Seguro buscarSegurosSistemaPorId(Long id);

    List<InstitucionPensionado> buscarInstitucionPensionadoTodas();

    InstitucionPensionado buscarPorInstitucionPensionadoId(Long id);

}