package com.spring.security.medi.care.app.usuario.service;

import com.spring.security.medi.care.app.commons.domain.Contacto;
import com.spring.security.medi.care.app.commons.domain.Usuario;
import com.spring.security.medi.care.app.usuario.repository.jpa.ContactoJpaRepo;
import com.spring.security.medi.care.app.usuario.repository.jpa.UsuarioJpaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ContactoServiceImpl implements ContactoService{


    private final ContactoJpaRepo contactoJpaRepo;

    @Autowired
    public ContactoServiceImpl(ContactoJpaRepo contactoJpaRepo) {
        this.contactoJpaRepo = contactoJpaRepo;
    }


    @Override
    public Contacto buscarContactoPorId(Long id) {
        return contactoJpaRepo.findByContactoId(id);
    }

    @Override
    public List<Contacto> buscarContactosSistema() {
        return contactoJpaRepo.findAll();
    }
}
