package com.prueba.pichincha.aplicacion.manejadores.cuenta;

import com.prueba.pichincha.aplicacion.fabrica.FabricaCuenta;
import com.prueba.pichincha.dominio.cuenta.servicio.ServicioEliminarCuenta;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ManejadorEliminarCuenta {

    private final ServicioEliminarCuenta servicioEliminarCuenta;
    private final FabricaCuenta fabricaCuenta;

    public ManejadorEliminarCuenta(ServicioEliminarCuenta servicioEliminarCuenta, FabricaCuenta fabricaCuenta) {
        this.servicioEliminarCuenta = servicioEliminarCuenta;
        this.fabricaCuenta = fabricaCuenta;
    }

    @Transactional
    public void ejecutar(Long id) {
        this.servicioEliminarCuenta.ejecutar(id);
    }
}
