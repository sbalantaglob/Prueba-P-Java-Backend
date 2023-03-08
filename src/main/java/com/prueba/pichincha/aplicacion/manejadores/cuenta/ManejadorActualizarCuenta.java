package com.prueba.pichincha.aplicacion.manejadores.cuenta;

import com.prueba.pichincha.aplicacion.dto.DtoCuenta;
import com.prueba.pichincha.aplicacion.fabrica.FabricaCuenta;
import com.prueba.pichincha.dominio.cuenta.modelo.Cuenta;
import com.prueba.pichincha.dominio.cuenta.servicio.ServicioActualizarCuenta;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ManejadorActualizarCuenta {

    private final ServicioActualizarCuenta servicioActualizarCuenta;
    private final FabricaCuenta fabricaCuenta;

    public ManejadorActualizarCuenta(ServicioActualizarCuenta servicioActualizarCuenta, FabricaCuenta fabricaCuenta) {
        this.servicioActualizarCuenta = servicioActualizarCuenta;
        this.fabricaCuenta = fabricaCuenta;
    }

    @Transactional
    public void ejecutar(DtoCuenta dtoCuenta) {
        Cuenta cuenta = fabricaCuenta.crearCuenta(dtoCuenta);
        this.servicioActualizarCuenta.ejecutar(cuenta);
    }
}
