package com.spring.security.medi.care.app.ciudadano.repository.jpa;

import com.spring.security.medi.care.app.commons.domain.Ciudadano;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CiudadanoJpaRepo extends PagingAndSortingRepository<Ciudadano, Long>{


    Ciudadano findByCiudadanoId(Long ciudadanoId);

    @Query("select c from Ciudadano c order by c.ciudadanoId asc")
    Page<Ciudadano> findAll(Pageable paging);

    @Query("select c from Ciudadano c where (:identificacion is null or c.cedula like :identificacion) and " +
            " (:identificacion is null or c.nss like :identificacion) and " +
            " (:texto is null or c.nombre like :texto) and " +
            " (:texto is null or c.primerApellido like :texto) and " +
            " (:texto is null or c.segundoApellido like :texto) and " +
            " (:estado is null or c.estado like :estado)" +
            " order by c.ciudadanoId asc")
    Page<Ciudadano> findByParameters(String identificacion, String texto, String estado, Pageable paging);

    @Query("select c from Ciudadano c where :cedula = c.cedula or :nss= c.nss")
    Ciudadano findByCedulaAndNss(String cedula, String nss);

}