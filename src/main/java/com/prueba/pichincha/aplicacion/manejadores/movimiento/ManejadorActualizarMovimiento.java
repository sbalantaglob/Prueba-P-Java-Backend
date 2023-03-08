package com.prueba.pichincha.aplicacion.manejadores.movimiento;

import com.prueba.pichincha.aplicacion.dto.DtoMovimiento;
import com.prueba.pichincha.aplicacion.fabrica.FabricaMovimiento;
import com.prueba.pichincha.dominio.movimiento.modelo.Movimiento;
import com.prueba.pichincha.dominio.movimiento.servicio.ServicioActualizarMovimiento;
import com.prueba.pichincha.dominio.utils.UtilsDominio;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Component
public class ManejadorActualizarMovimiento {

    private final ServicioActualizarMovimiento servicioActualizarMovimiento;
    private final FabricaMovimiento fabricaMovimiento;

    public ManejadorActualizarMovimiento(ServicioActualizarMovimiento servicioActualizarMovimiento, FabricaMovimiento fabricaMovimiento) {
        this.servicioActualizarMovimiento = servicioActualizarMovimiento;
        this.fabricaMovimiento = fabricaMovimiento;
    }

    @Transactional
    public void ejecutar(DtoMovimiento dtoMovimiento) {
        Movimiento Movimiento = fabricaMovimiento.crearMovimiento(dtoMovimiento);
        this.servicioActualizarMovimiento.ejecutar(Movimiento);
    }
}
