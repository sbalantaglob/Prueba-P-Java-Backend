package com.prueba.pichincha.aplicacion.fabrica;

import com.prueba.pichincha.aplicacion.dto.DtoMovimiento;
import com.prueba.pichincha.dominio.movimiento.modelo.Movimiento;
import org.springframework.stereotype.Component;

@Component
public class FabricaMovimiento {

    public Movimiento crearMovimiento(DtoMovimiento dtoMovimiento) {
        return new Movimiento(dtoMovimiento.getTipoMovimiento(), dtoMovimiento.getValor(),
                dtoMovimiento.getSaldo(), dtoMovimiento.getFecha(), dtoMovimiento.getCuenta());
    }
}
