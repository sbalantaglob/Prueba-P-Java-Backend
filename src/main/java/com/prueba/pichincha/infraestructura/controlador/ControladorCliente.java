package com.prueba.pichincha.infraestructura.controlador;

import com.prueba.pichincha.aplicacion.dto.DtoCliente;
import com.prueba.pichincha.aplicacion.manejadores.cliente.ManejadorActualizarCliente;
import com.prueba.pichincha.aplicacion.manejadores.cliente.ManejadorCrearCliente;
import com.prueba.pichincha.aplicacion.manejadores.cliente.ManejadorEliminarCliente;
import com.prueba.pichincha.aplicacion.manejadores.cliente.ManejadorObtenerClientePorIdentificacion;
import com.prueba.pichincha.dominio.cliente.modelo.Cliente;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
@Slf4j
public class ControladorCliente {

    private final ManejadorCrearCliente manejadorCrearCliente;
    private final ManejadorActualizarCliente manejadorActualizarCliente;
    private final ManejadorEliminarCliente manejadorEliminarCliente;
    private final ManejadorObtenerClientePorIdentificacion manejadorObtenerClientePorIdentificacion;

    public ControladorCliente(ManejadorCrearCliente manejadorCrearCliente,
                              ManejadorActualizarCliente manejadorActualizarCliente,
                              ManejadorEliminarCliente manejadorEliminarCliente,
                              ManejadorObtenerClientePorIdentificacion manejadorObtenerClientePorIdentificacion) {
        this.manejadorCrearCliente = manejadorCrearCliente;
        this.manejadorActualizarCliente = manejadorActualizarCliente;
        this.manejadorEliminarCliente = manejadorEliminarCliente;
        this.manejadorObtenerClientePorIdentificacion = manejadorObtenerClientePorIdentificacion;
    }

    @PostMapping
    public Long crear(@RequestBody DtoCliente dtoCliente) {
        return this.manejadorCrearCliente.ejecutar(dtoCliente);
    }

    @GetMapping("/{identificacion}")
    public Cliente obtenerClientePorIdentificacion(@PathVariable(name = "identificacion") Long identificacion) {
        return this.manejadorObtenerClientePorIdentificacion.ejecutar(identificacion);
    }

    @PutMapping
    public void actualizar(@RequestBody DtoCliente dtoCliente) {
        this.manejadorActualizarCliente.ejecutar(dtoCliente);
    }

    @DeleteMapping("/{identificacion}")
    public void eliminar(@PathVariable(name = "identificacion") Long identificacion) {
        this.manejadorEliminarCliente.ejecutar(identificacion);
    }

}
