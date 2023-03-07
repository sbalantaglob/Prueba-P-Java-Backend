package com.prueba.pichincha.aplicacion.manejadores.cliente;

import com.prueba.pichincha.aplicacion.dto.DtoCliente;
import com.prueba.pichincha.aplicacion.fabrica.FabricaCliente;
import com.prueba.pichincha.dominio.cliente.modelo.Cliente;
import com.prueba.pichincha.dominio.cliente.servicio.ServicioActualizarCliente;
import com.prueba.pichincha.dominio.cliente.servicio.ServicioCrearCliente;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
public class ManejadorActualizarCliente {

    private final ServicioActualizarCliente servicioActualizarCliente;
    private final FabricaCliente fabricaCliente;

    public ManejadorActualizarCliente(ServicioActualizarCliente servicioActualizarCliente, FabricaCliente fabricaCliente) {
        this.servicioActualizarCliente = servicioActualizarCliente;
        this.fabricaCliente = fabricaCliente;
    }

    @Transactional
    public void ejecutar(DtoCliente dtoCliente) {
        Cliente cliente = fabricaCliente.actualizarCliente(dtoCliente);
        this.servicioActualizarCliente.ejecutar(cliente);
    }
}
