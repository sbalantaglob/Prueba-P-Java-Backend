package com.prueba.pichincha.aplicacion.manejadores.cliente;

import com.prueba.pichincha.aplicacion.fabrica.FabricaCliente;
import com.prueba.pichincha.dominio.cliente.servicio.ServicioEliminarCliente;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ManejadorEliminarCliente {

    private final ServicioEliminarCliente servicioEliminarCliente;
    private final FabricaCliente fabricaCliente;

    public ManejadorEliminarCliente(ServicioEliminarCliente servicioEliminarCliente, FabricaCliente fabricaCliente) {
        this.servicioEliminarCliente = servicioEliminarCliente;
        this.fabricaCliente = fabricaCliente;
    }

    @Transactional
    public void ejecutar(Long id) {
        this.servicioEliminarCliente.ejecutar(id);
    }
}
