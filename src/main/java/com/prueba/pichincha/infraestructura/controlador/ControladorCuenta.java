package com.prueba.pichincha.infraestructura.controlador;

import com.prueba.pichincha.aplicacion.dto.DtoCuenta;
import com.prueba.pichincha.aplicacion.manejadores.cuenta.ManejadorActualizarCuenta;
import com.prueba.pichincha.aplicacion.manejadores.cuenta.ManejadorCrearCuenta;
import com.prueba.pichincha.aplicacion.manejadores.cuenta.ManejadorEliminarCuenta;
import com.prueba.pichincha.aplicacion.manejadores.cuenta.ManejadorObtenerCuentaPorNumeroCuenta;
import com.prueba.pichincha.dominio.cuenta.modelo.Cuenta;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cuentas")
@Slf4j
public class ControladorCuenta {

    private final ManejadorCrearCuenta manejadorCrearCuenta;
    private final ManejadorActualizarCuenta manejadorActualizarCuenta;
    private final ManejadorEliminarCuenta manejadorEliminarCuenta;
    private final ManejadorObtenerCuentaPorNumeroCuenta manejadorObtenerCuentaPorNumeroCuenta;

    public ControladorCuenta(ManejadorCrearCuenta manejadorCrearCuenta,
                             ManejadorActualizarCuenta manejadorActualizarCuenta,
                             ManejadorEliminarCuenta manejadorEliminarCuenta,
                             ManejadorObtenerCuentaPorNumeroCuenta manejadorObtenerCuentaPorNumeroCuenta) {
        this.manejadorCrearCuenta = manejadorCrearCuenta;
        this.manejadorActualizarCuenta = manejadorActualizarCuenta;
        this.manejadorEliminarCuenta = manejadorEliminarCuenta;
        this.manejadorObtenerCuentaPorNumeroCuenta = manejadorObtenerCuentaPorNumeroCuenta;
    }

    @PostMapping
    public Long crear(@RequestBody DtoCuenta dtoCuenta) {
        return this.manejadorCrearCuenta.ejecutar(dtoCuenta);
    }

    @GetMapping("/{id}")
    public Cuenta obtenerCuentaPorIdentificacion(@PathVariable Long identificacion) {
        return this.manejadorObtenerCuentaPorNumeroCuenta.ejecutar(identificacion);
    }

    @PutMapping
    public void actualizar(@RequestBody DtoCuenta dtoCuenta) {
        this.manejadorActualizarCuenta.ejecutar(dtoCuenta);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        this.manejadorEliminarCuenta.ejecutar(id);
    }

}
