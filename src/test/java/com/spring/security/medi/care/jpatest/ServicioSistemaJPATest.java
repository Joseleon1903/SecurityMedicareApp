package com.spring.security.medi.care.jpatest;

import com.spring.security.medi.care.BaseTest;
import com.spring.security.medi.care.app.catalogo.repository.jpa.ServicioSistemaJpaRepo;
import com.spring.security.medi.care.app.commons.domain.ServicioSistema;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;


@TestPropertySource(
        locations = "classpath:application-data-jpa-test.properties")
public class ServicioSistemaJPATest extends BaseTest {

    @Autowired private ServicioSistemaJpaRepo repository;

    public ServicioSistemaJPATest() {
    }

    @BeforeEach
    void validatePreconditions() {
        assertFalse(repository.count() > 0);
    }

    @Test
    public void testSaveServicioSistema() {
        Long id = 0L;
        id = repository.saveAndFlush(new ServicioSistema(null, "servico test", LocalDate.now(), "AC")).getServicioId();
        Long idInDb = jdbcTemplate.queryForObject("SELECT s.servicio_id FROM Servicio_Sistema s where s.servicio_Id = "+id, Long.class);
        assertNotNull(idInDb);
    }


}
