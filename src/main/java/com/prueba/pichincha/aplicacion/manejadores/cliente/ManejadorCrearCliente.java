package com.prueba.pichincha.aplicacion.manejadores.cliente;

import com.prueba.pichincha.aplicacion.dto.DtoCliente;
import com.prueba.pichincha.aplicacion.fabrica.FabricaCliente;
import com.prueba.pichincha.dominio.cliente.modelo.Cliente;
import com.prueba.pichincha.dominio.cliente.servicio.ServicioCrearCliente;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ManejadorCrearCliente {

    private final ServicioCrearCliente servicioCrearCliente;
    private final FabricaCliente fabricaCliente;

    public ManejadorCrearCliente(ServicioCrearCliente servicioCrearCliente, FabricaCliente fabricaCliente) {
        this.servicioCrearCliente = servicioCrearCliente;
        this.fabricaCliente = fabricaCliente;
    }

    @Transactional(propagation = Propagation.NESTED)
    public Long ejecutar(DtoCliente dtoCliente) {
        Cliente cliente = fabricaCliente.crearCliente(dtoCliente);
        return this.servicioCrearCliente.ejecutar(cliente);
    }
}
