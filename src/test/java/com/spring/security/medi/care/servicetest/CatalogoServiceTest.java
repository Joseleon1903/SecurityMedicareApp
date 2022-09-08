package com.spring.security.medi.care.servicetest;

import com.spring.security.medi.care.BaseTest;
import com.spring.security.medi.care.app.catalogo.service.CatalogoService;
import com.spring.security.medi.care.app.commons.AplicationConstantUtil;
import com.spring.security.medi.care.app.commons.domain.MotivoEstado;
import com.spring.security.medi.care.app.commons.domain.Municipio;
import com.spring.security.medi.care.app.commons.domain.Nacionalidad;
import com.spring.security.medi.care.app.commons.domain.ServicioSistema;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.context.TestPropertySource;
import org.junit.jupiter.api.DisplayName;

import java.util.Date;
import java.util.List;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@TestPropertySource(
        locations = "classpath:application-data-jpa-test.properties")
public class CatalogoServiceTest extends BaseTest {

    @Autowired
    private CatalogoService catalogoService;

    public CatalogoServiceTest() {
    }

    @BeforeEach
    void validatePreconditions() {
        createDefaultDBServicioSistema();
        createDefaultDBMotivoEstado();
    }

    public void createDefaultDBServicioSistema() {
        System.out.println("Enterin in createDefaultDBServicioSistema");
        Resource resource = new ClassPathResource("database/H2_Test_Insert/Servicio_Sistema_Insert.sql");
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(resource);
        databasePopulator.execute(dataSource);
    }

    public void createDefaultDBMotivoEstado() {
        System.out.println("Enterin in createDefaultDBMotivoEstado");
        Resource resource = new ClassPathResource("database/H2_Test_Insert/Motivo_Estado_Insert.sql");
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(resource);
        databasePopulator.execute(dataSource);
    }

    public void createDefaultDBNacionalidad() {
        System.out.println("Enterin in createDefaultDBMotivoEstado");
        Resource resource = new ClassPathResource("database/H2_Test_Insert/Nacionalidad_Insert.sql");
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(resource);
        databasePopulator.execute(dataSource);
    }

    public void createDefaultDBMunicipio() {
        System.out.println("Enterin in createDefaultDBMunicipio");
        Resource resource = new ClassPathResource("database/H2_Test_Insert/Municipio_Insert.sql");
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(resource);
        databasePopulator.execute(dataSource);
    }

    @Test
    @Order(1)
    @DisplayName(">>>> DisplayName : testBuscarMotivoPorId  <<<<<")
    public void testBuscarMotivoPorId() {
       // createDefaultDBMotivoEstado();
        Long motivoId = AplicationConstantUtil.EXISTE_SOLICITUD_AC_PARA_CIUDADANO;
        MotivoEstado motivo = catalogoService.buscarMotivoPorId(motivoId);
        assertNotNull(motivo);
    }

    @Test
    @Order(2)
    @DisplayName(">>>> DisplayName : testBuscarMotivosTodos  <<<<<")
    public void testBuscarMotivosTodos() {
        createDefaultDBMotivoEstado();
        List<MotivoEstado> motivo = catalogoService.buscarMotivosTodos();
        assertNotNull(motivo);
    }

    @Test
    @Order(3)
    @DisplayName(">>>> DisplayName : testBuscarNacionalidadPorId  <<<<<")
    public void testBuscarNacionalidadPorId() {
        createDefaultDBNacionalidad();
        Nacionalidad nacionalidad = catalogoService.buscarNacionalidadPorId(1L);
        assertNotNull(nacionalidad);
    }

    @Test@Order(4)
    @DisplayName(">>>> DisplayName : testBuscarNacionalidadTodos  <<<<<")
    public void testBuscarNacionalidadTodos() {
        List<Nacionalidad> nacionalidadList = catalogoService.buscarNacionalidadTodos();
        assertNotNull(nacionalidadList);
    }

    @Test
    @Order(5)
    @DisplayName(">>>> DisplayName : testBuscarMunicipioPorId  <<<<<")
    public void testBuscarMunicipioPorId() {
        createDefaultDBMunicipio();
        Municipio municipio = catalogoService.buscarMunicipioPorId(10L);
        assertNotNull(municipio);
    }

    @Test
    @Order(6)
    @DisplayName(">>>> DisplayName : testBuscarMunicipiosTodos  <<<<<")
    public void testBuscarMunicipiosTodos() {
        List<Municipio> municipioList = catalogoService.buscarMunicipiosTodos();
        assertNotNull(municipioList);
    }

  /*  @Test
    @DisplayName(">>>> DisplayName : testBuscarCatalogomotivoEstadooPorParametros  <<<<<")
    public void testBuscarCatalogomotivoEstadooPorParametros() {
        Long motivoId = AplicationConstantUtil.EXISTE_SOLICITUD_AC_PARA_CIUDADANO;
        String descripcion = "El ciudadnao ya tiene una solicitud acpetada para otra entidad";
        List<MotivoEstado> motivosList = catalogoService.buscarCatalogomotivoEstadooPorParametros(motivoId, descripcion, 500);
        assertNotNull(motivosList);
    }*/

    @Test
    @Order(7)
    @DisplayName(">>>> DisplayName : testActualizarMotivoEstado  <<<<<")
    public void testActualizarMotivoEstado() {
        MotivoEstado motivo = new MotivoEstado(AplicationConstantUtil.EXISTE_SOLICITUD_AC_PARA_CIUDADANO, "Motivo Actualizado", "IN");
        MotivoEstado motivoUpdated = catalogoService.actualizarMotivoEstado(motivo);
        assertTrue("IN".equals(motivoUpdated.getEstado()));
    }

    @Test
    @Order(8)
    @DisplayName(">>>> DisplayName : testActualizarMunicipio  <<<<<")
    public void testActualizarMunicipio() {
        Municipio municipio = new Municipio(1L, "texto test", "string", 1, "IN");
        Municipio municipioUpdated = catalogoService.actualizarMunicipio(municipio);
        assertTrue("IN".equals(municipioUpdated.getEstado()));
    }

    @Test
    @DisplayName(">>>> DisplayName : testBuscarServicioSistemaPorId  <<<<<")
    public void testBuscarServicioSistemaPorId() {
        createDefaultDBServicioSistema();
        ServicioSistema servicio = catalogoService.buscarServicioSistemaPorId(301L);
        assertNotNull(servicio);
    }

}