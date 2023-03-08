package com.prueba.pichincha.aplicacion.manejadores.movimiento;

import com.prueba.pichincha.aplicacion.fabrica.FabricaMovimiento;
import com.prueba.pichincha.dominio.movimiento.servicio.ServicioEliminarMovimiento;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ManejadorEliminarMovimiento {

    private final ServicioEliminarMovimiento servicioEliminarMovimiento;
    private final FabricaMovimiento fabricaMovimiento;

    public ManejadorEliminarMovimiento(ServicioEliminarMovimiento servicioEliminarMovimiento, FabricaMovimiento fabricaMovimiento) {
        this.servicioEliminarMovimiento = servicioEliminarMovimiento;
        this.fabricaMovimiento = fabricaMovimiento;
    }

    @Transactional
    public void ejecutar(Long id) {
        this.servicioEliminarMovimiento.ejecutar(id);
    }
}
