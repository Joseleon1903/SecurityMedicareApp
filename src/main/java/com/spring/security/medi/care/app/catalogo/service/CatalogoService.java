package com.spring.security.medi.care.app.catalogo.service;

import com.spring.security.medi.care.app.catalogo.dto.MotivoEstadoPaginatedDto;
import com.spring.security.medi.care.app.catalogo.dto.MunicipioPaginatedDto;
import com.spring.security.medi.care.app.catalogo.dto.NacionalidadPaginatedDto;
import com.spring.security.medi.care.app.commons.domain.*;
import java.util.List;

public interface CatalogoService {


    //   Metodos para el catalogo de Motivo Estado
    MotivoEstado buscarMotivoPorId(Long id);

    List<MotivoEstado> buscarMotivosTodos();

    List<MotivoEstado> buscarCatalogoMotivoEstadooPorParametros(Long motivoId, String descripcion, int rowCount);

    MotivoEstado actualizarMotivoEstado(MotivoEstado motivo);

    MotivoEstadoPaginatedDto buscarMotivosPorParametros(Long motivoId, String description , int page, int size);


    //   Metodos para el catalogo de Nacionalidad
    Nacionalidad buscarNacionalidadPorId(Long id);

    List<Nacionalidad> buscarNacionalidadTodos();

    List<Nacionalidad> buscarCatalogoNacionalidad(String paisId, String nombrePais, int rowCount);

    NacionalidadPaginatedDto buscarNacionalidadPorParametros(String paisId , int page, int size);


    //   Metodos para el catalogo de Municipio
    Municipio buscarMunicipioPorId(Long id);

    List<Municipio> buscarMunicipiosTodos();

    Municipio actualizarMunicipio(Municipio municipio);

    MunicipioPaginatedDto buscarMunicipioPorParametros(String codigoMunicipio, String description , int page, int size);

    //   Metodos para el catalogo de Seguro

    List<Seguro> buscarSegurosSistema();

    Seguro buscarSegurosSistemaPorId(Long id);

    Seguro guardarSeguroSistema(Seguro seguro);

    //   Metodos para el catalogo de InsitutcionPensionado

    List<InstitucionPensionado> buscarInstitucionPensionadoTodas();

    InstitucionPensionado buscarPorInstitucionPensionadoId(Long id);

    InstitucionPensionado guardarInstitucionPensionado(InstitucionPensionado intitucionPensionado);

    //   Metodos para el catalogo de Servicio Sistema

    List<ServicioSistema> buscarServiciosSistemas();

    ServicioSistema buscarServicioSistemaPorId(Long id);

    ServicioSistema registrarServicioSistema(ServicioSistema servicioSistema);
}