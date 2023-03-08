package com.prueba.pichincha.aplicacion.manejadores.movimiento;

import com.prueba.pichincha.aplicacion.fabrica.FabricaMovimiento;
import com.prueba.pichincha.dominio.movimiento.modelo.Movimiento;
import com.prueba.pichincha.dominio.movimiento.servicio.ServicioObtenerMovimiento;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;

@Component
public class ManejadorObtenerMovimientoPorFechaYCliente {

    private final ServicioObtenerMovimiento servicioObtenerMovimiento;
    private final FabricaMovimiento fabricaMovimiento;

    public ManejadorObtenerMovimientoPorFechaYCliente(ServicioObtenerMovimiento servicioObtenerMovimiento,
                                                      FabricaMovimiento fabricaMovimiento) {
        this.servicioObtenerMovimiento = servicioObtenerMovimiento;
        this.fabricaMovimiento = fabricaMovimiento;
    }

    public List<Movimiento> ejecutar(Timestamp fechaInicial, Timestamp fechaFinal, Long numeroCuenta) {
        return this.servicioObtenerMovimiento.ejecutar(fechaInicial, fechaFinal, numeroCuenta);
    }
}
