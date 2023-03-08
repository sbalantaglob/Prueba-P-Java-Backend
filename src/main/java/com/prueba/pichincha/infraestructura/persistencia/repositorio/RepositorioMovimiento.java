package com.prueba.pichincha.infraestructura.persistencia.repositorio;

import com.prueba.pichincha.dominio.excepcion.ExcepcionSinDatos;
import com.prueba.pichincha.dominio.movimiento.modelo.Movimiento;
import com.prueba.pichincha.dominio.movimiento.puerto.repositorio.IRepositorioMovimiento;
import com.prueba.pichincha.infraestructura.persistencia.builder.MovimientoBuilder;
import com.prueba.pichincha.infraestructura.persistencia.entidad.MovimientoEntidad;
import com.prueba.pichincha.infraestructura.persistencia.repositorio.jpa.IRepositorioMovimientoJPA;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Repository
public class RepositorioMovimiento implements IRepositorioMovimiento {
    private static final String MENSAJE_NO_EXISTE_MOVIMIENTO = "No se puedo encontrar el movimiento, no existe.";
    private static final String MENSAJE_ELIMINAR_NO_EXISTE = "No se puedo eliminar movimiento, no existe.";

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
    public Movimiento obtenerPorId(Long id) {
        MovimientoEntidad movimientoEntidad = repositorioMovimientoJPA.findById(id).orElseThrow(() ->
                new ExcepcionSinDatos(MENSAJE_NO_EXISTE_MOVIMIENTO));
        return MovimientoBuilder.convertirADominio(movimientoEntidad);
    }

    @Override
    public List<Movimiento> obtenerPorFechasYCuenta(Timestamp fechaInicial, Timestamp fechaFinal, Long numeroCuenta) {
        List<Movimiento> listaMovimiento =
                repositorioMovimientoJPA.findAllByFechaBetweenAndCuentaEntidad_NumeroCuenta(fechaInicial, fechaFinal, numeroCuenta)
                .stream()
                .map(movimientoEntidad -> MovimientoBuilder.convertirADominio(movimientoEntidad))
                        .toList();
        return listaMovimiento;
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
