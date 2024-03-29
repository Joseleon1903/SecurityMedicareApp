package com.spring.security.medi.care.app.usuario.repository.jpa;

import com.spring.security.medi.care.app.commons.domain.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly=true)
public interface UsuarioJpaRepo extends PagingAndSortingRepository<Usuario, Long>{

    Optional<Usuario> findByUsuarioId(Long id);

    @Query("select us from Usuario us where (:usuarioId is null or :usuarioId = us.usuarioId) and (:codigo is null or :codigo like us.codigo) and (:estado is null or :estado like us.estado) order by us.usuarioId asc")
    Page<Usuario> findByParameters(Long usuarioId, String codigo, String estado, Pageable paging);

    Optional<Usuario> findByCodigoIgnoreCase(String codigo);

    @Query("select us from Usuario us where :email like us.contactoId.correoPrimario ")
    Optional<Usuario> findByEmail(String email);

}