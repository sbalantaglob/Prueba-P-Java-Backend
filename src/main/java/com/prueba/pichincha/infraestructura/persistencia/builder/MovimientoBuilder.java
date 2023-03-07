package com.prueba.pichincha.infraestructura.persistencia.builder;

import com.prueba.pichincha.dominio.cuenta.modelo.Cuenta;
import com.prueba.pichincha.dominio.movimiento.modelo.Movimiento;
import com.prueba.pichincha.infraestructura.persistencia.entidad.CuentaEntidad;
import com.prueba.pichincha.infraestructura.persistencia.entidad.MovimientoEntidad;

import java.util.Objects;

public final class MovimientoBuilder {

    private MovimientoBuilder() {
    }
    
    public static Movimiento convertirADominio(MovimientoEntidad movimientoEntidad) {
        Movimiento movimiento = new Movimiento();
        if (Objects.nonNull(movimientoEntidad) ) {
            movimiento = new Movimiento(movimientoEntidad.getId(),
                    movimientoEntidad.getTipoMovimiento(), movimientoEntidad.getValor(),
                    movimientoEntidad.getSaldo(), movimientoEntidad.getFecha());
        }
        return movimiento;
    }

    public static MovimientoEntidad convertirAEntidad(Movimiento movimiento) {
        MovimientoEntidad movimientoEntidad = new MovimientoEntidad();
        movimientoEntidad.setId(movimiento.getId());
        movimientoEntidad.setTipoMovimiento(movimiento.getTipoMovimiento());
        movimientoEntidad.setValor(movimiento.getValor());
        movimientoEntidad.setSaldo(movimiento.getSaldo());
        movimientoEntidad.setFecha(movimiento.getFecha());
        return movimientoEntidad;
    }
    
}
