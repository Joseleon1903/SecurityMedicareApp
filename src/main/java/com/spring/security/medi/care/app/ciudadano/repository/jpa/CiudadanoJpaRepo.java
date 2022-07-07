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

}