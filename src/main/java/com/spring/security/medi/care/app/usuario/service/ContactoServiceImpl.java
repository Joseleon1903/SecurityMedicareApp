package com.spring.security.medi.care.app.usuario.service;

import com.spring.security.medi.care.app.commons.domain.Contacto;
import com.spring.security.medi.care.app.commons.domain.Usuario;
import com.spring.security.medi.care.app.usuario.repository.jpa.ContactoJpaRepo;
import com.spring.security.medi.care.app.usuario.repository.jpa.UsuarioJpaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ContactoServiceImpl implements ContactoService{


    private final ContactoJpaRepo contactoJpaRepo;

    @Autowired
    public ContactoServiceImpl(ContactoJpaRepo contactoJpaRepo) {
        this.contactoJpaRepo = contactoJpaRepo;
    }


    @Override
    public Contacto buscarContactoPorId(Long id) {
        if(contactoJpaRepo.findByContactoId(id).isPresent()){
            contactoJpaRepo.findByContactoId(id).get();
        }
        return new Contacto();
    }

    @Override
    public List<Contacto> buscarContactosSistema() {
        return contactoJpaRepo.findAll();
    }

    @Override
    public Contacto guardarContacto(Contacto contacto) {
        return contactoJpaRepo.save(contacto);
    }
}
