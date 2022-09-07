package com.spring.security.medi.care.servicetest;

import com.spring.security.medi.care.BaseTest;
import com.spring.security.medi.care.app.catalogo.service.CatalogoService;
import com.spring.security.medi.care.app.commons.domain.ServicioSistema;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.context.TestPropertySource;
import static org.junit.Assert.assertNotNull;

@TestPropertySource(
        locations = "classpath:application-data-jpa-test.properties")
public class CatalogoServiceTest extends BaseTest {

    @Autowired
    private CatalogoService catalogoService;

    public CatalogoServiceTest() {
    }

    @BeforeEach
    void validatePreconditions() {
        createDefaultDB();
    }

    public void createDefaultDB() {
        System.out.println("Enterin in createDefaultDB");
        Resource resource = new ClassPathResource("database/H2_Test_Insert/Servicio_Sistema_Insert.sql");
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(resource);
        databasePopulator.execute(dataSource);
    }

    @Test
    public void testBuscarServicioSistemaPorId() {
        createDefaultDB();
        ServicioSistema servicio = catalogoService.buscarServicioSistemaPorId(301L);
        assertNotNull(servicio);
    }

}
