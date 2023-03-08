package com.prueba.pichincha.infraestructura.controlador;

import com.prueba.pichincha.aplicacion.dto.DtoMovimiento;
import com.prueba.pichincha.aplicacion.manejadores.movimiento.ManejadorActualizarMovimiento;
import com.prueba.pichincha.aplicacion.manejadores.movimiento.ManejadorCrearMovimiento;
import com.prueba.pichincha.aplicacion.manejadores.movimiento.ManejadorEliminarMovimiento;
import com.prueba.pichincha.aplicacion.manejadores.movimiento.ManejadorObtenerMovimientoPorFechaYCliente;
import com.prueba.pichincha.dominio.movimiento.modelo.Movimiento;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public Movimiento obtenerMovimientoPorIdentificacion(@PathVariable(name = "identificacion") Long identificacion) {
        return this.manejadorObtenerMovimientoPorFechaYCliente.ejecutar(identificacion);
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
