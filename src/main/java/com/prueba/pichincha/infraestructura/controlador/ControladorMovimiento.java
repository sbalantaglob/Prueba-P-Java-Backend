package com.prueba.pichincha.infraestructura.controlador;

import com.prueba.pichincha.aplicacion.dto.DtoMovimiento;
import com.prueba.pichincha.aplicacion.manejadores.movimiento.ManejadorActualizarMovimiento;
import com.prueba.pichincha.aplicacion.manejadores.movimiento.ManejadorCrearMovimiento;
import com.prueba.pichincha.aplicacion.manejadores.movimiento.ManejadorEliminarMovimiento;
import com.prueba.pichincha.aplicacion.manejadores.movimiento.ManejadorObtenerMovimientoPorFechaYCliente;
import com.prueba.pichincha.dominio.movimiento.modelo.Movimiento;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/movimientos")
public class ControladorMovimiento {

    private final ManejadorCrearMovimiento manejadorCrearMovimiento;
    private final ManejadorActualizarMovimiento manejadorActualizarMovimiento;
    private final ManejadorEliminarMovimiento manejadorEliminarMovimiento;
    private final ManejadorObtenerMovimientoPorFechaYCliente manejadorObtenerMovimientoPorFechaYCliente;

    public ControladorMovimiento(ManejadorCrearMovimiento manejadorCrearMovimiento,
                             ManejadorActualizarMovimiento manejadorActualizarMovimiento,
                             ManejadorEliminarMovimiento manejadorEliminarMovimiento,
                                 ManejadorObtenerMovimientoPorFechaYCliente manejadorObtenerMovimientoPorFechaYCliente) {
        this.manejadorCrearMovimiento = manejadorCrearMovimiento;
        this.manejadorActualizarMovimiento = manejadorActualizarMovimiento;
        this.manejadorEliminarMovimiento = manejadorEliminarMovimiento;
        this.manejadorObtenerMovimientoPorFechaYCliente = manejadorObtenerMovimientoPorFechaYCliente;
    }

    @PostMapping
    public Long crear(@RequestBody DtoMovimiento dtoMovimiento) {
        return this.manejadorCrearMovimiento.ejecutar(dtoMovimiento);
    }

    @GetMapping("/{numeroCuenta}")
    public List<Movimiento> obtenerMovimientoPorFechasYIdentificacion(
            @PathVariable(name = "numeroCuenta") Long numeroCuenta,
            @RequestParam(name = "fechaInicial")Timestamp fechaInicial,
            @RequestParam(name = "fechaFinal")Timestamp fechaFinal) {
        return this.manejadorObtenerMovimientoPorFechaYCliente.ejecutar(fechaInicial, fechaFinal, numeroCuenta);
    }

    @PutMapping
    public void actualizar(@RequestBody DtoMovimiento dtoMovimiento) {
        this.manejadorActualizarMovimiento.ejecutar(dtoMovimiento);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        this.manejadorEliminarMovimiento.ejecutar(id);
    }
    
}
