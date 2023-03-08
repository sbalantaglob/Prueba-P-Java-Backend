package com.prueba.pichincha.aplicacion.manejadores.cuenta;

import com.prueba.pichincha.aplicacion.dto.DtoCuenta;
import com.prueba.pichincha.aplicacion.fabrica.FabricaCuenta;
import com.prueba.pichincha.dominio.cuenta.modelo.Cuenta;
import com.prueba.pichincha.dominio.cuenta.servicio.ServicioCrearCuenta;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ManejadorCrearCuenta {

    private final ServicioCrearCuenta servicioCrearCuenta;
    private final FabricaCuenta fabricaCuenta;

    public ManejadorCrearCuenta(ServicioCrearCuenta servicioCrearCuenta, FabricaCuenta fabricaCuenta) {
        this.servicioCrearCuenta = servicioCrearCuenta;
        this.fabricaCuenta = fabricaCuenta;
    }

    @Transactional
    public Long ejecutar(DtoCuenta dtoCuenta) {
        Cuenta cuenta = fabricaCuenta.crearCuenta(dtoCuenta);
        return this.servicioCrearCuenta.ejecutar(cuenta);
    }
}
