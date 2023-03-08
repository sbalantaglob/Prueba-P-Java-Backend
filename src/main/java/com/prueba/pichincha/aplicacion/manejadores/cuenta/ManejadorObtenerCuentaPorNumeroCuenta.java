package com.prueba.pichincha.aplicacion.manejadores.cuenta;

import com.prueba.pichincha.aplicacion.fabrica.FabricaCuenta;
import com.prueba.pichincha.dominio.cuenta.modelo.Cuenta;
import com.prueba.pichincha.dominio.cuenta.servicio.ServicioObtenerCuenta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorObtenerCuentaPorNumeroCuenta {

    private final ServicioObtenerCuenta servicioObtenerCuenta;
    private final FabricaCuenta fabricaCuenta;

    public ManejadorObtenerCuentaPorNumeroCuenta(ServicioObtenerCuenta servicioObtenerCuenta, FabricaCuenta fabricaCuenta) {
        this.servicioObtenerCuenta = servicioObtenerCuenta;
        this.fabricaCuenta = fabricaCuenta;
    }

    public Cuenta ejecutar(Long numeroCuenta) {
        return this.servicioObtenerCuenta.ejecutar(numeroCuenta);
    }
}
