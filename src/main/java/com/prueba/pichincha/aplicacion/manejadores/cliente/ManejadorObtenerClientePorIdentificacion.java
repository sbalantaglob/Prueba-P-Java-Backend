package com.prueba.pichincha.aplicacion.manejadores.cliente;

import com.prueba.pichincha.aplicacion.fabrica.FabricaCliente;
import com.prueba.pichincha.dominio.cliente.modelo.Cliente;
import com.prueba.pichincha.dominio.cliente.servicio.ServicioObtenerCliente;
import org.springframework.stereotype.Component;

@Component
public class ManejadorObtenerClientePorIdentificacion {

    private final ServicioObtenerCliente servicioObtenerCliente;
    private final FabricaCliente fabricaCliente;

    public ManejadorObtenerClientePorIdentificacion(ServicioObtenerCliente servicioObtenerCliente, FabricaCliente fabricaCliente) {
        this.servicioObtenerCliente = servicioObtenerCliente;
        this.fabricaCliente = fabricaCliente;
    }

    public Cliente ejecutar(Long identificacion) {
        return this.servicioObtenerCliente.ejecutar(identificacion);
    }
}
