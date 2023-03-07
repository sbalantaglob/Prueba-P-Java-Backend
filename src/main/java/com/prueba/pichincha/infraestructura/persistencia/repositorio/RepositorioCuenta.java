package com.prueba.pichincha.infraestructura.persistencia.repositorio;

import com.prueba.pichincha.dominio.cuenta.modelo.Cuenta;
import com.prueba.pichincha.dominio.cuenta.puerto.repositorio.IRepositorioCuenta;
import com.prueba.pichincha.dominio.excepcion.ExcepcionSinDatos;
import com.prueba.pichincha.infraestructura.persistencia.builder.CuentaBuilder;
import com.prueba.pichincha.infraestructura.persistencia.entidad.CuentaEntidad;
import com.prueba.pichincha.infraestructura.persistencia.repositorio.jpa.IRepositorioCuentaJPA;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class RepositorioCuenta implements IRepositorioCuenta {
    private static final String MENSAJE_ELIMINAR_NO_EXISTE = "No se puedo eliminar cliente, no existe.";

    private IRepositorioCuentaJPA repositorioCuentaJPA;

    public RepositorioCuenta(IRepositorioCuentaJPA iRepositorioCuentaJPA) {
        this.repositorioCuentaJPA = iRepositorioCuentaJPA;
    }

    @Override
    public Long guardar(Cuenta cuenta) {
        CuentaEntidad cuentaEntidad = CuentaBuilder.convertirAEntidad(cuenta);
        cuentaEntidad = repositorioCuentaJPA.save(cuentaEntidad);
        return cuentaEntidad.getId();
    }

    @Override
    public Cuenta obtenerPorNumeroCuenta(Long identificacion) {
        return new Cuenta();
    }


    @Override
    public void actualizar(Cuenta cuenta) {
        CuentaEntidad cuentaEntidad  = CuentaBuilder.convertirAEntidad(cuenta);
        repositorioCuentaJPA.save(cuentaEntidad);
    }

    @Override
    public void eliminar(Long id) {
        Optional<CuentaEntidad> cuentaEntidad = repositorioCuentaJPA.findById(id);
        repositorioCuentaJPA.delete(cuentaEntidad.orElseThrow(() ->
                new ExcepcionSinDatos(MENSAJE_ELIMINAR_NO_EXISTE)));
    }
}
