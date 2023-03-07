package com.prueba.pichincha.infraestructura.persistencia.repositorio.jpa;


import com.prueba.pichincha.infraestructura.persistencia.entidad.ClienteEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRepositorioClienteJPA extends JpaRepository<ClienteEntidad, Long> {

    Optional<ClienteEntidad> findById(Long id);
    /*ClienteEntidad findByIdenfiticacion(Long identificacion);*/

}
