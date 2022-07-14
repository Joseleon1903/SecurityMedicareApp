package com.spring.security.medi.care.app.ciudadano.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.spring.security.medi.care.app.ciudadano.repository.jpa.CiudadanoJpaRepo;
import com.spring.security.medi.care.app.commons.domain.Ciudadano;

@Service
public class CiudadanoServiceImpl implements CiudadanoService {

    private static final Logger logger = LoggerFactory.getLogger(CiudadanoServiceImpl.class);

    private final CiudadanoJpaRepo ciudadanoJpaRepo;

    @Autowired
    public CiudadanoServiceImpl(CiudadanoJpaRepo ciudadanoJpaRepo){
        this.ciudadanoJpaRepo = ciudadanoJpaRepo;
    }

    @Override
    public Ciudadano buscarCiudadanoPorCiudadanoId(Long ciudadanoId){
        return ciudadanoJpaRepo.findByCiudadanoId(ciudadanoId);
    }

    @Override
    public List<Ciudadano> buscarTodosCiudadanos(){
        Integer pageNo = 0;
        Integer pageSize = 15;
        Pageable paging = PageRequest.of(pageNo, pageSize);
        return ciudadanoJpaRepo.findAll(paging).toList();
    }

    @Override
    public void eliminarCiudadanoId(Long ciudadanoId){
        Ciudadano ciu = ciudadanoJpaRepo.findByCiudadanoId(ciudadanoId);
        if(ciu != null){
            ciudadanoJpaRepo.delete(ciu);
        }
    }

}