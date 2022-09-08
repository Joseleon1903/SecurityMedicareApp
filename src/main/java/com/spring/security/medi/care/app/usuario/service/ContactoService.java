package com.spring.security.medi.care.app.usuario.service;

import com.spring.security.medi.care.app.commons.domain.Contacto;
import java.util.List;

public interface ContactoService {

    Contacto buscarContactoPorId(Long id);

    List<Contacto> buscarContactosSistema();

    Contacto guardarContacto(Contacto contacto);
}
