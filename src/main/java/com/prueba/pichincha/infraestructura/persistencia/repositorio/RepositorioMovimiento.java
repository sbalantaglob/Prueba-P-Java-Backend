package com.prueba.pichincha.infraestructura.persistencia.repositorio;

import com.prueba.pichincha.dominio.cuenta.modelo.Cuenta;
import com.prueba.pichincha.dominio.cuenta.puerto.repositorio.IRepositorioCuenta;
import com.prueba.pichincha.dominio.excepcion.ExcepcionSinDatos;
import com.prueba.pichincha.dominio.movimiento.modelo.Movimiento;
import com.prueba.pichincha.dominio.movimiento.puerto.repositorio.IRepositorioMovimiento;
import com.prueba.pichincha.infraestructura.persistencia.builder.CuentaBuilder;
import com.prueba.pichincha.infraestructura.persistencia.builder.MovimientoBuilder;
import com.prueba.pichincha.infraestructura.persistencia.entidad.CuentaEntidad;
import com.prueba.pichincha.infraestructura.persistencia.entidad.MovimientoEntidad;
import com.prueba.pichincha.infraestructura.persistencia.repositorio.jpa.IRepositorioCuentaJPA;
import com.prueba.pichincha.infraestructura.persistencia.repositorio.jpa.IRepositorioMovimientoJPA;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class RepositorioMovimiento implements IRepositorioMovimiento {
    private static final String MENSAJE_ELIMINAR_NO_EXISTE = "No se puedo eliminar cliente, no existe.";

    private IRepositorioMovimientoJPA repositorioMovimientoJPA;

    public RepositorioMovimiento(IRepositorioMovimientoJPA repositorioMovimientoJPA) {
        this.repositorioMovimientoJPA = repositorioMovimientoJPA;
    }

    @Override
    public Long guardar(Movimiento movimiento) {
        MovimientoEntidad movimientoEntidad = MovimientoBuilder.convertirAEntidad(movimiento);
        movimientoEntidad = repositorioMovimientoJPA.save(movimientoEntidad);
        return movimientoEntidad.getId();
    }

    @Override
    public Movimiento obtenerPorCliente(Long identificacion) {
        return new Movimiento();
    }


    @Override
    public void actualizar(Movimiento movimiento) {
        MovimientoEntidad movimientoEntidad = MovimientoBuilder.convertirAEntidad(movimiento);
        repositorioMovimientoJPA.save(movimientoEntidad);
    }

    @Override
    public void eliminar(Long id) {
        Optional<MovimientoEntidad> cuentaEntidad = repositorioMovimientoJPA.findById(id);
        repositorioMovimientoJPA.delete(cuentaEntidad.orElseThrow(() ->
                new ExcepcionSinDatos(MENSAJE_ELIMINAR_NO_EXISTE)));
    }
}
