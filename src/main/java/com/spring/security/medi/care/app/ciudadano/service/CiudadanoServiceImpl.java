package com.spring.security.medi.care.app.ciudadano.service;

import com.spring.security.medi.care.app.ciudadano.type.CiudadanoPaginated;
import com.spring.security.medi.care.app.commons.PaginationOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    public CiudadanoPaginated buscarCiudadanosPorParametros(String identificacion, String texto, String estado, int page, int size) {
        logger.info("Entering in method buscarCiudadanosPorParametros");
        logger.info("param : "+identificacion );
        logger.info("param : "+texto );
        logger.info("param : "+estado );
        identificacion = (identificacion != null && !identificacion.isEmpty())? "%"+identificacion+"%": null;
        texto = (texto != null && !texto.isEmpty())? "%"+texto+"%": null;
        Pageable paging = PageRequest.of(page, size);
        Page<Ciudadano> listado = ciudadanoJpaRepo.findByParameters(identificacion, texto, estado ,paging );
        PaginationOutput pageOut = new PaginationOutput();
        pageOut.setPageIndex(page);
        pageOut.setTotalPages(listado.getTotalPages());
        pageOut.setRowSize(size);
        long registrosRestante = listado.getTotalElements() - (page*size);
        logger.info("Registro restante: "+ registrosRestante);
        pageOut.setTotalRowCount(registrosRestante);
        CiudadanoPaginated paginated = new CiudadanoPaginated(listado.getContent(), pageOut);
        return paginated;
    }

    @Override
    public void eliminarCiudadanoId(Long ciudadanoId){
        Ciudadano ciu = ciudadanoJpaRepo.findByCiudadanoId(ciudadanoId);
        if(ciu != null){
            ciudadanoJpaRepo.delete(ciu);
        }
    }

    @Override
    public Ciudadano buscarCiudadanoPorIdentifiacion(String cedula, String nss) {
        logger.info("Entering in method buscarCiudadanoPorIdentifiacion");
        logger.info("param : "+cedula );
        logger.info("param : "+nss );
        return ciudadanoJpaRepo.findByCedulaAndNss(cedula, nss);
    }

}