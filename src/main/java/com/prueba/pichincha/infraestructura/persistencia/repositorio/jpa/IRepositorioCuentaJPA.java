package com.prueba.pichincha.infraestructura.persistencia.repositorio.jpa;

import com.prueba.pichincha.infraestructura.persistencia.entidad.ClienteEntidad;
import com.prueba.pichincha.infraestructura.persistencia.entidad.CuentaEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRepositorioCuentaJPA extends JpaRepository<CuentaEntidad, Long> {

    Optional<CuentaEntidad> findById(Long id);

    Optional<CuentaEntidad> findByNumeroCuenta(Long numeroCuenta);

    @Query("SELECT COUNT(c) > 0 FROM CuentaEntidad c WHERE c.numeroCuenta = ?1")
    Boolean existePorNumeroCuenta(Long numeroCuenta);

}
