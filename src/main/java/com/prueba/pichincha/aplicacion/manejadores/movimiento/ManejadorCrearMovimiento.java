package com.prueba.pichincha.aplicacion.manejadores.movimiento;

import com.prueba.pichincha.aplicacion.dto.DtoMovimiento;
import com.prueba.pichincha.aplicacion.fabrica.FabricaMovimiento;
import com.prueba.pichincha.dominio.movimiento.modelo.Movimiento;
import com.prueba.pichincha.dominio.movimiento.servicio.ServicioCrearMovimiento;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ManejadorCrearMovimiento {

    private final ServicioCrearMovimiento servicioCrearMovimiento;
    private final FabricaMovimiento fabricaMovimiento;

    public ManejadorCrearMovimiento(ServicioCrearMovimiento servicioCrearMovimiento, FabricaMovimiento fabricaMovimiento) {
        this.servicioCrearMovimiento = servicioCrearMovimiento;
        this.fabricaMovimiento = fabricaMovimiento;
    }

    @Transactional
    public Long ejecutar(DtoMovimiento dtoMovimiento) {
        Movimiento Movimiento = fabricaMovimiento.crearMovimiento(dtoMovimiento);
        return this.servicioCrearMovimiento.ejecutar(Movimiento);
    }
}
