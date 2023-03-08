package com.prueba.pichincha.infraestructura.persistencia.repositorio.jpa;


import com.prueba.pichincha.infraestructura.persistencia.entidad.ClienteEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRepositorioClienteJPA extends JpaRepository<ClienteEntidad, Long> {

    Optional<ClienteEntidad> findById(Long id);

    @Query("SELECT c FROM ClienteEntidad c WHERE  c.identificacion = :identificacion")
    ClienteEntidad encontrarPorIdentificacion(@Param("identificacion") Long identificacion);

}
