package com.prueba.pichincha.infraestructura.persistencia.repositorio.jpa;

import com.prueba.pichincha.infraestructura.persistencia.entidad.MovimientoEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRepositorioMovimientoJPA extends JpaRepository<MovimientoEntidad, Long> {

    Optional<MovimientoEntidad> findById(Long id);

}
